package com.androidgdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.ColorAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import javax.xml.soap.Text;

public class MyActor extends Image {


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

        setBounds(getX(),getY(), getWidth(), getHeight());




        addListener(new InputListener(){
                        @Override
                        public boolean keyDown(InputEvent event, int keycode) {
                            if (keycode == Input.Keys.RIGHT)
                            {
                                MoveByAction mba = new MoveByAction();
                                mba.setAmount(100f, 100f);
                                mba.setDuration(5f);
                                MyActor.this.addAction(mba);
                            }
                            else if(keycode == Input.Keys.A)
                            {
                                ColorAction colorAction = new ColorAction();
                                colorAction.setEndColor(Color.PURPLE);
                                colorAction.setDuration(3f);
                                MyActor.this.addAction((colorAction));
                            }
                                return true;
                        }
        });
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
