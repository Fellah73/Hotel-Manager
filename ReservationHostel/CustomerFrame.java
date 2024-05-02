import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.annotation.processing.SupportedSourceVersion;
import javax.print.DocFlavor.STRING;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CustomerFrame extends JFrame implements ActionListener{
    JFrame window=new JFrame();
    JButton button=new JButton("EXIT");
    JPanel south_Panel=new JPanel();

      //Content page

      //options

      //Options Panel

       JPanel options_Panel = new JPanel();
           
        //room type
        JLabel roomTypeFeild=new JLabel();

        String[] roomTypeArray={"single","double","twin","triple","suite"};
        JComboBox <String>roomType=new JComboBox<>(roomTypeArray);

        //vue
       JLabel vueFeild=new JLabel("vue");
        String[] vueArray={"mer","montagne"};
        JComboBox <String>vue=new JComboBox<>(vueArray);

           //bed type
        JLabel bedTypeFeild=new JLabel("bed-type");
        String[] bedTypeArray={"simple","double","king-size","Queen-size"};
        JComboBox <String>bedType=new JComboBox<>(bedTypeArray);


       //Equipment Label
       JLabel equipmentFeild=new JLabel("Equipment:");

             //WIFI AND television and refrigerator
    JRadioButton wifi=new JRadioButton("WIFI");
    JRadioButton television=new JRadioButton("TV");

          //reservation time infos
          //month
          JLabel monthOfReservationFeild=new JLabel();
          //jour
        JLabel dateOfReservationFeild=new JLabel();
        //periode
        JLabel periodeOfReservationFeild=new JLabel();

        String []dates={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17",
        "18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        JComboBox <String>dateOfReservation=new JComboBox<>(dates);  

        String []months={"01","02","03","04","05","06","07","08","09","10","11","12"};
        JComboBox <String>monthOfReservation=new JComboBox<>(months);

          //periode max =25
        String []periodeofReservation={"1","2","3","4","5","6","7","8","9","10","11","12","13",
        "14","15","16","17","18","19","20","21","22","23","24","25"};
        JComboBox <String>periodeOfReservation=new JComboBox<>(periodeofReservation);
       

        //payment methodes
        JLabel paymentMethodFeild=new JLabel();
        String[] paymentMethodArray={"mastercard","visa","paypal"};
        JComboBox <String>paymentMethod=new JComboBox<>(paymentMethodArray);


        //showing photos of rooms buttons

        JButton image_dispalyer=new JButton();

        //reservatoin button
        JButton reservationButton=new JButton("Reservation");


        //west panel (update your reservation and display your reservation)
        
        JPanel west_Panel = new JPanel();
       
         //update panel 
        JPanel update_Panel = new JPanel();
        
        JLabel updateLabel = new JLabel();

      JButton updateButton = new JButton("update your reservation");
      JButton cancelButton = new JButton("cancel your reservation");

        //display panel
        JPanel display_Panel = new JPanel();
        JLabel image_label = new JLabel();


      JLabel ReservationInfos=new JLabel();
    public CustomerFrame(String a){

      
      ReservationController.getReservation();
      RoomController.getRooms();
        window.setSize(800, 600);
        window.setTitle(a);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.getContentPane().setBackground(new Color(20, 94, 102));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);



        //southPanel
        south_Panel.setPreferredSize(new Dimension(window.getWidth(), 90));
        south_Panel.setBackground(new Color(50,74,178));

        //Exit button
        button.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
        button.setForeground(Color.white);
        button.setBackground(new Color(35,41,108));
        button.setPreferredSize(new Dimension(100, 60));
        button.addActionListener(this);

        window.add(south_Panel, BorderLayout.SOUTH);
        south_Panel.add(button);


         //options part

        options_Panel.setPreferredSize(new Dimension(400, 400));
         options_Panel.setBackground(new Color(62,142,222));
         window.add(options_Panel, BorderLayout.EAST);

         //room type
          options_Panel.setLayout(new FlowLayout());

         roomTypeFeild.setPreferredSize(new Dimension(200, 40));
         roomTypeFeild.setText("Room Type");
         roomTypeFeild.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
         roomTypeFeild.setForeground(Color.BLACK);
         roomTypeFeild.setBackground(Color.GRAY);
         options_Panel.add(roomTypeFeild);
    



         roomType.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
          roomType.setForeground(Color.BLACK);
          roomType.setBackground(Color.GRAY);    
          roomType.setPreferredSize(new Dimension(120, 40));
          roomType.addActionListener(this);
         options_Panel.add(roomType);


         //vue type
         vueFeild.setPreferredSize(new Dimension(90, 40));
         vueFeild.setText("Vue");
         vueFeild.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
         vueFeild.setForeground(Color.BLACK);
         vueFeild.setBackground(Color.GRAY);
         options_Panel.add(vueFeild);

         vue.addActionListener(this);
         vue.setBackground(Color.GRAY);
         vue.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
         vue.setForeground(Color.BLACK);
         vue.setPreferredSize(new Dimension(150, 40));
         options_Panel.add(vue);

         //bed type
         bedTypeFeild.setPreferredSize(new Dimension(150, 40));
         bedTypeFeild.setText("Bed Type");
         bedTypeFeild.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
         bedTypeFeild.setForeground(Color.BLACK);
         options_Panel.add(bedTypeFeild);

         bedType.addActionListener(this);
         bedType.setBackground(Color.GRAY);
         bedType.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
         bedType.setForeground(Color.BLACK);
         bedType.setPreferredSize(new Dimension(120, 40));
         options_Panel.add(bedType);

         //equipment
         equipmentFeild.setPreferredSize(new Dimension(150, 60));
         equipmentFeild.setText("Equipment :");
         equipmentFeild.setFont(new Font(Font.SERIF,Font.ITALIC,25));
         equipmentFeild.setForeground(Color.BLACK);
         options_Panel.add(equipmentFeild);

          //wifi
          options_Panel.add(wifi);
          wifi.setBackground(Color.GRAY);
          wifi.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,16));
          wifi.setForeground(Color.BLACK);
          wifi.setPreferredSize(new Dimension(60, 40));
          wifi.setBounds(equipmentFeild.getX()+10, equipmentFeild.getY(), 60, 40);
          wifi.addActionListener(this);
          //tv
          options_Panel.add(television);
          television.setBackground(Color.GRAY);
          television.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,16));
          television.setForeground(Color.BLACK);
          television.setPreferredSize(new Dimension(60, 40));
          television.addActionListener(this);

           //time of reservation
           //day
         dateOfReservationFeild.setPreferredSize(new Dimension(150, 40));
         dateOfReservationFeild.setText("Day");
         dateOfReservationFeild.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
         dateOfReservationFeild.setForeground(Color.BLACK);
         options_Panel.add(dateOfReservationFeild);

         dateOfReservation.addActionListener(this);
         dateOfReservation.setBackground(new Color(117, 93, 45));
         dateOfReservation.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
         dateOfReservation.setForeground(Color.BLACK);
         dateOfReservation.setPreferredSize(new Dimension(120, 40));
         options_Panel.add(dateOfReservation);

           //month

        monthOfReservationFeild.setPreferredSize(new Dimension(150, 40));
        monthOfReservationFeild.setText("Month");
        monthOfReservationFeild.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
        monthOfReservationFeild.setForeground(Color.BLACK);
        options_Panel.add(monthOfReservationFeild);

        monthOfReservation.addActionListener(this);
        monthOfReservation.setBackground(new Color(117, 93, 45));
        monthOfReservation.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
        monthOfReservation.setForeground(Color.BLACK);
        monthOfReservation.setPreferredSize(new Dimension(120, 40));
        options_Panel.add(monthOfReservation);


         //periode of reservation (days)
      
        periodeOfReservationFeild.setPreferredSize(new Dimension(200, 40));
        periodeOfReservationFeild.setText("you 'll reserve for ");
        periodeOfReservationFeild.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
        periodeOfReservationFeild.setForeground(Color.BLACK);
        options_Panel.add(periodeOfReservationFeild);

        periodeOfReservation.addActionListener(this);
        periodeOfReservation.setBackground(Color.GRAY);
        periodeOfReservation.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
        periodeOfReservation.setForeground(Color.BLACK);
        periodeOfReservation.setPreferredSize(new Dimension(120, 40));
        options_Panel.add(periodeOfReservation);

       //payment methods

        paymentMethodFeild.setPreferredSize(new Dimension(250, 40));
        paymentMethodFeild.setText("Payment Methods");
        paymentMethodFeild.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
        paymentMethodFeild.setForeground(Color.BLACK);
        options_Panel.add(paymentMethodFeild);

        paymentMethod.addActionListener(this);
        paymentMethod.setBackground(new Color(218, 145, 0));
        paymentMethod.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,16));
        paymentMethod.setForeground(Color.BLACK);
        paymentMethod.setPreferredSize(new Dimension(120, 40));
        options_Panel.add(paymentMethod);


     //image displayer

       image_dispalyer.setPreferredSize(new Dimension(150, 60));
       image_dispalyer.setBackground(Color.black);
       image_dispalyer.setForeground(Color.white);
       image_dispalyer.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
       image_dispalyer.setText("display-it");
       image_dispalyer.addActionListener(this);
       options_Panel.add(image_dispalyer);

        reservationButton.setPreferredSize(new Dimension(150, 60));
        reservationButton.setText("Reserve");
        reservationButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
        reservationButton.setForeground(Color.BLACK);
        reservationButton.setBackground(new Color(99,65,15));
        reservationButton.addActionListener(this);
        options_Panel.add(reservationButton);
        
        //west panel

        west_Panel.setPreferredSize(new Dimension(400, 400));
        west_Panel.setBackground(new Color(8, 77, 60));
        window.add(west_Panel, BorderLayout.WEST);
         
        west_Panel.setLayout(new BorderLayout());

        //update panel

        update_Panel.setPreferredSize(new Dimension(400, 250));
        update_Panel.setBackground(new Color(117, 93, 45));
        west_Panel.add(update_Panel,BorderLayout.NORTH);
        
        updateLabel.setLayout(new BorderLayout());
        updateLabel.setPreferredSize(new Dimension(250, 35));
        updateLabel.setText("here is your old reservation "+window.getTitle().toUpperCase());
        updateLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN|Font.ITALIC,15));
        updateLabel.setForeground(new Color(10, 37, 43));
        update_Panel.add(updateLabel);

        updateButton.setPreferredSize(new Dimension(200, 60));
        updateButton.setText("Update");
        updateButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.BOLD,25));
        updateButton.setForeground(Color.BLACK);
        updateButton.setBackground(new Color(45, 99, 173));
        updateButton.addActionListener(this);
        update_Panel.add(updateButton);

        cancelButton.setPreferredSize(new Dimension(200, 60));
        cancelButton.setText("Cancel");
        cancelButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.BOLD,25));
        cancelButton.setForeground(Color.BLACK);
        cancelButton.setBackground(new Color(150, 122, 18));
        cancelButton.addActionListener(this);
        update_Panel.add(cancelButton);

        ReservationInfos.setPreferredSize(new Dimension(250, 35));
        if(ReservationController.reservations.containsKey(window.getTitle()))
        {
          Reservation reserve=ReservationController.reservations.get(window.getTitle());
          ReservationInfos.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.PLAIN,14));
          if(reserve.isConfirmed==true)
          {
            ReservationInfos.setText(reserve.customerName+" your rooom_number: "+reserve.reservationId%100);
          }
          else
          {
            ReservationInfos.setText("demande en cours de traitment "+reserve.reservationId);
          }
        }
        else
        {
          ReservationInfos.setText("here you can find your next reservation");
        }
        
        ReservationInfos.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.PLAIN,14));
        ReservationInfos.setForeground(Color.BLACK);
        update_Panel.add(ReservationInfos);
       //display panel
        display_Panel.setPreferredSize(new Dimension(400, 150));
        display_Panel.setBackground(Color.black);
        west_Panel.add(display_Panel,BorderLayout.CENTER);

        //add the image
        display_Panel.setLayout(new FlowLayout());
        //image_label.setIcon(image);
        image_label.setIcon(new ImageIcon("random.jpg"));
        display_Panel.add(image_label);
       


    }

    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
          ReservationController.exportReservations();
          window.dispose();
        }
       if(e.getSource()==reservationButton)
        {
        
                Reservation reservation = new Reservation();
                reservation=Reservation.getReservation(this);
                reservation.customerName=window.getTitle();
                reservation.PrintReservation(reservation);
                ReservationController.addReservation(reservation);
                this.ReservationInfos.setText(window.getTitle()+" Reservation infos : "+ReservationController.reservations.get(window.getTitle()).reservationId);

          
        }
        if(e.getSource()==image_dispalyer)
        {
          String roomTypeChoice = roomType.getSelectedItem().toString();
          switch(roomTypeChoice)
          {
            case "single":
            image_label.setIcon(new ImageIcon("single.jpg"));
          
            break;
            case "double":
            image_label.setIcon(new ImageIcon("double.png"));
            break;
            case "twin":
            image_label.setIcon(new ImageIcon("twin.png"));
            break;
            case "triple":
            image_label.setIcon(new ImageIcon("triple.png"));
            break;

            case "suite":
            image_label.setIcon(new ImageIcon("suite.png"));
            break;
        }
    }
    if(e.getSource()==updateButton)
    {
     UpdateRoom updateBox = new UpdateRoom();
      Reservation.updateResrvation(window.getTitle(),updateBox );
    }
    if(e.getSource()==cancelButton)
    {
      if(ReservationController.reservations.containsKey(window.getTitle()))

      {
        if(ReservationController.reservations.get(window.getTitle()).isConfirmed==false)
       {
        System.out.println("cancel reservation");
        ReservationController.cancelReservation(window.getTitle());
        ReservationInfos.setText("reservation cancelled");
      }
      else
      {
        ReservationInfos.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.PLAIN,9));
        ReservationInfos.setText("reservation already confirmed,it is canceled");
        System.out.println("you had to pay a fees");
        ReservationController.cancelReservation(window.getTitle());
      }
        
      }
      else
      {
        System.out.println("no reservation to cancel");
      }
   }
}
}

