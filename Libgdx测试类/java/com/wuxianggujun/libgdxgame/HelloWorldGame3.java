package com.wuxianggujun.libgdxgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;

public class HelloWorldGame3 extends ApplicationAdapter{
    ShapeRenderer shapeRenderer;

    @Override
    public void create()
    {
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void render() {
       Gdx.gl.glClearColor(25f,25f,25f,1);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);              
       
      for(int i=0;i<10000;i++){
          shapeRenderer.setColor(MathUtils.random(),MathUtils.random(),MathUtils.random(),1);      
          shapeRenderer.circle(MathUtils.random(Gdx.graphics.getWidth()),MathUtils.random(Gdx.graphics.getHeight()),25);
      }
      shapeRenderer.end();
       
       
    }

    @Override
    public void dispose() {
       shapeRenderer.dispose();
    }
    

    
      
    
}
