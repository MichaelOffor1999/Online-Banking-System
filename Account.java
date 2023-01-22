import java.util.Scanner;
public class Account{
    //make attributes
    private String name;
    private String id;
    private double balance;
    private double previousTransaction;


    //constructor for  String name and String ID
    public Account(String name, String id){
        this.name = name;
        this.id = id;
    }
    //method that returns deposit
    public double Depositmoney(double deposit){
        //CheckMethod("Enter deposit amount: ", "Please ensure you entered a double amount!", );
        if(deposit > 0){
            this.balance = this.balance + deposit;
            this.previousTransaction = deposit;
        }
        return deposit;
    }
    //method that returns withdrawal
    public double Withrawalnmaoney(double withdrawal){
        //check if withdrawal is more than balance
        if(withdrawal > balance){
            System.out.println("Insufficient funds");
        }
        if(withdrawal > 0){
            this.balance = this.balance - withdrawal;
            this.previousTransaction = -withdrawal;
        }
        return withdrawal;
    }
    //method that returns transactions made
    public double TransactionMoney(){
        if(this.previousTransaction > 0){
            System.out.println("You deposited: " + previousTransaction);
        }else if(this.previousTransaction < 0){
            System.out.println("You withdrew: " + previousTransaction);
        }else{
            System.out.println("No transaction occurred");
        }
        return previousTransaction;
    }
    //method that calculates interest and return what the balance will be
    public double InterestMoney(int years){
        double interestrate = 0.12;
        balance = balance * interestrate * years;
        return balance;
    }
    //main method for the actual account composing of all methods
    public void ShowMenu(){
        System.out.println("Welcome, " + name + "!");
        System.out.println("Your ID is:" + id);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("1. Check your balance");
        System.out.println();
        System.out.println("2. Make a deposit");
        System.out.println();
        System.out.println("3. Make a withdrawal");
        System.out.println();
        System.out.println("4. View previous transaction");
        System.out.println();
        System.out.println("5. Calculate interest");
        System.out.println();
        System.out.println("6. Exit");

        boolean end = false;
        //int end = 0;
        int optint = 0;
        String optstr;
        do{
            System.out.println();
            Scanner in = new Scanner(System.in);
            System.out.println("Please pick an option from 1 - 6: ");
            optstr = in.nextLine();
            try{
                optint = Integer.parseInt(optstr);
                if(optint < 0 || optint > 6){
                    System.out.println("Please enter a valid option!");
                    continue;
                }
            }catch(Exception e){
                System.out.println("Please enter an integer!");
            }
            System.out.println();

            switch(optint){
                case 1 :
                    System.out.println("=================================");
                    System.out.println("Your balance is: " + balance);
                    System.out.println("=================================");
                    break;
                case 2 :
                    double depmoney = Keyboard.CheckMethod("Enter deposit amount: ", "Please ensure you entered a double amount");
                    System.out.println(Depositmoney(depmoney));
                    System.out.println();
                    break;
                case 3 :
                    double input = Keyboard.CheckMethod("Enter withdrawal amount: ", "Please ensure you entered a double amount");
                    System.out.println(Withrawalnmaoney(input));
                    System.out.println();
                    break;
                case 4 :
                    System.out.println(TransactionMoney());
                    break;
                case 5:
                    System.out.print("Please enter an integer: ");
                    String strmoney;
                    int intmoney = 0;
                    strmoney = in.nextLine();
                    try{
                        intmoney = Integer.parseInt(strmoney);
                    } catch(Exception e){
                        System.out.print("Please enter an integer!");
                    }
                    System.out.println(InterestMoney(intmoney));
                    break;
                case 6:
                    end = true;
                    break;
            }
        }while(end == false);
        System.out.println("Thank you for banking with us");
    }
}
