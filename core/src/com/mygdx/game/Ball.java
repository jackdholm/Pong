package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Ball extends  Object
{
    float moveSpeed;
    Random rand;
    Vec2 startPosition;
    float lowerXBounds;
    float upperXbounds;

    public Ball(float speed, String filename, float width, float height, float posX, float posY)
    {
        moveSpeed = speed;
        img = new Texture(filename);
        size = new Vec2(width, height);
        centerPosition = new Vec2(posX, posY);
        startPosition = new Vec2(posX, posY);
        position = new Vec2(posX - width/2, posY - height/2);
        velocity = new Vec2(0,0);
        lowerBounds = -1*Pong.HEIGHT/2;
        upperBounds = Pong.HEIGHT/2;
        lowerXBounds = -1*Pong.WIDTH/2;
        upperXbounds = Pong.WIDTH/2;
        start();
    }
    void  start()
    {
        rand = new Random();
        velocity.x = rand.nextBoolean() ? 1 : -1;
        velocity.x *= moveSpeed;
        velocity.y = rand.nextBoolean() ? 1 : -1;
        velocity.y *= moveSpeed * rand.nextFloat();
    }
    @Override
    public void Update()
    {
        if (position.y < lowerBounds || position.y + size.y > upperBounds)
        {
            velocity.y *= -1;
        }
        if (position.x < lowerXBounds)
        {
            Pong.p2Score++;
            resetPosition();
        }
        else if (position.x + size.x > upperXbounds)
        {
            Pong.p1Score++;
            resetPosition();
        }
        move();
    }

    private void resetPosition()
    {
        centerPosition.x = startPosition.x;
        centerPosition.y = startPosition.y;
        position.x = centerPosition.x-size.x/2;
        position.y = centerPosition.y-size.y/2;
        start();
    }
}
