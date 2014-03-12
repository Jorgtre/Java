package Objects.Buttons;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.newdawn.slick.util.BufferedImageUtil;

import Game.Image;
import Objects.Button;

public class textImgButton extends Button {
	private int img;
	private int hoverImg;
	private String imgPath;
	private int iW;
	private int iH;
	private BufferedImage buffImg;
	
	public textImgButton(String imgName , int size,int x, int y) {
		super(x , y, 0 , 0);
		this.imgPath = "res/Buttons/" + imgName + ".png";
		this.buffImg = Utility.ImageUtility.loadBufferedImage(imgPath);
		
		
		this.img = Image.Load(imgPath);
		this.hoverImg = Utility.ImageUtility.setOutLineOnImage(imgPath);
		
		this.h = buffImg.getHeight() / 2 * size;
		this.w = buffImg.getWidth() / 2  * size;
	}
	

	
	public void render() {
		if (mouseHover()) 
		{
			Image.print(img, x, y, w, h, 255, 255, 255, true);
			Image.print(hoverImg, x, y, w, h, true);
		}
		else 
		{
			Image.print(img, x, y, w, h, 255, 255, 255, true);
		}
		
	}
	
	
	
}
