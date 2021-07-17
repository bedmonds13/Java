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


    private float distance;

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(this.getColor());
        ((TextureRegionDrawable)getDrawable()).draw(batch, getX(),getY()
                ,getOriginX(),getOriginY(),
                getWidth(), getHeight()
                ,getScaleX(),getScaleY(),getRotation());

    }
    float speed;

    public MyActor(Texture texture)
    {


        super(texture);
        distance = 100f;
        speed = 0.1f;
        setBounds(getX(),getY(), getWidth(), getHeight());


        addListener(new InputListener(){
                        @Override
                        public boolean keyDown(InputEvent event, int keycode) {

                            Movement2D(keycode);
                            return true;
                        }
        });
    }

    private void Movement2D(int keycode) {
        switch (keycode)
        {
            case  Input.Keys.UP:
                addAction(moveTo(getX(),getY() + distance,speed));
                break;
            case  Input.Keys.DOWN:
                addAction(moveTo(getX(),getY()-distance,speed));
                break;
            case  Input.Keys.RIGHT:
                addAction(moveTo(getX()+distance,getY(),speed));
                break;
            case  Input.Keys.LEFT:
                addAction(moveTo(getX()-distance,getY(),speed));
                break;
            default:
                break;
        }
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
