package se.skoggy.tweening;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Interpolation;

/**
 * Created by Erik on 2014-04-21.
 */
public class AlphaInterpolationTween extends ColorTween{

    private float start;
    private float end;
    private Interpolation interpolationType;

    public AlphaInterpolationTween(Color color, float start, float end, Interpolation interpolationType, float duration) {
        super(color, duration);
        this.start = start;
        this.end = end;
        this.interpolationType = interpolationType;
    }

    @Override
    public void update(float dt) {
        super.update(dt);

        if(!isDone()){
            color.a = interpolationType.apply(start, end, getProgress());
        }
    }
}
