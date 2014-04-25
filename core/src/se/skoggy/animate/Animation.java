package se.skoggy.animate;

import java.util.ArrayList;
import java.util.List;


public class Animation {

    protected String name;
    protected List<AnimationPart> parts;
    protected float maxTime, speedMultiplier;
    protected boolean looping = true;
    protected float loopStop;
    
    public Animation() {
        this("<Untitled>");
    }
    public Animation(String name) {
        this.name = name;
        parts = new ArrayList<AnimationPart>();
        looping = true;
    }

    public List<AnimationPart> getParts() {
        return parts;
    }

    public void addPart(AnimationPart part){
        parts.add(part);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public float getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(float maxTime) {
        this.maxTime = maxTime;
    }

    public float getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void setSpeedMultiplier(float speedMultiplier) {
        this.speedMultiplier = speedMultiplier;
    }
    
    public boolean isLooping() {
		return looping;
	}
    
    public float getLoopStop() {
		return loopStop;
	}
    
    @Override
    public String toString() {
        return name;
    }
}
