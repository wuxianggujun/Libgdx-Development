package com.wuxianggujun.libgdxgame.screen;
import com.badlogic.gdx.Screen;
import com.wuxianggujun.libgdxgame.game.MainGame;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;



public class StartScreen implements Screen {
  
    private static final int WORLD_WIDTH = 1280;
    private static final int WORLD_HEIGHT = 720;
    
    private MainGame game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Stage stage;
    private Texture texture;
    private Sprite sprite;
    private Viewport viewport;
    FreeTypeFontGenerator generator;
   
    public StartScreen(MainGame game) {
        this.game = game;
    }
    
    @Override
    public void show() {
        texture = new Texture(Gdx.files.internal("image/start_background.jpg"));
        texture.setFilter(TextureFilter.Linear,TextureFilter.Linear);
        sprite = new Sprite(texture);
        sprite.setOrigin(0,0);
        sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);   
        
        camera = new OrthographicCamera(WORLD_WIDTH,WORLD_HEIGHT);
        viewport = new StretchViewport(WORLD_WIDTH,WORLD_HEIGHT,camera);
        stage = new Stage();
        viewport.setCamera(camera);
        //camera = (OrthographicCamera) stage.getCamera();
           
        batch = new SpriteBatch();
        
        BitmapFont  font = new BitmapFont();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font/HanyiSentyMarshmallow.ttf"));
        FreeTypeFontParameter parameter = new FreeTypeFontParameter();
        parameter.characters = generator.DEFAULT_CHARS+"被遗忘的世界";
        parameter.size = 100;
        parameter.color = Color.RED;
        font = generator.generateFont(parameter); 
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        Label title = new Label("被遗忘的世界", labelStyle);
        title.setAlignment(Align.center);
        title.setY(Gdx.graphics.getHeight() * 2 / 3);
        title.setWidth(Gdx.graphics.getWidth());
        stage.addActor(title);
        
        parameter.characters = generator.DEFAULT_CHARS+"开始游戏";
        parameter.size = 100;
        parameter.color = Color.RED;
        
        font = generator.generateFont(parameter); 
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        TextButton playButton=new TextButton("开始游戏", textButtonStyle);
        playButton.setWidth(Gdx.graphics.getWidth() / 2);
        playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - playButton.getHeight() / 2);
        playButton.addListener(new ClickListener(){

                @Override
                public void clicked(InputEvent event, float x, float y) {               
                    game.setScreen(game.gameScreen);
                    //game.setScreen(new StartPlusScreen());
                }

            });
        stage.addActor(playButton);           
        Gdx.input.setInputProcessor(stage);        
    }

    @Override
    public void render(float p1) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        
        sprite.draw(batch);
        
        batch.end();
        
        stage.draw();
      
    }

    @Override
    public void resize(int width, int height) {
                
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
        if(generator!=null){
            generator.dispose();
        }
        if(batch!=null){
           batch.dispose(); 
        }
        if(stage!=null){
           stage.dispose(); 
        }
    }
    
    
    
    
}
