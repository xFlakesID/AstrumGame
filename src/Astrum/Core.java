package Astrum;
import java.awt.*;

import javax.swing.*;

//if abstract is to inherite in other classes
public abstract class Core {

	public static DisplayMode modes[] = {
		new DisplayMode(1920,1080,32,0),
		new DisplayMode(1920,1080,24,0),
		new DisplayMode(1920,1080,16,0),
		new DisplayMode(1680,1050,32,0),
		new DisplayMode(1680,1050,24,0),
		new DisplayMode(1680,1050,16,0),
		new DisplayMode(1600,1200,32,0),
		new DisplayMode(1600,1200,24,0),
		new DisplayMode(1600,1200,16,0),
		new DisplayMode(1440,1080,32,0),
		new DisplayMode(1440,1060,24,0),
		new DisplayMode(1440,1080,16,0),
		new DisplayMode(1440,900,32,0),
		new DisplayMode(1440,900,24,0),
		new DisplayMode(1440,900,16,0),
		new DisplayMode(1336,768,32,0),
		new DisplayMode(1336,768,24,0),
		new DisplayMode(1336,768,16,0),
		new DisplayMode(1280,854,32,0),
		new DisplayMode(1280,854,24,0),
		new DisplayMode(1280,854,16,0),
		new DisplayMode(1280,960,32,0),
		new DisplayMode(1280,960,24,0),
		new DisplayMode(1280,960,16,0),
		new DisplayMode(1280,768,32,0),
		new DisplayMode(1280,768,24,0),
		new DisplayMode(1280,768,16,0),
		new DisplayMode(1280,720,32,0),
		new DisplayMode(1280,720,24,0),
		new DisplayMode(1280,720,16,0),
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(640,480,16,0),
		new DisplayMode(640,480,24,0),
		new DisplayMode(640,480,32,0),
		
	};
	private boolean running;
	protected ScreenManager s;
	
	//stop();
	public void stop(){
		running = false;
	}
	
	//call init and gameloop
	public void run(){
		try{
			init();
			gameLoop();
		}finally{
			s.restoreScreen();
		}
	}
		
	//set to fullscreen
	public void init(){
		s = new ScreenManager();
		DisplayMode dm = s.findFirstCompatibleMode(modes);
		s.setFullScreen(dm);
		
		Window w = s.getFullScreenWindow();
		w.setFont(new Font("Arial", Font.PLAIN,20));
		w.setBackground(Color.GREEN);
		w.setForeground(Color.WHITE);
		running = true;
	}
	
	//main gameLoop
	public void gameLoop(){
		long startTime = System.currentTimeMillis();
		long qTime = startTime;
		
		
		while(running){
			long timePassed = System.currentTimeMillis() - qTime;
			qTime += timePassed;
			
			update(timePassed);
			
			Graphics2D g = s.getGraphics();
			draw(g);
			g.dispose();
			s.update();
		
			try{
				Thread.sleep(20);
			}catch(Exception ex){}
		}		
	}
	
	//update animation
	public void update(long timePassed){
	}
	
	//draws to the screen
	public abstract void draw(Graphics2D g);
	
}
	
	
