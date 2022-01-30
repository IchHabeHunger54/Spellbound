package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ChangeWeather extends Spell {
    public ChangeWeather() {
        super(Config.CHANGE_WEATHER_USE_DURATION);
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        if (level.isThundering()) {
            level.setWeatherParameters(Config.CHANGE_WEATHER_MIN.get() + level.random.nextInt(Math.max(Config.CHANGE_WEATHER_MAX.get() - Config.CHANGE_WEATHER_MIN.get(), 1)), 0, false, false);
        } else {
            level.setWeatherParameters(0, Config.CHANGE_WEATHER_MIN.get() + level.random.nextInt(Math.max(Config.CHANGE_WEATHER_MAX.get() - Config.CHANGE_WEATHER_MIN.get(), 1)), true, level.isRaining());
        }
        return true;
    }
}
