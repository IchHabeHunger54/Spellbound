package ihh.spellbound.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class SpellProjectileRenderer<T extends Entity & IRendersAsItem> extends SpriteRenderer<T> {
    private final ResourceLocation ITEM;

    public SpellProjectileRenderer(EntityRendererManager renderManagerIn, Item item) {
        super(renderManagerIn, Minecraft.getInstance().getItemRenderer());
        ITEM = new ResourceLocation("spellbound:textures/item/" + item.getRegistryName().getPath());
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull Entity entity) {
        return ITEM;
    }
}
