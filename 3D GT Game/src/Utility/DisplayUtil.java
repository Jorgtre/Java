package Utility;

import static org.lwjgl.opengl.GL11.glViewport;

import java.awt.Desktop;

import javax.management.monitor.Monitor;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import Game.Main;

public class DisplayUtil {
	
	public static DisplayMode getFullscreenDisplay(){
		DisplayMode[] modes = null;
		int MonitorWidth = Display.getDesktopDisplayMode().getWidth();
		int MonitorHeight = Display.getDesktopDisplayMode().getHeight();
		int MonitorFrequency = Display.getDesktopDisplayMode().getFrequency();
		int MonitorBpp = Display.getDesktopDisplayMode().getBitsPerPixel();
		
		
		try {
			modes = Display.getAvailableDisplayModes();
			for (int x = 0; x < modes.length; x++) {
				if (modes[x].getWidth() == MonitorWidth &&
					modes[x].getHeight() == MonitorHeight &&
					modes[x].getFrequency() == MonitorFrequency &&
					modes[x].getBitsPerPixel() == MonitorBpp) {return modes[x];}
			}
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static void toggleFullscreen(boolean Fullscreen){
		
		
		try {
			
			if (Fullscreen)
			{
				
				Display.setDisplayMode(getFullscreenDisplay());
				Display.setFullscreen(Fullscreen);
				updateViewport();
			}
			else 
			{
				Display.setDisplayMode(new DisplayMode(Main.screenWidth, Main.screenHeight));
				Display.setFullscreen(Fullscreen);
				updateViewport();
				
			}
			
			
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

	}
	
	public static void updateViewport(){
		Main.screenHeight = Display.getHeight();
		Main.screenWidth =  Display.getWidth();
		glViewport(0, 0, Main.screenWidth, Main.screenHeight);
	}
	

	
}
