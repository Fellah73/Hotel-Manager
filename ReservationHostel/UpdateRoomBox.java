

import java.awt.TextField;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class UpdateRoomBox {

    JOptionPane box=new JOptionPane();

    TextField room_id=new TextField();

    
        


        String[] bedTypeArray={"simple","double","king-size","Queen-size"};
        JComboBox <String>bedType=new JComboBox<>(bedTypeArray);


    int result;


    Object[] options = { 
        "room code", room_id,
        "bed type", bedType,
        
    };

    public UpdateRoomBox() {

        JOptionPane.showInputDialog(null, options, "update a room", JOptionPane.QUESTION_MESSAGE);
    }
    
}

