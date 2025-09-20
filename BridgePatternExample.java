// Implementor: Color
interface Color {
    String applyColor();
}

// Concrete Implementor: RedColor
class RedColor implements Color {
    @Override
    public String applyColor() {
        return "Red";
    }
}

// Concrete Implementor: BlueColor
class BlueColor implements Color {
    @Override
    public String applyColor() {
        return "blue";
    }
}

// Abstraction: Shape
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract String draw();
}

// Concrete Abstraction: Circle
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    String draw() {

        return "Drawing a Circle with color " + color.applyColor();
    }
}

// Concrete Abstraction: Square
class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    String draw() {
        return "Drawing a Square with color " + color.applyColor();
    }
}

// Usage
public class BridgePatternExample {
    public static void main(String[] args) {
        Color redColor = new RedColor();
        Color blueColor = new BlueColor();
        Circle circle = new Circle(redColor);
        Square square = new Square(blueColor);
        System.out.println(circle.draw()); // Output: Drawing a Circle with Color Red
        System.out.println(square.draw()); // Output: Drawing a Square with Color Blue
    }
}