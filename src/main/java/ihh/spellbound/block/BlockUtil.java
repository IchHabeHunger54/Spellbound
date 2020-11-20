package ihh.spellbound.block;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;

public final class BlockUtil {
    public static ArrayList<BlockPos> getBlocksInDistance(World world, double x, double y, double z, int distance) {
        ArrayList<BlockPos> list = new ArrayList<>();
        for (Block block : ForgeRegistries.BLOCKS.getValues().toArray(new Block[]{}))
            getBlocksInDistance(world, (int) x, (int) y, (int) z, distance, list, block);
        return list;
    }

    public static ArrayList<BlockPos> getBlocksInDistance(World world, double x, double y, double z, int distance, Block... blocks) {
        ArrayList<BlockPos> list = new ArrayList<>();
        for (Block block : blocks) getBlocksInDistance(world, (int) x, (int) y, (int) z, distance, list, block);
        return list;
    }

    private static void getBlocksInDistance(World world, int x, int y, int z, int distance, ArrayList<BlockPos> list, Block block) {
        int dx = x - distance;
        while (dx < x + distance) {
            int dz = z - distance;
            while (dz < z + distance) {
                int dy = y + 3;
                while (dy > y - 1) {
                    if (world.getBlockState(new BlockPos(dx, dy, dz)).getBlock() == block)
                        list.add(new BlockPos(dx, dy, dz));
                    dy--;
                }
                dz++;
            }
            dx++;
        }
    }
}
