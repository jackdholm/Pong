package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.mygdx.game.Player;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.Object;

public class MainScreen implements Screen
{
    Pong pong;
    Player player;
    Ball ball;
    AI ai;
    BitmapFont font;
    SpriteBatch batch;
    OrthographicCamera camera;

    public MainScreen(Pong pong)
    {
        this.resize(1920, 1080);
        this.pong = pong;
        player = new Player(600,"Player.png", 40, 400, -1*Pong.WIDTH/2+40, 0);
        ball = new Ball(1200, "Ball.png", 46, 46, 0, 0);
        ai = new AI(600,"Player.png", 40, 400, Pong.WIDTH/2-40, 0, ball);
        font = new BitmapFont(Gdx.files.internal("score_font.fnt"),Gdx.files.internal("score_font.png"),false);
        font.setColor(Color.WHITE);
        font.getData().setScale(7,7);
        camera = new OrthographicCamera(Pong.WIDTH, Pong.HEIGHT);
        camera.translate(Pong.WIDTH/2,Pong.HEIGHT/2);
        batch = new SpriteBatch();
        pong.batch.setProjectionMatrix(camera.combined);
    }
    @Override
    public void show()
    {
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ball.Update();
        player.Update();
        ai.Update();
        if (ball.collidesWith(player))
        {
            ball.velocity.x *= -1;
            ball.velocity.y += player.velocity.y * 0.25;
        }
        if (ball.collidesWith(ai))
        {
            ball.velocity.x *= -1;
            ball.velocity.y += ai.velocity.y * 0.25;
        }
        pong.batch.begin();
        pong.batch.draw(player.img, player.position.x, player.position.y);
        pong.batch.draw(ai.img, ai.position.x, ai.position.y);
        pong.batch.draw(ball.img, ball.position.x, ball.position.y);
        font.draw(pong.batch, Integer.toString(Pong.p1Score), -200, Pong.HEIGHT/2-10);
        font.draw(pong.batch, Integer.toString(Pong.p2Score), 200, Pong.HEIGHT/2-10);
        pong.batch.end();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }
}
