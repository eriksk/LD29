package se.skoggy.animate;

import se.skoggy.entities.Entity;

/**
 * Created by ErikAsus on 25/04/2014.
 */
public class AnimationMapper {
    public static void keyFrameToEntity(AnimationKeyFrame keyFrame, Entity entity, boolean flipped, float scale){
        entity.setColor(keyFrame.color.r, keyFrame.color.g, keyFrame.color.b, keyFrame.color.a);
        entity.origin.x = keyFrame.origin.x;
        entity.origin.y = keyFrame.origin.y;
        entity.setSource((int)keyFrame.source.x, (int)keyFrame.source.y, (int)keyFrame.source.width, (int)keyFrame.source.height);
        entity.transform.scale.x = keyFrame.scale.x * scale;
        entity.transform.scale.y = keyFrame.scale.y * scale;
        entity.transform.position.x = keyFrame.position.x  * (flipped ? -1f : 1f) * scale;
        entity.transform.position.y = keyFrame.position.y * scale;
        entity.transform.rotation = keyFrame.rotation * (flipped ? -1f : 1f);
    }
}
