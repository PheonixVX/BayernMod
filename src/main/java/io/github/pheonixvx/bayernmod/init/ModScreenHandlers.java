package io.github.pheonixvx.bayernmod.init;

import io.github.pheonixvx.bayernmod.BayernMod;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<BraukesselScreenHandler> BRAUKESSEL_HANDLER = register("braukessel_handler", BraukesselScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerRegistry.SimpleClientHandlerFactory<T> factory) {
        return ScreenHandlerRegistry.registerSimple(new Identifier(BayernMod.MOD_ID, id), factory);
    }
}
