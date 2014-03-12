package Utility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Game.Image;

public class ImageUtility {
	
	
	public static BufferedImage loadBufferedImage(String path){
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return img;
	}
	
	
	
	public static int setOutLineOnImage(String path){
		BufferedImage image = null;
		BufferedImage outLine = null;
		
		try {
			image = ImageIO.read(new File(path));
			outLine = ImageIO.read(new File( path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		int alpha = 100;
		int red = 255;
		int green = 255;
		int blue = 255;
		
		
		int col = (alpha << 24) | (red << 16) | (green << 8) | blue;
		
		
		int w = image.getWidth();
		int h = image.getHeight();
		int t = 0;
		
		
		for (int y = 0; y < h; y++){
			for (int x = 0; x < w; x++){
				
					
					if (x >= 0 && ALPHA(x,y,image) > t)	{outLine.setRGB(x, y, col);}
			
			}
		}
		return Image.ConvertToTexture(outLine);
	}
	private static int ALPHA(int x, int y, BufferedImage image){
		return ((image.getRGB(x, y) >> 24) & 0xFF);
	}
	
	
	
	
	

	
	
	
	
	

	
	
	
	
}
