package CSCI1933P1;
import java.util.Scanner;
import java.util.scanner;

public class FractalProgram {
    //TODO:
    // Main should ask user for shape input, and then draw the corresponding fractal.
    // This method should print area of fractal, after the fractal is done drawing.
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        FractalDrawer test = new FractalDrawer();

        System.out.print("Enter a shape (circle, triangle, rectangle): ");
        
        String userShape = s.nextLine();
        
        test.drawFractal(userShape);

        double total = test.drawFractal(userShape); // capture returned total area
        System.out.println("Total area: " + total);
        
        s.close();
    }
}
