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
        if (world.isThundering()) world.setWeather(SpellConfig.CHANGE_WEATHER_DURATION.get(), 0, false, false);
        else world.setWeather(0, SpellConfig.CHANGE_WEATHER_DURATION.get(), true, world.isRaining());
        return true;
    }

    @Override
    protected ForgeConfigSpec.IntValue getTimeConfig() {
        return SpellTimeConfig.CHANGE_WEATHER;
    }
}
