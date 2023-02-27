package WorkingWithAbstractionLab.P02PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;


    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean Contains(Point point) {
        if (point.getPointX() >= bottomLeft.getPointX() && point.getPointY() >= bottomLeft.getPointY()
        && point.getPointX()<= topRight.getPointX() && point.getPointY()<= topRight.getPointY()){
            return true;
        }
        //boolean bottomLeft = point.getPointX() >= bottomLeft.getPointX() && point.getPointY() >= bottomLeft.getPointY();
        return false;
    }
}
