package ryan.ufm.mixin;

import net.minecraft.client.util.Monitor;
import net.minecraft.client.util.VideoMode;
import net.minecraft.client.util.Window;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import ryan.ufm.IWindow;

@Mixin({Window.class})
public abstract class WindowMixin implements IWindow {
    @Shadow private int windowedX, windowedY, windowedWidth, windowedHeight;
    @Shadow @Nullable public abstract Monitor getMonitor();
    @Shadow protected abstract void updateWindowRegion();
    @Shadow @Final private long handle;
    @Shadow private boolean fullscreen;

    @Unique public void ufm$override() {
        GLFW.glfwSetWindowAttrib(handle, GLFW.GLFW_DECORATED, GLFW.GLFW_FALSE);

        Monitor monitor = getMonitor();
        assert monitor != null;

        VideoMode vm = monitor.getCurrentVideoMode();

        int w = vm.getWidth();
        // push a line of pixels below the screen
        int h = vm.getHeight() + 1;

        windowedWidth = w;
        windowedHeight = h;
        windowedX = 0;
        windowedY = 0;
        fullscreen = false;

        updateWindowRegion();
    }
}
