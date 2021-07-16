package com.androidgdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class ActorTest  extends ApplicationAdapter {
    Stage stage;

    public void create() {
        ScreenViewport viewport = new ScreenViewport();
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);;

        MyActor actor = new MyActor(new Texture(Gdx.files.internal("clout.png")));
        stage.addActor(actor);
        stage.setKeyboardFocus(actor);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }
}

