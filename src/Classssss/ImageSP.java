/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classssss;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Nhi
 */
public class ImageSP {
    public static Image resize(Image originalImage, int targetWidth, int targetHeight){
        Image resualtingImage =originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resualtingImage;
    }
    public static byte[] toByteArray(Image img, String type) throws IOException{
        BufferedImage bimage = new BufferedImage(img.getWidth(null),img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D q = bimage.createGraphics();
        q.drawImage(img, 0,0,null);
        q.dispose();
        
        ByteArrayOutputStream baos =new ByteArrayOutputStream();
        ImageIO.write(bimage, type, baos);
        byte[] imageInByte =baos.toByteArray();
        
        return imageInByte;
    }
    public static Image createImageFromByteArray(byte[] data ,String type) throws IOException{
        ByteArrayInputStream  bis =new ByteArrayInputStream(data);
        BufferedImage bImage2 =ImageIO.read(bis);
        
        Image img = bImage2.getScaledInstance(bImage2.getWidth(),bImage2.getHeight() , Image.SCALE_SMOOTH);
        return img;
    }
}
