import java.util.Scanner;
import java.util.ArrayList;

class Rectangle extends Shape {
    // TO DO: define fields
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        // TO DO:
        this("", "", width, height);
    }

    public Rectangle(String text, String material, int width, int height) {
        // TO DO:
        super(text, material);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        // TO DO:
        return "Rectangle: height is: " + this.height + ", width is: " + this.width + ", made of " + this.material + ", contains the text: \"" + this.text + "\".";
    }

    @Override
    public boolean equals(Object obj) {
        // TO DO:
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Rectangle newRectangle = (Rectangle) obj;
        return super.equals(newRectangle) &&
                this.width == newRectangle.width &&
                this.height == newRectangle.height;
    }

    @Override
    public int hashCode() {
        // TO DO:
        int prime = 31;
        int result = super.hashCode();
        result = prime * result + width;
        result = prime * result + height;
        return result;
    }

    public void displayRectangleHeight() {
        // TO DO:
        System.out.println("Rectangle height is: " + this.height);
    }

    @Override
    public int getSize() {
        // TO DO:
        return (this.width * this.height);
    }
}

class Shape {
    // TO DO: define fields
    public String text;
    public String material;

    public Shape() {
        this("", "");
    }

    public Shape(String text, String material) {
        this.text = text;
        this.material = material;
    }

    @Override
    public String toString() {
        // TO DO:
        return "made of " + this.material + ", contains the text: \"" + this.text + "\".";
    }

    @Override
    public boolean equals(Object obj) {
        // TO DO:
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Shape other = (Shape) obj;
        return (this.text.equals(other.text)) && (this.material.equals(other.material));
    }

    @Override
    public int hashCode() {
        // TO DO:
        final int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode()) + ((material == null) ? 0 : material.hashCode());
        return result;
    }

    public int getSize() {
        // TO DO:
        return -1;
    }
}

class Triangle extends Shape {
    /// TO DO: define fields
    private int base;
    private int height;

    public Triangle(int base, int height) {
        // TO DO:
        this("", "", base, height);
    }

    public Triangle(String text, String material, int base, int height) {
        // TO DO:
        super(text, material);
        this.base = base;
        this.height = height;
    }

    @Override
    public String toString() {
        // TO DO:
        return "Triangle: height is " + this.height + ", base is: " + this.base + ", made of " + this.material + ", contains the text: \"" + this.text + "\".";
    }

    @Override
    public boolean equals(Object obj) {
        // TO DO:
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Triangle newTriangle = (Triangle) obj;
        return super.equals(newTriangle) &&
                this.material.equals(newTriangle.material) &&
                this.text.equals(newTriangle.text) &&
                this.base == newTriangle.base &&
                this.height == newTriangle.height;
    }

    @Override
    public int hashCode() {
        // TO DO:
        int prime = 31;
        int result = super.hashCode();
        result = prime * result + base;
        result = prime * result + height;
        return result;
    }

    public void displayTriangleHeight() {
        // TO DO:
        System.out.println("Triangle height is: " + this.height);
    }

    @Override
    public int getSize() {
        // TO DO:
        return ((this.base * this.height) / 2);
    }
}

public class Main {
    public static Triangle readTriangle(Scanner sc) {
        System.out.print("material: ");
        String material = sc.nextLine();
        System.out.print("mesaj: ");
        String message = sc.nextLine();
        System.out.print("base: ");
        int base = sc.nextInt();
        sc.nextLine();
        System.out.print("height: ");
        int height = sc.nextInt();
        sc.nextLine();
        return new Triangle(message, material, base, height);
    }

    public static Rectangle readRectangle(Scanner sc) {
        System.out.print("material: ");
        String material = sc.nextLine();
        System.out.print("mesaj: ");
        String message = sc.nextLine();
        System.out.print("width: ");
        int width = sc.nextInt();
        sc.nextLine();
        System.out.print("height: ");
        int height = sc.nextInt();
        sc.nextLine();
        return new Rectangle(message, material, width, height);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Rectangle newRect = readRectangle(scanner);
//        Shape newerRect = readRectangle(scanner);
//        System.out.println("Primul dreptunghi:");
//        System.out.println(newRect.getSize());
//        System.out.println(newRect.text);
//        System.out.println(newRect.getClass());
//        System.out.println(newerRect.getClass());
//        System.out.println(newRect.equals(newerRect));
//        System.out.println(newRect.hashCode());
        Triangle triangle1 = readTriangle(scanner);
        Triangle triangle2 = readTriangle(scanner);

        System.out.println((triangle1).getSize());
        System.out.println(((Shape) triangle1).hashCode());
        triangle1.displayTriangleHeight();
        System.out.println(triangle1.equals(triangle2));
        //triangle1.displayTriangleHeight();
    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<Shape> myShapes = new ArrayList<Shape>();
//        int a = scanner.nextInt();
//        switch (a) {
//            case 1:
//                while (scanner.hasNext()) {
//                    scanner.nextLine();
//                    Triangle t = readTriangle(scanner);
//                    t.displayTriangleHeight();
//                    System.out.println(t.toString());
//                    System.out.println(t.getSize());
//                    myShapes.add(t);
//                }
//                if (myShapes.size() > 1) {
//                    Triangle first = (Triangle) myShapes.get(0);
//                    for (int i = 1; i < myShapes.size(); ++i) {
//                        Triangle t = (Triangle) myShapes.get(i);
//                        System.out.println(t.equals(first));
//                    }
//                }
//                break;
//            case 2:
//                while (scanner.hasNext()) {
//                    scanner.nextLine();
//                    Rectangle t = readRectangle(scanner);
//                    t.displayRectangleHeight();
//                    System.out.println(t.toString());
//                    System.out.println(t.getSize());
//                    myShapes.add(t);
//                }
//                if (myShapes.size() > 1) {
//                    Rectangle first = (Rectangle) myShapes.get(0);
//                    for (int i = 1; i < myShapes.size(); ++i) {
//                        Rectangle r = (Rectangle) myShapes.get(i);
//                        System.out.println(r.equals(first));
//                    }
//                }
//                break;
//            case 3:
//                int c = 0;
//                while (scanner.hasNext()) {
//                    scanner.nextLine();
//                    Shape s;
//                    if (c % 2 == 0) {
//                        s = readTriangle(scanner);
//                    } else {
//                        s = readRectangle(scanner);
//                    }
//                    System.out.println(s.toString());
//                    myShapes.add(s);
//                    ++c;
//                }
//                if (myShapes.size() > 1) {
//                    Shape first = myShapes.get(0);
//                    for (int i = 1; i < myShapes.size(); ++i) {
//                        System.out.println(myShapes.get(i).equals(first));
//                    }
//                }
//                break;
//        }
//    }
}
