package se.skoggy.animate.utils.interpolation;

public abstract class Interpolation {
    
	
    public abstract float apply(float weight);    
    
    public float apply(float start, float end, float weight){
        return start + (end - start) * apply(weight);
    }
    
    public static Interpolation lerp = new Interpolation(){
        @Override
        public float apply(float weight) {
            return weight;
        }
    };
    
    public static Interpolation sine = new Interpolation() {
        @Override
        public float apply(float weight) {
            return (1f - (float)Math.cos(weight * (float)Math.PI)) / 2f;
        }
    };
        
    public static Interpolation exp10 = new Exp(2, 10);
    public static Interpolation exp5 = new Exp(2, 5);
    
    public static Interpolation pow2 = new Pow(2);
    public static Interpolation pow3 = new Pow(3);
    public static Interpolation pow4 = new Pow(4);
    public static Interpolation pow5 = new Pow(5);
    
    
}


