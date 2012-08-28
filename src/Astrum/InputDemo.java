package Astrum;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.*; 
import org.lwjgl.*;	
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.input.Mouse.*;
import org.lwjgl.input.Keyboard.*;

public class InputDemo {
	
	private List<Box> shapes = new ArrayList<Box>(16);
	private boolean somethingIsSelected = false;
	public InputDemo(){
		try{
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Astrum - When everything seems lost! ");
			Display.create();
		} catch (LWJGLException e){
			e.printStackTrace();
		}
		
		shapes.add(new Box(15, 15));
		shapes.add(new Box(150, 150));
		
		// Initialization code OPENGL
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0 , 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		while (!Display.isCloseRequested()){
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Display.destroy();
				System.exit(0);
			}
		for(Box box : shapes){
			if(Mouse.isButtonDown(0) && box.inBounds(450 -Mouse.getX(), 350 - Mouse.getX())&& !somethingIsSelected){
			
				System.out.println("Ouch! You clicked me!");
				somethingIsSelected = true;
				box.selected = true;
			}
			if (Mouse.isButtonDown(1)){
				somethingIsSelected = false;
				box.selected = false;
				
			}
			
			if(box.selected){
				box.update(Mouse.getDX(), -Mouse.getDY());
			}
			box.draw();
		}
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
		
	}
	
	private static class Box{
		public int x, y;
		public boolean selected = false;
		private float colorRed, colorBlue, colorGreen;
		
		Box(int x, int y){
			this.x = x;
			this.y = y;
			
			Random randomGenerator = new Random();
			colorRed = randomGenerator.nextFloat();
			colorBlue = randomGenerator.nextFloat();
			colorGreen = randomGenerator.nextFloat();
		}
		
		boolean inBounds(int mousex, int mousey ){
			if(mousex > x && mousey < x + 50 && mousey > y && mousey < y + 50 ){
				return true;
			}else
			return false;
			
		}
		
		void update(int dx, int dy){
			x += dx;
			y += dy; 
		}

		void randomizedColors() {
			Random randomGenerator = new Random();
			colorRed = randomGenerator.nextFloat();
			colorBlue = randomGenerator.nextFloat();
			colorGreen = randomGenerator.nextFloat();
			
		}
		
		void draw(){
			glColor3f(colorRed, colorGreen, colorBlue);
			
			glBegin(GL_QUADS);
				glVertex2f(x, y);
				glVertex2f(x + 50, y);
				glVertex2f(x + 50, y +50);
				glVertex2f(x, y + 50);
			glEnd();
		}
	
	} 
	
		
	
	public static void main (String[] args){
		new InputDemo();
	}
	
	
}
