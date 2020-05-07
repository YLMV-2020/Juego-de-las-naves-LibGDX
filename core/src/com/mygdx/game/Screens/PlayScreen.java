package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

import javax.swing.Renderer;

public class PlayScreen implements Screen {

    MyGdxGame game;
    SpriteBatch batch;

    Texture texture;
    ShapeRenderer renderer;

    OrthographicCamera camera;
    Viewport viewport;

    BitmapFont texto;



    public PlayScreen(MyGdxGame game)
    {
        this.game = game;
        batch = new SpriteBatch();

        texture = new Texture("nebula.jpg");
        renderer = new ShapeRenderer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, MyGdxGame.WIDTH, MyGdxGame.HEIGHT);
        viewport = new FitViewport(MyGdxGame.WIDTH, MyGdxGame.HEIGHT, camera);

        texto = new BitmapFont();
        texto.getData().setScale(2);
        texto.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        camera.update();

      //  game.batch.setProjectionMatrix(camera.combined);
        renderer.setProjectionMatrix(viewport.getCamera().combined);
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        texto.draw(batch,"VIDAS" ,20,30);
        batch.draw(texture,0,0);
        batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            camera.translate(-180*delta,0);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            camera.translate(0,180*delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            camera.translate(0,-180*delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            camera.translate(180*delta,0);
        }

    }

    @Override
    public void resize(int width, int height) {
        camera.viewportHeight = MyGdxGame.HEIGHT;
        camera.viewportWidth = MyGdxGame.WIDTH;
        camera.position.set(0,0,0);
        viewport.update(width,height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
