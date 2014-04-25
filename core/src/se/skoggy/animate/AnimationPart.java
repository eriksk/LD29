package se.skoggy.animate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import se.skoggy.animate.utils.AnimateHelpers;
import se.skoggy.animate.utils.GameObject;
import se.skoggy.animate.utils.interpolation.Interpolation;

public class AnimationPart extends GameObject{

    protected String name = "<NAME>";
    protected String interpolationType;
    protected List<AnimationKeyFrame> keyFrames;
    protected float currentTime;

    public AnimationPart() {
        keyFrames = new ArrayList<AnimationKeyFrame>();
        currentTime = 0f;
        interpolationType = "linear";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterpolationType() {
        return interpolationType;
    }

    public void setInterpolationType(String interpolationType) {
        this.interpolationType = interpolationType;
    }

    public List<AnimationKeyFrame> getKeyFrames() {
        return keyFrames;
    }

    public void addKeyFrameAtCurrentPosition(float maxTime) {
        addKeyFrameAtPosition(currentTime, maxTime);
    }

    public AnimationKeyFrame addKeyFrameAtPosition(float positionInTime, float maxTime) {
        AnimationKeyFrame keyFrame = null;
        if (keyFrames.size() > 1) {
            // get interpolated frame instead
            keyFrame = new AnimationKeyFrame(positionInTime);
            keyFrame.set(getInterpolatedKeyFrame(positionInTime, maxTime));
        } else {
            keyFrame
                    = (AnimationKeyFrame) new AnimationKeyFrame(positionInTime)
                    .teleport(0f, 0f)
                    .setScale(scale.x, scale.y)
                    .setOrigin(origin.x, origin.y)
                    .setRotation(rotation)
                    .setSource(source.x, source.y, source.width, source.height)
                    .setColor(color.r, color.g, color.b, color.a);
        }
        keyFrames.add(keyFrame);
        sortKeyFrames();
        return keyFrame;
    }

    public void sortKeyFrames() {
        Collections.sort(keyFrames, new Comparator<AnimationKeyFrame>() {
            @Override
            public int compare(AnimationKeyFrame o1, AnimationKeyFrame o2) {
                return Float.compare(o1.time, o2.time);
            }
        });
    }

    private AnimationKeyFrame interpolationKeyFrame = new AnimationKeyFrame(0f);
    public AnimationKeyFrame getInterpolatedKeyFrame(float positionInTime, float maxTime) {
        AnimationKeyFrame currentFrame = AnimateHelpers.getCurrentFrame(positionInTime, keyFrames);
        AnimationKeyFrame nextFrame = AnimateHelpers.getNextFrame(positionInTime, keyFrames);


        float progress = AnimateHelpers.getProgress(currentFrame, nextFrame, positionInTime, maxTime);

        // TODO: break out and let the object interpolate, use interpolationtype
        Interpolation interpolation = Interpolation.pow4;

        if (interpolationType.equals("linear")) {
            interpolation = Interpolation.lerp;
        } else if (interpolationType.equals("pow2")) {
            interpolation = Interpolation.pow2;
        } else if (interpolationType.equals("pow4")) {
            interpolation = Interpolation.pow4;
        } else if (interpolationType.equals("bounce")) {
            interpolation = Interpolation.exp5;
        }else if (interpolationType.equals("sine")) {
            interpolation = Interpolation.sine;
        }

        interpolationKeyFrame.position.x = interpolation.apply(currentFrame.position.x, nextFrame.position.x, progress);
        interpolationKeyFrame.position.y = interpolation.apply(currentFrame.position.y, nextFrame.position.y, progress);
        interpolationKeyFrame.rotation = interpolation.apply(currentFrame.rotation, nextFrame.rotation, progress);
        interpolationKeyFrame.scale.x = interpolation.apply(currentFrame.scale.x, nextFrame.scale.x, progress);
        interpolationKeyFrame.scale.y = interpolation.apply(currentFrame.scale.y, nextFrame.scale.y, progress);
        interpolationKeyFrame.origin.x = interpolation.apply(currentFrame.origin.x, nextFrame.origin.x, progress);
        interpolationKeyFrame.origin.y = interpolation.apply(currentFrame.origin.y, nextFrame.origin.y, progress);
        interpolationKeyFrame.setSource(currentFrame.source.x, currentFrame.source.y, currentFrame.source.width, currentFrame.source.height);
        return interpolationKeyFrame;
    }


    @Override
    public String toString() {
        return name;
    }
}
