package ryan.ufm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.client.MinecraftClient;

public class UFM implements ModInitializer {
    private boolean ufmFlag = false;

    @Override
    public void onInitialize() {
        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            if (ufmFlag) return;
            ufmFlag = true;

            ((IWindow) (AutoCloseable) MinecraftClient.getInstance().getWindow()).ufm$override();
        });
    }
}