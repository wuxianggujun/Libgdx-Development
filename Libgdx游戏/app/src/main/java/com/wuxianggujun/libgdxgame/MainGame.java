package com.wuxianggujun.libgdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class MainGame extends Game {
    SpriteBatch spriteBatch;
    ShapeRenderer shapeRenderer;
    BitmapFont bitmapFont;
    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        bitmapFont = new BitmapFont();
        setScreen(new TitleScreen(this));     
    }

    @Override
    public void dispose() {
      spriteBatch.dispose();
      shapeRenderer.dispose();
      bitmapFont.dispose();
    }
    
    
    
    
}
