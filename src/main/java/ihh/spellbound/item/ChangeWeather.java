package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public final class ChangeWeather extends Spell {
    public ChangeWeather() {
        super(Config.CHANGE_WEATHER_USE_DURATION, Type.SELF);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (world.isThundering()) world.setWeather(Config.CHANGE_WEATHER_DURATION.get(), 0, false, false);
        else world.setWeather(0, Config.CHANGE_WEATHER_DURATION.get(), true, world.isRaining());
        return true;
    }
}
