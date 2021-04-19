package com.wuxianggujun.libgdxgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class Drop extends ApplicationAdapter {
    SpriteBatch batch;
    FreeTypeFontGenerator freeTypeFontGenerator;
    FreeTypeBitmapFontData fontData;
    FreeTypeFontParameter fontParameter;
    
    Texture img;
    BitmapFont font;
    Music music;
    Stage stage;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("test.jpg");
        font = new BitmapFont();
        freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("HanyiSentyMarshmallow.ttf"));
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.characters = freeTypeFontGenerator.DEFAULT_CHARS+"无相孤君";
        fontParameter.size = 100;
        fontParameter.color = Color.RED;
        font = freeTypeFontGenerator.generateFont(fontParameter);      
        stage = new Stage();

        stage.addActor(new ParticleActor(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2));
        stage.addListener(new InputListener() {
                @Override
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                    stage.addActor(new ParticleActor(x, y));

                    return true;
                }

                @Override
                public void touchDragged(InputEvent event, float x, float y, int pointer) {
                    super.touchDragged(event, x, y, pointer);

                    stage.addActor(new ParticleActor(x, y));
                }
            });

        Gdx.input.setInputProcessor(stage);
        
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        music.setLooping(true);
        music.play();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        batch.begin();
        font.draw(batch,"无相孤君",Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        // 和resize方法的坐标一致，0,0总是指屏幕左下角
        // 绘制位置px，(0,0)为[当前正常观看的]左下角        
        //for (int i = 0; i < 10000; i++) {
        batch.draw(img, MathUtils.random(Gdx.graphics.getWidth()), MathUtils.random(Gdx.graphics.getHeight()), 50, 50, 0, 1, 1, 0);
        // }
        batch.end(); 
        
        stage.act();
        stage.draw();
        
        
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        font.dispose();
        music.dispose();
        stage.clear();
        stage.dispose();
    }
    
    
    
    
}
