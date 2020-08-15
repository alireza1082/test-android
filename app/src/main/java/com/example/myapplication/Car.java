package com.example.myapplication;

public class Car {

    public static void main(String[] args) {
        Car car = new Car(200 , 50 , "red");
        car.drive();
        car.gasoline(10);
        car.drive();
    }

    private float gas = 20;
    private int distance = 0;
    private int topSpeed;
    private int speed = 0;
    private String color;
    private int gas_MAX = 100;

    Car(int topSpeed , int gas , String color ){
        this.color = color;
        this.gas = gas;
        this.topSpeed = topSpeed;
    }
    Car(int topSpeed , String color){
        this.topSpeed = topSpeed;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void icreamentspeed(){
        this.speed++ ;
        System.out.println("speed increased");
    }

    public void decreamentspeed(){
        this.speed-- ;
        System.out.println("speed decreased");
    }

    public String getColor() {
        return color;
    }

    public int getDistance() {
        return distance;
    }

    public float getGas() {
        return gas;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public void gasoline(int gas1){
        if (this.gas + gas1 < gas_MAX)
            this.gas += gas1;
        else {
            this.gas = this.gas_MAX;
            System.out.println("overflow");
        }
        System.out.println("gasoline:" + gas1 + "Lit");
    }
    public void gasoline(){
        if (this.gas + 10 < gas_MAX)
            this.gas += 10;
        else
            this.gas = this.gas_MAX;
        System.out.println("gasoline:" + 10 + "Lit");
    }


    public void decreamentGas(){
        this.gas -= this.speed * 0.1;
    }
    public void decreamentGas(double km){
        this.gas -= km ;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void increamentDistance(int dis){
        this.distance += dis;
    }

    public void drive(){
        if (this.gas > this.speed * 0.1) {
            this.decreamentGas();
            this.increamentDistance(this.speed);
            System.out.println("Drive for " + this.speed +" K.M");
        }
    }
    public void drive(int km){
        double gas2 =  (km/10.0);
        if (this.gas > gas2) {
            this.decreamentGas(gas2);
            this.increamentDistance(km);
            System.out.println("Drive for " + km + " K.M" + "with" + gas2 + "speed");
        }
    }


}
