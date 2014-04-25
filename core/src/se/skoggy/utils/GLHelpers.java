package se.skoggy.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

/**
 * Created by Erik on 2014-04-21.
 */
public class GLHelpers {

    public static void enableAlpha(){
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    public static void disableAlpha(){
        Gdx.gl.glDisable(GL20.GL_BLEND);
    }
}
