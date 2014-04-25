package se.skoggy.tweening;

import se.skoggy.entities.Transform;

/**
 * Created by Erik on 2014-04-21.
 */
public class TransformTween extends Tween {

    protected Transform object;

    public TransformTween(Transform object, float duration) {
        super(duration);
        this.object = object;
    }
}
