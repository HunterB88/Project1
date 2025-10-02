package CSCI1933P1;
import java.awt.Color;

public class Rectangle{

    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    public Rectangle(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double calculatePerimeter(){
        return  2 * (x + y);
    }

    public double calculateArea(){
        return x * y;
    }

    public void setColor(Color color){this.color = color;}
    public void setPos(double x, double y){this.x = x; this.y = y;}
    public void setHeight(double height){this.height = height;}
    public void setWidth(double width){this.width = width;}

    public Color getColor(){return color;}
    public double getXPos(){return x;}
    public double getYPos(){return y;}
    public double getHeight(){return height;}
    public double getWidth(){return width;}
}