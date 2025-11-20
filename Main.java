import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float balance = 3015.00f;
        float withdrawCharge = 15.00f;
        float checkBalCharge = 1.00f;
        String choose2;
        String proceedTwo;


        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("============ ATM MACHINE==========");
            System.out.println();
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose transaction: ");
            String choose = scanner.nextLine();
            System.out.println();

            if (choose.equalsIgnoreCase("1")) {
                if (balance > 0) {
                    System.out.println("Charge to check balance is 1.00 (pesos). Proceed? Y/N?");
                    String proceed = scanner.nextLine();
                    if (proceed.equalsIgnoreCase("Y")) {
                        System.out.println("Savings Balance: " + balance);
                        System.out.println("Service Charge: " + checkBalCharge);
                        balance -= checkBalCharge;
                        System.out.println("Total Remaining Balance: " + balance);
                    } else {
                        System.out.println("Okay!");
                    }
                } else {
                    System.out.println("Zero balance! try to deposit first");
                }
            } else if (choose.equalsIgnoreCase("2")) {
                System.out.println("Enter amount: ");
                int deposit = scanner.nextInt();
                scanner.nextLine();
                balance += deposit;
                System.out.println("Successful, your new balance is: " + balance);
            } else if (choose.equalsIgnoreCase("3")) {
                if (balance > 15) {
                    System.out.println("Charge for withdrawal is 15.00 (Pesos). Proceed? Y/N?: ");
                    proceedTwo = scanner.nextLine();
                    if (proceedTwo.equalsIgnoreCase("y")) {
                        System.out.println("Enter amount: ");
                        int withdraw = scanner.nextInt();
                        scanner.nextLine();
                        if ((withdraw + withdrawCharge) <= balance) {
                            balance -= withdraw;
                            balance -= withdrawCharge;
                            System.out.println("Successful! please get your card and wait for the money to come out. " +
                                    "Do not accept help from the strangers");
                        } else {
                            System.out.println("Insufficient Balance! Please try again!");
                        }
                    }
                } else {
                    System.out.println("Less than 15 pesos balance. Try to deposit first. Thanks!");
                }
            }   else if (choose.equalsIgnoreCase("4")){
                System.out.println("Thank you for using ATM MACHINE! See yah!");
                return;
            } else {
                System.out.println("Error!");
            }

                System.out.println();
                System.out.println("Want another transaction?: Y/N?");
                choose2 = scanner.nextLine();

        } while(choose2.equalsIgnoreCase("y"));

        System.out.println("Thank you for using ATM MACHINE! See yah!");
    }
}
