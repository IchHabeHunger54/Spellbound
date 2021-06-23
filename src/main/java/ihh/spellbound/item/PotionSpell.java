package ihh.spellbound.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeConfigSpec;

public final class PotionSpell extends Spell {
    private final EffectInstance effect;

    public PotionSpell(ForgeConfigSpec.IntValue timeConfig, EffectInstance instance) {
        super(timeConfig);
        effect = instance;
    }

    @Override
    protected boolean use(ItemStack stack, PlayerEntity player, ServerWorld world) {
        player.addPotionEffect(effect);
        return true;
    }
}
