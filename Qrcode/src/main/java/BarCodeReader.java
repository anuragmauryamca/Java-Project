
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cft
 */
public class BarCodeReader {
    public static void main(String[] args) {
        
    
    


InputStream barCodeInputStream = null;
        try {
            barCodeInputStream = new FileInputStream("/home/cft/Desktop/Ram.png");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
       
BufferedImage barCodeBufferedImage = null;
        try {
            barCodeBufferedImage = ImageIO.read(barCodeInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
Reader reader = new MultiFormatReader();
Result result = null;
        try {
            result = reader.decode(bitmap);
        } catch (NotFoundException ex) {
            ex.printStackTrace();
        } catch (ChecksumException ex) {
            ex.printStackTrace();
        } catch (FormatException ex) {
            ex.printStackTrace();
        }
        
     
String value=result.toString();
char[] str=value.toCharArray();
for(char mychar :str)
{
    System.out.println("***"+mychar);
}




System.out.println("Barcode text is" + result.toString());
}
}