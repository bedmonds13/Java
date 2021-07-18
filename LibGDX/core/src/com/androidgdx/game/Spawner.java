package com.androidgdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.*;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class Spawner extends Actor {
    List<Asteroid> spawnablesStored;
    List<Asteroid> spawnables;
    float time=0;

    Spawner()
    {

        spawnables = new ArrayList<>();

        Texture texture = new Texture(Gdx.files.internal("asteroid1.png"));
        for (int i = 0; i < 5; i++) {
            spawnables.add(new Asteroid(texture));

            spawnables.get(i).setScale(0.5f);
            spawnables.get(i).IsActive = false;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        time += Gdx.graphics.getDeltaTime();
        if(time > 5 )
        {
            for (Asteroid asteroid: spawnables
                 ) {
                asteroid.IsActive= true;

            }
        }
        if(time > 15 && spawnables.get(0).getX() < 0)
        {
            spawnables.get(0).setX(getStage().getWidth());
            time = 0;
        }
    }
}
