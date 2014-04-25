package se.skoggy.tweening;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Erik on 2014-04-21.
 */
public abstract class ColorTween extends Tween {

    protected Color color;

    public ColorTween(Color color, float duration) {
        super(duration);
        this.color = color;
    }
}
