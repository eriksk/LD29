package se.skoggy.scenes;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;

public class SceneManager {

	protected List<Scene> scenes, pushedScenes;

	public SceneManager() {
		scenes = new ArrayList<Scene>();
		pushedScenes = new ArrayList<Scene>();
	}

	public boolean hasAnyScenes(){
		return !scenes.isEmpty() || !pushedScenes.isEmpty();
	}

    public void pushScene(Scene scene){
        pushScene(scene, false);
    }

    public void pushScene(Scene scene, boolean isPreloaded) {
        scene.setPassive(false);
		// set all other to passive
		for (int i = 0; i < scenes.size(); i++) {
			scenes.get(i).setPassive(true);
		}
        // add to temp list
        pushedScenes.add(scene);
        scene.setSceneManager(this);
        if (!isPreloaded)
            scene.load();
        scene.setState(Scene.STATE_TRANSITION_IN);
    }

	public void popScene(Scene scene){
		if(scene.getState() != Scene.STATE_TRANSITION_OUT){
			scene.setState(Scene.STATE_TRANSITION_OUT);
		}
	}

	public void popAllScenes(){
		for (Scene scene : scenes) {
			popScene(scene);
		}
	}

	protected void afterTransitionOut(Scene scene){
		scene.beforeRemoved();
        // set last scene to not passive again
        if(scenes.size() > 1){
            Scene sceneToActivate = scenes.get(scenes.size() - 2);
            if(sceneToActivate.isPopup())
                sceneToActivate = scenes.get(scenes.size() - 1);
            sceneToActivate.setPassive(false);
            Gdx.input.setInputProcessor(sceneToActivate);
        }
		scenes.remove(scene);
	}

	public void update(float dt) {
        for (Scene s : scenes)
            s.update(dt);
		
		// add pushed scenes
		while(pushedScenes.size() > 0){
			Scene scene = pushedScenes.get(0);
			// always add below other scenes, unless popup
			if(scene.isPopup()){
				scenes.add(scene);
			}else{
				scenes.add(0, scene);
			}
			pushedScenes.remove(0);
		}

		for (int i = 0; i < scenes.size(); i++) {
			Scene s = scenes.get(i);
			if(s.isDone()){
				afterTransitionOut(s);
				i--;
			}
		}
	}
	
	public void draw(){
        for (Scene s : scenes)
            s.draw();
	}
}
