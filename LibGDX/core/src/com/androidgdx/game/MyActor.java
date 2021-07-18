package com.androidgdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.ColorAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import static  com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class MyActor extends Image {


    protected float distance;
    protected float speed;

    @Override
    public void draw(Batch batch, float parentAlpha) {


        batch.setColor(this.getColor());
        ((TextureRegionDrawable)getDrawable()).draw(batch, getX(),getY()
                ,getOriginX(),getOriginY(),
                getWidth(), getHeight()
                ,getScaleX(),getScaleY(),getRotation());

    }


    public MyActor(Texture texture)
    {
        super(texture);
        setZIndex(1);
        distance = 100f;
        speed = 0.1f;
        setBounds(getX(),getY(), getWidth(), getHeight());
    }

    @Override
    protected void positionChanged() {
        setPosition(getX(),getY());
        super.positionChanged();
    }



    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
