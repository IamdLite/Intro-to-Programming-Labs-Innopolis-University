package comShapes;

import comShapes.shapes.*;


public class ShapeCreator {

    public static void main(String[] args){

       Shape[] shapes = addShapes();
       displayShapeSizes(shapes);
    }

    private static void displayShapeSizes(Shape[] shapes){
        for(Shape shape : shapes){
            System.out.println(shape.getClass().getSimpleName() 
            + " area is " + shape.calculateArea() + ", " + shape.getClass().getSimpleName() + 
            " perimeter is " + shape.calculatePerimeter());
        }
    }

    private static Shape[] addShapes(){
        Shape[] shapes = new Shape[5];

        Shape circle = new Circle(5);
        shapes[0] = circle;

        Shape square = new Square(3);
        shapes[1] = square;

        Shape rectangle = new Rectangle(5, 2);
        shapes[2] = rectangle;

        Shape ellipse = new Ellipse(3, 6);
        shapes[3] = ellipse;

        Shape triangle = new Triangle(2, 2, 2, 60);
        shapes[4] = triangle;
        
        return shapes;

    }
    
}
