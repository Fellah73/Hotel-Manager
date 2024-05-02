import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FirstFrame extends JFrame implements ActionListener{

    ImageIcon logoIcon = new ImageIcon("logo_app.png");

    JFrame window=new JFrame();
    JPanel northPanel=new JPanel();
    JPanel centerPanel=new JPanel();

   JPanel center_east_panel = new JPanel();
   JPanel center_west_panel = new JPanel();
   JPanel center_north_panel = new JPanel();
   JLabel choose_Label = new JLabel("Are u an admin or a customer?");

    JPanel southPanel=new JPanel();
    JPanel eastPanel=new JPanel();
    
    JPanel westPanel=new JPanel();
    JLabel title = new JLabel("HOTEL MANAGER APP");
    JButton exit_Button=new JButton("EXIT");
    JOptionPane pane=new JOptionPane();

    ImageIcon exit_Icon = new ImageIcon("asd.png");


    JLabel reception_Label = new JLabel("to our hostel");
    ImageIcon reception_Icon = new ImageIcon("reception.png");


    JLabel customer_Label = new JLabel("welcome");
    ImageIcon customer_Icon = new ImageIcon("holidays.png");






    //center panel
    //admin part

    JLabel admin_Label = new JLabel("administrateur");
    JButton admin_log_in = new JButton("login your account");

  
    JLabel login_Label = new JLabel();
    TextField login_TextField = new TextField();
    JButton register_Button = new JButton("create one");


    //admin-login

    JOptionPane login_pane=new JOptionPane();


   //cutomer-part

   //cutomer-login

   JLabel customer_login_Label = new JLabel("Check your reservation");


   JButton customer_login_Button = new JButton();


   //cutomer-register
   TextField customer_login_TextField = new TextField("First reversation??");

   JButton customer_register_Button = new JButton("reserve your room");











   BackEnd a=new BackEnd();










  int jour,mois;






public FirstFrame(){

     
    //frame reglage
    //this.get_Date();
    window.setVisible(true);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(1200,700);
    window.setTitle("HOTEL RESERVATION APP");
    window.getContentPane().setBackground(Color.gray);
    window.setLayout(new BorderLayout());
    window.setIconImage(logoIcon.getImage());
    window.setResizable(false);
    
    //panel reglage
    westPanel.setPreferredSize(new Dimension(250,700));
    westPanel.setBackground(Color.darkGray);
    eastPanel.setPreferredSize(new Dimension(250,700));
    eastPanel.setBackground(new Color(105, 81, 79));
    northPanel.setPreferredSize(new Dimension(1100,70));
    northPanel.setBackground(Color.black);
    southPanel.setPreferredSize(new Dimension(1100,70));
    southPanel.setBackground(Color.black);
    centerPanel.setPreferredSize(new Dimension(700,600));
    centerPanel.setBackground(Color.orange);
    window.add(westPanel,BorderLayout.WEST);
    window.add(eastPanel,BorderLayout.EAST);
    window.add(northPanel,BorderLayout.NORTH);
    window.add(southPanel,BorderLayout.SOUTH);
    window.add(centerPanel,BorderLayout.CENTER);
    //title label reglage
    title.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
    title.setForeground(Color.white);
    title.setHorizontalAlignment(JLabel.CENTER);
    title.setVerticalAlignment(JLabel.CENTER);
    northPanel.add(title);
    //exit button reglage
    exit_Button.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,25));
    exit_Button.setForeground(Color.white);
    exit_Button.setBackground(new Color(77, 21, 21));
    exit_Button.setBounds(600,10,100,60);
    exit_Button.addActionListener(this);
    southPanel.add(exit_Button);
     
    //center panel reglage
  
    centerPanel.setLayout(new BorderLayout());

    centerPanel.add(center_east_panel,BorderLayout.EAST);
    center_east_panel.setPreferredSize(new Dimension(350,530));
    center_east_panel.setBackground(new Color(74, 72, 72));
    
    centerPanel.add(center_west_panel,BorderLayout.WEST);
    center_west_panel.setPreferredSize(new Dimension(350,530));
    center_west_panel.setBackground(new Color(105, 81, 79));

    centerPanel.add(center_north_panel,BorderLayout.NORTH);
    center_north_panel.setPreferredSize(new Dimension(350,70));
    center_north_panel.setBackground(new Color(177,145,34));
    

     //choose label reglage
    choose_Label.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.PLAIN,30));
    choose_Label.setForeground(Color.black);
    choose_Label.setBounds(160,35,300,60);
    center_north_panel.add(choose_Label);
    
    //image reglage
    reception_Label.setIcon(reception_Icon);
    reception_Label.setHorizontalTextPosition(JLabel.CENTER);
    reception_Label.setVerticalTextPosition(JLabel.TOP);
    reception_Label.setFont(new Font(Font.SANS_SERIF,Font.PLAIN|Font.ITALIC,35));
    reception_Label.setForeground(Color.BLACK);

    reception_Label.setBounds(150,100,300,60);
    eastPanel.add(reception_Label);

    customer_Label.setIcon(customer_Icon);
    customer_Label.setHorizontalTextPosition(JLabel.CENTER);
    customer_Label.setVerticalTextPosition(JLabel.TOP);
    customer_Label.setFont(new Font(Font.SANS_SERIF,Font.PLAIN|Font.ITALIC,35));
    customer_Label.setForeground(Color.BLACK);

    westPanel.add(customer_Label);

   //admin part
    center_west_panel.setLayout(null);
   admin_Label.setFont(new Font(Font.SANS_SERIF,Font.PLAIN|Font.ITALIC,30));
   admin_Label.setForeground(Color.black);
   admin_Label.setBounds(80,50,300,60);
   center_west_panel.add(admin_Label);   
  
      //1-sign in
   admin_log_in.setFont(new Font(Font.SANS_SERIF,Font.PLAIN|Font.ITALIC,20));
   admin_log_in.setForeground(Color.white);
   admin_log_in.setBackground(Color.black);
   admin_log_in.setBounds(50,150,220,60);
   admin_log_in.addActionListener(this);
   center_west_panel.add(admin_log_in);

    //2-login
    login_TextField.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.PLAIN,18));
    login_TextField.setBounds(2,250,200,60);
    login_TextField.setText("Don't have an acount?");
    login_TextField.setEditable(false);
    login_TextField.setForeground(Color.BLACK);
    login_TextField.setBackground(Color.gray);
    center_west_panel.add(login_TextField);


    register_Button.setFont(new Font(Font.SANS_SERIF,Font.PLAIN|Font.ITALIC,18));
    register_Button.setForeground(Color.white);
    register_Button.setBackground(Color.BLACK);
    register_Button.setBounds(2 + login_TextField.getWidth(),250,130,60);
    register_Button.setText("Create one");
    register_Button.addActionListener(this);
    center_west_panel.add(register_Button);

  

    //customer part
       center_east_panel.setLayout(null);
    //title

    customer_login_Label.setForeground(Color.black);
    customer_login_Label.setFont(new Font(Font.SANS_SERIF,Font.PLAIN|Font.ITALIC,30));
    customer_login_Label.setBounds(130,50,300,60);
    customer_login_Label.setText("Client");
    center_east_panel.add(customer_login_Label);
  
    //login part

    customer_login_Button.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.PLAIN,20));
    customer_login_Button.setForeground(Color.black);
    customer_login_Button.setBackground(Color.gray);
    customer_login_Button.setBounds(50,150,260,60);
    customer_login_Button.addActionListener(this);
    customer_login_Button.setText("Check your reservation");
    center_east_panel.add(customer_login_Button);

    //login textfield

    customer_login_TextField.setFont(new Font(Font.SANS_SERIF,Font.ITALIC|Font.PLAIN,18));
    customer_login_TextField.setBounds(2,250,150,60);
    customer_login_TextField.setText("First reversation??");
    customer_login_TextField.setEditable(false);
    customer_login_TextField.setForeground(Color.GRAY);
    customer_login_TextField.setBackground(Color.BLACK);
    center_east_panel.add(customer_login_TextField);


    customer_register_Button.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,18));
    customer_register_Button.setForeground(Color.white);
    customer_register_Button.setBackground(new Color(0,0,30));
    customer_register_Button.setBounds(2 + customer_login_TextField.getWidth(),250,200,60);
    customer_register_Button.addActionListener(this);
    customer_register_Button.setText("reserve your room!");
    center_east_panel.add(customer_register_Button);
     
}

  public void actionPerformed(ActionEvent e){
      if(e.getSource()==exit_Button){
      int i=pane.showOptionDialog(null,
      "Are you sure you want to exit?",
                              "Good bye",
                     JOptionPane.YES_NO_OPTION,
               JOptionPane.INFORMATION_MESSAGE,
                                     exit_Icon,
                     new Object[]{"yes","stay"},
                             null); 
       if(i==0)
        {
            window.dispose();
        }
      }
      else if(e.getSource()==admin_log_in)
      {
      loginBox login_box=new loginBox();
      if(login_box.i==JOptionPane.OK_OPTION)
          {
             
           if(a.CheckAdminExsistence(login_box).equals("admin"))
              {
                  new AdminFrame(login_box.user_name.getText());
                  

                  System.out.println("exist");
                  System.out.println("I've imported all the rooms");
              }

            else if (a.CheckAdminExsistence(login_box).equals("none")){

              JOptionPane.showMessageDialog(null,"Admin not found");
            }
            else if(a.CheckAdminExsistence(login_box).equals("wrong_pass"))
            {
              JOptionPane.showMessageDialog(null,"wrong password");
            }
            

          }
      }
      else if(e.getSource()==register_Button)
      {
       AdminSignInBox admin= new AdminSignInBox();
       if(admin.i==JOptionPane. OK_OPTION)  
       {

        if(admin.name.getText().equals("")||admin.gmail.getText().equals("")||admin.password.getText().equals(""))
        {
          JOptionPane.showMessageDialog(null,"please fill all the fields");
        }
        else
        {
         a.AddNewAdmin(admin);
         new AdminFrame(admin.name.getText());
       }

       }
      }

      else if(e.getSource()==customer_login_Button)
    {
      CustomerLogInBox box=new CustomerLogInBox();
          
     

       if(box.result==JOptionPane.OK_OPTION)
       {
           if(a.CustomerCheckExistence(box).equals("admin"))
           {
            new CustomerFrame(box.name.getText());
            
           }
           else if(a.CustomerCheckExistence(box).equals("wrong_pass"))
           {
            JOptionPane.showMessageDialog(null,"wrong password");

           }
           else if(a.CustomerCheckExistence(box).equals("none"))
           {
            JOptionPane.showMessageDialog(null,"admin not found");
           }

       }
       
    }
    else if(e.getSource()==customer_register_Button)
    {
      CustomerSignInBox box=new  CustomerSignInBox();

      
        if(box.result==JOptionPane.OK_OPTION)
        {
             if(box.name.getText().equals("")||box.country.getText().equals("")||box.password.getText().equals(""))
          { 
                JOptionPane.showMessageDialog(null,"please fill all the fields");
          }
           else
          {
            a.AddNewCustomer(box);
            System.out.println("thank u for using our app");
            new CustomerFrame(box.name.getText());
          }
  
            
        }
        
      
    }
      
  }


}