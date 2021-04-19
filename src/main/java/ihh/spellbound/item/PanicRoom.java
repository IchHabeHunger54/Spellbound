package ihh.spellbound.item;

import ihh.spellbound.Config;
import ihh.spellbound.Util;
import ihh.spellbound.init.BlockInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public final class PanicRoom extends SelfSpell {
    public PanicRoom() {
        super(Config.PANIC_ROOM_CHARGE_TIME);
    }

    @Override
    protected boolean use(ItemStack stack, LivingEntity target, ServerWorld world) {
        boolean b = false;
        int i = (Config.PANIC_ROOM_WIDTH.get() - 1) / 2;
        for (int w = -i; w <= i; w++)
            for (int h = -i; h <= i; h++)
                b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, Config.PANIC_ROOM_HEIGHT.get(), h)), BlockInit.DECAYING_BEDROCK.get()) || b;
        for (int w = -i; w <= i; w++)
            for (int h = -i; h <= i; h++)
                b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, -1, h)), BlockInit.DECAYING_BEDROCK.get()) || b;
        for (int w = -i + 1; w <= i + 1; w++)
            for (int h = 0; h < Config.PANIC_ROOM_HEIGHT.get(); h++) {
                b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(-i + 1, h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, h, -i + 1)), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(i + 1, h, w)), BlockInit.DECAYING_BEDROCK.get()) || b;
                b = Util.replaceAir(world, new BlockPos(target.getPositionVec().add(w, h, i + 1)), BlockInit.DECAYING_BEDROCK.get()) || b;
            }
        return b;
    }
}
