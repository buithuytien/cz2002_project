import display.*;
import java.util.*;

public class Moblima extends display {
    Scanner sc = new Scanner(System.in);
    protected void start() {
        System.out.println("==========MOBLIMA==========");
        System.out.println("1.Moviegoer");
        System.out.println("2.Staff");
        System.out.println("3. Exit");

        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                intent(this, new display_mg());

            case 2:
                intent(this, new display_staff());

            case 3:
                System.out.println("Bye bye.");
                destroy();
                break;
            default:
                System.out.println("Wrong input.");
        }
    }
    public static void main(String[] args){
        new Moblima().start();
    }
}