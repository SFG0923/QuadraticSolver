package org.example;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        if (a == 0) throw new IllegalArgumentException("Коэффициент 'a' не может быть равен 0");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve() {
        double disc = b * b - 4 * a * c;
        if (disc > 0) {
            return new double[]{
                    (-b + Math.sqrt(disc)) / (2 * a),
                    (-b - Math.sqrt(disc)) / (2 * a)
            };
        } else if (disc == 0) {
            return new double[]{-b / (2 * a)};
        } else {
            return new double[0];
        }
    }
}