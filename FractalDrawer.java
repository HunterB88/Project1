package CSCI1933P1;
// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;

public class FractalDrawer {
    private double totalArea=0;// member variable for tracking the total area

    public FractalDrawer() {}  // contructor


    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        Canvas can = new Canvas(800, 800);
        int depth = 7;
        totalArea = 0;

        if (type.equals("circle")){
            drawCircleFractal(200, 400, 400, Color.BLUE, can, depth);
        } 
        else if (type.equals("triangle")){
            drawTriangleFractal(600, 450, 100, 475, Color.BLUE, can, depth);
        }
        else if (type.equals("rectangle")){
            drawRectangleFractal(200, 100, 300, 350, Color.PINK, can, depth);
        }
        else{
            System.out.println("Unknown type, defaulting to circle");
            drawCircleFractal(200, 400, 400, Color.BLUE, can, depth);
        }

        return totalArea;
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        if (level <= 0 || width <= 1 || height <= 1 ){
            return;
        }

        Triangle triangle = new Triangle(x, y, width, height);
        triangle.setColor(c);
        can.drawShape(triangle);
        totalArea += triangle.calculateArea();

        double newW = width / 2.0;
        double newH = height / 2.0;

        drawTriangleFractal(newW, newH, x, y, Color.BLUE, can, level - 1);
        drawTriangleFractal(newW, newH, x + newW, y, Color.GREEN, can, level - 1);
        drawTriangleFractal(newW, newH, x + newW / 2, y - newH, Color.PINK, can, level - 1);
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if (level <=0 || radius <= 1 ){
            return;
        }

        Circle circle = new Circle(x,y,radius);
        circle.setColor(c);
        can.drawShape(circle);
        totalArea += circle.calculateArea();

        double newR = radius * 0.5;
        double d = radius;
        

        drawCircleFractal(newR, x + d, y, Color.MAGENTA, can, level - 1); // right
        drawCircleFractal(newR, x - d, y, Color.YELLOW, can, level - 1);  // left
        drawCircleFractal(newR, x, y + d, Color.CYAN, can, level - 1);    // down
        drawCircleFractal(newR, x, y - d, Color.PINK, can, level - 1);

    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level <= 0 || width <= 1 || height <= 1){
            return;
        }

        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.setColor(c);
        can.drawShape(rectangle);
        totalArea += rectangle.calculateArea();

        double newW = width / 2.0;
        double newH = height / 2.0;

        drawRectangleFractal(newW, newH, x - newW, y - newH, Color.BLACK,  can, level - 1);  // top-left
        drawRectangleFractal(newW, newH, x + newW, y - newH, Color.YELLOW, can, level - 1);  // top-right
        drawRectangleFractal(newW, newH, x - newW, y + newH, Color.PINK,   can, level - 1);  // bottom-left
        drawRectangleFractal(newW, newH, x + newW, y + newH, Color.GRAY,   can, level - 1);
    }
}
