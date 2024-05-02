//import java.awt.TextField;

import java.io.File;
import java.io.FileWriter;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AddingRoomBox {

    JOptionPane box=new JOptionPane();

    

    String[] roomTypeArray={"single","double","twin","triple","suite"};
        JComboBox <String>roomType=new JComboBox<>(roomTypeArray);

        String[] vueArray={"mer","montagne"};
        JComboBox <String>vue=new JComboBox<>(vueArray);


        String[] bedTypeArray={"simple","double","king-size","Queen-size"};
        JComboBox <String>bedType=new JComboBox<>(bedTypeArray);


 
      String resultat;

    Object[] options = { 
        "room type", roomType,
        "external view", vue,
        "bed type", bedType,
        
    };

    public AddingRoomBox() {

      resultat=(String)  JOptionPane.showInputDialog(null, options, "add a room", JOptionPane.QUESTION_MESSAGE);
    }

    public void getInfos(){

        try(FileWriter fw = new FileWriter("room.txt")) {
            fw.write(roomType.getSelectedItem().toString()+","+vue.getSelectedItem().toString()+","+bedType.getSelectedItem().toString()+"\n");
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
