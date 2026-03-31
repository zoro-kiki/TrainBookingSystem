import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookingService {

    private List<Train> trainList = new ArrayList<>();
    private List<Ticket> ticketList = new ArrayList<>();
    public BookingService(){
        trainList.add(new Train(101,"Rajdhani Express","Delhi","Nagpur",100));
        trainList.add(new Train(102,"Shatabdi Express","Delhi","Mumbai",100));
        trainList.add(new Train(103,"Doronto Express","Agra","Delhi",100));
        trainList.add(new Train(104,"Vande bharat Express","Delhi","Goa",100));trainList.add(new Train(101,"Rajdhani Express","Delhi","Nagpur",100));
        trainList.add(new Train(105,"Intercity Express","Kolkata","Manali",100));
        trainList.add(new Train(106,"Teja Express","Delhi","Bengaluru",100));

    }
    public List<Train> searchTrain(String source,String destination){
        List<Train> res = new ArrayList<>();
        for(Train train:trainList){
            if(train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)){
                res.add(train);
            }
        }
        return res;
    }
    private Ticket bookTicket(User user,int trainId,int seatCount){
        for(Train train:trainList){
            if(train.getTrainId()==trainId){
                if(train.bookSeats(seatCount)){
                    Ticket ticket = new Ticket(user,train,seatCount);
                    ticketList.add(ticket);
                    return ticket;
                }else{
                    System.out.println("No enough seats available");
                    return null;
                }
            }
        }
        System.out.println("Train Id not found");
        return null;
    }
    public List<Ticket> getTicketByUser(User user){
        List<Ticket> res = new ArrayList<>();
        for(Ticket ticket:ticketList){
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                res.add(ticket);
            }
        }
        return res;
    }
    public boolean cancelTicket(int ticketId,User user){
        Iterator<Ticket> iterator = ticketList.listIterator();
        while(iterator.hasNext()){
            Ticket ticket = iterator.next();
            if(ticket.getTicketId()==ticketId &&
               ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername())){
                Train train = ticket.getTrain();
                train.cancelSeats(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket " + ticketId + "Canceled succesfully");
                return true;
            }
        }
        System.out.println("Ticket not found or does not belongs to current user");
        return false;
    }
    public void listAllTrain(){
        System.out.println("List of all trains: ");
        for(Train train:trainList){
            System.out.println(train);
        }
    }
}
