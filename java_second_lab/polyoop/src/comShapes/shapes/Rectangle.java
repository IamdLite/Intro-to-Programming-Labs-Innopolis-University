package comShapes.shapes;

public class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;

    }

    @Override
    protected double calculateArea(){
        return length * width;

    }

    @Override
    protected double calculatePerimeter(){
        return 2 * (length + width);
    }
    
}
