package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Object
{
    private float moveSpeed;
    public Player(float speed, String filename, float width, float height, float posX, float posY)
    {
        moveSpeed = speed;
        img = new Texture(filename);
        size = new Vec2(width, height);
        centerPosition = new Vec2(posX, posY);
        position = new Vec2(posX - width/2, posY - height/2);
        velocity = new Vec2(0,0);
        lowerBounds = -1*Pong.HEIGHT/2;
        upperBounds = Pong.HEIGHT/2;
    }
    @Override
    public void Update()
    {
        if (position.y < lowerBounds)
        {
            position.y = lowerBounds;
        }
        if (position.y + size.y > upperBounds)
        {
            position.y = upperBounds - size.y;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            velocity.y = moveSpeed;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            velocity.y = -moveSpeed;
        }
        else
        {
            velocity.y = 0;
        }

        move();
    }
}
