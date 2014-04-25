package se.skoggy.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Camera2D extends OrthographicCamera{

	Rectangle area;
	private float width, height;
	Vector2 shakeOffset, target;
	float shakeCurrent, shakeDuration;
	float magnitude;
	private float targetZoom;
    private boolean initialized = false;
    private float movementSpeed;
    private Matrix4 UIMatrix;
    private Matrix4 hudMatrix;

    public Camera2D(float width, float height, Rectangle area) {
		super(width, height);
		setToOrtho(true, width, height);
		this.area = area;
		this.width = width;
		this.height = height;
        target = new Vector2();
		targetZoom = 1f;
		shakeOffset = new Vector2();
        movementSpeed = 0.05f;

        hudMatrix = combined.cpy();
        initialized = true;
	}

	public float toWorldX(float localX){
		return position.x - ((width * 0.5f)* zoom) + localX * zoom;
	}

	public float toWorldY(float localY){
 		return position.y - ((height * 0.5f) * zoom) + localY * zoom;
	}

	public Matrix4 getParallaxCombined(float parallax) {
		return projection.cpy().translate(-position.x * parallax, position.y * parallax, 0f).scale(1f, -1f, 1f);
	}

    public Matrix4 getHudMatrix() {
        return hudMatrix;
    }

	public void zoomTo(float targetZoom){
		this.targetZoom = targetZoom;
	}

    public void moveTo(float x, float y) {
        target.x = x;
        target.y = y;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

	@Override
	public void update() {
        if(initialized) {
            // boundaries
            if (area != null) {
                float halfScreenHeight = (area.height * zoom) * 0.5f;
                float halfScreenWidth = (area.width * zoom) * 0.5f;

                if (position.x - halfScreenWidth < area.x) {
                    position.x = area.x + halfScreenWidth;
                }
                if (position.y - halfScreenHeight < area.y) {
                    position.y = area.y + halfScreenHeight;
                }
                if (position.x + halfScreenWidth > area.x + area.width) {
                    position.x = area.x + area.width - halfScreenWidth;
                }
                if (position.y + halfScreenHeight > area.y + area.height) {
                    position.y = area.y + area.height - halfScreenHeight;
                }
            }

            shakeCurrent += 16.0f;
            if (shakeCurrent > shakeDuration)
                shakeCurrent = shakeDuration;

            if (isShaking()) {
                float shakeProgress = 1f - (shakeCurrent / shakeDuration);
                shakeOffset.x = (-0.5f + Rand.rand()) * magnitude * shakeProgress;
                shakeOffset.y = (-0.5f + Rand.rand()) * magnitude * shakeProgress;

                position.x += shakeOffset.x;
                position.y += shakeOffset.y;
            }


            position.x = Helpers.lerp(position.x, target.x, movementSpeed);
            position.y = Helpers.lerp(position.y, target.y, movementSpeed);
            zoom = Helpers.lerp(zoom, targetZoom, 0.05f);
        }

        super.update();
	}

	public boolean isShaking(){
		return shakeDuration != 0f && shakeCurrent / shakeDuration != 1f;
	}

	public void shake(float duration, float magnitude) {
		shakeCurrent = 0f;
		shakeDuration = duration;
		this.magnitude = magnitude;
	}

	public void stopShake(){
		shakeCurrent = shakeDuration;
		magnitude = 0f;
	}
}
