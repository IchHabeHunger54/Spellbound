package ihh.spellbound.item;

import ihh.spellbound.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.IServerWorldInfo;

public final class ChangeWeather extends SelfSpell {
    public ChangeWeather() {
        super(Config.CHANGE_WEATHER_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        if (!world.isRemote) {
            IServerWorldInfo info = (IServerWorldInfo) world.getWorldInfo();
            if (world.isThundering()) {
                info.setClearWeatherTime(Config.CHANGE_WEATHER_DURATION.get());
                info.setRainTime(0);
                info.setThunderTime(0);
                info.setRaining(false);
                info.setThundering(false);
            } else if (world.isRaining()) {
                info.setClearWeatherTime(0);
                info.setRainTime(Config.CHANGE_WEATHER_DURATION.get());
                info.setThunderTime(Config.CHANGE_WEATHER_DURATION.get());
                info.setRaining(true);
                info.setThundering(true);
            } else {
                info.setClearWeatherTime(0);
                info.setRainTime(Config.CHANGE_WEATHER_DURATION.get());
                info.setThunderTime(0);
                info.setRaining(true);
                info.setThundering(false);
            }
        }
        return true;
    }
}
