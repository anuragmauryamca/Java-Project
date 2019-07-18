import com.itextpdf.text.BaseColor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.image.BufferedImage;
 
  class BarCode
{
       BufferedImage image=null;
      
        public static void main(String[] args)
        {
                try
                {
                        Document document = new Document();
                        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
                         
                        document.open();
                        PdfContentByte pdfContentByte = pdfWriter.getDirectContent();
                         
                        Barcode128 barcode128 = new Barcode128();
                        barcode128.setCode("Anurag Maurya MCU");
                        barcode128.setCodeType(Barcode128.CODE128);
                        
                        BaseColor baseColor=BaseColor.BLUE;
                        BaseColor baseTextcolor=BaseColor.GREEN;
                        Image code128Image = barcode128.createImageWithBarcode(pdfContentByte,baseColor,baseTextcolor);
                        
                       // barcode128.createAwtImage(Color.BLUE,Color.GREEN);
                        
                        code128Image.setAbsolutePosition(10, 700);
                        code128Image.scalePercent(100);
                        document.add(code128Image);
 
                        BarcodeEAN barcodeEAN = new BarcodeEAN();
                        barcodeEAN.setCodeType(BarcodeEAN.EAN13);
                        barcodeEAN.setCode("9454060447898878678");
                        Image codeEANImage = barcodeEAN.createImageWithBarcode(pdfContentByte, null, null);
                        codeEANImage.setAbsolutePosition(20, 600);
                        codeEANImage.scalePercent(100);
                        document.add(codeEANImage);
 
                        BarcodeQRCode barcodeQrcode = new BarcodeQRCode("Anurag Maurya From Mcu", 1, 1, null);
                        Image qrcodeImage = barcodeQrcode.getImage();
                        qrcodeImage.setAbsolutePosition(20, 500);
                        qrcodeImage.scalePercent(100);
                        document.add(qrcodeImage);
 
                        document.close();
                }
                catch (FileNotFoundException e)
                {
                        e.printStackTrace();
                }
                catch (DocumentException e)
                {
                        e.printStackTrace();
                }
        }
}