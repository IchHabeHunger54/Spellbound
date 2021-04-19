package ihh.spellbound.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeConfigSpec;

public abstract class SelfSpell extends Spell {
    public SelfSpell(ForgeConfigSpec.IntValue config) {
        super(config);
    }

    @Override
    protected final LivingEntity getTarget(World world, PlayerEntity player) {
        return player;
    }
}
