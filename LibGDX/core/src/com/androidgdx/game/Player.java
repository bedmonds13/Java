package com.androidgdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;

public class Player extends   MyActor{


    Player(Texture texture)
    {
        super(texture);
        distance  = 100f;
        speed = 0.1f;
        addListener(new InputListener(){
            @Override
            public boolean keyDown(InputEvent event, int keycode) {

                Movement2D(keycode);
                return true;
            }
        });
    }

    protected void Movement2D(int keycode) {

            switch (keycode) {
                case Input.Keys.UP:
                    if(getY() + distance < getStage().getHeight())
                        addAction(moveTo(getX(), getY() + distance, speed));
                    break;
                case Input.Keys.DOWN:
                    if(getY() - distance > 0)
                        addAction(moveTo(getX(), getY() - distance, speed));
                    break;
                case Input.Keys.RIGHT:
                    if(getX() + distance < getStage().getWidth() - getWidth())
                        addAction(moveTo(getX() + distance, getY(), speed));
                    break;
                case Input.Keys.LEFT:
                    if(getX() - distance > 0)
                    addAction(moveTo(getX() - distance, getY(), speed));
                    break;
                default:
                    break;
            }
        }
    }

