package io.github.apace100.wwfix;

import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.Chunk;

public class FluidStateHelper {

    public static FluidState getFluidState(BlockView world, BlockPos pos) {
        if (world.isOutOfHeightLimit(pos)) {
            return Fluids.EMPTY.getDefaultState();
        } else {
            if (world instanceof WorldView worldView) {
                Chunk chunk = worldView.getChunk(pos);
                return chunk.getFluidState(pos);
            }
            return world.getFluidState(pos);
        }
    }
}
