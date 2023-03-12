package EncapsulationExercises.P01ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height){
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length){
        if (validator(length)){
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        if (validator(width)){
            this.width = width;
        }else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
    }

    private void setHeight(double height) {
        if (validator(height)){
            this.height = height;
        }else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea(){
        return 2*length*width + 2*length*height + 2*width*height;
    }
    public double calculateLateralSurfaceArea(){
        return width*height*2 + 2*length*height;
    }
    public double calculateVolume(){
        return length*width*height;
    }
    private boolean validator(double parameter) {
        return parameter>0;
    }
}
