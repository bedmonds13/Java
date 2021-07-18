package com.androidgdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;


public class ActorTest  extends ApplicationAdapter   {

    Stage stage;
    Texture background;
    Player actor;
    Image backgroundImg;

    public void create() {
        background = new Texture(Gdx.files.internal("space-background.png"));
        


        ScreenViewport viewport = new ScreenViewport();
        stage = new Stage(viewport);
        stage.getViewport().update(viewport.getScreenWidth(), viewport.getScreenHeight(),false);
        Gdx.input.setInputProcessor(stage);




        Texture texture = new Texture(Gdx.files.getFileHandle("Starbasesnow.png", Files.FileType.Internal));
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
         backgroundImg = new Image(texture);

        /*
        Image backgroundImages[] = new Image[5];
        for (int i = 0; i < 5 ;i++)
        {
            Image backgroundImg = new Image(new Texture(Gdx.files.getFileHandle("Starbasesnow.png", Files.FileType.Internal)));
            backgroundImg.setZIndex(0);
            backgroundImages[i] = backgroundImg;
            stage.addActor(backgroundImg);
        }
*/
        actor = new Player(new Texture(Gdx.files.internal("blueship1.png")));
        Asteroid asteroid = new Asteroid(new Texture(Gdx.files.internal("asteroid1.png")));
        stage.addActor(backgroundImg);
        stage.addActor(actor);
        stage.addActor(asteroid);
        stage.setKeyboardFocus(actor);

    }

    @Override
    public void render() {

        backgroundImg.addAction(moveTo(backgroundImg.getX() -0.5f, backgroundImg.getY() ));
        // stage.getViewport().getCamera().position.y = actor.getY();
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
    }

}

