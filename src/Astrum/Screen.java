package Astrum;

import java.awt.*;
import javax.swing.JFrame;

public class Screen {
	private GraphicsDevice vc;
	
	public Screen(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//Get acces to our computerscreen
		vc= env.getDefaultScreenDevice();
		
	}
	
	public void setFullscreen(DisplayMode dm, JFrame window){
		//make it undecorated and unsizable
		window.setUndecorated(true);
		window.setResizable(false);
		vc.setFullScreenWindow(window);
		//dm is able to work with the vc to support the dm
		if(dm != null && vc.isDisplayChangeSupported()){
			try{
				vc.setDisplayMode(dm);
			}catch(Exception ex){}
			
		}	
	}
	//set window to fullscreen
	public Window getFullScreenWindow(){
		return vc.getFullScreenWindow();
	}
	//restores screen to normal aka exits
	public void restoreScreen(){
		Window w = vc.getFullScreenWindow();
		if(w != null){
			w.dispose();
		}
		//destroy the monitor
		vc.setFullScreenWindow(null);
	}
	
	
	
}
