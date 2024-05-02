import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CustomerLogInBox {
    

    JOptionPane option=new JOptionPane();
    JTextField name = new JTextField();
    JTextField password = new JTextField();

    Object[] message = {
        "name:", name,
        "password:", password
    };

    int result;
    public CustomerLogInBox(){
        result=option.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
    }
}
