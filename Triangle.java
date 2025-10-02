package CSCI1933P1;
import java.awt.Color;

public class Triangle{
    
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    public Triangle(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double calculatePerimeter(){
        double halfBase = width / 2.0;
        double side = Math.sqrt(halfBase * halfBase + height * height);
        return width + 2 * side;
    }

    public double calculateArea(){
        return 0.5 * (width * height);
    }

    public void setColor(Color c) {this.color = c;}
    public void setPos(double x, double y) {this.x = x; this.y = y;}
    public void setHeight(double height) {this.height = height;}
    public void setWidth(double width) {this.width = width;}

    public Color getColor() {return color;}
    public double getXPos() {return x;}
    public double getYPos() {return y;}
    public double getHeight() {return height;}
    public double getWidth() {return width;}
}