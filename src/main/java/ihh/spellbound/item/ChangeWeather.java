package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;

public class ChangeWeather extends Spell {
    public ChangeWeather() {
        super(Config.CHANGE_WEATHER_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        if (world.isThundering()) world.setWeather(Config.CHANGE_WEATHER_MIN.get() + world.rand.nextInt(Math.max(Config.CHANGE_WEATHER_MAX.get() - Config.CHANGE_WEATHER_MIN.get(), 1)), 0, false, false);
        else world.setWeather(0, Config.CHANGE_WEATHER_MIN.get() + world.rand.nextInt(Math.max(Config.CHANGE_WEATHER_MAX.get() - Config.CHANGE_WEATHER_MIN.get(), 1)), true, world.isRaining());
        return true;
    }
}
