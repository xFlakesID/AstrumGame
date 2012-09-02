package Astrum;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame {
		public static void main(String[] args){
			
			DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
			Main m = new Main();
			m.run();
		}

		private Animation a;
		private ScreenManager s;
		private Image bg;
		
		private static final DisplayMode modes1[] = {
			
			new DisplayMode(800,600,32,0),
			new DisplayMode(800,600,24,0),
			new DisplayMode(800,600,16,0),
			new DisplayMode(640,480,16,0),
			new DisplayMode(640,480,24,0),
			new DisplayMode(640,480,32,0),
			
		};
		
		//Load images and add Scenes
		public void loadImages(){
			bg = new ImageIcon("D:\\Astrum\\TriPort Files\\LogoBackGroundTest.png").getImage();
			
			Image face1 = new ImageIcon("D:\\Astrum\\Animation\\1.png").getImage();
			Image face2 = new ImageIcon("D:\\Astrum\\Animation\\2.png").getImage();
			
			a = new Animation();
			a.addScene(face1, 100);
			a.addScene(face2, 100);
		}
		
		//main method called form main
		public void run(){
			s = new ScreenManager();
			try{
				DisplayMode dm = s.findFirstCompatibleMode(modes1);
				s.setFullScreen(dm);
				loadImages();
				movieLoop();
				
			}finally{
				s.restoreScreen();
			}
		}
	
		
		//play movie
		public void movieLoop(){
			long startingTime = System.currentTimeMillis();
			long qTime = startingTime;
			while(qTime - startingTime <5000){
				long timePassed = System.currentTimeMillis() - qTime;
				qTime += timePassed;
				a.updateScene(timePassed);
				
				//draw and update
				Graphics2D g = s.getGraphics();
				draw(g);
				g.dispose();
				s.update();
				
				try{
					Thread.sleep(20);
					
				}catch(Exception ex){}
			}
		}
		
		//draw graphics
		public void draw(Graphics g){
			g.drawImage(bg, 0,0, null);
			g.drawImage(a.getImage(), 0,0, null);
		}
		
		
}