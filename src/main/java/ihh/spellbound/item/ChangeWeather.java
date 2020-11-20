package ihh.spellbound.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class ChangeWeather extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (world.isThundering()) {
            world.getWorldInfo().setClearWeatherTime(1000000);
            world.getWorldInfo().setRainTime(0);
            world.getWorldInfo().setThunderTime(0);
            world.getWorldInfo().setRaining(false);
            world.getWorldInfo().setThundering(false);
        } else if (world.isRaining()) {
            world.getWorldInfo().setClearWeatherTime(0);
            world.getWorldInfo().setRainTime(1000000);
            world.getWorldInfo().setThunderTime(1000000);
            world.getWorldInfo().setRaining(true);
            world.getWorldInfo().setThundering(true);
        } else {
            world.getWorldInfo().setClearWeatherTime(0);
            world.getWorldInfo().setRainTime(1000000);
            world.getWorldInfo().setThunderTime(1000000);
            world.getWorldInfo().setRaining(true);
            world.getWorldInfo().setThundering(false);
        }
        return true;
    }

    @Override
    protected Time getDefaultTime() {
        return Time.THREE;
    }
}
