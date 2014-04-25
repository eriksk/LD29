package se.skoggy.infrastructure;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.skoggy.content.ContentManager;
import se.skoggy.utils.Camera2D;

/**
 * Created by Erik on 2014-04-22.
 */
public interface IRenderer {
    public void load(ContentManager content);
    public void update(float dt);
    public void render(SpriteBatch spriteBatch, Camera2D cam);
    public void renderDebug(SpriteBatch spriteBatch, Camera2D cam);
}
