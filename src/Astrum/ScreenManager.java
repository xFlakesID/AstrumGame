package Astrum;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JFrame;

public class ScreenManager {

	private GraphicsDevice vc;
	
	//Give vc acces to Monitor/Screen;
	public ScreenManager(){
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = e.getDefaultScreenDevice();
	}
	
	//Get all compatible DMs
	public DisplayMode[] getCompatibleDisplayModes(){
		return vc.getDisplayModes();
	}
	
}
