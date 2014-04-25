package se.skoggy.animate;


import java.util.ArrayList;
import java.util.List;

public class AnimationCollection {

    protected List<Animation> animations;
    protected String name = "";
    
    public AnimationCollection() {
        animations = new ArrayList<Animation>();
    }

    public void add(Animation animation){
        animations.add(animation);
    }

    public void remove(Animation anim) {
        animations.remove(anim);
    }

    public List<Animation> getAnimations() {
        return animations;
    }
}
