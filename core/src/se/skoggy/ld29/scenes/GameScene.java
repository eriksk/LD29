package se.skoggy.ld29.scenes;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import se.skoggy.animate.*;
import se.skoggy.animate.utils.Vector2;
import se.skoggy.entities.Entity;
import se.skoggy.ld29.Config;
import se.skoggy.ld29.maps.MapLoader;
import se.skoggy.ld29.maps.MapRenderer;
import se.skoggy.scenes.Scene;

/**
 * Created by ErikAsus on 25/04/2014.
 */
public class GameScene extends Scene {

    BitmapFont font;

    AnimationLoader animationLoader;
    AnimationRenderer animationRenderer;

    MapLoader mapLoader;
    MapRenderer mapRenderer;

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
        animationLoader = new AnimationLoader();
        animationRenderer = new AnimationRenderer(animationLoader.load("character"), content.loadTexture("character"));
        animationRenderer.setAnim("idle");

        mapLoader = new MapLoader();
        mapRenderer = new MapRenderer(mapLoader.load("testmap"), content.loadTexture("towerfall"));
    }

    @Override
    public void update(float dt) {

        animationRenderer.update(dt);
        mapRenderer.update(dt);

        super.update(dt);
    }

    @Override
    public void draw() {
        spriteBatch.begin();
        mapRenderer.draw(spriteBatch);
        spriteBatch.end();

        spriteBatch.setProjectionMatrix(cam.getHudMatrix());
        spriteBatch.begin();
        font.draw(spriteBatch, "#LD48", 100, 100);
        animationRenderer.draw(spriteBatch, new Vector2(Config.WIDTH * 0.5f, Config.HEIGHT * 0.5f), false, 1f);
        spriteBatch.end();
    }
}
