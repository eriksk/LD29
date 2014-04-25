package se.skoggy.animate.utils.interpolation;

public class Pow extends Interpolation {
    final int power;

    public Pow (int power) {
            this.power = power;
    }

    @Override
    public float apply (float a) {
        if (a <= 0.5f) return (float)Math.pow(a * 2, power) / 2;
        return (float)Math.pow((a - 1) * 2, power) / (power % 2 == 0 ? -2 : 2) + 1;
    }
}