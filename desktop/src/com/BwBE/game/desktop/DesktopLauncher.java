package com.BwBE.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.BwBE.game.BwBE;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Boats With Buds";
        config.width = 1080/3;
        config.height = 1920/3;
		new LwjglApplication(new BwBE(new ActionResolverDesktop()), config);
	}
}
