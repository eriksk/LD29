package se.skoggy.ld29.maps;

import se.skoggy.entities.Entity;
import se.skoggy.levelitate.GameObject;

/**
 * Created by ErikAsus on 25/04/2014.
 */
public class MapMapper {
    public static void GameObjectToEntity(GameObject obj, Entity entity){
        entity.setColor(obj.color.r, obj.color.g, obj.color.b, obj.color.a);
        entity.origin.x = obj.origin.x;
        entity.origin.y = obj.origin.y;
        entity.setSource((int)obj.source.x, (int)obj.source.y, (int)obj.source.width, (int)obj.source.height);
        entity.transform.scale.x = obj.scale.x;
        entity.transform.scale.y = obj.scale.y;
        entity.transform.position.x = obj.position.x;
        entity.transform.position.y = obj.position.y;
        entity.transform.rotation = obj.rotation;
    }
}
