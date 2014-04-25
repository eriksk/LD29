package se.skoggy.animate;


import se.skoggy.animate.utils.GameObject;

public class AnimationKeyFrame extends GameObject{

    public float time;
    
    public AnimationKeyFrame(float time) {
        this.time = time;
    }
    
    @Override
    public AnimationKeyFrame clone(){
        AnimationKeyFrame clone = new AnimationKeyFrame(time);
        clone.set(this);
        return clone;
    }
}