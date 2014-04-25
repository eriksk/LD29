package se.skoggy.tweening;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Erik on 2014-04-21.
 */
public class TweenManager {

    protected List<Tween> tweens;

    public TweenManager(){
        tweens = new ArrayList<Tween>();
    }

    public void clear(){
        tweens.clear();
    }

    public void add(Tween tween){
        tweens.add(tween);
    }

    public void update(float dt){
        for(int i = 0; i < tweens.size(); i++){
            if(tweens.get(i).isDone()){
                tweens.remove(i--);
            }else{
                tweens.get(i).update(dt);
            }
        }
    }
}
