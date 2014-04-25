package se.skoggy.infrastructure;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.skoggy.utils.Camera2D;

/**
 * Created by Erik on 2014-04-22.
 */
public interface IManager {
    public void reset();
    public void load();
    public void update(float dt);
    public void draw(SpriteBatch spriteBatch, Camera2D cam);
    public void drawDebug(SpriteBatch spriteBatch, Camera2D cam);
}
