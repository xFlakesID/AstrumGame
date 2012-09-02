package Astrum;
import java.awt.Image;

public class Sprite {

	private Animation a;
	private float x;
	private float y;
	private float vx;
	private float vy;
	
	//Constructor
	public Sprite(Animation a){
		this.a = a;
	
	}
	
	//able to make it change poisitions
	public void updateSprite(long timePassed){
		x += vx * timePassed;
		y += vy * timePassed;
		a.updateScene(timePassed);
	}
	//get x position
	public float getX(){
		return x;
	}
	//get y position
	public float getY(){
		return y;
	}
	//set sprite x position
	public void setX(float x){
		this.x = x;
	}
	//set sprite Y position
	public void setY(float y){
		this.y = y;
	}
			
	//get sprite width
	public int getWidth(){
		return a.getImage().getWidth(null);
	}
	//get sprite heigth
	public int getHeight(){
		return a.getImage().getHeight(null);
	}
	
	//get horizontal verocity
	public float getVelocityX(){
		return vx;
	}
	//get vertical verocity
	public float getVelocityY(){
		return vy;
	}
	//set horizontal velocity
	public void setVelocityX(float vx){
		this.vx = vx;
	}
	//set vertical velocity
	public void setVelocityY(float vy){
		this.vy = vy;
	}
	
	//get sprites image
	public Image getImage(){
		return a.getImage();
	}
}
