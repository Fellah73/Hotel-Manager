import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminSignInBox{
    
      JOptionPane option=new JOptionPane();
      JTextField name = new JTextField();
      JTextField nickname = new JTextField();
      JTextField gmail= new JTextField();
      JTextField password = new JTextField();

      Object[] message = {
          "name:", name,
          "nickname:", nickname,
          "gmail:", gmail,
          "password:", password
      };

      static int i;

    public AdminSignInBox(){

       i= option.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
        

    }
}
