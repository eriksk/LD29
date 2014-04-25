package se.skoggy.utils;

import com.badlogic.gdx.graphics.Color;

public class Helpers {
	
	static final float PI = (float)Math.PI;

	public static float lerp(float x, float y, float w){
		return x + (y - x) * w;
	}

	public static Color lerpC(Color color1, Color color2, float w){
		return new Color(
				lerp(color1.r, color2.r, w),
				lerp(color1.g, color2.g, w),
				lerp(color1.b, color2.b, w),
				lerp(color1.a, color2.a, w));
	}
	
	public static float pulse(float time) {
	    return pulse(time, 10);
	}
	
	/**
	 * Creates a pulse
	 * @param time current time
	 * @param frequency in hz
	 * @return pulsated value
	 */
	public static float pulse(float time, float frequency) {
	    return 0.5f * (1f + (float)Math.sin(2f * PI * frequency * time));
	}
	

	public static int clamp(int value, int min, int max){
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
	public static float clamp(float value, float min, float max){
		if(value < min) return min;
		if(value > max) return max;
		return value;
	}
	
	public static boolean rectOverlaps(float r1x, float r1y, float r1w, float r1h,float r2x, float r2y, float r2w, float r2h){
		if(r1x > r2x + r2w) return false;
		if(r1x + r1w < r2x) return false;
		if(r1y > r2y + r2h) return false;
		if(r1y + r1h < r2y) return false;
		return true;
	}
}
