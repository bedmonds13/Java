package com.androidgdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.*;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class Spawner extends Actor {
    List<Asteroid> spawnablesStored;
    List<Asteroid> spawnableList;
    float time=0;
    Random randomSeed;
    Player playerTarget;

    Spawner(Player player)
    {
        playerTarget = player;
        spawnableList = new ArrayList<>();
        randomSeed = new Random();
        Texture texture = new Texture(Gdx.files.internal("asteroid1.png"));
        for (int i = 0; i < 30; i++) {
            Asteroid asteroid = new Asteroid(texture, player);
            spawnableList.add(asteroid);
            asteroid.IsActive = false;
            asteroid.setScale(0.5f);
            asteroid.setTarget(player);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        time += Gdx.graphics.getDeltaTime();

        if(time > 0.5f  && HasAvailableObject())
        {
            int asteroidIndex = GetLane();
            GrabObject(asteroidIndex);
            time = 0;
        }

    }
    private int GetLane()
    {

        return (int) Math.floor(Math.random()*spawnableList.size()+1);
    }
    private Boolean HasAvailableObject()
    {
        for (Asteroid spawnable: spawnableList) {
            if(spawnable.getX() < 0 || spawnable.IsActive == false)
            {
                spawnableList.remove(spawnable);
                spawnableList.add(spawnable);
                spawnable.IsActive = true;
                return true;
            }

        }
        return false;
    }
    private void GrabObject(int lane)
    {
        float y = lane/getStage().getHeight();
        spawnableList.get(spawnableList.size()-1).setPosition(getStage().getWidth(), (getStage().getHeight()/spawnableList.size()*lane));
    }
}
