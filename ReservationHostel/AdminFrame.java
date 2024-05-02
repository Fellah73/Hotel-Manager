import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.CollationElementIterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Scanner;



public class AdminFrame extends JFrame implements ActionListener{


    static  String roomNumber="5";
    static int ReservationEnAttente=0;


     JFrame window=new JFrame("Admin Frame");
     //exit panel
     JPanel exitPanel=new JPanel();
     JButton exitButton=new JButton("EXIT");
       

     //rooms panel

      JPanel roomsPanel=new JPanel();
      JLabel roomsTiltle=new JLabel("roooooms-managment"); 

      //I-adding a room
      JLabel addRoom=new JLabel("adding a new room");
      JButton addRoomButton=new JButton("create");
     
      //II-updating a room

      JLabel updateRoom=new JLabel("updating a room");
      JButton updateRoomButton=new JButton("update");


      //III-deleting a room
    JLabel deleteRoom=new JLabel("deleting a room");
    JButton deleteRoomButton=new JButton("delete");


    //IV-wallpaper label
    JLabel wallpaperLabel=new JLabel();



    //reservation panel
     JPanel reservationPanel=new JPanel();


     //I-reservation en attente 
     JLabel reservationEnAttente=new JLabel("reservation en attente");
     JButton reservationEnAttenteButton=new JButton("show");

     //III-decision

     JLabel decision=new JLabel("decisions");
     JButton RoomInfos=new JButton("Room Infos");
     JButton decisionButton=new JButton("accept");
     JButton decisionButton2=new JButton("reject");


     //IV-number of rooms
     JLabel numberOfRooms=new JLabel();
     JLabel Reservation_label=new JLabel("reservation en attente :"+ReservationEnAttente);



     int mois,jour;


    public AdminFrame(String adminName){
        ReservationController.getReservation();
        RoomController.getRooms();
        window.setSize(800,600);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle(adminName);
     //   window.getContentPane().setBackground(new Color(0, 102, 34));
        window.setLayout(new BorderLayout());

        
        
        exitPanel.setBackground(new Color(128, 0, 255));
        exitPanel.setPreferredSize(new Dimension(800,80));
        window.add(exitPanel,BorderLayout.SOUTH);

        exitButton.addActionListener(this);
        exitButton.setPreferredSize(new Dimension(100,60));
        exitButton.setBackground(new Color(51, 0, 102));
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial",Font.BOLD,23));
        exitButton.setVerticalAlignment(JButton.CENTER);
        exitPanel.add(exitButton);


        //rooms panel

        roomsPanel.setBackground(Color.lightGray);
        roomsPanel.setPreferredSize(new Dimension(400,450));
        window.add(roomsPanel,BorderLayout.EAST);

        roomsTiltle.setFont(new Font("Arial",Font.ITALIC,30));
        roomsTiltle.setForeground(Color.BLACK);
        roomsPanel.add(roomsTiltle);

        //add a room
        addRoom.setFont(new Font("Arial",Font.BOLD,23));
        addRoom.setPreferredSize(new Dimension(250,60));
        addRoom.setForeground(Color.BLACK);
        roomsPanel.add(addRoom);

        addRoomButton.setFont(new Font("Arial",Font.BOLD,23));
        addRoomButton.setPreferredSize(new Dimension(120,60));
        addRoomButton.setForeground(Color.BLACK);
        addRoomButton.setBackground(Color.WHITE);
        addRoomButton.addActionListener(this);
        roomsPanel.add(addRoomButton);

        //update a room
        updateRoom.setFont(new Font("Arial",Font.BOLD,23));
        updateRoom.setPreferredSize(new Dimension(250,60));
        updateRoom.setForeground(Color.BLACK);
        roomsPanel.add(updateRoom);

        updateRoomButton.setFont(new Font("Arial",Font.BOLD,23));
        updateRoomButton.setPreferredSize(new Dimension(120,60));
        updateRoomButton.setForeground(Color.WHITE);
        updateRoomButton.setBackground(Color.BLACK);
        updateRoomButton.addActionListener(this);
        roomsPanel.add(updateRoomButton);

        //delete a room
        deleteRoom.setFont(new Font("Arial",Font.BOLD,23));
        deleteRoom.setPreferredSize(new Dimension(250,60));
        deleteRoom.setForeground(Color.BLACK);
        roomsPanel.add(deleteRoom);

        deleteRoomButton.setFont(new Font("Arial",Font.BOLD,23));
        deleteRoomButton.setPreferredSize(new Dimension(120,60));
        deleteRoomButton.setForeground(new Color(47, 47, 30));
        deleteRoomButton.setBackground(new Color(82, 122, 122));
        deleteRoomButton.addActionListener(this);
        roomsPanel.add(deleteRoomButton);
     
   
     

        wallpaperLabel.setBounds(80,240,250,250);
        wallpaperLabel.setIcon(new ImageIcon("admin2.jpg"));
        roomsPanel.add(wallpaperLabel);

      //reservation panel

      reservationPanel.setBackground(new Color(201, 169, 91));
      reservationPanel.setBounds(0,0,400,500);
       window.add(reservationPanel);
       reservationPanel.setLayout(new FlowLayout());


      //I-Title
      JLabel title=new JLabel("Reservation Managment");
      title.setFont(new Font("Arial",Font.ITALIC,30));
      title.setForeground(new Color(87, 75, 18));
      title.setBounds(30,0,360,60);
      reservationPanel.add(title);

      //II-En attente

      reservationEnAttente.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.PLAIN|Font.BOLD,23));
      reservationEnAttente.setBounds(10,60,250,60);
      reservationEnAttente.setForeground(Color.BLACK);
      reservationPanel.add(reservationEnAttente);

      reservationEnAttenteButton.setFont(new Font(Font.SANS_SERIF,Font.PLAIN | Font.ITALIC,23));
      reservationEnAttenteButton.setBounds(260,70,120,60);
      reservationEnAttenteButton.setForeground(Color.BLACK);
      reservationEnAttenteButton.setBackground(new Color(133, 116, 93));
      reservationEnAttenteButton.addActionListener(this);
      reservationPanel.add(reservationEnAttenteButton);



      

      //III-decision 
        decision.setFont(new Font(Font.SERIF,Font.BOLD|Font.ITALIC,30));
        decision.setBounds(30,150,150,60);
        decision.setForeground(Color.BLACK);
        reservationPanel.add(decision);

        RoomInfos.setFont(new Font("Arial",Font.ITALIC|Font.PLAIN,23));
        RoomInfos.setBounds(200,150,180,60);
        RoomInfos.setForeground(Color.BLACK);
        RoomInfos.setBackground(new Color(104, 96, 138));
        RoomInfos.addActionListener(this);
        //reservationPanel.add(RoomInfos);


        decisionButton.setFont(new Font("Arial",Font.BOLD,18));
        decisionButton.setBounds(30,220,250,60);
        decisionButton.setForeground(Color.BLACK);
        decisionButton.setBackground(new Color(92, 55, 6));
        decisionButton.addActionListener(this);
        decisionButton.setText("check if the reservation are ended");
         reservationPanel.add(decisionButton);

        //IV-number of rooms and resertvation en attente

        numberOfRooms.setFont(new Font("Arial",Font.ITALIC|Font.PLAIN,23));
        numberOfRooms.setBounds(30,300,250,60);
        numberOfRooms.setForeground(Color.BLACK);
        numberOfRooms.setText("number of rooms is :"+RoomController.dispoNumbers.size());
        reservationPanel.add(numberOfRooms);

        Reservation_label.setFont(new Font("Arial",Font.ITALIC|Font.PLAIN,23));
        Reservation_label.setBounds(30,350,250,60);
        Reservation_label.setForeground(Color.BLACK);
        Reservation_label.setText("reservation en attente :"+ReservationController.reservations.size());
        reservationPanel.add(Reservation_label);

      

        

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==addRoomButton)
        {
           AddingRoomBox add_box= new AddingRoomBox();
          //recuperer les infos de la chambre ajoutée
          //check if the user cilk on OK or CANCEL
           
           
            RoomController.addRoom(add_box);
           
          
           
          
        }

        if(e.getSource()==updateRoomButton)
        {
          System.out.println("the encoding of the rooms");
           System.out.println("single,mer,1111");
           System.out.println("single,montagne,1122");
           System.out.println("double,mer,2211");
           System.out.println("double,montagne,2222");
           System.out.println("triple,mer,3311");
           System.out.println("triple,montagne,3322");
           System.out.println("twin,mer,4411");
           System.out.println("twin,montagne,4422");
           System.out.println("suite,mer,5511");
           System.out.println("suite,montagne,5522");
           
           UpdateRoomBox upadte_box= new UpdateRoomBox();


          

           RoomController.Update(upadte_box);
        }
        if(e.getSource()==deleteRoomButton)
        {
           

           System.out.println("the encoding of the rooms");
           System.out.println("single,mer,1111");
           System.out.println("single,montagne,1122");
           System.out.println("double,mer,2211");
           System.out.println("double,montagne,2222");
           System.out.println("triple,mer,3311");
           System.out.println("triple,montagne,3322");
           System.out.println("twin,mer,4411");
           System.out.println("twin,montagne,4422");
           System.out.println("suite,mer,5511");
           System.out.println("suite,montagne,5522");

            
            
         DeleteRoomBox delete_box= new DeleteRoomBox();
               RoomController.Delete(delete_box);
            
        }
        if(e.getSource()==RoomInfos)
        {
           Decision decision_box= new Decision();

        }
        if(e.getSource()==exitButton)
        {

            RoomController.UpadateDataBase();
            System.out.println("i've updated the data base of the rooms");
            ReservationController.exportReservations();
            System.out.println("i've exported the data base of the reservations");
            window.dispose();
        }
        if(e.getSource()==reservationEnAttenteButton)
        {
           ReservationController.ReservationEnAttente();
           EnAttenteChcker waitingBox=new EnAttenteChcker();
           ReservationController.TraitmenAttentes(waitingBox);
        }
        if(e.getSource()==decisionButton)
        {
         int [] date=get_Date();
        this.jour=date[0];
        this.mois=date[1];
         Date.Dealloction(jour, mois);
        }
   }

   public int[] get_Date()
   {
       this.jour=0;
       this.mois=0;
         Scanner scanner = new Scanner(System.in);
         
         System.out.println("entrer ce jour");
 
         jour=scanner.nextInt();
         scanner.nextLine();
 
         System.out.println("entrer ce mois");
         mois=scanner.nextInt();
         scanner.nextLine();
         
         return new int[]{jour,mois};
   }
}


class EnAttenteChcker{

   TextField customerName=new TextField();
   Object[] options = {
       "customer-Name", customerName
   };
   public EnAttenteChcker()
   {
      JOptionPane.showInputDialog(null, options, "select a name", JOptionPane.QUESTION_MESSAGE);
   }
}