package Astrum;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame {
		public static void main(String[] args){
			
			DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
			Main m = new Main();
			m.run(dm);
		}
		
		private Screen screen;
		private Image bg;
		private Animation a;
		
		//loads Pictures from computer to .java and adds a scene
		public void loadPics(){
			bg = new ImageIcon("D:\\Astrum\\TriPort Files\\LogoBackGroundTest.png").getImage();

			Image face1 = new ImageIcon("D:\\Astrum\\Animation\\1.png").getImage();
			Image face2 = new ImageIcon("D:\\Astrum\\Animation\\2.png").getImage();
			a = new Animation();
			a.addScene(face1, 250);
			a.addScene(face2, 250);
		}
		
		//Main engine to run
		public void run(DisplayMode dm){
			screen = new Screen();
			try{
				screen.setFullscreen(dm, new JFrame());
				loadPics();
				movieLoop();
			}finally{
				screen.restoreScreen();
			}
		}
		
		//Main Move Loop
		//Changed cumTime to qTime because of the irony behind it.
		public void movieLoop(){
			long startingTime = System.currentTimeMillis();
			long qTime = startingTime;
			
			while(qTime - startingTime <5000){
				
			 long timePassed = System.currentTimeMillis() - qTime;
				qTime += timePassed;
				a.updateScene(timePassed);
				
				Graphics g = screen.getFullScreenWindow().getGraphics();
				draw(g);
				g.dispose();
			
				try{
					Thread.sleep(20);
				}catch(Exception ex){}
		}
	}
	//Draw Method
	public void draw(Graphics g){
		g.drawImage(bg, 0,0,null);
		g.drawImage(a.getImage(), 0,0,null);
	}
}

