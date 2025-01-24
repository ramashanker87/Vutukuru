package com.rama.app;

class Shape{
    public void area(){
        System.out.println("This is the area");
    }
}

class Circle extends Shape{
    double radius;
    public Circle(double radius){
        this.radius=radius;
    }
    public void area(){
      double  area=Math.PI*radius*radius;
      System.out.println("Area of circle : "+area);
    }
}

class Triangle extends Shape{
    double base,height;
    public Triangle(double base,double height){
        this.base=base;
        this.height=height;
    }
    public void area(){
        double  area=base*height;
        System.out.println("Area of Triangle : "+area);
    }
}

class Rectangle extends Shape{
    double lenght,width;
    public Rectangle(double lenght,double width){
        this.lenght=lenght;
        this.width=width;
    }
    public void area(){
        double  area=lenght*width;
        System.out.println("Area of Rectangle : "+area);
    }
}
public class App 
{
    public static void main( String[] args )
    {
        Circle cir=new Circle(12);
        cir.area();
        Rectangle rect=new Rectangle(12,12);
        rect.area();
        Triangle trn=new Triangle(16,8);
        trn.area();
    }
}

