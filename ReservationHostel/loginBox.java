import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class loginBox 
{  
      JOptionPane option=new JOptionPane();
    JTextField user_name = new JTextField();
    JTextField pass_word = new JTextField();

    Object[] message = {
        "User_name:", user_name,
        "password:", pass_word,

};

  static int i;

    public loginBox()
    {

       
       i= JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);


    }
    
    
}
