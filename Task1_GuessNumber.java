package codsoft;

import java.util.Random;
import java.util.Scanner;

public class Task1_GuessNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random rand = new Random();
        while(true) {
            int num = rand.nextInt(100);

            System.out.println("Random Number Is Generated And You Have Only 3 Chance For Guess");
            int counter = 0;
            while (true) {
                counter++;
                System.out.println("\nChance : " + counter);
                System.out.print("Guess the Random Number : ");
                int user = sc.nextInt();

                if (user == num) {
                    System.out.println("\n----Both match----");
                    System.out.println("Random : " + num);
                    System.out.println("User Guess : " + user);
                    break;
                } else {
                    System.out.println("\n----Not Match----");
//                System.out.println("Random number : " + num);
                    if (user > num) {
                        System.out.println("Your Guess is Hiegher than " + (user - num));
                    } else {
                        System.out.println("Your Guess is Lower than " + (num - user));
                    }
                }

                if (counter == 3) {
                    System.out.println("\nYou have used all 3 chances. The number was " + num);
                    break;
                }
            }

            System.out.print("\nDo You Want To Play Again yes/no : ");
            String play_again = sc.next();

            if(play_again.equals("no")){
                break;
            }
        }
    }
}
