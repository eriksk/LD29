package se.skoggy.animate;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.skoggy.animate.utils.Vector2;
import se.skoggy.entities.Entity;
import se.skoggy.utils.TimerTrig;

/**
 * Created by ErikAsus on 25/04/2014.
 */
public class AnimationRenderer {

    protected Entity template;
    protected TimerTrig timer;
    private AnimationCollection animationCollection;
    private Animation currentAnimation;

    public AnimationRenderer(AnimationCollection animationCollection, TextureRegion texture){
        this.animationCollection = animationCollection;
        timer = new TimerTrig(0);
        template = new Entity(texture);
    }

    public void setAnim(String name){
        if(currentAnimation != null){
            if(!currentAnimation.getName().equals(name)){
                currentAnimation = animationCollection.getAnimation(name);
                timer.setInterval(currentAnimation.getMaxTime());
            }
        }else{
            currentAnimation = animationCollection.getAnimation(name);
            timer.setInterval(currentAnimation.getMaxTime());
        }
    }

    public void reset(){
        if(currentAnimation != null){
            timer.reset();
        }
    }

    public void update(float dt){
        if(currentAnimation != null){
            if(timer.isTrigged(dt * currentAnimation.getSpeedMultiplier())){
                timer.reset();
            }
        }
    }

    public void draw(SpriteBatch spriteBatch, Vector2 position, boolean flipped, float scale){
        if(currentAnimation != null){
            for(AnimationPart part : currentAnimation.getParts()){
                AnimationKeyFrame kf = part.getInterpolatedKeyFrame(timer.getTime(), currentAnimation.getMaxTime());
                AnimationMapper.keyFrameToEntity(kf, template, flipped, scale);
                template.transform.position.x += position.x;
                template.transform.position.y += position.y;
                template.draw(spriteBatch);
            }
        }
    }
}
