package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.block.Util;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LightType;
import net.minecraft.world.server.ServerWorld;

public final class Torchlight extends Spell {
    public Torchlight() {
        super(Config.TORCHLIGHT_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (world.getLightFor(LightType.BLOCK, target.getPosition()) < 8) {
            Util.replaceAirBlock(world, target.getPosition(), Blocks.TORCH);
            return true;
        }
        return false;
    }
}
