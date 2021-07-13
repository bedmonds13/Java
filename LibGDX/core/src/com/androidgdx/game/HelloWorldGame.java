package com.androidgdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Scanner;

public class HelloWorldGame extends ApplicationAdapter  implements InputProcessor {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	BitmapFont font;
	String myText;
	BitmapFontCache cache;
	Sound sound;
	GlyphLayout bounds;
	float rotator = 0;
	@Override
	public void create () {

		sound = Gdx.audio.newSound(Gdx.files.internal("whistle.mp3"));
		long id = sound.play();
		float volume =1;
		sound.loop(volume-0.1f, 1.0f ,0.0f);

		batch = new SpriteBatch();


		img = new Texture("clout.png");

		sprite = new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2,
				Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		sprite.setScale(0.5f);

		font = new BitmapFont(Gdx.files.internal("ravie-blue.fnt"));
		cache = new BitmapFontCache(font);
		myText= "Hello World\n" + "This is my first attempt at a multiline string. \n" + "Adding the font to text as well\n ";

		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render () {
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT))
		{
			sprite.translateX(20f * Gdx.graphics.getDeltaTime());
			//rotator += 1 * Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT))
			rotator -= 1* Gdx.graphics.getDeltaTime();
		else  if(rotator < 0)
			rotator +=1 * Gdx.graphics.getDeltaTime();
		else if(rotator >0)
			rotator -=1 * Gdx.graphics.getDeltaTime();

		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear((GL20.GL_COLOR_BUFFER_BIT));
		GlyphLayout layout = new GlyphLayout(font, myText);

		batch.begin();
		font.draw(batch, layout, (Gdx.graphics.getWidth()/2 - layout.width/2)  , Gdx.graphics.getHeight()/2 + layout.height/2);
		batch.end();

		batch.begin();
		batch.draw(sprite, sprite.getX(), sprite.getY(), sprite.getWidth()/2,sprite.getHeight()/2,sprite.getWidth(),sprite.getHeight(), sprite.getScaleX(),sprite.getScaleY(), sprite.getRotation());
		batch.end();
		sprite.setRotation(sprite.getRotation()+ 10 * rotator );

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
		sprite.setPosition(screenX-sprite.getWidth()/2, (Gdx.graphics.getHeight()-screenY) -sprite.getHeight()/2 );
		sound.play();
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
		return false;
	}
}
