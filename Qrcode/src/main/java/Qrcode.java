import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.File;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Qrcode {

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
                     
                    
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
                  

       Path path = FileSystems.getDefault().getPath(filePath);
        
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) {
        try {
            generateQRCodeImage("Hi   ", 350, 350,"./cft.png");// Path Where you want to save the bar code 
        } catch (WriterException e) {                                                                       //1- "./anurag.png "   Denote Current path into project 
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());         //2- "/home/cft/Desktop/cft.png"  Denote Specific your  Dairectory path
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }     
        
        
    }
}
/**
 * 1. First of all your need to Add the Dependencies in Maven Pom.xml file 
 * 2. you need to create a Maven project and Chose Maven core project
 * 3.Create a New Java Class and paste the Above given code in your java class
 * 4.then compile and Run
 * 5.And finally you Get a Qr image code in your file path location
 * 
 * Example :<dependencies>
    <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>core</artifactId>
        <version>3.3.0</version>
    </dependency>
    <dependency>
        <groupId>com.google.zxing</groupId>
        <artifactId>javase</artifactId>
        <version>3.3.0</version>
    </dependency>
</dependencies>	
 */
////////////////////////////////*****************************************************Qr2Example****************************************************///

// public class QrCode {
//
//      private final String DIR = "/directory/to/save/images";
//      private final String ext = ".png";
//      private final String LOGO = "logo_url";
//      private final String CONTENT = "some content here";
//      private final int WIDTH = 300;
//      private final int HEIGHT = 300;
//
//      public void generate() {
//          // Create new configuration that specifies the error correction
//          Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
//          hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
//
//          QRCodeWriter writer = new QRCodeWriter();
//          BitMatrix bitMatrix = null;
//          ByteArrayOutputStream os = new ByteArrayOutputStream();
//
//          try {
//              // init directory
//              cleanDirectory(DIR);
//              initDirectory(DIR);
//              // Create a qr code with the url as content and a size of WxH px
//              bitMatrix = writer.encode(CONTENT, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
//
//              // Load QR image
//              BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, getMatrixConfig());
//
//              // Load logo image
//              BufferedImage overly = getOverly(LOGO);
//
//              // Calculate the delta height and width between QR code and logo
//              int deltaHeight = qrImage.getHeight() - overly.getHeight();
//              int deltaWidth = qrImage.getWidth() - overly.getWidth();
//
//              // Initialize combined image
//              BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
//              Graphics2D g = (Graphics2D) combined.getGraphics();
//
//              // Write QR code to new image at position 0/0
//              g.drawImage(qrImage, 0, 0, null);
//              g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
//
//              // Write logo into combine image at position (deltaWidth / 2) and
//              // (deltaHeight / 2). Background: Left/Right and Top/Bottom must be
//              // the same space for the logo to be centered
//              g.drawImage(overly, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);
//
//              // Write combined image as PNG to OutputStream
//              ImageIO.write(combined, "png", os);
//              // Store Image
//              Files.copy( new ByteArrayInputStream(os.toByteArray()), Paths.get(DIR + generateRandoTitle(new Random(), 9) +ext), StandardCopyOption.REPLACE_EXISTING);
//
//          } catch (WriterException e) {
//              e.printStackTrace();
//              //LOG.error("WriterException occured", e);
//          } catch (IOException e) {
//              e.printStackTrace();
//              //LOG.error("IOException occured", e);
//          }
//      }
//
//      private BufferedImage getOverly(String LOGO) throws IOException {
//          URL url = new URL(LOGO);
//          return ImageIO.read(url);
//      }
//
//      private void initDirectory(String DIR) throws IOException {
//          Files.createDirectories(Paths.get(DIR));
//      }
//
//      private void cleanDirectory(String DIR) {
//          try {
//              Files.walk(Paths.get(DIR), FileVisitOption.FOLLOW_LINKS)
//                      .sorted(Comparator.reverseOrder())
//                      .map(Path::toFile)
//                      .forEach(File::delete);
//          } catch (IOException e) {
//              // Directory does not exist, Do nothing
//          }
//      }
//
//      private MatrixToImageConfig getMatrixConfig() {
//          // ARGB Colors
//          // Check Colors ENUM
//          return new MatrixToImageConfig(QrCode.Colors.WHITE.getArgb(), QrCode.Colors.ORANGE.getArgb());
//      }
//
//      private String generateRandoTitle(Random random, int length) {
//          return random.ints(48, 122)
//                  .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
//                  .mapToObj(i -> (char) i)
//                  .limit(length)
//                  .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
//                  .toString();
//      }
//
//      public enum Colors {
//
//          BLUE(0xFF40BAD0),
//          RED(0xFFE91C43),
//          PURPLE(0xFF8A4F9E),
//          ORANGE(0xFFF4B13D),
//          WHITE(0xFFFFFFFF),
//          BLACK(0xFF000000);
//
//          private final int argb;
//
//          Colors(final int argb){
//              this.argb = argb;
//          }
//
//          public int getArgb(){
//              return argb;
//          }
//      }
//  }