package se.skoggy.content;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

public class ContentManager implements Disposable{

	String contentRoot;
	boolean flipYOnSprites;
	private HashMap<String, Texture> textureCache;
	
	public ContentManager(String contentRoot, boolean flipYOnSprites){
		this.contentRoot = contentRoot;
		this.flipYOnSprites = flipYOnSprites;
		if(!this.contentRoot.endsWith("/") && this.contentRoot != ""){
			this.contentRoot += "/";
		}
		textureCache = new HashMap<String, Texture>();
	}

	public TextureRegion loadTexture(String name){
		if(textureCache.containsKey(name))
			return new TextureRegion(textureCache.get(name));
		
		Pixmap pixMap = new Pixmap(Gdx.files.internal(contentRoot + "gfx/" + name + ".png"));
		premultiplyAlpha(pixMap);
		Texture rawTexture = new Texture(pixMap);
		
		TextureRegion texture = new TextureRegion(rawTexture);
		texture.getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		// TODO: Doesn't really work, if region is set later this will be overridden, FIX
		texture.flip(false, flipYOnSprites);
		
		textureCache.put(name, texture.getTexture());

        System.out.println("cached texture: " + name);
        
		return texture;
	}

	private void premultiplyAlpha(Pixmap pixMap) {
		for (int x = 0; x < pixMap.getWidth(); x++) {
			for (int y = 0; y < pixMap.getHeight(); y++) {
				Color color = new Color(pixMap.getPixel(x, y));
				color.r = color.a * color.r;
				color.g = color.a * color.g;
				color.b = color.a * color.b;
				color.a = 1f;
				if(color.r + color.g + color.b == 0f)
					color.a = 0f;
				pixMap.drawPixel(x, y, (int)color.toFloatBits());
			}
		}
		
	}

	public BitmapFont loadFont(String name){
		return new BitmapFont(Gdx.files.internal("fonts/" + name + ".fnt"), Gdx.files.internal("fonts/" + name + ".png"), true);
	}

	@Override
	public void dispose() {
		// TODO: cache all textures and dispose here
		for (Texture texture : textureCache.values()) {
			texture.dispose();
		}
	}
}
