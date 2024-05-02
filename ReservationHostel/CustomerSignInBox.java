import java.awt.TextField;

import javax.swing.JOptionPane;

public class CustomerSignInBox {
    
    JOptionPane option=new JOptionPane();

    TextField name = new TextField();
    TextField country = new TextField();
    TextField password = new TextField();


    Object[] message = {
        "name:", name,
        "country:", country,
        "password:", password,
    };

    int result;
    public CustomerSignInBox()
    {

        result=option.showConfirmDialog(null, message, "Sign-in", JOptionPane.OK_CANCEL_OPTION);
    }
}
