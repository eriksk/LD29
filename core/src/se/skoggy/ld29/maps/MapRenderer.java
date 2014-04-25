package se.skoggy.ld29.maps;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.skoggy.entities.Entity;
import se.skoggy.levelitate.GameObject;
import se.skoggy.levelitate.Map;
import se.skoggy.levelitate.MapLayer;

/**
 * Created by ErikAsus on 25/04/2014.
 */
public class MapRenderer {

    private Map map;
    private Entity template;

    public MapRenderer(Map map, TextureRegion towerfall) {
        this.map = map;
        template = new Entity(towerfall);
    }

    public void update(float dt) {

    }

    public void draw(SpriteBatch spriteBatch) {
        for(MapLayer layer : map.getLayers()){
            for(GameObject obj : layer.getObjects()){
                MapMapper.GameObjectToEntity(obj, template);
                template.draw(spriteBatch);
            }
        }
    }
}
