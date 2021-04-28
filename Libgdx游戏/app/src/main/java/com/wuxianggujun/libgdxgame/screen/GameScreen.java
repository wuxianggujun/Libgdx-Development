package com.wuxianggujun.libgdxgame.screen;
import com.badlogic.gdx.Screen;
import com.wuxianggujun.libgdxgame.game.MainGame;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.wuxianggujun.libgdxgame.actors.Human;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class GameScreen implements Screen {
    private MainGame game;

    private Stage stage;
    //private Viewport viewport;

    public GameScreen(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Viewport viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport.apply(true);
        stage = new Stage(viewport);

        Gdx.input.setInputProcessor(stage);
        Texture texture = new Texture(Gdx.files.internal("image/hero/hero.png"));
        TextureRegion textureRegion = new TextureRegion(texture);
        for (int i = 0; i < 100; i++) {
            Human human = new Human(textureRegion,MathUtils.random(Gdx.graphics.getWidth()),MathUtils.random(Gdx.graphics.getHeight()));   
            stage.addActor(human); 
        }
        
    }

    @Override
    public void render(float p1) {
        Gdx.gl.glClearColor(0.39f, 0.58f, 0.92f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int p1, int p2) {
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
