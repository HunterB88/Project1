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
            drawCircleFractal(200, cx, cy, Color.BLUE, can, depth);
        }
        else if (type.equals("triangle")){
            drawTriangleFractal(600, 450, cx - 300, cy + 75, Color.BLUE, can, depth);
        }
        else if (type.equals("rectangle")){
            drawRectangleFractal(340, 340, cx - 170, cy - 170, Color.PINK, can, depth);
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
        if (level <= 0 || width <= 1 || height <= 1 ) return;

        Triangle triangle = new Triangle(x, y, width, height);
        triangle.setColor(c);
        can.drawShape(triangle);
        totalArea += triangle.calculateArea();

        if (level == 1) return;

        double newW = width / 2.0;
        double newH = height / 2.0;

        drawTriangleFractal(newW, newH, x, y, Color.BLUE, can, level - 1);
        drawTriangleFractal(newW, newH, x + newW, y, Color.GREEN, can, level - 1);
        drawTriangleFractal(newW, newH, x + newW / 2, y - newH, Color.PINK, can, level - 1);
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

        // force square for a symmetric pattern
        double s = Math.min(width, height);

        Rectangle r = new Rectangle(x, y, s, s);   // top-left API
        r.setColor(c);
        can.drawShape(r);
        totalArea += r.calculateArea();

        if (level == 1) return;

        double child = s / 2.0;        // child side
        double half  = child / 2.0;    // offset to put child center at each parent corner

        // TL
        drawRectangleFractal(child, child, x - half,     y - half,     Color.MAGENTA, can, level - 1);
        // TR
        drawRectangleFractal(child, child, x + s - half, y - half,     Color.ORANGE, can, level - 1);
        // BL
        drawRectangleFractal(child, child, x - half,     y + s - half, Color.BLUE, can, level - 1);
        // BR
        drawRectangleFractal(child, child, x + s - half, y + s - half, Color.GREEN, can, level - 1);
    }
}
