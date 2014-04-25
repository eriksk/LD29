package se.skoggy.animate.utils;

import java.util.List;

import se.skoggy.animate.AnimationKeyFrame;

public class AnimateHelpers {
    public static float getProgress(AnimationKeyFrame currentFrame, AnimationKeyFrame nextFrame, float positionInTime, float maxTime) {
        float progress;
        
        float localProgress = (positionInTime - currentFrame.time) / (nextFrame.time - currentFrame.time);
        float localNextFrameTime = (positionInTime - nextFrame.time) / (maxTime - nextFrame.time);
        
        if(positionInTime >= currentFrame.time && positionInTime < nextFrame.time){
            progress = localProgress;
        }else{
            progress = localNextFrameTime;
        }
        
        if(nextFrame.time == 0f){
            progress = (positionInTime - currentFrame.time) / (maxTime - currentFrame.time);
        }
        
        return progress;
    }

    public static AnimationKeyFrame getCurrentFrame(float positionInTime, List<AnimationKeyFrame> keyFrames) {
        for (int i = 0; i < keyFrames.size(); i++) {
            AnimationKeyFrame keyFrame = keyFrames.get(i);
            if(keyFrames.size() > i + 1){
               if(keyFrame.time <= positionInTime && keyFrames.get(i + 1).time > positionInTime){
                   return keyFrame;
               } 
            }else{
                if(keyFrame.time <= positionInTime){
                   return keyFrame;
               } 
            }
        }
        return keyFrames.get(0);
    }

    public static AnimationKeyFrame getNextFrame(float positionInTime, List<AnimationKeyFrame> keyFrames) {        
        for (int i = 0; i < keyFrames.size(); i++) {
            AnimationKeyFrame keyFrame = keyFrames.get(i);
            if(keyFrames.size() > i + 1){
               if(keyFrame.time <= positionInTime && keyFrames.get(i + 1).time > positionInTime){
                   return keyFrames.get(i + 1);
               } 
            }
        }
        return keyFrames.get(0);
    }
}
