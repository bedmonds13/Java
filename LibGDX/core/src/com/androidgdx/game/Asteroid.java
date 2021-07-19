package com.androidgdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class Asteroid extends MyActor{
    Actor target;
    Sound sound;
    public Asteroid(Texture texture, Player target) {
        super(texture);
        sound = Gdx.audio.newSound(Gdx.files.internal("punch.mp3"));

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(IsActive == true)
        {
            addAction(moveTo(getX()- distance*speed, getY()));
            super.draw(batch, parentAlpha);
            CollisionCheck();
        }

    }

    public void setTarget(Actor target) {
        this.target = target;
    }
    private void CollisionCheck()
    {
        assert target != null;

        if((target.getX() > getX() && target.getX() < getX() + getWidth()) && target.getY() > getY() && target.getY() < getHeight() + getY())
        {
            IsActive = false;
            sound.play();
        }

    }
}
