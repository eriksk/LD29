package se.skoggy.animate.utils.interpolation;

public class Exp extends Interpolation {
    final float value, power, min, scale;

    public Exp (float value, float power) {
            this.value = value;
            this.power = power;
            min = (float)Math.pow(value, -power);
            scale = 1 / (1 - min);
    }

    @Override
    public float apply (float a) {
        if (a <= 0.5f) return ((float)Math.pow(value, power * (a * 2 - 1)) - min) * scale / 2;
        return (2 - ((float)Math.pow(value, -power * (a * 2 - 1)) - min) * scale) / 2;
    }
}