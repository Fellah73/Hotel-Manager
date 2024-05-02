import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter.Entry;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;



// Model classes
class Room {
    public int roomNumber;
    public String roomType;
    public String vue;
    public String bedType;
    public boolean isReserved;
    public int roomId;
   
    public Room(String roomType, String vue, String bedType, boolean isReserved) {
        this.roomNumber = 100;
        this.roomType = roomType;
        this.isReserved = isReserved;
        this.vue = vue;
        this.bedType = bedType;
        
    }
   
    

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getVue() {
        return vue;
    }

    public String getBedType() {
        return bedType;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
   
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setVue(String vue) {
        this.vue = vue;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }
   
    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }   

     public static void generateRoomId(Room room)//hadi non
     {
        int Id = 0;
        switch (room.getRoomType()) {
            case "single":
            Id = 11*100;    
                break;
            case "double":
            Id = 22*100;
                break;
            case "twin":
            Id = 33*100;
                break;
            case "triple":
            Id = 44*100;
                break;
            case "suite":   
            Id = 55*100;
                break;
        }
        switch (room.getVue()) {
            case "mer":
            Id += 11;
                break;
            case "montagne":
            Id += 22;
                break;
        }
        Id = Id*100;
        switch (room.getBedType()) {
            case "simple":
            Id += 11;
                break;
            case "double":
            Id += 22;
                break;
            case "king-size":
            Id += 33;
                break;
            case "Queen-size":
            Id += 44;
                break;        
        }
        Id = Id*100;  
      
      room.setRoomNumber(Room.generateRoomNumber(room, RoomController.dispoNumbers));
        if(room.roomNumber!=-1)
        {
            Id += room.getRoomNumber();
            room.isReserved=false;
             room.roomId=Id;
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Room Not Available");
            Id=-1;
        }
        room.roomId=Id;
        
     }


    
    public static int generateRoomNumber(Room room,HashMap<Integer,Boolean> dispoNumbers)
    {          int begin=00,end=00;

        if(room.roomType.equals("single"))
        {
            if(room.vue.equals("montagne"))
            {
               begin=1;
               end=10;
            }
            else
            {
               begin=11;
               end=20;
            }

        }

        if(room.roomType.equals("double"))
        {
            if(room.vue.equals("montagne"))
            {
               begin=21;
               end=30;
            }
            else
            {
               begin=31;
               end=40;
            }

        }
        if(room.roomType.equals("twin"))
        {
            if(room.vue.equals("montagne"))
            {
               begin=41;
               end=50;
            }
            else
            {
               begin=51;
               end=60;
            }

        }
        if(room.roomType.equals("triple"))
        {
            if(room.vue.equals("montagne"))
            {
               begin=61;
               end=70;
            }
            else
            {
               begin=71;
               end=80;
            }

        }
        if(room.roomType.equals("suite"))
        {
            if(room.vue.equals("montagne"))
            {
               begin=81;
               end=90;
            }
            else
            {
               begin=91;
               end=99;
            }

        }

       int i;
        //iterate over dispoNumbers using begin and end
        for( i=begin;i<=end;i++)
        {
            //create an entry to iterate over the map
            
             
            if(!dispoNumbers.containsKey(i))
            {
                dispoNumbers.put(i,true);
                return i;
            }
           
            
        }
        
       
        System.out.println("chambre au max");
        return -1;

    }

}

class Reservation {
    public int reservationId;
    public String customerName;
    public String roomType;
    public String vue;
    public String bedType;
    public int startDate;
    public int startMonth;
    public int periode;
    public String paymentMethod;
    public boolean isConfirmed;
    public int[] finReservation=new int[2];
    
    public Reservation()
     {
        this.reservationId = 0;
        this.customerName = "";
        this.roomType = "";
        this.vue = "";
        this.bedType = "";
        this.startDate = 0;
        this.startMonth = 0;
        this.periode = 0;
        this.paymentMethod = "";
        this.isConfirmed = false;
        this.finReservation[0] =0 ;
        this.finReservation[1] =0 ;

    }

    
   public static Reservation getReservation(CustomerFrame frame)
    {
             Reservation reservation = new Reservation();
             reservation.roomType=frame.roomType.getSelectedItem().toString();
             reservation.vue=frame.vue.getSelectedItem().toString();
             reservation.bedType=frame.bedType. getSelectedItem().toString();
             reservation.periode=Integer.valueOf(frame.periodeOfReservation.getSelectedItem().toString());
             reservation.paymentMethod=frame.paymentMethod.getSelectedItem().toString();
             reservation.startDate=Integer.valueOf(frame.dateOfReservation.getSelectedItem().toString());
             reservation.startMonth=Integer.valueOf(frame.monthOfReservation.getSelectedItem().toString());
             reservation.reservationId=reservation.generateReservationId();
             reservation.finReservation=Date.dateFinReservation(reservation.startDate, reservation.startMonth, reservation.periode);
             return reservation;
    }
     public void PrintReservation(Reservation reservation)
    {
    System.out.println("customerName "+reservation.customerName);
    System.out.println("roomType "+reservation.roomType+"-roomView-"+reservation.vue+"-bedType-"+reservation.bedType);
    System.out.println("start date-"+reservation.startDate+"-start Month-"+reservation.startMonth+"periode-"+reservation.periode);
    System.out.println("paymentMethod-"+reservation.paymentMethod);
    System.out.println("fin de votre reservation "+reservation.finReservation[0]+"-"+reservation.finReservation[1]);
    }

    public static void updateResrvation(String customerName,UpdateRoom updateRoom)
    {
        Reservation reservation = ReservationController.reservations.get(customerName);
        String bedType=updateRoom.bedType.getSelectedItem().toString();
        int startDate=Integer.valueOf(updateRoom.startDate.getSelectedItem().toString());
        int startMonth=Integer.valueOf(updateRoom.startMonth.getSelectedItem().toString());
        int periode=Integer.valueOf(updateRoom.periode.getSelectedItem().toString());

        reservation.startDate=startDate;
        reservation.startMonth=startMonth;
        reservation.periode=periode;
        reservation.bedType=bedType;
        reservation.reservationId=reservation.generateReservationId();
        reservation.finReservation=Date.dateFinReservation(startDate,startMonth,periode);
        

        ReservationController.reservations.remove(customerName);
        ReservationController.reservations.put(customerName,reservation);

    }

    public int generateReservationId()
    {
        int Id = 0;
        switch (this.roomType) {
            case "single":
            Id = 11;    
                break;
            case "double":
            Id = 22;
                break;
            case "twin":
            Id = 33;
                break;
            case "triple":
            Id = 44;
                break;
            case "suite":   
            Id = 55;
                break;
        }
          Id*=100;
        switch (this.vue) {
            case "mer":
            Id += 11;
                break;
            case "montagne":
            Id += 22;
                break;
        }
        Id = Id*100;
        switch (this.bedType) {
            case "simple":
            Id += 11;
                break;
            case "double":
            Id += 22;
                break;
            case "king-size":
            Id += 33;
                break;
            case "Queen-size":
            Id += 44;
                break;        
        }
       return Id; 
    }
}


// Controller classes


//hna we use files to get all the rooms from thier data base(RoomDataBase.txt)
class RoomController {
    public static Map<Integer, Room> rooms = new HashMap<>();
    public static HashMap<Integer,Boolean> dispoNumbers=new HashMap<>();
 

    //بسم الله
    public static void getRooms()//tmchi -prbleme complier
     {

          System.out.println("i started");
       
        try{
            BufferedReader br=new BufferedReader(new FileReader("RoomDataBase.txt"));
            String line;
            

              while ((line=br.readLine())!=null) {
                String[] RoomData=line.split(",");
                boolean isReserved;

                if(RoomData[3].equals("true"))
                {
                    isReserved=true;
                }
                else 
                {
                    isReserved=false;
                }                 //roomtype     //view      //bed-type  //is_reserved
                Room room=new Room(RoomData[0], RoomData[1], RoomData[2], isReserved);
                 
            
                             //room-id
                   rooms.put(Integer.valueOf(RoomData[4]), room);
                   String roomId=RoomData[4].substring(6);
                   dispoNumbers.put(Integer.valueOf(roomId), isReserved);
              }
              br.close();
              System.out.println("the map have got all the reservation");
              //Syso the RoomDataBase
              for(Map.Entry<Integer,Room> entry: rooms.entrySet())
              {          //print the room bedType and roomType
                             System.out.println("room number "+entry.getKey()+" "+entry.getValue().getRoomType()+", "+entry.getValue().getVue()+", "+entry.getValue().getBedType());
                             System.out.println("-------------------------------------------------------------");
                 
             }
             //Syso the DispoNumbers of the rooms
             System.out.println("dispo rooms:");

             RoomController.PrintDispoNumbers();
            
           }

       catch(IOException e){
           System.out.println("error");
       }
      
    }



    public static void UpadateDataBase()
    {
        try
        {
            BufferedWriter bw=new BufferedWriter(new FileWriter("RoomDataBase.txt"));
            for(Map.Entry<Integer,Room> entry: rooms.entrySet())
            {
                bw.write(entry.getValue().getRoomType()+","+entry.getValue().getVue()+","+entry.getValue().getBedType()+","+entry.getValue().isReserved()+","+entry.getKey());
                bw.newLine();
            }
            bw.close();
            System.out.println("-------------------------------------");
            System.out.println("finish the update of the RoomDataBase");
            System.out.println("-------------------------------------");
        }
        catch(IOException e)
        {
            System.out.println("error");
        }
    }

    
    // Method to add a room
    public static void addRoom(AddingRoomBox add_box) {
      
      
            String roomType = add_box.roomType.getSelectedItem().toString();
            String vue = add_box.vue.getSelectedItem().toString();
            String bedType = add_box.bedType.getSelectedItem().toString();
            System.out.println(roomType+","+vue+","+bedType);
            Room new_room=new Room(roomType, vue, bedType, false);
            Room.generateRoomId(new_room);
      
           System.out.println("new_room.roomId="+new_room.roomId);
  
           if (new_room.roomId!=-1) {
            rooms.put(new_room.roomId, new_room);
            System.out.println("Room added successfully.");
            System.out.println(roomType+","+vue+","+bedType+","+new_room.isReserved+","+new_room.roomId);
           }
            
        

    }

      public static int[] getExtremistes(int roomCode)
       {
         System.out.println("roomCode="+roomCode);
         int roomCode2=roomCode;
        int [] e=new int[2];
           if(roomCode2==1122)
           {
               e[0]=00;
               e[1]=10;
               return e;
           }
           if (roomCode2==1111)
           {
               e[0]=11;
               e[1]=20;
               return e;
            
           }if (roomCode2==2222)
           {
               e[0]=21;
               e[1]=30;
               return e;
            
           }
           if (roomCode2==2211)
           {
               e[0]=31;
               e[1]=40;
               return e;
            
           }
           if(roomCode2==3322)
           {
               e[0]=41;
               e[1]=50;
               return e;
            
           }
           if(roomCode2==3311)
           {
               e[0]=51;
               e[1]=60;
               return e;
            
           }
           if(roomCode2==4422)
           {
               e[0]=61;
               e[1]=70;
               return e;
            
           }
           if (roomCode2==4411)
           {
               e[0]=71;
               e[1]=80;
               return e;
            
           }
           if (roomCode2==5522)
           {
               e[0]=81;
               e[1]=90;
               return e;
           }
           if (roomCode2==5511)
           {
               e[0]=91;
               e[1]=100;
               return e;
           }
      return e;
       }


    // Method to remove a room
    public static void removeRoom(int roomCode,int bedType) {
        int[] e = RoomController.getExtremistes(roomCode);
        System.out.println("from"+e[0]+" => to"+e[1]);
        int begin=e[0], end=e[1];

        int i;
            for( i=begin ; i<=end ;i++)
            {
                //entry for the DispoNumbers
                if(dispoNumbers.containsKey(i)&& dispoNumbers.get(i)==false)
                {
                    int roomNumber=roomCode*10000+bedType*100+i;
                     
                 System.out.println("roomNumber="+roomNumber);
                     
                    if(rooms.containsKey(roomNumber))
                    {
                        rooms.remove(roomNumber);
                        dispoNumbers.remove(i);
                        System.out.println("<Map>Room removed successfully.");
                        break;
                    }
                }
            }

            if(i>end)
            {
                System.out.println("<Map>Room not found.");
            }
    }

    public static void Delete(DeleteRoomBox delete_box)
    {
        int roomCode=Integer.valueOf(delete_box.room_id.getText().toString());

        System.out.println("roomCode="+roomCode);
         int bedTYPE=delete_box.bedType.getSelectedIndex();

         bedTYPE=bedTYPE*10+bedTYPE+11;

         System.out.println("bedTYPE="+bedTYPE);

         removeRoom(roomCode, bedTYPE);

        
    }

    // Method to update a room
    public static void updateSystem(int roomCode,int bedType) {
        bedType=bedType*11+11;
        int roomId=roomCode*100+bedType;
        int [] e = RoomController.getExtremistes(roomCode);
        int [] bedtypeArray={11,22,33,44};
        String[] bedTypeArray={"simple","double","king-size","Queen-size"};

        System.out.println("from"+e[0]+" => to"+e[1]);

        for(int i=e[0] ; i<e[1] ;i++)
        {
            //entry for the DispoNumbers
            if(dispoNumbers.containsKey(i))
            {
                System.out.println("room_Number"+i);
                for(int j:bedtypeArray)
                {
                    int roomNumber=roomCode*10000+j*100+i;
                     
                   
                     
                    if(rooms.containsKey(roomNumber))
                    {
                        System.out.println("roomNumber="+roomNumber);
                        
                        Room room=rooms.get(roomNumber);

                        System.out.println(room.roomNumber+" "+room.roomId+" "+room.bedType+" "+room.isReserved()+" "+room.getRoomType()+" "+room.getVue());

                        rooms.remove(roomNumber);

                        room.bedType=bedTypeArray[(bedType-11)/10];

                        room.roomId=roomCode*10000+bedType*100+i;

                        System.out.println("new room"+room.roomId+" "+room.bedType);


                        rooms.put(room.roomId, room);

                        System.out.println("room updated successfully"+room.bedType);

                        break;
                    }
                }
                

                
            }
        }
        
       
        
    }

public static void Update(UpdateRoomBox update_box)
{
    int roomCode=Integer.valueOf(update_box.room_id.getText().toString());
    int bedTYPE=update_box.bedType.getSelectedIndex();
    RoomController.updateSystem(roomCode, bedTYPE);
    
}


public static void PrintDispoNumbers()
{
    for (Map.Entry<Integer, Boolean> entry : dispoNumbers.entrySet())
    {
        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }
}
}



class ReservationController {
   
   public static HashMap<String, Reservation> reservations = new HashMap<>();

    public static void addReservation(Reservation reservation) {
        if(reservations.containsKey(reservation.customerName))
        {
            System.out.println("Reservation already exists,you'd to delete your previous reservation");
           
        }
        else
        {
            reservations.put(reservation.customerName, reservation);
        System.out.println("Reservation added successfully."+reservation.customerName);
        }
        
    }

    public static void getReservation()
     {
        try {
            BufferedReader br = new BufferedReader(new FileReader("ReservationDataBase.txt"));
            String Line;
            while ((Line=br.readLine())!=null)
             {  String[] reservationData=Line.split(",");
                Reservation reservation = new Reservation();
                reservation.customerName=reservationData[0];
                reservation.reservationId=Integer.valueOf(reservationData[1]);
                reservation.roomType=reservationData[2];
                reservation.vue=reservationData[3];
                reservation.bedType=reservationData[4];
                reservation.startDate=Integer.valueOf(reservationData[5]);
                reservation.startMonth=Integer.valueOf(reservationData[6]);
                reservation.periode=Integer.valueOf(reservationData[7]);
                reservation.paymentMethod=reservationData[8];
                reservation.isConfirmed=Boolean.valueOf(reservationData[9]);
                reservation.finReservation[0]=Integer.valueOf(reservationData[10]);
                reservation.finReservation[1]=Integer.valueOf(reservationData[11]);
                reservations.put(reservation.customerName, reservation);

                
             }

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void exportReservations() {
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter("ReservationDataBase.txt"));
            for (Map.Entry<String, Reservation> entry : reservations.entrySet()) {
                br.write(entry.getKey()+","+entry.getValue().reservationId+","+entry.getValue().roomType+","+entry.getValue().vue
                +","+entry.getValue().bedType+","+entry.getValue().startDate+","
                +entry.getValue().startMonth+","+entry.getValue().periode+","
                +entry.getValue().paymentMethod+","+entry.getValue().isConfirmed+","
                +entry.getValue().finReservation[0]+","+entry.getValue().finReservation[1]+"\n");
            }

            System.out.println("Reservation exported successfully");
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }
 
    public static void ReservationEnAttente() {

        for (Map.Entry<String, Reservation> entry : reservations.entrySet()) {
            if (entry.getValue().isConfirmed == false) {
                System.out.println(entry.getValue().customerName +" his roomId is: "+entry.getValue().reservationId);
            }
        }
    }

    //hadi ghdwa

    public static void TraitmenAttentes(EnAttenteChcker enAttenteFrame) {
        String customerName = enAttenteFrame.customerName.getText().toString();
        Reservation reserve = reservations.get(customerName);
        System.out.println("roomType "+reserve.roomType+"-roomView-"+reserve.vue+"-bedType-"+reserve.bedType);
        int [] e = RoomController.getExtremistes(reserve.reservationId/100);
        System.out.println("from"+e[0]+" => to"+e[1]);

        int NumberOfSprecificRoom = 0,NeededRoom=0;
        int i=0;
        for(i=e[0] ; i<=e[1] ;i++)
        {
            //entry for the DispoNumbers
            if(RoomController.dispoNumbers.containsKey(i))
            {
                System.out.println("I've found  a room, his Number"+i);
                int roomNumber= reserve.reservationId*100+i;
                System.out.println(roomNumber);
                if(RoomController.rooms.containsKey(roomNumber)&& RoomController.rooms.get(roomNumber).isReserved==false)
                {
                    NumberOfSprecificRoom=-10;
                    //en cas on a trouvé un chambre
                    //update of the room

                    //in rooms hashmap
                     Room room = RoomController.rooms.get(roomNumber);
                     RoomController.rooms.remove(roomNumber);
                     room.isReserved=true;
                     room.roomNumber=roomNumber;
                     RoomController.rooms.put(roomNumber, room);

                     //in dispoNumbers hashmap

                     RoomController.dispoNumbers.remove(i);
                     RoomController.dispoNumbers.put(i, true);

                     RoomController.PrintDispoNumbers();
                     //in reservations hashmap
                      reserve.isConfirmed=true;
                      reserve.reservationId=roomNumber;
                      reservations.remove(customerName);
                      reservations.put(customerName, reserve);

                     System.out.println("<Map>Room updated successfully");
                   break;
                }
                else
                {
                    NumberOfSprecificRoom++;
                }
            }
            else
            {
                NeededRoom++;
            }
        }
        if(i>e[1])
        {
            if(NumberOfSprecificRoom==10)
            {
                System.out.println("the rooms are full, you can't reserve now this room");
            }
            else if(NeededRoom!=0)
            {
              Reservation reservation=reservations.get(customerName);
              System.out.println("you had to add a new room of type "+reservation.roomType+" "+" and a view of "+reservation.vue+" and bed type of "+reservation.bedType);
            }
        }
        

    } 

    public static void cancelReservation(String customerName) {
        Reservation reservation = reservations.get(customerName);
        int reservationId=reservation.reservationId;
        System.out.println("your room Id "+reservationId);
             //avant traitment
        if(reservationId<100000)
        {
            reservations.remove(customerName);
            System.out.println("Update Successfully avant le traitment");
        }
         //apres traitement 
        else if(reservationId>100000)
        {  //effacer la reservation
            reservations.remove(customerName);
            //recuperer depuis dans room HashMap
            Room room = RoomController.rooms.get(reservationId);
            System.out.println(room.roomNumber+" "+room.roomId+" "+room.bedType+" "+room.isReserved()+" "+room.getRoomType()+" "+room.getVue());
            room.isReserved=false;
            
            //recupere le roomNumber pour liberer la chambre
            int roomNumber=reservationId%100;

            System.out.println(reservationId +" % 100 = "+roomNumber);

            //parcour de DispoNumbers et affichage des chambres (entry)
            //affichage des chambres (entry)
            RoomController.dispoNumbers.remove(roomNumber);
            RoomController.dispoNumbers.put(roomNumber, false);
            RoomController.PrintDispoNumbers();

           for(Map.Entry<Integer, Room> entry : RoomController.rooms.entrySet())
            {
                System.out.println(entry.getKey()+" "+entry.getValue().isReserved());
            }
           
            

            //update dans room HashMap
            RoomController.rooms.remove(reservationId);
            RoomController.rooms.put(reservationId, room);
             System.out.println("Update Successfully apres le traitment");
             RoomController.UpadateDataBase();
        }
        else
        {
            System.out.println("Error");
        }
        
       


    }
    
}


// User class as a base for Client and Administrator
abstract class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Authentication method
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

// Client class
class Client extends User {
    RoomController roomController = new RoomController();
    ReservationController reservationController = new ReservationController();
    String County;
    // Constructor
    public Client(String username, String County,String password) {
        super(username, password);
        this.County=County;
    }

    // Method to generate a reservation ID
    private int generateReservationId(int roomNumber, String roomType, String vue, String bedType) {
        int Id = 0;
        switch (roomType) {
            case "single":
            Id = 11*100;    
                break;
            case "double":
            Id = 22*100;
                break;
            case "twin":
            Id = 33*100;
                break;
            case "triple":
            Id = 44*100;
                break;
            case "suite":   
            Id = 55*100;
                break;
        }
        switch (vue) {
            case "mer":
            Id += 11;
                break;
            case "montagne":
            Id += 22;
                break;
        }
        Id = Id*100;
        switch (bedType) {
            case "single":
            Id += 11;
                break;
            case "double":
            Id += 22;
                break;
            case "king-size":
            Id += 33;
                break;
            case "Queen-size":
            Id += 44;
                break;        
        }
        Id = Id*1000;
        Id += roomNumber;
        return Id;
    }

    // Client-specific methods
    

    
    
}

// Administrator class
class Administrator extends User {
    RoomController roomController = new RoomController();
    ReservationController reservationController = new ReservationController();
    public String nickname,gamil;
    // Constructor
    public Administrator(String username,String nickname,String gamil, String password) {
        super(username, password);
        this.gamil=gamil;
        this.nickname=nickname;
    }

    // Admin-specific methods

    /*
    public void createRoom(int roomNumber, String roomType, String vue, String bedType) {
        if (!roomController.getRooms().containsKey(roomNumber)) {
            Room newRoom = new Room( roomType, vue, bedType, false);
            roomController.getRooms().put(roomNumber, newRoom);
            System.out.println("Room " + roomNumber + " created successfully.");
        } else {
            System.out.println("Room " + roomNumber + " already exists.");
        }
    }

    public void modifyRoom(int roomNumber, String newRoomType, String newVue, String newBedType) {
        Room room = roomController.getRooms().get(roomNumber);
        if (room != null && !room.isReserved()) {
            room.setRoomType(newRoomType);
            room.setVue(newVue);
            room.setBedType(newBedType);
            System.out.println("Room " + roomNumber + " modified successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is reserved or does not exist.");
        }
    }

    public void deleteRoom(int roomNumber) {
        Room room = roomController.getRooms().get(roomNumber);
        if (room != null && !room.isReserved()) {
            roomController.getRooms().remove(roomNumber);
            System.out.println("Room " + roomNumber + " deleted successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is reserved or does not exist.");
        }
    }
 */
    // Methods to manage reservations

    /* 
    public void viewReservations() {
        for (Reservation reservation : reservationController.getAllReservations()) {
            System.out.println(reservation);
        }
    }

    public void acceptReservation(int reservationId) {
        Reservation reservation = reservationController.getReservation(reservationId);
        if (reservation != null && !reservation.isConfirmed()) {
            reservation.setConfirmed(true);
            System.out.println("Reservation " + reservationId + " has been accepted.");
        } else {
            System.out.println("Reservation is either already confirmed or does not exist.");
        }
    }

    public void declineReservation(int reservationId) {
        Reservation reservation = reservationController.getReservation(reservationId);
        if (reservation != null) {
            reservationController.removeReservation(reservationId);
            System.out.println("Reservation " + reservationId + " has been declined and removed.");
        } else {
            System.out.println("Reservation does not exist.");
        }
    }
    */
}

// Main class
public class BackEnd {
    private static Scanner scanner = new Scanner(System.in);
    private static RoomController roomController = new RoomController();
    private static ReservationController reservationController = new ReservationController();
    private static Map<String, User> users = new HashMap<>();

    
    

    // Method to handle user login
   public   String CheckAdminExsistence(loginBox LogInFrame)
   {
    boolean existe=false;
    try{
          BufferedReader   admin_buffer=new BufferedReader(new FileReader("AdminDataBase.txt"));

        String name=LogInFrame.user_name.getText().toString();
        String pass_word=LogInFrame.pass_word.getText().toString();

        String  Line=null;
        


        while((Line=admin_buffer.readLine())!=null)
        {
            
                    String[] AdminData=Line.split(",");
            if( AdminData[0].equals(name) )
            {
                if(AdminData[3].equals(pass_word))
                
                {
                    existe=true;
                }
                else
                {
                    return "wrong_pass";
                }
            }
        }

    
    
    }
    catch(Exception e)
    {
        System.out.println("error");;
    }
    if(existe)
    {
        return "admin";
    }

    return "none";
   
   }


   public  void AddNewAdmin(AdminSignInBox SignFrame){

     String name=SignFrame.name.getText().toString();
     String nickName=SignFrame.name.getText().toString();
     String gmail=SignFrame.gmail.getText().toString();
     String pass_word=SignFrame.password.getText().toString();
    
    Administrator admin=new Administrator(name, nickName, gmail, pass_word);

    AddNewAdminToData(admin);

    System.out.println("Admin ajoute avec succes."+name+" "+nickName+" "+gmail+" "+pass_word);

    
   }

   public static void AddNewAdminToData(Administrator admin)
   {

    try{

          BufferedWriter  admin_adder=new BufferedWriter(new FileWriter(new File("AdminDataBase.txt"),true));

            //add the admin to the file sans ecrasement

          
            admin_adder.write(admin.username+","+admin.nickname+","+admin.gamil+","+admin.password+"\n");
            admin_adder.close();
            System.out.println("Nouvel administrateur ajouté avec succès au fichier.");
            



    }
    catch(Exception e)
    {
       System.out.println("error");;

   }
}
 
public void AddNewCustomer(CustomerSignInBox SignFrame)
{
     Client client=new Client(SignFrame.name.getText(),SignFrame.country.getText(), SignFrame.password.getText());
     
       AddNewCustomerToDataBase(client);

}

public void AddNewCustomerToDataBase(Client customer)
{
  try
  {
    BufferedWriter customer_adder=new BufferedWriter(new FileWriter(new File("CustomerDataBase.txt"),true));

    customer_adder.write(customer.username+","+customer.County+","+customer.password+"\n");
    customer_adder.close();
    System.out.println("Customer added succesfully");
  }
  catch(IOException e)
  {
    System.out.println("error");
  }
}


public String  CustomerCheckExistence(CustomerLogInBox LogInFrame)
{
  try{
     BufferedReader cutomer_reader=new BufferedReader(new FileReader("CustomerDataBase.txt"));

     String line;
      
     String name=LogInFrame.name.getText();
     String pass_word=LogInFrame.password.getText();
     

     while ((line=cutomer_reader.readLine())!=null) 
     {
        String[] CustomerData=line.split(",");
        
        if(CustomerData[0].equals(name)  && CustomerData[2].equals(pass_word))
        {
            return "admin";
        }
        if(CustomerData[0].equals(name)  && !CustomerData[2].equals(pass_word))
        {
            return "wrong_pass";
        }
     }
  
    }catch(IOException e)
    {
        System.out.println("error");
    }    



return "none";
}


}

class UpdateRoom         
{

     
      String[] bedTypeArray={"simple","double","king-size","Queen-size"};
      JComboBox <String>bedType=new JComboBox<>(bedTypeArray);
     String[] startDateArray={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
      JComboBox <String>startDate=new JComboBox<>(startDateArray);
      String[] startMonthArray={"1","2","3","4","5","6","7","8","9","10","11","12"};
      JComboBox <String>startMonth=new JComboBox<>(startMonthArray);
      String[] periodeArray={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
      JComboBox <String>periode=new JComboBox<>(periodeArray);


      Object[] options = {
          "bed type", bedType,
          "start date", startDate,
          "start month", startMonth,
          "periode", periode
      };
    
 
     public UpdateRoom()
     {
         JOptionPane.showInputDialog(null, options, "update your room", JOptionPane.QUESTION_MESSAGE);
     }    
}

class Date {
    
    private static final int[] JOURS_PAR_MOIS = {
        31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static int[] dateFinReservation(int jour, int mois, int dureeReservation) {
        int moisActuel = mois - 1; // Indexer les mois de 0 à 11
        int jourActuel = jour;

        // Ajouter la durée à la date actuelle
        jourActuel += dureeReservation;

        // Ajuster les jours et les mois
        while (jourActuel > JOURS_PAR_MOIS[moisActuel]) {
            jourActuel -= JOURS_PAR_MOIS[moisActuel]; // Décompter les jours du mois actuel
            moisActuel += 1; // Passer au mois suivant
        }

        // Ajuster si on dépasse décembre (mais cela ne devrait pas arriver en 2024)
        if (moisActuel >= 12) {
            moisActuel = 11; // Empêcher le débordement
            jourActuel = 31; // Maximum des jours
        }
        if(moisActuel>=12 && jourActuel>=31){
            System.out.println("la date max est 31/12/2024 car l'hotel est fermé en 2025");
        }

        return new int[]{jourActuel, moisActuel + 1}; 
    }

    public static void Dealloction(int jour, int mois)
    {  
        //parcour de ReservationController.reservations
        for(Map.Entry<String,Reservation> entry: ReservationController.reservations.entrySet())
        {
           Reservation reservation=ReservationController.reservations.get(entry.getKey());
           if(reservation.finReservation[0]<=jour && reservation.finReservation[1]<=mois)
           {
               ReservationController.cancelReservation(entry.getKey());
           }
        }
        
         
             //felile ga3,
    }
}