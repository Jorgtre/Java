package Game;

import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_RGBA8;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_S;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_T;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;
import static org.lwjgl.opengl.GL11.glVertex2i;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GLContext;

import Utility.Folder;
import Utility.folderUtility;

public class Image {

	private static final int BYTES_PER_PIXEL = 4;
	public static int Blank;
	public static BufferedImage Font;
	
	
	
	public static int [] list = new int[20];
	
	public static ArrayList<Folder> imgFolder = null;
	
	
	public static int MenuBackground;
	public static int GameBackground;

	
	
	
	
	
	public static void LoadImgs()	{
		imgFolder = initImgFolders();
		
		
		
		
		
			GameBackground = Load("res/BackgroundImgs/air.png");
			MenuBackground = Load("res/BackgroundImgs/Menu.png");
		
	}

	
	
	
	
	public static int[] getImgListFromFolder(String path, int startAt){
		
		File [] filelist = new File(path).listFiles();
		int [] imgList = new int[filelist.length + startAt];
		
		
			for (int x = startAt; x < imgList.length; x++) {
				imgList[x] = Image.Load(filelist[x - startAt].toString());
			}
		
		
		return imgList;
	}
	
	
	//creates a list of Images from a sprite sheet
	public static int[] getSubImgList(int size, String image, int rows, int columns, int ix, int iy, int iw, int ih){
		BufferedImage buffimage = null;
		
		try {
			buffimage = ImageIO.read(new File("res/Fonts/"+ image +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[] ImgList = new int[size];
		
		int I = 0;
		
		for(int y = 0; y < columns; y++)
			for(int x = 0; x < rows; x ++){
				int y2 = y * iy; // font1 X & Y = 32
				int x2 = x * ix;
				ImgList[I] = ConvertToTexture(buffimage.getSubimage(x2 ,y2 ,iw, ih));
				I++;
			}
		return ImgList;
	}
	

		
		
		
		public static ArrayList<Folder> initImgFolders(){
			ArrayList<Utility.Folder> List = new ArrayList<>(1);
			
			String[] folderName = folderUtility.getNameOfSubFolders("res/Blocks");
			
			
			for (int x = 0; x < folderName.length; x++){
				boolean eBlock = false;
				boolean sBlock = false;
				if (folderName[x].contains("Solid")) {sBlock = true;}
				if (folderName[x].contains("Event")) {eBlock = true;}
				
				String path = "res/Blocks/"+folderName[x];
				
				String[] imgNameList = folderUtility.getNameOfFilesInFolder(path);
				int imgList[] = getImgListFromFolder(path, 0);
				List.add(new Folder(folderName[x], imgList, imgNameList, sBlock, eBlock));
			}
			
			
			
			for (Utility.Folder f: List){
				System.out.println(f.info());
			}
			
			return List;
		}
		
		
		
		

	
	public static int ConvertToTexture(BufferedImage image){
	   
	   int[] pixels = new int[image.getWidth() * image.getHeight()];
	   image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

	   ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * BYTES_PER_PIXEL); //4 for RGBA, 3 for RGB
	   
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				int pixel = pixels[y * image.getWidth() + x];
				buffer.put((byte) ((pixel >> 16) & 0xFF)); // Red component
				buffer.put((byte) ((pixel >> 8) & 0xFF)); // Green component
				buffer.put((byte) (pixel & 0xFF)); // Blue component
				buffer.put((byte) ((pixel >> 24) & 0xFF)); // Alpha component.
															// Only for RGBA
			}
		}

		buffer.flip();

		int textureID = glGenTextures(); // Generate texture ID
		glBindTexture(GL_TEXTURE_2D, textureID); // Bind texture ID
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth(),
				image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

		buffer.clear();
		return textureID;
	}
	  /*  
	public static int Load(String image) throws IOException {
		BufferedImage IMAGE = ImageIO.read(new File(image));
		return (ConvertToTexture(IMAGE));
	}
	  */
	
	public static int Load(String image) {
		BufferedImage IMAGE = null;
		try {
			IMAGE = ImageIO.read(new File(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ConvertToTexture(IMAGE));
	}
	
	public static void print(int fillWindowImage, boolean followScreen) {
		print(fillWindowImage, 0, 0, Main.ScreenWidth, Main.ScreenHeight, followScreen);
	}
	    
	public static void print(int image, int X, int Y, int W, int H, boolean FollowScreen) {
		print(image, X, Y, W, H, 255, 255, 255, FollowScreen);
	}
	public static void print(int image, int X, int Y, int W, int H, int r, int g, int b , boolean FollowScreen) {
	
	
	if(!FollowScreen){
		X = (int) (X - Camera.X);
	    Y = (int) (Y - 	Camera.Y);
		}
		glPushMatrix();
		glTranslatef(X , Y, 0);
		org.newdawn.slick.Color.white.bind();
		glBindTexture(GL_TEXTURE_2D, image);

		GL11.glColor3f(r / (float)255, g / (float)255, b / (float)255); //setting the amount of rgb in the image.
		
		glBegin(GL_QUADS);
		{
			glTexCoord2f(0, 0); // Upper-Left
			glVertex2i(0, 0);
			glTexCoord2f(1, 0); // Upper-Right
			glVertex2f(W, 0);
			glTexCoord2f(1, 1); // Bottom-Right
			glVertex2f(W, H);
			glTexCoord2f(0, 1); // Bottom-Left
			glVertex2f(0, H);
		}
		glEnd();
		glPopMatrix();

	}

	
	
	
	public static void Blank(){
		print(list[2], 0, 0, 0, 0,false);
	}
	
	
}
