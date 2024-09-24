public class Abstract_classes {
    public static void main(String[] args) {
        horse h=new horse();
        h.eat();
        h.legs();
        System.out.println(h.color);
        bird b=new bird();
        b.eat();
        b.legs();
        b.changecolor();
        System.out.println(b.color);
        //Mustang m=new Mustang();
        
        
    }
}
 abstract class animal {
    
    String color;
    animal(){
        color="brown";
        System.out.println("Animal constructor called");
}
    void eat(){System.out.println("Animal eats.");}
    abstract void legs();    
 }
 class horse extends animal{
    horse(){
        System.out.println("Horse constructor called");
    }
    void legs(){
        System.out.println("4 legs");
    }
 }
 class Mustang extends horse{
    Mustang(){
        System.out.println("Mustang constructor called");
    }
 }
 class bird extends animal{
    void legs(){
        System.out.println("2 legs");
    }
    void changecolor(){
        color="kala";
    }
 }