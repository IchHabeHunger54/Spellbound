package ihh.spellbound.item;

import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LightType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class Torchlight extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (world.isAirBlock(target.getPosition()) && world.getBlockState(target.getPosition().down()).isOpaqueCube(world, target.getPosition().down()) && world.getLightFor(LightType.BLOCK, target.getPosition()) < 8) {
            world.setBlockState(target.getPosition(), Blocks.TORCH.getDefaultState());
            return true;
        }
        return false;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.TORCHLIGHT;
    }
}
