package codsoft;

import java.util.Scanner;

import static java.lang.System.exit;


class account_holder{
    protected long account_number = 0,balance = 0;
    protected String name, password;

    public void set_data(){
        Scanner sc = new Scanner(System.in);
        account_number++;
        System.out.print("Create Bank Account \nEnter Your Name : ");
        name = sc.nextLine();
        System.out.print("Create Password : ");
        password = sc.nextLine();

        System.out.println("Your Bank Account Is Created With Account Number " + account_number);
    }
}

class ATM_machine extends account_holder{
    public void Deposite(int rs){
        if(rs > 0){
            balance += rs;
            System.out.println("Rs. "+rs+" Deposite to "+account_number+" Account Number");
        }
    }
    public void Withdraw(int rs, int acc_number, String pass){
        if(acc_number == account_number && pass.equals(password)){
            balance -= rs;
            System.out.println("Rs. "+rs+" Withdraw from "+account_number+" Account Number");
        }
        else{
            System.out.println("Account number And Password Is Incorrect");
        }
    }

    public void Check_Balance(int acc_number, String pass){
        if(acc_number == account_number && pass.equals(password)){
            System.out.println("Your Account Balance is "+balance);
        }
        else{
            System.out.println("Account number And Password Is Incorrect");
        }
    }
}
public class Task3_ATM {
    public static void main(String[] args) {
        ATM_machine holder = new ATM_machine();

        Scanner sc = new Scanner(System.in);

        int rs, acc_num, choise;
        String pass;

        holder.set_data();

        while (true){
            System.out.println("1 : Deposite");
            System.out.println("2 : Withdraw");
            System.out.println("3 : Check Balance");
            System.out.println("4 : EXIT\n");

            System.out.print("Select Any Option : ");
            choise = sc.nextInt();

            switch (choise){
                case 1:
                    System.out.print("Enter Amount : ");
                    rs = sc.nextInt();
                    holder.Deposite(rs);
                    break;

                case 2:
                    System.out.print("Enter Account Number :");
                    acc_num = sc.nextInt();
                    pass = sc.nextLine();
                    System.out.print("Enter Your Password :");
                    pass = sc.nextLine();
                    System.out.print("Enter Withdraw Amount :");
                    rs = sc.nextInt();

                    holder.Withdraw(rs, acc_num, pass);
                    break;

                case 3:
                    System.out.print("Enter Account Number :");
                    acc_num = sc.nextInt();
                    pass = sc.nextLine();
                    System.out.print("Enter Your Password :");
                    pass = sc.nextLine();

                    holder.Check_Balance(acc_num, pass);
                    break;
                case 4:
                    exit(0);
                    break;

                default:
                    System.out.println("Select VAlid Option");
                    break;
            }
        }
    }
}