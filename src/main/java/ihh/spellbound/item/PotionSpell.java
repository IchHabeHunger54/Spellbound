package ihh.spellbound.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.function.Supplier;

public class PotionSpell extends Spell {
    private final Supplier<MobEffectInstance> effect;

    public PotionSpell(ForgeConfigSpec.IntValue timeConfig, Supplier<MobEffectInstance> instance) {
        super(timeConfig);
        effect = instance;
    }

    @Override
    protected boolean use(ItemStack stack, Player player, ServerLevel level) {
        player.addEffect(effect.get());
        return true;
    }
}
