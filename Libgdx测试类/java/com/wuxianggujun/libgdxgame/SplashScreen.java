package com.wuxianggujun.libgdxgame.screen;


import com.badlogic.gdx.Screen;
import com.wuxianggujun.libgdxgame.game.MainGame;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;


public class SplashScreen implements Screen,GestureListener {
    MainGame game;

   private SpriteBatch batch;
   private Texture texture;

   private OrthographicCamera camera;
   private Sprite sprite;
   
   //字体
   FreeTypeFontGenerator generator;
   BitmapFont font;
   
   Stage stage;
     
    public SplashScreen(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(1280,720);  
        stage = new Stage();
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("image/start_background.jpg"));
        texture.setFilter(Texture.TextureFilter.Linear,Texture.TextureFilter.Linear);
        
        sprite = new Sprite(texture);
        sprite.setOrigin(0,0);
        sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
         
         font = new BitmapFont();
         generator = new FreeTypeFontGenerator(Gdx.files.internal("font/HanyiSentyMarshmallow.ttf"));
         FreeTypeFontParameter parameter = new FreeTypeFontParameter();
         parameter.characters = generator.DEFAULT_CHARS+"无相孤君";
         parameter.size = 40;
         parameter.flip = false;
         parameter.genMipMaps = true;
                 
         font = generator.generateFont(parameter); 
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        Label title = new Label("开始游戏", labelStyle);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight() * 2 / 3);
        title.setWidth(Gdx.graphics.getWidth());
        
        stage.addActor(title);
        
         //stage.addListener(new  GestureListener(this));
                
        Gdx.input.setInputProcessor(new GestureDetector(this));
        generator.dispose();
    }
    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(float arg0) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
       
        batch.begin();
  
        sprite.draw(batch);
       
        batch.end();
        stage.act();
        stage.draw();
        
    }

    @Override
    public void resize(int arg0, int arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
     batch.dispose();
     texture.dispose();
    }


    @Override
    public boolean touchDown(float p1, float p2, int p3, int p4) {
        return false;
    }

    @Override
    public boolean tap(float p1, float p2, int p3, int p4) {
        game.setScreen(game.startScreen);
        return false;
    }

    @Override
    public boolean longPress(float p1, float p2) {
        return false;
    }

    @Override
    public boolean fling(float p1, float p2, int p3) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {   
      camera.translate(deltaX,0);
      camera.update();
        return false;
    }

    @Override
    public boolean panStop(float p1, float p2, int p3, int p4) {
        return false;
    }

    @Override
    public boolean zoom(float p1, float p2) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 p1, Vector2 p2, Vector2 p3, Vector2 p4) {
        return false;
    }

    @Override
    public void pinchStop() {
    }


    
    
    }
