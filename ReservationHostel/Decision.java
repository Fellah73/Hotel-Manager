
import java.awt.TextField;

import javax.swing.JOptionPane;

public class Decision {
    


    TextField room_id=new TextField();

    int result=JOptionPane.OK_OPTION;
    Object[] options = { 
        "room id", room_id
    };
    public Decision() {
        
        JOptionPane.showInputDialog(null, options, "delete a room", JOptionPane.QUESTION_MESSAGE);
    }

}
