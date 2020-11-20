package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import java.util.Arrays;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class ColorSpray extends AbstractSelfSpell {
    private static final Block[] WOOL = {Blocks.WHITE_WOOL, Blocks.ORANGE_WOOL, Blocks.MAGENTA_WOOL, Blocks.LIGHT_BLUE_WOOL, Blocks.YELLOW_WOOL, Blocks.LIME_WOOL, Blocks.PINK_WOOL, Blocks.GRAY_WOOL, Blocks.LIGHT_GRAY_WOOL, Blocks.CYAN_WOOL, Blocks.PURPLE_WOOL, Blocks.BLUE_WOOL, Blocks.BROWN_WOOL, Blocks.GREEN_WOOL, Blocks.RED_WOOL, Blocks.BLACK_WOOL};

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        Direction direction = target.getHorizontalFacing();
        for (int length = 3; length < 14; length++) {
            int xCount = direction.getAxis() == Direction.Axis.X ? 0 : length;
            int zCount = direction.getAxis() == Direction.Axis.Z ? 0 : length;
            BlockPos pos = new BlockPos(direction.getAxis() == Direction.Axis.X ? target.getPosX() + xCount : target.getPosX() - xCount, target.getPosY(), direction.getAxis() == Direction.Axis.Z ? target.getPosZ() + zCount : target.getPosZ() - zCount);
            for (Object e : world.getEntitiesWithinAABBExcludingEntity(target, new AxisAlignedBB(pos.getX() - 6, pos.getY() - 3, pos.getZ() - 6, pos.getX() + 6, pos.getY() + 3, pos.getZ() + 6))) {
                if (e instanceof LivingEntity && !((LivingEntity) e).isPotionActive(EffectInit.SPELL_SHIELD.get()) && !((LivingEntity) e).isPotionActive(EffectInit.COLD_SHIELD.get())) {
                    b = true;
                    LivingEntity hitEntity = (LivingEntity) e;
                    hitEntity.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 200));
                    if (e instanceof SheepEntity) {
                        SheepEntity entitySheep = (SheepEntity) e;
                        entitySheep.setFleeceColor(DyeColor.byId(world.rand.nextInt(16)));
                    }
                }
            }
        }
        for (int x = -4; x <= 4; x++)
            for (int z = -4; z <= 4; z++) {
                BlockPos pos = target.getPosition().add(x, -1, z);
                if (Arrays.asList(WOOL).contains(world.getBlockState(pos).getBlock())) {
                    world.setBlockState(pos, WOOL[world.rand.nextInt(16)].getDefaultState());
                    b = true;
                }
            }
        return b;
    }

    @Override
    protected Time getDefaultTime() {
        return Time.TWO;
    }
}
