package ihh.spellbound.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.Item;

import javax.annotation.Nonnull;

public class SpellProjectileRenderer<T extends Entity & ItemSupplier> extends ThrownItemRenderer<T> {
    private final ResourceLocation ITEM;

    public SpellProjectileRenderer(EntityRendererProvider.Context renderManagerIn, Item item) {
        super(renderManagerIn);
        ITEM = new ResourceLocation("spellbound:textures/item/" + item.getRegistryName().getPath());
    }

    @Nonnull
    @Override
    public ResourceLocation getTextureLocation(@Nonnull Entity entity) {
        return ITEM;
    }
}
