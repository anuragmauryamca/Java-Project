
package StartUp;

import com.sun.scenario.effect.impl.prism.PrCropPeer;
import gui.LoginUser;
import gui.NewUserRegistrations;
import gui.ProcessBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainClass {

   
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
       
        
        
//        <------------Login user Member------------------->
        LoginUser loginUser=new LoginUser(null, true);
//         loginUser.setLocationRelativeTo(null);
        
        loginUser.setVisible(true);
       
       
    }
    
}
