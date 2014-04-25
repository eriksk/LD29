package se.skoggy.tweening;

/**
 * Created by Erik on 2014-04-21.
 */
public abstract class Tween {

    public float currentTime, duration;

    public Tween(float duration){
        this.duration = duration;
        currentTime = 0f;
    }

    public boolean isDone(){
        return currentTime == duration;
    }

    public float getProgress(){
        return currentTime / duration;
    }

    public void update(float dt){
        currentTime += dt;
        if(currentTime > duration)
            currentTime = duration;
    }
}
