package com.wuxianggujun.libgdxgame.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class StartPlusScreen implements Screen {
 
    Stage stage;
    
    @Override
    public void show() {
        Viewport viewport =new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
       // stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(),false);
        
        stage = new Stage(viewport);
        Texture texture = new Texture(Gdx.files.internal("image/start_background.jpg"));
        
        Image backgroudImage = new Image(texture);
        backgroudImage.setFillParent(true);
        
        stage.addActor(backgroudImage);
    }

    @Override
    public void render(float p1) {
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
        stage.dispose();
     
    }

    
    
    
}
