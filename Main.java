import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        Account[] accounts = new Account[100];
        int count = 0;


        accounts[count++] = new CurrentAccount("213", "Fahmida Munni", 1000);
        accounts[count++] = new SavingsAccount("214", "Munni", 3000);
        accounts[count++] = new DepositPremiumAccount("215","Fahmida",5000);



        while (true)
        {
            System.out.println("\n1. Create");
            System.out.println("2. Credit");
            System.out.println("3. Debit");
            System.out.println("4. Transfer");
            System.out.println("5. View Account by ID");
            System.out.println("6. Exit");

            System.out.println("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1)
            {
                System.out.println("Select Account Type");
                System.out.println("1.Current Account ");
                System.out.println("2.Savings Account ");
                System.out.println("3.Deposit Premium Account ");

                int accType = sc.nextInt();
                sc.nextLine();


                System.out.print("ID: ");
                String id = sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.println("Balance: ");
                double bal = sc.nextDouble();
                sc.nextLine();


                if(accType==1)
                {
                    accounts[count++]=new CurrentAccount(id,name,bal);
                }
                else if(accType==2)
                {
                    accounts[count++]=new SavingsAccount(id,name,bal);
                }
                else if(accType==3)
                {
                    accounts[count++]=new DepositPremiumAccount(id,name,bal);
                }


                System.out.println("Account created!!!");
            }

            else if (ch == 2 || ch == 3)
            {
                System.out.print("Enter Account ID: ");
                String id = sc.nextLine();
                Account acc = Main.findAccount(accounts, count, id);

                if (acc != null)
                {
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();

                    if (ch == 2)
                    {
                        acc.credit(amt);
                        System.out.println("Amount deposited!!");
                    }
                    else
                    {
                        acc.debit(amt);
                    }
                }


                else
                {
                    System.out.println("Account not found:(");
                }
            }

            else if (ch == 4)
            {
                System.out.print("From ID: ");
                String fromID = sc.nextLine();
                System.out.print("To ID: ");
                String toID = sc.nextLine();
                System.out.print("Amount: ");
                int amt = sc.nextInt();
                sc.nextLine();

                Account from = findAccount(accounts,count,fromID);
                Account to = findAccount(accounts ,count ,toID);

                if (from != null && to != null)
                {
                    from.transferTo(to, amt);
                }

                else
                {
                    System.out.println("One or maybe both accounts not found :'");
                }
            }

            else if (ch == 5)
            {
                System.out.print("Enter Account ID: ");
                String id = sc.nextLine();

                Account acc = findAccount(accounts,count,id);
                if(acc != null)
                {
                    acc.showInfo();
                }
                else
                    System.out.println("NoT Found :(");
            }

            else if (ch == 6)
            {
                System.out.println("Exiting :)");
                break;
            }

            else
            {
                System.out.println("Invalid choice:(");
            }
        }

        sc.close();
    }


    public static Account findAccount(Account[] accounts, int count, String id)
    {
        for (int i = 0; i < count; i++) {
            if (accounts[i].id.equals(id)) {
                return accounts[i];
            }
        }
        return null;
    }
}
