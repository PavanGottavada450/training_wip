package Day4;


abstract class Vehicle{
    void startEngine(){
       System.out.println("Engine Started"); 
    }
    abstract void drive();
}

interface Flyable{
    void fly();
}

class Car1 extends Vehicle{
    void drive(){
        System.out.println("driving on road");
    }
}

class Plane extends Vehicle implements Flyable{
    void drive(){
        System.out.println("Rolling on runway");
    }
    
    public void fly(){
        System.out.println("Flying in the air");
    }
}

public class Main{
    public static void main(String[] args){
        Vehicle c = new Car1();
        c.startEngine();
        c.drive();
        
        Vehicle p = new Plane();
        p.startEngine();
        p.drive();
        
        // Cast to Flyable to call fly()
        if (p instanceof Flyable) {
            ((Flyable) p).fly();
        }
    }
}