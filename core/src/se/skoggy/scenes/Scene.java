package se.skoggy.scenes;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import se.skoggy.content.ContentManager;
import se.skoggy.utils.Camera2D;
import se.skoggy.utils.TimerTrig;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class Scene extends Stage{

	public final static int STATE_TRANSITION_IN = 0;
	public final static int STATE_TRANSITION_OUT = 1;
	public final static int STATE_ACTIVE = 2;
	public final static int STATE_DONE = 3;

	private int state;
	private boolean isPassive;

	protected SceneManager manager;
	protected Camera2D cam;
	protected float width, height;
	protected SpriteBatch spriteBatch;
	protected ContentManager content;
	protected TimerTrig transitionTimer;
	protected float totalTime;

	public Scene(float width, float height) {
		this.width = width;
		this.height = height;
		transitionTimer = new TimerTrig(0);
	}

	protected void initCam(){
        createCam(null);
    }
	protected void createCam(Rectangle area){
		cam = new Camera2D(width, height, area);
        this.setViewport(new StretchViewport(width, height, cam)); //new FitViewport(width, height, cam));
	}

	public Camera2D getCam() {
		return cam;
	}

	public void setSceneManager(SceneManager manager){
		this.manager = manager;
	}
	
	/**
	 * Hook, called after transition out, right before scene is removed
	 */
	public void beforeRemoved(){
		
	}

	public boolean isPassive() {
		return isPassive;
	}

	public void setPassive(boolean isPassive) {
		this.isPassive = isPassive;
	}

	public void setState(int state) {
		this.state = state;

		switch (state) {
			case STATE_TRANSITION_IN:
				transitionTimer.setInterval(transitionInDuration());
                onTransitionInStarted();
				break;
			case STATE_TRANSITION_OUT:
				transitionTimer.setInterval(transitionOutDuration());
				onTransitionOutStarted();
                break;
            case STATE_ACTIVE:
                onActivated();
                break;
		}
	}
	public int getState() {
		return state;
	}
    protected void onTransitionInStarted(){}
    protected void onTransitionOutStarted(){}
    protected void onActivated(){}

	public boolean isActive(){
		return state == STATE_ACTIVE && !isPassive;
	}
	public boolean isDone(){
		return state == STATE_DONE;
	}

	public abstract float transitionInDuration();
	public abstract float transitionOutDuration();
	public abstract boolean isPopup();
	public void load(){
		content = new ContentManager("", true);
		spriteBatch = new SpriteBatch();
		initCam();
	}
	public void update(float dt){
		switch (state) {
			case STATE_TRANSITION_IN:
				if(transitionTimer.isTrigged(dt)){
					updateTransitionIn(dt, 1f);
					setState(STATE_ACTIVE);
				}else{
					updateTransitionIn(dt, transitionTimer.progress());
				}
				break;
			case STATE_TRANSITION_OUT:
				if(transitionTimer.isTrigged(dt)){
					updateTransitionOut(dt, 1f);
					setState(STATE_DONE);
				}else{
					updateTransitionOut(dt, transitionTimer.progress());
				}
				break;
			default:
				cam.update();
				break;
		}
		totalTime += dt;
	}
	public void updateTransitionIn(float dt, float progress){
		cam.update();
	}
	public void updateTransitionOut(float dt, float progress){
		cam.update();
	}
	public abstract void draw();
}
