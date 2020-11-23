package ihh.spellbound.item;

import ihh.spellbound.config.SpellConfig;
import ihh.spellbound.config.SpellTimeConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class ChangeWeather extends AbstractSelfSpell {
    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (world.isThundering()) {
            world.getWorldInfo().setClearWeatherTime(SpellConfig.CHANGE_WEATHER_DURATION.get());
            world.getWorldInfo().setRainTime(0);
            world.getWorldInfo().setThunderTime(0);
            world.getWorldInfo().setRaining(false);
            world.getWorldInfo().setThundering(false);
        } else if (world.isRaining()) {
            world.getWorldInfo().setClearWeatherTime(0);
            world.getWorldInfo().setRainTime(SpellConfig.CHANGE_WEATHER_DURATION.get());
            world.getWorldInfo().setThunderTime(SpellConfig.CHANGE_WEATHER_DURATION.get());
            world.getWorldInfo().setRaining(true);
            world.getWorldInfo().setThundering(true);
        } else {
            world.getWorldInfo().setClearWeatherTime(0);
            world.getWorldInfo().setRainTime(SpellConfig.CHANGE_WEATHER_DURATION.get());
            world.getWorldInfo().setThunderTime(0);
            world.getWorldInfo().setRaining(true);
            world.getWorldInfo().setThundering(false);
        }
        return true;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.CHANGE_WEATHER;
    }
}
