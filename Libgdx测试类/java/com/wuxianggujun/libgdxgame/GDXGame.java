package com.wuxianggujun.libgdxgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;


public class GDXGame extends ApplicationAdapter {

    private Stage stage;
    private Music music;
    private Sound sound;
    private Label playOrPauseMusic;
    private Label stopMusic;
    private Label playSound;
    private Label loopSound;
    private Label stopSound;

    @Override
    public void create() {
        initAudioRes(); // 加载音频
        initActors(); // 创建操作控件
        initEvent(); // 定义事件
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        if (music.isPlaying())
            music.stop();
        music.dispose();

        sound.stop();
        sound.dispose();

        stage.clear();
        stage.dispose();
    }

    private void initAudioRes() {
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3")); // 底层是安卓的MediaPlayer
        music.setLooping(true); // 循环。有对应的get方法
        music.isLooping(); // 是否循环模式。有对应的get方法
        music.setVolume(1f); // 音量。取值0-1。有对应的get方法
        music.setPan(-1, 0);// 指定声道音量。pan（-1左声道、1右声道、0中间），volume取值0-1。可制造从左到右的效果。有对应的get方法
        music.setPosition(11); //指定播放位置-秒。有对应的get方法。原生MediaPlayer.getDuration()可得到音乐长度
        music.setOnCompletionListener(new Music.OnCompletionListener() {
                @Override
                public void onCompletion(Music music) {
                    // 播放结束做点什么
                }
            });

        sound = Gdx.audio.newSound(Gdx.files.internal("drivecar.wav")); // 底层为安卓的SoundPool
        //sound.setPan(soundId, -1, 1); // 根据id设置声道音量
        //sound.setPitch(soundId, 2); // 音调。默认1, 大于1会变尖锐，反之低沉取值0.5-2
        //sound.setVolume(soundId, 1f); // 音量。
        //sound.setLooping(soundId, true); // soud.play后返回播放线程的id，可以据此控制其是否循环播放
    }

    private void initActors() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        
        BitmapFont font = new BitmapFont(Gdx.files.internal("fnt.fnt"));
        
//        FreeTypeFontGenerator  freeTypeFontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("HanyiSentyMarshmallow.ttf"));
//        FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
//        fontParameter.characters = freeTypeFontGenerator.DEFAULT_CHARS+"无相孤君";
//        fontParameter.size = 100;
//        fontParameter.color = Color.RED;
//        BitmapFont font = freeTypeFontGenerator.generateFont(fontParameter);      
//        
         
        Label.LabelStyle style = new Label.LabelStyle(font, Color.WHITE);

        // Music 播放，暂停
        playOrPauseMusic = new Label("播放Music", style);
        playOrPauseMusic.setPosition(100, Gdx.graphics.getHeight() - 200);

        // Music 停止
        stopMusic = new Label("停止Music", style);
        stopMusic.setPosition(400, Gdx.graphics.getHeight() - 200);

        // Sound 播放
        playSound = new Label("播放Sound", style);
        playSound.setPosition(100, Gdx.graphics.getHeight() - 600);

        // Sound 循环
        loopSound = new Label("循环Sound", style);
        loopSound.setPosition(400, Gdx.graphics.getHeight() - 600);

        // Sound 停止
        stopSound = new Label("停止Sound", style);
        stopSound.setPosition(700, Gdx.graphics.getHeight() - 600);

        stage.addActor(playOrPauseMusic);
        stage.addActor(stopMusic);
        stage.addActor(playSound);
        stage.addActor(loopSound);
        stage.addActor(stopSound);
    }

    private void initEvent() {
        playOrPauseMusic.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);

                    if (music.isPlaying()) {
                        music.pause();
                        playOrPauseMusic.setText("Music暂停中");
                    } else if (!music.isPlaying()) { // 没有isPause()
                        music.play();

                        playOrPauseMusic.setText("播放Music");
                    }
                }
            });
        stopMusic.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);

                    music.stop();
                }
            });

        playSound.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    long soundId = sound.play(); // 返回一个id
                    //sound.play(1); // 制定音量
                    //sound.play(1, 1, 1); // 指定音量、音调、声道
                }
            });
        loopSound.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    sound.loop();  // 无限循环播放
                    //sound.loop(2); // 再播放指定次数
                    //sound.loop(1, 2, -1); // 按音量，音调，声道，播放1次
                }
            });
        stopSound.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);

                    sound.stop();
                    //sound.stop(soundId); // 停止某个音效
                }
            });
    }
}
