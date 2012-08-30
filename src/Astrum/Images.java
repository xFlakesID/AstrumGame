package Astrum;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Images extends JFrame {
		public static void main(String[] args){
			
			DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
			Images i = new Images();
			i.run(dm);
		}
		
		private Screen s;
		private Image bg;
		private Image pic;
		private boolean loaded;
		
		
		//run method
		public void run(DisplayMode dm){
			setBackground(Color.BLACK);
			setForeground(Color.WHITE);
			setFont(new Font("Verdana",Font.PLAIN, 24));
			loaded = false;
			
			/*
			 * 
			 * Make it fullscreen and actually catch the screen after 5 sec timer until it quits
			 * 
			 */
			s = new Screen();
			try{
				s.setFullscreen(dm, this);
				loadpics();
				try{
					Thread.sleep(5000);
				}catch(Exception ex){}
				//the screen gets killed  here and gets restored to your normal dekstop
			}finally{
				s.restoreScreen();
			}
		}
		
		/*
		 * 
		 * load pictures
		 * 
		 */
		public void loadpics(){
			
			bg = new ImageIcon("D:\\Astrum\\TriPort Files\\LogoBackGroundTest.png").getImage();
			pic = new ImageIcon("D:\\Astrum\\TriPort Files\\LogoMedium.png").getImage();
			loaded = true;
			repaint();
		}
		
		//paint with the paint method
		public void paint(Graphics g){
			if(g instanceof Graphics2D){
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
			if(loaded){
				g.drawImage(bg,0,0,null);
				g.drawImage(pic,120,180,null);
			}
		}
		
}
