package com.wuxianggujun.libgdxgame;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;

public class TitleScreen extends ScreenAdapter {
    MainGame game;

    public TitleScreen(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter(){
                @Override
                public boolean keyDown(int keyCode) {
                    if(keyCode == Input.Keys.SPACE){
                        game.setScreen(new GameScreen(game));
                    }
                    return true;
                }

            });    
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0,25f,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.spriteBatch.begin();
        game.bitmapFont.draw(game.spriteBatch,"Title Screen",Gdx.graphics.getWidth() /2, Gdx.graphics.getHeight() /2);  
        game.bitmapFont.draw(game.spriteBatch,"Click the circle to win",Gdx.graphics.getWidth() * 25f, Gdx.graphics.getHeight() * 5f);  
        game.bitmapFont.draw(game.spriteBatch,"Press space to play",Gdx.graphics.getWidth() * 25f, Gdx.graphics.getHeight() * 25f);  
        game.spriteBatch.end();
        
        
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }


    

}
