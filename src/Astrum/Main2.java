package Astrum;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main2 extends JFrame {
		public static void main(String[] args){
			
			DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
			Main2 m = new Main2();
			m.run();
		}

		private Sprite sprite;
		private Animation a;
		private ScreenManager s;
		private Image bg;
		
		private static final DisplayMode modes1[] = {
			
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
		
		//Load images and add Scenes
		public void loadImages(){
			bg = new ImageIcon("D:\\Astrum\\TriPort Files\\LogoBackGroundTest.png").getImage();
			
			Image face1 = new ImageIcon("D:\\Astrum\\Animation\\1.png").getImage();
			Image face2 = new ImageIcon("D:\\Astrum\\Animation\\2.png").getImage();
			
			a = new Animation();
			a.addScene(face1, 100);
			a.addScene(face2, 100);
			
			sprite = new Sprite(a);
			sprite.setVelocityX(0.3f);
			sprite.setVelocityY(0.3f);
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
				update(timePassed);
				
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
		
		//draw graphics also round the sprites there coords
		public void draw(Graphics g){
			g.drawImage(bg, 0,0, null);
			g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
				
		}
		
		//if the sprite goes off the screen it puts it back
		public void update(long timePassed){
			if(sprite.getX() < 0){
				sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
			}else if(sprite.getX() + sprite.getWidth() >= s.getWidth()){
				sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
			}
			
			if(sprite.getY() < 0){
				sprite.setVelocityY(Math.abs(sprite.getVelocityY()));
			}else if(sprite.getY() + sprite.getHeight() >= s.getHeight()){
				sprite.setVelocityY(-Math.abs(sprite.getVelocityY()));
			}
			
			sprite.updateSprite(timePassed);
		}
		

}