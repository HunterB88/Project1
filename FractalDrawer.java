package CSCI1933P1;
// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area

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
            drawTriangleFractal(200, 150, 300, 475, Color.RED, can, depth);
        }
        else if (type.equals("rectangle")){
            drawRectangleFractal(100, 100, 600, 400, Color.PINK, can, depth);
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

        drawTriangleFractal(newW, newH, x + width/4.0, y - height - newH, c, can, level - 1);
        drawTriangleFractal(newW, newH, x - newW, y - newH / 2.0, c, can, level - 1);
        drawTriangleFractal(newW, newH, x + width, y - newH / 2.0, c, can, level - 1);
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if (level <=0 || redius <= 1 ){
            return;
        }

        Circle circle = new Circle(x,y,radius);
        circle.setColor(c);
        can.drawShape(circle);
        totalArea += circle.calculateArea();

        double newR = radius / 2.0;
        

        drawCircleFractal(newR, x, y, c, can, level - 1);
        drawCircleFractal(newR, x + newR, y, c, can, level - 1);
        drawCircleFractal(newR, x, y, c, can, level - 1);

    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
    }

    public Canvas(){
        Canvas canvas = new Canvas(800, 800);
    }

    public Canvas(int height, int width){

    }

    public void drawTriangle(Triangle triangleObj){
        
    }

    public void drawCircle(Circle circleObj){
        Canvas drawing = new Canvas(800,800);
        Circle myCircle = new Circle(0,0,100);
        myCircle.setColor(Color.BLUE);
        drawing.drawShape(myCircle);
    }

    public void drawRectangle(Rectangle RectangleObj){

    }

}
