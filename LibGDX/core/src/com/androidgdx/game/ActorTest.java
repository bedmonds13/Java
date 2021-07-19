package com.androidgdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;


public class ActorTest  extends ApplicationAdapter   {

    World world;
    Stage stage;
    Texture background;
    Player player;
    Image backgroundImg;
    Spawner asteroidSpawner;

    public void create() {
        world = new World(new Vector2(0,-10f), true);
        background = new Texture(Gdx.files.internal("space-background.png"));



        ScreenViewport viewport = new ScreenViewport();
        stage = new Stage(viewport);
        stage.getViewport().update(viewport.getScreenWidth(), viewport.getScreenHeight(),false);
        Gdx.input.setInputProcessor(stage);
        player = new Player(new Texture(Gdx.files.internal("blueship1.png")));
        stage.setKeyboardFocus(player);




        Texture texture = new Texture(Gdx.files.getFileHandle("Starbasesnow.png", Files.FileType.Internal));
        texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        backgroundImg = new Image(texture);
        stage.addActor(backgroundImg);




        asteroidSpawner = new Spawner(player);
        stage.addActor(asteroidSpawner);
        for (int i = 0; i < asteroidSpawner.spawnableList.size() ; i++)
        {
            asteroidSpawner.spawnableList.get(i).addAction(moveTo(stage.getWidth()-asteroidSpawner.getWidth(), (stage.getHeight()/5) * i));
            stage.addActor(asteroidSpawner.spawnableList.get(i));
        }

        stage.addActor(player);



    }

    @Override
    public void render() {

        backgroundImg.addAction(moveTo(backgroundImg.getX() -0.5f, backgroundImg.getY() ));

        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            stage.act(Gdx.graphics.getDeltaTime());
            stage.draw();
    }

}

