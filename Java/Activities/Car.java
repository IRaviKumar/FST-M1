package Activities;

public class Car {

    public String color;
    public String transmission;
    public int make;
    int tyres;
    int doors;

    public Car()
    {
        this.tyres=4;
        this.doors=4;
    }

    public void displayCharacteristics()
    {
        System.out.println("Car color is"+color);
        System.out.println("Car Transmission is"+transmission);
        System.out.println("Car make is"+make);
        System.out.println("Car has"+tyres+"number of tyres");
        System.out.println("Car has"+doors+"number of doors");
    }

    public void accelerate()
    {
           System.out.println("Car is moving forward");
    }

    public void brake()
    {
        System.out.println("Car has stopped");
    }
}
