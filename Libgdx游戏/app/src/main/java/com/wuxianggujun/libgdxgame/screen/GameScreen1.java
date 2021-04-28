package com.wuxianggujun.libgdxgame.screen;

import com.badlogic.gdx.Screen;
import com.wuxianggujun.libgdxgame.game.MainGame;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;

public class GameScreen1 implements Screen {         

    MainGame game;
    public static final int FRAME_COLS = 4;
    public static final int FRAME_ROWS = 4;
    
    Animation animation;

    Texture texture;
    
    TextureRegion[] textureRegion;
    
    SpriteBatch batch;
    
    TextureRegion currentFrame;
    float startTime;
    
    public GameScreen1(MainGame game) {
        this.game = game;
        texture = new Texture(Gdx.files.internal("image/hero/hero.png"));
        TextureRegion[][] temp = TextureRegion.split(texture,texture.getWidth() / FRAME_COLS,texture.getHeight() / FRAME_ROWS);
        textureRegion = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
               textureRegion[index++] = temp[i][j];
            }
        }
        animation = new Animation(0.025f,textureRegion);
       // animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);   
        
        batch = new SpriteBatch();
        
        startTime= 0;
        
        
       
        
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float p1) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        startTime+=Gdx.graphics.getDeltaTime();
        
        currentFrame = (TextureRegion) animation.getKeyFrame(startTime,true);
        
        batch.begin();     
        batch.draw(currentFrame,100,100);
        batch.end();
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
