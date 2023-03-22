package PolymorphismLab.P02Shapes;

public class Rectangle extends Shape{
     private Double height;
     private Double width;

    public Rectangle(Double perimeter, Double area, Double height, Double width) {
        super(perimeter, area);
        this.height = height;
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    @Override
    public double calculatePerimeter() {
        return 2*width+2*height;
    }

    @Override
    public double calculateArea() {
        return width*height;
    }
}
