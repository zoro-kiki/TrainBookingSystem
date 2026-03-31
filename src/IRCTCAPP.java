import java.util.Scanner;

public class IRCTCAPP {

    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService = new UserService();
    private final BookingService bookingService = new BookingService();
    public static void main(String[] args) {
     new IRCTCAPP().start();
    }

    public void start(){
        while(true){
            System.out.println("\n---Welcome to IRCTC APP---");
            if(!userService.isLoggedIn()){
                System.out.println("1. Register");
                System.out.println("2. LOgin");
                System.out.println("3. Exit");
                System.out.println("Enter Choice: ");
                int choice = scanner.nextInt();

                switch(choice){
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Invalid Choice...");
                }
            }
        }
    }
    public void register(){
        System.out.println("Enter username : ");
        String username = scanner.next();
        System.out.println("Enter Passowrd : ");
        String password = scanner.next();
        System.out.println("Enter Full name: ");
        scanner.nextLine();
        String fullName = scanner.nextLine();
        System.out.println("Enter contact : ");
        int contact = scanner.nextInt();
        userService.registerUser(username,password,fullName,contact);
    }

}
