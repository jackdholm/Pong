package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class AI extends Object
{
    private float moveSpeed;
    private float threshold = 100;
    Ball ball;

    public AI(float speed, String filename, float width, float height, float posX, float posY, Ball ball)
    {
        moveSpeed = speed;
        img = new Texture(filename);
        size = new Vec2(width, height);
        centerPosition = new Vec2(posX, posY);
        position = new Vec2(posX - width/2, posY - height/2);
        velocity = new Vec2(0,0);
        lowerBounds = -1*Pong.HEIGHT/2;
        upperBounds = Pong.HEIGHT/2;
        this.ball = ball;
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
        if (ball.centerPosition.y + threshold > centerPosition.y)
        {
            velocity.y = moveSpeed;
        }
        else if (ball.centerPosition.y - threshold < centerPosition.y)
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
