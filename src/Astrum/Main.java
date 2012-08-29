package Astrum;
import java.awt.*;
import javax.swing.JFrame;

public class Main extends JFrame {
		public static void main(String[] args){
			
			DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
			Main m = new Main();
			m.run(dm);
		}
		
		public void run(DisplayMode dm){
			setBackground(Color.BLACK);
			setForeground(Color.WHITE);
			setFont(new Font("Verdana",Font.PLAIN, 24));
			
			
			/*
			 * 
			 * Make it fullscreenand actually catch the screen after 5 sec timer until it quits
			 * 
			 */
			Screen s = new Screen();
			try{
				s.setFullscreen(dm, this);
				try{
					Thread.sleep(5000);
				}catch(Exception ex){}
				//the screen gets killed  here and gets restored to your normal dekstop
			}finally{
				s.restoreScreen();
			}
		}
		
		//paint with the paint method
		public void paint(Graphics g){
			if(g instanceof Graphics2D){
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
			g.drawString("Hello Rob",  200, 200);
		}
		
}
