package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LightType;
import net.minecraft.world.server.ServerWorld;

public final class Torchlight extends SelfSpell {
    public Torchlight() {
        super(Config.TORCHLIGHT_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (world.getLightFor(LightType.BLOCK, target.getPosition()) <= Config.TORCHLIGHT_LIGHT_LEVEL.get()) {
            Util.replaceAir(world, target.getPosition(), Blocks.TORCH);
            return true;
        }
        return false;
    }
}
