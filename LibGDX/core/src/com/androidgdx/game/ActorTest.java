package com.androidgdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class ActorTest  extends ApplicationAdapter   {

    Stage stage;
    Texture background;


    public void create() {
        background = new Texture(Gdx.files.internal("space-background.png"));
        


        ScreenViewport viewport = new ScreenViewport();
        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);;

        MyActor actor = new MyActor(new Texture(Gdx.files.internal("blueship1.png")));
        stage.addActor(actor);
        stage.setKeyboardFocus(actor);

    }

    @Override
    public void render() {
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {

        }
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
    }

}

