package PolymorphismLab.P02Shapes;

public class Circle extends Shape {
    private final Double radius;

    public Circle(Double perimeter, Double area, Double radius) {
        super(perimeter, area);
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}
