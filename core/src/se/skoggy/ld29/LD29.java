package se.skoggy.ld29;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.skoggy.ld29.scenes.GameScene;
import se.skoggy.scenes.Scene;
import se.skoggy.scenes.SceneManager;

public class LD29 extends ApplicationAdapter {

    SceneManager sceneManager;

    @Override
    public void create() {
        sceneManager = new SceneManager();
        sceneManager.pushScene(getStartScene());
    }


    public Scene getStartScene() {
        return new GameScene(Config.WIDTH, Config.HEIGHT);
    }

	@Override
	public void render () {
        if(!sceneManager.hasAnyScenes())
            Gdx.app.exit();

        sceneManager.update(Gdx.graphics.getDeltaTime() * 1000f);

		Gdx.gl.glClearColor(100f / 255f, 149f / 255f, 237f / 255f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        sceneManager.draw();
	}
}
