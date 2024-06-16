package net.navaha.frigieletfluffymagic.item.essences;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Supplier;

public class WaterEssenceItem extends Item {
    private final Fluid content;

    public WaterEssenceItem(Properties pProperties) {
        super(pProperties);
        this.content = Fluids.WATER;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, this.content == Fluids.EMPTY ? net.minecraft.world.level.ClipContext.Fluid.SOURCE_ONLY : net.minecraft.world.level.ClipContext.Fluid.NONE);
        InteractionResultHolder<ItemStack> ret = ForgeEventFactory.onBucketUse(pPlayer, pLevel, itemstack, blockhitresult);
        if (ret != null) {
            return ret;
        }
        if (blockhitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else if (blockhitresult.getType() != HitResult.Type.BLOCK) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            BlockPos blockpos = blockhitresult.getBlockPos();
            Direction direction = blockhitresult.getDirection();
            BlockPos blockpos1 = blockpos.relative(direction);
            if (pLevel.mayInteract(pPlayer, blockpos) && pPlayer.mayUseItemAt(blockpos1, direction, itemstack)) {
                BlockState blockstate1;

                blockstate1 = pLevel.getBlockState(blockpos);
                BlockPos blockpos2 = this.canBlockContainFluid(pLevel, blockpos, blockstate1) ? blockpos : blockpos1;
                if (this.emptyContents(pPlayer, pLevel, blockpos2, blockhitresult, itemstack)) {
                    this.checkExtraContent(pPlayer, pLevel, itemstack, blockpos2);
                    if (pPlayer instanceof ServerPlayer) {
                        CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)pPlayer, blockpos2, itemstack);
                    }

                    pPlayer.awardStat(Stats.ITEM_USED.get(this));
                    itemstack.consume(1, pPlayer);
                    return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());

                } else {
                    return InteractionResultHolder.fail(itemstack);
                }


            } else {
                return InteractionResultHolder.fail(itemstack);
            }
        }
    }

    public void checkExtraContent(@Nullable Player pPlayer, Level pLevel, ItemStack pContainerStack, BlockPos pPos) {
    }

    public boolean emptyContents(@Nullable Player p_150716_, Level p_150717_, BlockPos p_150718_, @Nullable BlockHitResult p_150719_, @Nullable ItemStack container) {
        Fluid var7 = this.content;
        if (!(var7 instanceof FlowingFluid flowingfluid)) {
            return false;
        }
        else {
            boolean $$8;
            BlockState blockstate;
            boolean flag2;
            Block $$7;
            label80: {
                label79: {
                    blockstate = p_150717_.getBlockState(p_150718_);
                    $$7 = blockstate.getBlock();
                    $$8 = blockstate.canBeReplaced(this.content);
                    if (!blockstate.isAir() && !$$8) {
                        if (!($$7 instanceof LiquidBlockContainer)) {
                            break label79;
                        }

                        LiquidBlockContainer liquidblockcontainer = (LiquidBlockContainer)$$7;
                        if (!liquidblockcontainer.canPlaceLiquid(p_150716_, p_150717_, p_150718_, blockstate, this.content)) {
                            break label79;
                        }
                    }

                    flag2 = true;
                    break label80;
                }

                flag2 = false;
            }

            Optional<FluidStack> containedFluidStack = Optional.ofNullable(container).flatMap(FluidUtil::getFluidContained);
            if (!flag2) {
                return p_150719_ != null && this.emptyContents(p_150716_, p_150717_, p_150719_.getBlockPos().relative(p_150719_.getDirection()), (BlockHitResult)null, container);
            } else if (containedFluidStack.isPresent() && this.content.getFluidType().isVaporizedOnPlacement(p_150717_, p_150718_, (FluidStack)containedFluidStack.get())) {
                this.content.getFluidType().onVaporize(p_150716_, p_150717_, p_150718_, (FluidStack)containedFluidStack.get());
                return true;
            } else if (p_150717_.dimensionType().ultraWarm() && this.content.is(FluidTags.WATER)) {
                int l = p_150718_.getX();
                int i = p_150718_.getY();
                int j = p_150718_.getZ();
                p_150717_.playSound(p_150716_, p_150718_, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, 2.6F + (p_150717_.random.nextFloat() - p_150717_.random.nextFloat()) * 0.8F);

                for(int k = 0; k < 8; ++k) {
                    p_150717_.addParticle(ParticleTypes.LARGE_SMOKE, (double)l + Math.random(), (double)i + Math.random(), (double)j + Math.random(), 0.0, 0.0, 0.0);
                }

                return true;
            } else {
                if ($$7 instanceof LiquidBlockContainer) {
                    LiquidBlockContainer liquidblockcontainer1 = (LiquidBlockContainer)$$7;
                    if (liquidblockcontainer1.canPlaceLiquid(p_150716_, p_150717_, p_150718_, blockstate, this.content) && this.content == Fluids.WATER) {
                        liquidblockcontainer1.placeLiquid(p_150717_, p_150718_, blockstate, flowingfluid.getSource(false));
                        this.playEmptySound(p_150716_, p_150717_, p_150718_);
                        return true;
                    }
                }

                if (!p_150717_.isClientSide && $$8 && !blockstate.liquid()) {
                    p_150717_.destroyBlock(p_150718_, true);
                }

                if (!p_150717_.setBlock(p_150718_, this.content.defaultFluidState().createLegacyBlock(), 11) && !blockstate.getFluidState().isSource()) {
                    return false;
                } else {
                    this.playEmptySound(p_150716_, p_150717_, p_150718_);
                    return true;
                }
            }
        }
    }

    protected void playEmptySound(@Nullable Player pPlayer, LevelAccessor pLevel, BlockPos pPos) {
        SoundEvent soundevent = this.content.is(FluidTags.LAVA) ? SoundEvents.BUCKET_EMPTY_LAVA : SoundEvents.BUCKET_EMPTY;
        SoundEvent custom = this.content.getFluidType().getSound(pPlayer, pLevel, pPos, SoundActions.BUCKET_EMPTY);
        if (custom != null) {
            soundevent = custom;
        }

        pLevel.playSound(pPlayer, pPos, soundevent, SoundSource.BLOCKS, 1.0F, 1.0F);
        pLevel.gameEvent(pPlayer, GameEvent.FLUID_PLACE, pPos);
    }

    protected boolean canBlockContainFluid(Level worldIn, BlockPos posIn, BlockState blockstate) {
        Block var5 = blockstate.getBlock();
        boolean var10000;
        if (var5 instanceof LiquidBlockContainer liquid) {
            if (liquid.canPlaceLiquid((Player)null, worldIn, posIn, blockstate, this.content)) {
                var10000 = true;
                return var10000;
            }
        }

        var10000 = false;
        return var10000;
    }
}
