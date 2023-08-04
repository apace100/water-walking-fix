package io.github.apace100.wwfix.mixin;

import io.github.apace100.wwfix.FluidShapes;
import io.github.apace100.wwfix.FluidStateHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.AbstractBlockState.class)
public class FluidloggedWalkMixin {

    @Inject(method = "getCollisionShape(Lnet/minecraft/world/BlockView;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/ShapeContext;)Lnet/minecraft/util/shape/VoxelShape;", at = @At("RETURN"), cancellable = true)
    private void wwfix$fixFluidloggedCollisionShape(BlockView world, BlockPos pos, ShapeContext context, CallbackInfoReturnable<VoxelShape> cir) {
        FluidState fluidState = FluidStateHelper.getFluidState(world, pos);
        if (fluidState == null) {
            return;
        }
        int level = fluidState.getLevel();
        if(level == 0) {
            return;
        }
        VoxelShape shape = FluidShapes.VOXEL_SHAPES[level];
        VoxelShape shapeBelow = FluidShapes.VOXEL_SHAPES[level - 1];
        if (context.isAbove(shapeBelow, pos, true)
                && context.canWalkOnFluid(FluidStateHelper.getFluidState(world, pos.up()), fluidState)) {
            VoxelShape original = cir.getReturnValue();
            cir.setReturnValue(VoxelShapes.union(original, shape));
        }
    }
}
