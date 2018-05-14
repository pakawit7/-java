
package javaapplication3;


import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random; 

public class SpaceShip extends Sprite{

	int step = 10;
        
	Color color_random = new Color ( new Random().nextFloat(), new Random().nextFloat(), new Random().nextFloat() );
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color_random);
		g.fillRect(x, y, width, height);
		
	}

	public void moveX(int direction){
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 400 - width)
			x = 400 - width;
	}
        
        public void moveY(int direction){
		y += (step * direction);
		if(y < 0)
			y = 0;
		if(y > 600 - width)
			y = 600 - width;
	}

}

