package Astrum;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*; 
import org.lwjgl.*;	

public class lwjgl_helloWorld {

	public lwjgl_helloWorld(){
		try{
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Astrum");
			Display.create();
		} catch (LWJGLException e){
			e.printStackTrace();
		}
		
		// Initialization code OPENGL
		
		while (!Display.isCloseRequested()){
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
		
	}
	
	public static void main (String[] args){
		new lwjgl_helloWorld();
	}
	
	
}
