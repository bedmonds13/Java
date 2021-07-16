package com.androidgdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Scanner;

public class HelloWorldGame extends ApplicationAdapter  implements InputProcessor {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;

	Sound sound;
	GlyphLayout bounds;
	float rotator = 0;
	final float GAME_WORLD_WIDTH = 100;
	final float GAME_WORLD_HEIGHT = 50;
	float aspectRatio;

	OrthographicCamera camera;
	@Override
	public void create () {


		sound = Gdx.audio.newSound(Gdx.files.internal("whistle.mp3"));
		float volume =1;

		batch = new SpriteBatch();


		img = new Texture("clout.png");

		sprite = new Sprite(img);

		sprite.setSize(1, 1);
		sprite.setPosition(0,0);
		sprite.setOriginCenter();

		aspectRatio =(float) Gdx.graphics.getHeight()/ (float)Gdx.graphics.getWidth();
		camera = new OrthographicCamera(GAME_WORLD_HEIGHT * aspectRatio , GAME_WORLD_HEIGHT);
		camera.translate(0, 0);




		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render () {
		camera.update();

		if(Gdx.input.isKeyPressed(Input.Keys.A))
			sprite.translateX(-1f * Gdx.graphics.getDeltaTime());
		else if(Gdx.input.isKeyPressed(Input.Keys.D))
			sprite.translateX(1f * Gdx.graphics.getDeltaTime());



		Gdx.gl.glClearColor(0.8f,0.2f,0.8f,1);
		Gdx.gl.glClear((GL20.GL_COLOR_BUFFER_BIT));



		sprite.setRotation(sprite.getRotation()+ 1 * rotator );
		batch.begin();
		batch.setProjectionMatrix((camera.combined));
		sprite.draw(batch);
		batch.end();



	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
		{
			Vector3 convertedPosition = camera.unproject(new Vector3(screenX, screenY,0));
			sprite.setPosition(convertedPosition.x-sprite.getWidth()/2, convertedPosition.y - sprite.getHeight()/2 );
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {

		if(amountY > 0)
			rotator += 1 * Gdx.graphics.getDeltaTime() * amountY;
		else  if(amountY < 0)
			rotator += 1 * Gdx.graphics.getDeltaTime() * amountY;

		return true;
	}
}
