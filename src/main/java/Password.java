import org.mindrot.jbcrypt.BCrypt;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        System.out.println("Please create a password");
        Scanner scan = new Scanner(System.in);
        String userPass = scan.nextLine();
        String hash = BCrypt.hashpw(userPass, BCrypt.gensalt());

        System.out.println("Please enter your password.");
        String userAttempt = scan.nextLine();
        boolean match = BCrypt.checkpw(userAttempt,hash);

           if(match){
               System.out.println("You may enter");

           }else{
               System.out.println("Wrong");
           }


       }



    }

