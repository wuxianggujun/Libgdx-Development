package com.wuxianggujun.libgdxgame.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.wuxianggujun.libgdxgame.screen.MainMenuScreen;
import com.badlogic.gdx.Gdx;
import com.wuxianggujun.libgdxgame.screen.StartScreen;
import com.wuxianggujun.libgdxgame.screen.GameScreen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;

public class MainGame extends Game {
    
   public MainMenuScreen mainMenuScreen;
   public StartScreen startScreen;
   public GameScreen gameScreen;
   public int SCREEN_WIDTG = 1080;
   public int SCREEN_HEIGHT = 720;
  // public Music music;
   public AssetManager assetManager;
   
   public static final String START_BACKGROUND_IMAGE = "image/start_background.jpg";
    public static final String BITMAPFONT = "font/HanyiSentyMarshmallow.ttf";
    
   
   
   
    @Override
    public void create() {
       /* mainMenuScreen = new MainMenuScreen(this);
        startScreen = new StartScreen(this);
        gameScreen = new GameScreen(this);
        */
         assetManager = new AssetManager();
         assetManager.load(START_BACKGROUND_IMAGE,Texture.class);
         //assetManager.load(BITMAPFONT,BitmapFont.class);
         assetManager.load("music/music.mp3",Music.class);
         assetManager.load("image/hero/hero.png",Texture.class);
         //assetManager.load("sound/sy.wav",Sound.class);
         
         assetManager.finishLoading();
         
       /* music = Gdx.audio.newMusic(Gdx.files.internal("music/music.mp3")); 
        music.play();
        music.setLooping(true);
        music.setVolume(15f);
        */
        
        //this.setScreen(startScreen);
    }

    @Override
    public void dispose() {
        super.dispose();
        if(startScreen!=null){
        startScreen.dispose();
        }
        if(assetManager !=null){
            assetManager.dispose();
        }
        if(mainMenuScreen != null){
            mainMenuScreen.dispose();
            mainMenuScreen = null;
        }
        
    }
    
    
    
    
    
}
