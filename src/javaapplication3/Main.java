
package javaapplication3;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main {
       
        
       
        
	public static void main(String[] args){
           
                GridLayout g = new GridLayout(0,2);
                g.setHgap(5);
		JFrame frame = new JFrame("Space War");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 650);
		frame.getContentPane().setLayout(new BorderLayout());
		JPanel jp = new JPanel();
                jp.setLayout(g);
                
		SpaceShip v_one = new SpaceShip(180, 550, 20, 20);
		GamePanel gp_one = new GamePanel();
		GameEngine engine_one = new GameEngine(gp_one, v_one);
                jp.add(gp_one);
		frame.addKeyListener(engine_one);
                
                SpaceShip v_two = new SpaceShip(180, 550, 20, 20);
		GamePanel gp_two = new GamePanel();
		GameEngineTwo engine_two = new GameEngineTwo(gp_two, v_two);
                jp.add(gp_two);
		frame.addKeyListener(engine_two);
                
		frame.getContentPane().add(jp, BorderLayout.CENTER);
		frame.setVisible(true);
		
		engine_one.start();
                engine_two.start();
         
	}
       
        
        
}
