package com.j3ff97.steelindustries.worldgen;

import com.j3ff97.steelindustries.handler.ConfigurationHandler;
import com.j3ff97.steelindustries.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class OreGen implements IWorldGenerator
{
    public void generate(Random random, int x, int z, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.dimensionId)
        {
            case -1:
                generateNether(world, random, x * 16, z * 16);
                break;
            case 0:
                generateSurface(world, random, x * 16, z * 16);
                break;
            case 1:
                generateEnd(world, random, x * 16, z *16);
        }
    }

    private void generateEnd(World world, Random random, int x, int z)
    {

    }

    private void generateSurface(World world, Random random, int x, int z)
    {
        addOreSpawn(ModBlocks.oreGraphite, world, random, Blocks.coal_ore, x, z, 8, 8, 25, ConfigurationHandler.oreGraphiteSpawnChance, 0, 128);
        addOreSpawn(ModBlocks.oreRutile, world, random, Blocks.stone, x, z, 8, 8, 7, ConfigurationHandler.oreRutileSpawnChance, 0, 16);
        addOreSpawn(ModBlocks.oreSilicon, world, random, Blocks.sand, x, z, 8, 8, 5, ConfigurationHandler.oreSiliconSpawnChance, 0, 128);
        addOreSpawn(ModBlocks.highOven, world, random, Blocks.furnace, x, z, 8, 8, 1, 40, 0, 256);
    }

    private void generateNether(World world, Random random, int x, int z)
    {

    }

    /**
     * Adds a new block to spawn in the world.
     *
     * @param block          Block to Spawn
     * @param world          World to spawn in
     * @param random         Random object for retrieving random pos. within the world to spawn the block
     * @param target         The block to replace
     * @param blockXPos      int for passing the X-Coordinate for the Generation method
     * @param blockZPos      int for passing the Z-Coordinate for the Generation method
     * @param maxX           int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
     * @param maxZ           int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
     * @param maxVeinSize    int for setting the maximum size of a vein
     * @param chancesToSpawn int for the Number of chances available for the Block to spawn per-chunk
     * @param minY           int for the minimum Y-Coordinate height at which this block may spawn
     * @param maxY           int for the maximum Y-Coordinate height at which this block may spawn
     */

    public void addOreSpawn(Block block, World world, Random random, Block target, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
        assert minY > 0 :               "addOreSpawn: The minimum Y-coord must be greater than 0";
        assert maxY > minY :            "addOreSpawn: The maximum Y-coord must be greater than the min Y-coord";
        assert maxX > 0 && maxX <= 16 : "addOreSpawn: The maximum X-coord must be less than 16  but greater than 0";
        assert maxZ > 0 && maxZ <=0 :   "addOreSpawn: The maximum Z-coord must be less than 16  but greater than 0";
        assert maxY < 256 && maxY > 0 : "addOreSpawn: The maximum Y-coord must be less than 256 but greater than 0";

        int diffbtwnMinMaxY = maxY - minY;
        for(int x = 0; x < chancesToSpawn; x++)
        {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffbtwnMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize, target)).generate(world, random, posX, posY, posZ);
        }
    }
}
