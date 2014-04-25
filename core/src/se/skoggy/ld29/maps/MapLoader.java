package se.skoggy.ld29.maps;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import se.skoggy.levelitate.Map;

/**
 * Created by ErikAsus on 25/04/2014.
 */
public class MapLoader {

    public MapLoader(){
    }

    public Map load(String name){
        String content = Gdx.files.internal(String.format("maps/%s.json", name)).readString();
        Gson gson = new GsonBuilder()
                .create();
        return gson.fromJson(content, Map.class);
    }
}
