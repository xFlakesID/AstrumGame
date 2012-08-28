package Astrum;

import java.awt.*;
import javax.swing.JFrame;

public class Screen {
	//Get acces to the GraphicsDevice Var = vc
	private GraphicsDevice vc;
	
	public Screen(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//Get acces to our computerscreen
		vc= env.getDefaultScreenDevice();
		
	}
	
	public void setFullscren(DisplayMode dm, JFrame window){
		
		window.setUndecorated(true);
		window.setResizable(false);
		vc.setFullScreenWindow(window);
		
		
	}
	
}
