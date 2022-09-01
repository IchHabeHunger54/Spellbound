package ihh.spellbound;

import ihh.spellbound.entity.SpellProjectile;
import ihh.spellbound.init.EntityInit;
import ihh.spellbound.init.IInit;
import ihh.spellbound.init.ItemInit;
import ihh.spellbound.item.ProjectileSpell;
import net.minecraft.Util;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

@Mod(Spellbound.MOD_ID)
public final class Spellbound {
    public static final String MOD_ID = "spellbound";
    public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.BASE_TABLET.get());
        }
    };

    public Spellbound() {
        IInit.init(FMLJavaModLoadingContext.get().getModEventBus());
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.config);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Spellbound::commonSetup);
    }

    private static void commonSetup(FMLCommonSetupEvent e) {
        e.enqueueWork(() -> {
            registerSpellDispenseBehavior(ItemInit.ICY_GRIP, EntityInit.ICY_GRIP);
            registerSpellDispenseBehavior(ItemInit.ICICLE, EntityInit.ICICLE);
            registerSpellDispenseBehavior(ItemInit.COLD_BLAST, EntityInit.COLD_BLAST);
            registerSpellDispenseBehavior(ItemInit.FLAMING_HANDS, EntityInit.FLAMING_HANDS);
            registerSpellDispenseBehavior(ItemInit.FIREBALL, EntityInit.FIREBALL);
            registerSpellDispenseBehavior(ItemInit.GREATER_FIREBALL, EntityInit.GREATER_FIREBALL);
            registerSpellDispenseBehavior(ItemInit.TASER, EntityInit.TASER);
            registerSpellDispenseBehavior(ItemInit.LIGHTNING_BOLT, EntityInit.LIGHTNING_BOLT);
            registerSpellDispenseBehavior(ItemInit.AREA_LIGHTNING, EntityInit.AREA_LIGHTNING);
            registerSpellDispenseBehavior(ItemInit.SUMMON_WOLF, EntityInit.SUMMON_WOLF);
            registerSpellDispenseBehavior(ItemInit.SUMMON_SKELETON, EntityInit.SUMMON_SKELETON);
            registerSpellDispenseBehavior(ItemInit.SUMMON_WITHER_SKELETON, EntityInit.SUMMON_WITHER_SKELETON);
            registerSpellDispenseBehavior(ItemInit.DISINTEGRATE, EntityInit.DISINTEGRATE);
            registerSpellDispenseBehavior(ItemInit.ELEMENTAL_FURY, EntityInit.ELEMENTAL_FURY);
            registerSpellDispenseBehavior(ItemInit.WAIL_OF_THE_SHE_WOLF, EntityInit.WAIL_OF_THE_SHE_WOLF);
            registerSpellDispenseBehavior(ItemInit.BREACH, EntityInit.BREACH);
            registerSpellDispenseBehavior(ItemInit.COLOR_SPRAY, EntityInit.COLOR_SPRAY);
            registerSpellDispenseBehavior(ItemInit.PUSH, EntityInit.PUSH);
            registerSpellDispenseBehavior(ItemInit.CHAOS, EntityInit.CHAOS);
            registerSpellDispenseBehavior(ItemInit.MISCAST_MAGIC, EntityInit.MISCAST_MAGIC);
        });
    }

    private static void registerSpellDispenseBehavior(Supplier<? extends ProjectileSpell> item, Supplier<? extends EntityType<? extends SpellProjectile>> entity) {
        DispenserBlock.registerBehavior(item.get(), new AbstractProjectileDispenseBehavior() {
            @Nonnull
            @Override
            protected Projectile getProjectile(@Nonnull Level level, @Nonnull Position position, @Nonnull ItemStack stack) {
                return Util.make(entity.get().create(level), e -> e.setPos(position.x(), position.y(), position.z()));
            }
        });
    }
}
