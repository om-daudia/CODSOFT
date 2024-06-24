package codsoft;

import java.util.Scanner;

public class Task2_student {

    //3 subjects
    int java, c, php, python;
    double tot, per;

    Scanner sc = new Scanner(System.in);

    Task2_student() {

        System.out.print("Enter Marks for java : ");
        java = sc.nextInt();
        System.out.print("Enter Marks for C : ");
        c = sc.nextInt();
        System.out.print("Enter Marks for php : ");
        php = sc.nextInt();
        System.out.print("Enter Marks for python : ");
        python = sc.nextInt();
    }

    private void set_result() {
        if(java > 1 && java <= 100 && c > 1 && c <= 100 && php > 1 && php <= 100 && python > 1 && python <= 100) {
            tot = java + c + php + python;
            per = tot / 4;
        }
        else {
            System.out.println("Enter Marks Between 1 to 100");
        }
    }

    private void display_result() {
        if(tot > 0 ) {
            System.out.println("Total Obtain Marks : " + tot + "/400");
            System.out.println("Percentage : " + per);

            if (per < 28) {
                System.out.println("Fail (Better Luck Next Time)");
            }
            if (per > 28 && per < 40) {
                System.out.println("Grade : D");
            } else if (per > 41 && per < 50) {
                System.out.println("Grade : C2");
            }
            if (per > 51 && per < 60) {
                System.out.println("Grade : C1 ");
            }
            if (per > 61 && per < 70) {
                System.out.println("Grade : B2");
            }
            if (per > 71 && per < 80) {
                System.out.println("Grade : B1");
            }
            if (per > 81 && per < 90) {
                System.out.println("Grade : A2");
            }
            if (per > 91 && per < 100) {
                System.out.println("Grade : A1");
            }
        }
    }

    public static void main(String[] args) {
        Task2_student obj = new Task2_student();
        obj.set_result();
        obj.display_result();
    }
}
