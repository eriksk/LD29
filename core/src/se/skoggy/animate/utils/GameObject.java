package se.skoggy.animate.utils;

public class GameObject {

    public Vector2 position, origin, scale;
    public Rectangle source;
    public Color color;
    public float rotation;

    public GameObject() {
        
        position = new Vector2();
        origin = new Vector2(0.5f, 0.5f);
        scale = new Vector2(1f, 1f);
        source = new Rectangle();
        color = new Color(1f, 1f, 1f, 1f);
        rotation = 0f;
    }  
    
    /**
     * Copies all properties from another game object
     * @param other 
     */
    public void set(GameObject other){
        position.x = other.position.x;
        position.y = other.position.y;
        origin.x = other.origin.x;
        origin.y = other.origin.y;
        scale.x = other.scale.x;
        scale.y = other.scale.y;
        source.x = other.source.x;
        source.y = other.source.y;
        source.width = other.source.width;
        source.height = other.source.height;
        color.r = other.color.r;
        color.g = other.color.g;
        color.b = other.color.b;
        color.a = other.color.a;
        rotation = other.rotation;
    }
    
    /**
     * Axis align contain check
     * @param x
     * @param y
     * @return 
     */
    public boolean contains(float x, float y){
        if(x > position.x + width() / 2f) return false;
        if(x < position.x - width() / 2f) return false;
        if(y > position.y + height() / 2f) return false;
        if(y < position.y - height() / 2f) return false;
        return true;
    }
    
    public float width(){
        return (source.width * scale.x);
    }
    
    public float height(){
        return (source.height * scale.y);
    }
    
    public GameObject setOrigin(float x, float y){
        this.origin.x = x;
        this.origin.y = y;
        return this;
    }
    
    public GameObject setSource(float x, float y, float w, float h){
        source.x = x;
        source.y = y;
        source.width = w;
        source.height = h;
        return this;
    }
    
    public GameObject teleport(float x, float y){
        position.x = x;
        position.y = y;
        return this;
    }
    
    public GameObject setColor(float r, float g, float b, float a){
        color.r = r;
        color.g = g;
        color.b = b;
        color.a = a;
        return this;
    }
    
    public GameObject setRotation(float rotation){
        this.rotation = rotation;
        return this;
    }
    
    public GameObject setScale(float x, float y){
        scale.x = x;
        scale.y = y;
        return this;
    }
    
    public GameObject setScale(float scale){
        this.scale.x = scale;
        this.scale.y = scale;
        return this;
    }
}