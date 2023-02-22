package io.github.apace100.wwfix;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

public final class FluidShapes {

    public static final VoxelShape[] VOXEL_SHAPES;

    static {
        VOXEL_SHAPES = new VoxelShape[16];
        for(int i = 0; i < 16; i++) {
            VOXEL_SHAPES[i] = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, i, 16.0);
        }
    }
}
