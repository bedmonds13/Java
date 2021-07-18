package com.androidgdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class Asteroid extends MyActor{
    public Asteroid(Texture texture) {
        super(texture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        addAction(moveTo(getX()- distance*speed, getY()));
    }

}
