package Javase;

public class Frog extends Animal implements swim {
    public Frog(){}

    public Frog(String cloor, String name) {
        super(cloor, name);
    }

    @Override
    public void eat() {
        System.out.println("青蛙吃东西");
    }

    @Override
    public void swim() {
        System.out.println("青蛙游泳" );
    }

    public static void main(String[] args){
        Frog f=new Frog();
        System.out.println(f.a);
        System.out.println(Frog.a);
        f.eat();

    }
}
