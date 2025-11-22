import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float balance = 3015.00f;
        float withdrawCharge = 15.00f;
        float checkBalCharge = 1.00f;
        String choose2;
        String proceedTwo;
        int[] pins = {111221, 111222, 111223};
        boolean access = false;
        int count = 0;
        int pinNum;
        float previousBalance;


        Scanner scanner = new Scanner(System.in);

    do{ System.out.print("Enter PIN: ");
        pinNum = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < 3; i++) {
            if (pinNum == pins[i]) {
                access = true;
                break;
            }
        }
        if (access) {
            do {
                System.out.println("============ ATM MACHINE==========");
                System.out.println();
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose transaction: ");
                int choose = scanner.nextInt();
                scanner.nextLine();
                System.out.println();


                if (choose == 1) {
                    if (balance > 0) {
                        System.out.println("Charge to check balance is 1.00 (pesos). Proceed? Y/N?");
                        String proceed = scanner.nextLine();
                        if (proceed.equalsIgnoreCase("Y")) {
                            balance -= checkBalCharge;
                            System.out.println("Total Remaining Balance: " + balance);
                        } else {
                            System.out.println("Cancelled!");
                        }
                    } else {
                        System.out.println("Zero balance! try to deposit first");
                    }
                } else if (choose == 2) {
                    System.out.println("Enter amount: ");
                    int deposit = scanner.nextInt();
                    scanner.nextLine();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Successful, your new balance is: " + balance);
                    } else {
                        System.out.println("Error! Input an amount to deposit");
                    }
                } else if (choose == 3) {
                    if (balance > withdrawCharge) {
                        System.out.println("Charge for withdrawal is 15.00 (Pesos). Proceed? Y/N?: ");
                        proceedTwo = scanner.nextLine();
                        if (proceedTwo.equalsIgnoreCase("y")) {
                            System.out.println("Enter amount: ");
                            int withdraw = scanner.nextInt();
                            scanner.nextLine();
                            if ((withdraw + withdrawCharge) <= balance && withdraw > 0) {
                                previousBalance = balance + withdraw + withdrawCharge;

                                balance -= withdraw;
                                balance -= withdrawCharge;

                                System.out.println();
                                System.out.println("SUCCESSFUL");
                                System.out.println();
                                System.out.println("------RECEIPT------");
                                System.out.println("Balance : " + previousBalance);
                                System.out.println("Charge fee: -" + withdrawCharge);
                                System.out.println("Withdraw : -" + withdraw);
                                System.out.println("-------------------");
                                System.out.println("Total Remaining Balance : " + balance);
                                System.out.println("-------------------");
                                System.out.println("Please get your card and wait for the money to come out. " +
                                        "Do not accept help from the strangers");
                                return;
                            } else if (withdraw <= 0){
                                System.out.println("Input an amount!");
                            }
                            else {
                                System.out.println("Insufficient Balance or you did not input an amount!");
                            }
                        } else if (proceedTwo.equalsIgnoreCase("n")) {
                            System.out.println("Cancelled!");
                        }
                    } else {
                        System.out.println("Less than 15 pesos balance. Try to deposit first. Thanks!");
                    }
                } else if (choose == 4) {
                    System.out.println("Thank you for using ATM MACHINE! See yah!");
                    return;
                } else {
                    System.out.println("Invalid option, please try again!");
                }

                System.out.println();
                System.out.println("Want another transaction?: Y/N?");
                choose2 = scanner.nextLine();

            } while (choose2.equalsIgnoreCase("y"));

                System.out.println("Thank you for using ATM MACHINE! See yah!");
                return;

        } else {
            count++;
            System.out.println("Access Denied!");
            System.out.println("attempt(s):" + count + "/3");
        }

    }while(count<3);

    System.out.println("Account temporary suspended! ");

            scanner.close();

            return;
    }
}

