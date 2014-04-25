package se.skoggy.tweening;

import com.badlogic.gdx.math.Interpolation;
import se.skoggy.entities.Transform;

/**
 * Created by Erik on 2014-04-21.
 */
public class ScaleInterpolationTween extends TransformTween {

    private float start;
    private float end;
    private Interpolation interpolationType;

    public ScaleInterpolationTween(Transform object, float start, float end, Interpolation interpolationType, float duration) {
        super(object, duration);
        this.start = start;
        this.end = end;
        this.interpolationType = interpolationType;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if(!isDone()){
            object.setScale(interpolationType.apply(start, end, getProgress()));
        }
    }
}
