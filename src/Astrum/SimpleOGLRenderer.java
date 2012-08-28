package Astrum;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*; 
import org.lwjgl.*;	

public class SimpleOGLRenderer {

	public SimpleOGLRenderer(){
		try{
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.setTitle("Astrum");
			Display.create();
		} catch (LWJGLException e){
			e.printStackTrace();
		}
		
		// Initialization code OPENGL
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 600, 0 , 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		while (!Display.isCloseRequested()){
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			glBegin(GL_QUADS);
				glVertex2i(400, 400); // Upperleft Corner
				glVertex2i(500, 400); // UpperRight Corner
				glVertex2i(500, 500); // BottomLeft Corner
				glVertex2i(400, 500); // ButtomLeft Corner
			glEnd();
			
			glBegin(GL_LINES);
				glVertex2i(100, 100); // Upperleft KeyPixel
				glVertex2i(200, 200); // Bottom RightKeyPixel
			glEnd();
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
		
		
	}
	
	public static void main (String[] args){
		new SimpleOGLRenderer();
	}
	
	
}
