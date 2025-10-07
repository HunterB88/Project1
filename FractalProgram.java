package CSCI1933P1;
import java.util.Scanner;

public class FractalProgram {
    //TODO:
    // Main should ask user for shape input, and then draw the corresponding fractal.
    // This method should print area of fractal, after the fractal is done drawing.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FractalDrawer shape = new FractalDrawer();

        System.out.print("Enter a shape (circle, triangle, rectangle): ");
        
        String userShape = s.nextLine();
        
        shape.drawFractal(userShape);

        double total = shape.drawFractal(userShape); // capture returned total area
        System.out.println("Total area: " + total);
        
        s.close();
    }
}
