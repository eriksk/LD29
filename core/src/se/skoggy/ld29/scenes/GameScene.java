package se.skoggy.ld29.scenes;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import se.skoggy.scenes.Scene;

/**
 * Created by ErikAsus on 25/04/2014.
 */
public class GameScene extends Scene {

    BitmapFont font;

    public GameScene(float width, float height) {
        super(width, height);
    }

    @Override
    public float transitionInDuration() {
        return 100f;
    }

    @Override
    public float transitionOutDuration() {
        return 100f;
    }

    @Override
    public boolean isPopup() {
        return false;
    }

    @Override
    public void load() {
        super.load();

        font = content.loadFont("andy");
    }

    @Override
    public void update(float dt) {



        super.update(dt);
    }

    @Override
    public void draw() {
        spriteBatch.setProjectionMatrix(cam.getHudMatrix());
        spriteBatch.begin();
        font.draw(spriteBatch, "#LD48", 100, 100);
        spriteBatch.end();
    }
}
