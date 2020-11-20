package ihh.spellbound.item;

import ihh.spellbound.init.EffectInit;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;

public final class Breach extends AbstractTargetSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        if (target.isPotionActive(EffectInit.SURGE_SHIELD.get())) {
            target.removeActivePotionEffect(EffectInit.SURGE_SHIELD.get());
            b = true;
        }
        List<ItemStack> is = new ArrayList<>();
        for (int x = -1; x <= 1; x++)
            for (int z = -1; z <= 1; z++)
                if (!world.getBlockState(new BlockPos(target.getPosX() + x, target.getPosY() - 1, target.getPosZ() + z)).isAir(world, new BlockPos(target.getPosX() + x, target.getPosY() - 1, target.getPosZ() + z))) {
                    is.addAll(world.getBlockState(new BlockPos(target.getPosX() + x, target.getPosY() - 1, target.getPosZ() + z)).getDrops((new LootContext.Builder(world)).withRandom(world.rand).withParameter(LootParameters.POSITION, target.getPosition()).withParameter(LootParameters.TOOL, stack).withNullableParameter(LootParameters.THIS_ENTITY, target)));
                    world.setBlockState(new BlockPos(target.getPosX() + x, target.getPosY() - 1, target.getPosZ() + z), Blocks.AIR.getDefaultState());
                    b = true;
                }
        for (ItemStack i : is)
            world.addEntity(new ItemEntity(world, target.getPosX(), target.getPosY(), target.getPosZ(), i));
        return b;
    }

    @Override
    protected Time getDefaultTime() {
        return Time.TWO;
    }
}
