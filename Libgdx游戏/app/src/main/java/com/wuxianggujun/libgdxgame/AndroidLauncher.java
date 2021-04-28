package com.wuxianggujun.libgdxgame;

import com.badlogic.gdx.backends.android.AndroidApplication;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.wuxianggujun.libgdxgame.game.MainGame;
public class AndroidLauncher extends AndroidApplication{
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;
        initialize(new MainGame(), config);
    }
    
    
}
