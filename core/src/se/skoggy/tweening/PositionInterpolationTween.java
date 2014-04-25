package se.skoggy.tweening;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import se.skoggy.entities.Transform;

/**
 * Created by Erik on 2014-04-21.
 */
public class PositionInterpolationTween extends TransformTween {

    private Vector2 start;
    private Vector2 end;
    private Interpolation interpolationType;

    public PositionInterpolationTween(Transform object, Vector2 start, Vector2 end, Interpolation interpolationType, float duration) {
        super(object, duration);
        this.start = start;
        this.end = end;
        this.interpolationType = interpolationType;
    }

    @Override
    public void update(float dt) {
        super.update(dt);
        if(!isDone()){
            object.position.x = interpolationType.apply(start.x, end.x, getProgress());
            object.position.y = interpolationType.apply(start.y, end.y, getProgress());
        }
    }
}
