package com.example.myapplication;

public class Pokemon {
    String name;
    String type;
    int health;
    int attack_power;
    boolean isalive = true;

    Pokemon(){
    }

    Pokemon(String name , String type , int health , int attack_power){
        this.name = name;
        this.type = type;
        this.health = health;
        this.attack_power = attack_power;
    }

    public void setIsalive(boolean isalive) {
        this.isalive = isalive;
        if (!isalive)
            this.health = 0;
    }

    public void setAttack_power(int attack_power) {
        this.attack_power = attack_power;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public boolean dodge(){
        return Math.random() > 0.5;
    }

    void attack (Pokemon enemey){
        if (!enemey.dodge()){
            enemey.health -= this.attack_power;
            if (enemey.health <= 0)
                enemey.setIsalive(false);
        }
    }

}
