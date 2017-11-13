package javaExampleGreeter;

public class Greeter {
    private String name;

    public Greeter(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        new Greeter("Java").greet();
    }

    public void greet() {
        System.out.println(String.format("Hello, %s!", this.name));
    }
}
