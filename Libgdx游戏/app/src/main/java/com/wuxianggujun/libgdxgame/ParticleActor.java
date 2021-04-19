package com.wuxianggujun.libgdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ParticleActor extends Actor {

    float x, y;
    ParticleEffect effect;

    /* x,y坐标 */
    public ParticleActor(float x, float y) {
        effect = new ParticleEffect();
        // 加载tool生成的粒子属性配置文件
       effect.load(Gdx.files.internal("fire.p"), Gdx.files.internal("")); // 如果粒子的图片在assets根目录就留空，默认图片明即.p文件最后的配置
        this.x = x;
        this.y = y;
        effect.start();

        // 过多久熄灭火焰
        new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000); // 注意粒子的life，火焰的燃烧周期。否则只看到燃起的一瞬间
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    effect.dispose();
                    effect = null;
                }
            }).start();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (null != effect) {
            effect.setPosition(x, y);
        }
        if (null != effect) {
            effect.update(delta);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (null != effect) {
            effect.draw(batch);
        }
    }
}
