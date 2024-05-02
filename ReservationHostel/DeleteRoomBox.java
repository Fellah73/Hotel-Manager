
import java.awt.TextField;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class DeleteRoomBox {
    
    JOptionPane box=new JOptionPane();
    TextField room_id=new TextField();
    String[] bedTypeArray={"simple","double","king-size","Queen-size"};
    JComboBox <String>bedType=new JComboBox<>(bedTypeArray);
    int result;
    Object[] options = { 
        "room id", room_id,
        "bed type", bedType,
    };
    public DeleteRoomBox() {
        
        JOptionPane.showInputDialog(null, options, "delete a room", JOptionPane.QUESTION_MESSAGE);
    }
}
