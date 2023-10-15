# UFM (Undecorated Fullscreen Mod)
This mod forces the game to appear as a fullscreen application without actually applying the fullscreen attribute.

The intention is to enable Windows 11 screenshot functionality and application switching without the window disappearing, as it does if the game were in fullscreen.

This goal is achieved while also maintaining the clean look of fullscreen, having no decorations (toolbar + close button) and filling the whole* screen.

Well... it actually makes the window fill the whole screen *except* for the rightmost column. This is because I was experiencing some minor issues when the whole screen was filled (The application floated over the Snip & Sketch tool's overlay and the screen flashed whenever switching to other applications).

Windows seems to know if an application covers the whole monitor and assigns it as fullscreen without being explicitly told to do so. I believe this to be due in part to LWJGL 3, which Minecraft 1.20.2 uses, as I'm able to fill the whole screen while still avoiding "fullscreen" behavior when using LWJGL 2.

The one-wide line of pixels on the right is only really noticible if you know about it beforehand though, so it's allg.
