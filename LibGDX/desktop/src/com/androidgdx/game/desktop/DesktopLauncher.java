package com.androidgdx.game.desktop;

import com.androidgdx.game.ActorTest;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.androidgdx.game.HelloWorldGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 2000;
		config.height = 1000;
		new LwjglApplication(new ActorTest(), config);
	}
}
