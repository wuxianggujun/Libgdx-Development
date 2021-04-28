package com.wuxianggujun.libgdxgame.actors;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

public class Human extends Actor {

    private TextureRegion[] walkFrams;//保存每一帧
    private Animation animation;
    private float stateTime;//总时间
    private TextureRegion currentFrame;//当前帧
    private int titleWidth = 50;
    private int titleHeight = 50;
    
    private Pixmap mPixmap;
    
    private int positionX;
    private int positionY;
    
    
   int margin= 2;
   int pixHeight= 5;
   int maxHp;//总血量
   int currentHp;//当前血量

    public Human(TextureRegion atlasRegion,int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.setWidth(titleWidth);
        this.setHeight(titleHeight);
        this.maxHp = 2; // 设置总血量为1
		this.currentHp = 2; // 设置当前血量为1
        
        TextureRegion[][] temp = atlasRegion.split(titleWidth,titleHeight);
        walkFrams = new TextureRegion[4];
        for(int i = 0;i<4;i++){
          walkFrams[i] = temp[i][i];  
        }
        animation = new Animation(0.1f,walkFrams);
    }
    
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = (TextureRegion) animation.getKeyFrame(stateTime,true);
        batch.draw(currentFrame,positionX,positionY,this.getWidth(),this.getHeight());
        
        Pixmap pixmap= new Pixmap(64,8,Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.drawRectangle(0,0,titleWidth,pixHeight);//绘制边框
        pixmap.setColor(Color.RED);
        pixmap.fillRectangle(0,1,titleWidth * currentHp/maxHp,pixHeight-2);//绘制血条
        
        
        Texture pixmaptex = new Texture(pixmap);
        TextureRegion pix = new TextureRegion(pixmaptex,titleWidth,pixHeight);
        batch.draw(pix,positionX,positionY,this.titleHeight,this.margin);
        pixmap.dispose();
              
    }
    
    
    
    
    
    
    
    
}
