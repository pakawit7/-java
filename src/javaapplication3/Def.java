
package javaapplication3;

public class Def {
    private int countSpeed = 0;
    private int countEnemy = 0;
    private int speed;
    private double enemy;
    public Def(int speed,double enemy){
        this.speed = speed;
        this.enemy = enemy;
    }
    
    public int speedUp(){ 
        countSpeed ++;
        
        if(countSpeed == 20){
            if(speed >= 10){
                speed = speed-2;
                System.out.println(speed);
            }
            countSpeed = 0;
        }
        return speed;
    }
    
    public double enemyUp(){ 
        countEnemy ++;
        enemy = 0.2;
        if(countEnemy == 100){
            enemy = enemy + 0.1;  
            System.out.println(enemy);
            countEnemy = 0;
            
        }
        return enemy;
    }
    
    public void speedin(int i){
        this.speed = i;
    } 
}
