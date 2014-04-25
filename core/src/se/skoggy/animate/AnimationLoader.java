package se.skoggy.animate;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by ErikAsus on 25/04/2014.
 */
public class AnimationLoader {

    public AnimationLoader(){
        // TODO: cache animations
    }

    public AnimationCollection load(String name){
        String content = Gdx.files.internal(String.format("animations/%s.json", name)).readString();

        Gson gson = new GsonBuilder()
                .create();

        AnimationCollection animationCollection = gson.fromJson(content, AnimationCollection.class);

        return animationCollection;
    }
}
