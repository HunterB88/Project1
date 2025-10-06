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

        double cx = can.getWidth()  / 2.0;
        double cy = can.getHeight() / 2.0;

        if (type.equals("circle")){
            drawCircleFractal(200, cx, cy, Color.CYAN, can, depth);
        }
        else if (type.equals("triangle")){
            drawTriangleFractal(600, 450, cx - 300, cy + 150, Color.YELLOW, can, depth);
        }
        else if (type.equals("rectangle")){
            drawRectangleFractal(340, 340, cx - 170, cy - 170, Color.MAGENTA, can, depth);
        }
        else{
            System.out.println("Unknown type, defaulting to circle");
            drawCircleFractal(200, 400, 400, Color.CYAN, can, depth);
        }
        return totalArea;
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        if (level <= 0 || width <= 1 || height <= 1 ) return;

        Triangle triangle = new Triangle(x, y, width, height);
        triangle.setColor(c);
        can.drawShape(triangle);
        totalArea += triangle.calculateArea();

        if (level == 1) return;

        double newW = width / 2.0;
        double newH = height / 2.0;

        drawTriangleFractal(newW, newH, x, y, Color.YELLOW, can, level - 1);
        drawTriangleFractal(newW, newH, x + newW, y, Color.RED, can, level - 1);
        drawTriangleFractal(newW, newH, x + newW / 2, y - newH, Color.orange, can, level - 1);
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if (level <= 0 || radius <= 1) return;

        Circle circle = new Circle(x,y,radius);
        circle.setColor(c);
        can.drawShape(circle);
        totalArea += circle.calculateArea();

        if (level == 1) return;

        double newR = radius / 2.0;
        double off  = newR;

        drawCircleFractal(newR, x - off, y, Color.MAGENTA, can, level - 1);
        drawCircleFractal(newR, x + off, y, Color.YELLOW,  can, level - 1);
        drawCircleFractal(newR, x, y - off, Color.CYAN,    can, level - 1);
        drawCircleFractal(newR, x, y + off, Color.PINK,    can, level - 1);
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level <= 0 || width <= 1 || height <= 1) return;

        double s = Math.min(width, height);

        Rectangle rectangle = new Rectangle(x, y, s, s);
        rectangle.setColor(c);
        can.drawShape(rectangle);
        totalArea += rectangle.calculateArea();

        if (level == 1) return;

        double base = s / 2.0;
        double half  = base / 2.0;

        drawRectangleFractal(base, base, x - half, y - half, Color.MAGENTA, can, level - 1);
        drawRectangleFractal(base, base, x + s - half, y - half, Color.black, can, level - 1);
        drawRectangleFractal(base, base, x - half, y + s - half, Color.BLUE, can, level - 1);
        drawRectangleFractal(base, base, x + s - half, y + s - half, Color.CYAN, can, level - 1);
    }
}
