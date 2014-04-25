package se.skoggy.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class EntityBehavior {
	public abstract void Update(float dt, Entity owner);
	public void BeforeDraw(SpriteBatch spriteBatch, Entity owner){}
	public void AfterDraw(SpriteBatch spriteBatch, Entity owner){}
}
