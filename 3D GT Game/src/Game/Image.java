package Game;


import static org.lwjgl.opengl.GL11.*;
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
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glDisable;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;


public class Image {
	
	private static final int BYTES_PER_PIXEL = 4;
	
	
	
	
	
	
	public static void print3D(int image, float x, float y, float z, float size, int RotateX, int RotateY, int RotateZ) {
		
		

		
		glPushMatrix();
		glTranslatef(x, y, z);
		glScalef(size, size, size);
		glRotatef(RotateX, RotateX, 0, 0);
		glRotatef(RotateY, 0, RotateY, 0);
		glRotatef(RotateZ, 0, 0, RotateZ);
		
		org.newdawn.slick.Color.white.bind();
		glBindTexture(GL_TEXTURE_2D, Main.GrassBlock);
		
		glEnable(GL_TEXTURE_2D);
		glBegin(GL_QUADS);
		{
			//------Front------
			glTexCoord3f(-1, -1, 1);
			glVertex3f(-1, -1, 1);
			glTexCoord3f(1, -1, 1);
			glVertex3f(1, -1, 1);
			glTexCoord3f(1, 1, 1);
			glVertex3f(1, 1, 1);
			glTexCoord3f(-1, 1, 1);
			glVertex3f(-1, 1, 1);
			//-------Back--------
			glTexCoord3f(-1, -1, -1);
			glVertex3f(-1, -1, -1);
			glTexCoord3f(1, -1, -1);
			glVertex3f(1, -1, -1);
			glTexCoord3f(1, 1, -1);
			glVertex3f(1, 1, -1);
			glTexCoord3f(-1, 1, -1);
			glVertex3f(-1, 1, -1);
			//---------left-------
			glTexCoord3f(-1, -1, -1);
			glVertex3f(-1, -1, -1);
			glTexCoord3f(-1, -1, 1);
			glVertex3f(-1, -1, 1);
			glTexCoord3f(-1, 1, 1);
			glVertex3f(-1, 1, 1);
			glTexCoord3f(-1, 1, -1);
			glVertex3f(-1, 1, -1);
			//--------right side --------
			glTexCoord3f(1, -1, -1);
			glVertex3f(1, -1, -1);
			glTexCoord3f(1, -1, 1);
			glVertex3f(1, -1, 1);
			glTexCoord3f(1, 1, 1);
			glVertex3f(1, 1, 1);
			glTexCoord3f(1, 1, -1);
			glVertex3f(1, 1, -1);
			
			//-------top side----------
			glTexCoord3f(-1, -1, -1);
			glVertex3f(-1, -1, -1);
			glTexCoord3f(1, -1, -1);
			glVertex3f(1, -1, -1);
			glTexCoord3f(1, -1, 1);
			glVertex3f(1, -1, 1);
			glTexCoord3f(-1, -1, 1);
			glVertex3f(-1, -1, 1);
			
			//----------bottom side--------
			glTexCoord3f(-1, 1, -1);
			glVertex3f(-1, 1, -1);
			glTexCoord3f(1, 1, -1);
			glVertex3f(1, 1, -1);
			glTexCoord3f(1, 1, 1);
			glVertex3f(1, 1, 1);
			glTexCoord3f(-1, 1, 1);
			glVertex3f(-1, 1, 1);
			
			
			
			
			
			
			
			
		}
		glEnd();
		glDisable(GL_TEXTURE_2D);
		glPopMatrix();
		
		

	}
	public static void print2D(int image, int x, int y, int w, int h) {
			Initialize.Projection2D();
			
			
			glPushMatrix();
			glTranslatef(x , y, 0);
			org.newdawn.slick.Color.white.bind();
			glEnable(GL_TEXTURE_2D);
			glBindTexture(GL_TEXTURE_2D, image);
			
			
			
			glBegin(GL_QUADS);
			{
				glTexCoord2f(0, 0); // Upper-Left
				glVertex2i(0, 0);
				glTexCoord2f(1, 0); // Upper-Right
				glVertex2f(w, 0);
				glTexCoord2f(1, 1); // Bottom-Right
				glVertex2f(w, h);
				glTexCoord2f(0, 1); // Bottom-Left
				glVertex2f(0, h);
			}
			glEnd();
			glDisable(GL_TEXTURE_2D);
			glPopMatrix();
			
			
		}
	
	

	
	
	
	
	public static int ConvertToTexture(BufferedImage image){
		   
		int[] pixels = new int[image.getWidth() * image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0,image.getWidth());

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
	
	
	public static int Load(String image) {
		BufferedImage IMAGE = null;
		try {
			IMAGE = ImageIO.read(new File(image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (ConvertToTexture(IMAGE));
	}
	
	
}
