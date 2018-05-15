
package javaapplication3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
//import java.util.Random; 


import javax.swing.Timer;


public class GameEngineTwo implements KeyListener, GameReporter{
	GamePanel gp;	
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        private ArrayList<Reward> reenemies = new ArrayList<Reward>();
         private ArrayList<DownSpeed> lowspeed = new ArrayList<DownSpeed>();
      
	private SpaceShip v;		
	private Timer timer;
	private int state = 0;
        private int temp = 0;
        private int temp1 = 0;
	private long score = 0;
        private int i = 0;
	private double difficulty = 0.2;
        private Def speed = new Def(100,0.2);
	public GameEngineTwo(GamePanel gp, SpaceShip v) {
		this.gp = gp;
		this.v = v;
                this.i = i;
		gp.sprites.add(v);
        
		timer = new Timer(1, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
                                
			}
		});
		timer.setRepeats(true);
		
	}
	
	public void start(){
                
		timer.start();
     
	}
	
	private void generateEnemy(){
            int ran=(int)(Math.random()*100);
            if(ran >= 10){
		Enemy e = new Enemy((int)(Math.random()*390), 30);
                gp.sprites.add(e);
		enemies.add(e);
	    
            }
            if(ran < 10){
                Reward k = new Reward((int)(Math.random()*390), 30);
                gp.sprites.add(k);
		reenemies.add(k);
                
            }
            
            if(ran >=5 && ran < 10 ){
		DownSpeed a = new DownSpeed((int)(Math.random()*390), 30);
                gp.sprites.add(a);
		lowspeed.add(a);
            }
           }	
        
            
	
	private void process(){
            
                timer.setDelay(speed.speedUp()); //
                difficulty = speed.enemyUp();//
		if(Math.random() < difficulty){
			generateEnemy();
		}
		
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
				score += 10;
			}
		}
                
                
                
		Iterator<Reward> k_iter = reenemies.iterator();
		while(k_iter.hasNext()){
			Reward k = k_iter.next();
			k.proceed();
			
			if(!k.isAlive()){
				k_iter.remove();
				gp.sprites.remove(k);
				score += 10;
			}
		}
                
                Iterator<DownSpeed> a_iter = lowspeed.iterator();
		while(a_iter.hasNext()){
			DownSpeed a = a_iter.next();
			a.proceed();
			
			if(!a.isAlive()){
				a_iter.remove();
				gp.sprites.remove(a);
				
			}
		}
		
		gp.updateGameUI(this);
		
		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double er;
		for(Enemy e : enemies){
			er = e.getRectangle();
			if(er.intersects(vr)){
                            if(temp1 == 0)
                                gp.updateGameOver(this);
				die();
				return;
			}
		}
                
               
		for(Reward e : reenemies){
			er = e.getRectangle();
			if(er.intersects(vr)){
				reward();
				return;
			}
		}
                
                for(DownSpeed e : lowspeed){
			er = e.getRectangle();
			if(er.intersects(vr)){
				lowspeed();
				return;
			}
		}
	}
        
        
        public void reward(){
                
                score += 100000;
              
        }
	
	public void die(){
              
               timer.stop();
               
	}
        
        public void lowspeed(){
              
               speed.speedin(100);
               
	}
	
	
	void controlVehicle(KeyEvent e) {
		switch (e.getKeyCode()) {
		
                
                       
                case KeyEvent.VK_LEFT:
			v.moveX(-1);
			break;
		case KeyEvent.VK_RIGHT:
			v.moveX(1);
			break;
                
                case KeyEvent.VK_DOWN:
			v.moveY(1);
			break;
		case KeyEvent.VK_UP:
			v.moveY(-1);
			break;        
                case KeyEvent.VK_P:
                        state ++ ;
			if((state % 2) == 0)
                            timer.stop();
                        if((state % 2) == 1)
                            timer.start();
			break;
                case KeyEvent.VK_I:
                        temp++;
                        if((temp % 2) == 1)
                            temp1 = 1;
                        if((temp % 2) == 0)
                            temp1 = 0;
                case KeyEvent.VK_O:
                        score += 100000;
                
		}

	}
	

	public long getScore(){
		return score  ;
	}
        public String getString(){
            return "Player_2";
        }
	
	@Override
	public void keyPressed(KeyEvent e) {
		controlVehicle(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
				
	}
}