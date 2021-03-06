package com.wuxianggujun.libgdxgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


/***
小球靠近屏幕边框自动反弹
*/
public class HelloWorldGame extends ApplicationAdapter{
    ShapeRenderer shapeRenderer;
    
    float circleX = 200;
    float circleY = 100;
    
    float xSpeed = 120;
    float ySpeed = 60;

    @Override
    public void create() {
       shapeRenderer = new ShapeRenderer();
       
    }

    @Override
    public void render() {
       circleX += xSpeed * Gdx.graphics.getDeltaTime();
       circleY +=ySpeed * Gdx.graphics.getDeltaTime();
       if(circleX < 0||circleX>Gdx.graphics.getWidth()){
           xSpeed *= -1;       
       }
      if(circleY < 0||circleY > Gdx.graphics.getHeight()){
          ySpeed *= -1;
      } 
      Gdx.gl.glClearColor(25f,25f,25f,1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      
      shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
      shapeRenderer.setColor(0,1,0,1);
      shapeRenderer.circle(circleX,circleY,75);
      shapeRenderer.end();
    }

    @Override
    public void dispose() {
           shapeRenderer.dispose();
    }
    
    
    
}
