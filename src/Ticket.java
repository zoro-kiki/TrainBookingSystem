public class Ticket {
    private int ticketId;
    private User user;
    private Train train;
    private int seatBooked;
    private static int counter= 1001;

    public Ticket(int seatBooked, User user, Train train) {
        this.seatBooked = seatBooked;
        this.ticketId = counter++;
        this.user = user;
        this.train = train;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getSeatBooked() {
        return seatBooked;
    }

    public void setSeatBooked(int seatBooked) {
        this.seatBooked = seatBooked;
    }

    @Override
    public String toString() {
        return "Ticket ID: " +ticketId +
                " | Train :" + train.getName()+" |Route :" +train.getSource() + " -> " + train.getDestination()+
                " | Seats : " + seatBooked + "| Booked by : " + user.getFullName();
    }
}
