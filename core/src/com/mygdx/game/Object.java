package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.security.PublicKey;

public class Object
{
    public Vec2 position;
    public Vec2 velocity;
    public Vec2 size;
    public Vec2 centerPosition;
    public com.badlogic.gdx.graphics.Texture img;
    public float lowerBounds;
    public float upperBounds;

    public Object()
    {

    }
    public void Update()
    {

    }
    public boolean collidesWith(Object other)
    {
        return  position.x < other.position.x + other.size.x
                && position.y < other.position.y + other.size.y
                && position.x + size.x > other.position.x
                && position.y + size.y > other.position.y;
    }
    void move()
    {
        position.x = position.x + velocity.x * Gdx.graphics.getDeltaTime();
        position.y = position.y + velocity.y * Gdx.graphics.getDeltaTime();
        centerPosition.x = centerPosition.x + velocity.x * Gdx.graphics.getDeltaTime();
        centerPosition.y = centerPosition.y + velocity.y * Gdx.graphics.getDeltaTime();
    }
}
