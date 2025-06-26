public abstract class Account {

    String id, name;
        double balance;

        public Account(String id, String name, double balance)
        {
            this.id = id;
            this.name = name;
            this.balance = balance;
        }

        public void credit(double amount)
        {
        }

        public void debit(double amount)
        {
            if (canWithdraw(amount))
            {
                balance -= amount;
                System.out.println("Debited successfully!!");
            }
            else
            {
                System.out.println("Cannot be withDrawn :(");
            }
        }

        public void transferTo(Account another, double amount)
        {
            if (canTransfer() && canWithdraw(amount))
            {
                balance -= amount;
                another.credit(amount);
                System.out.println("Transfer successful!!");
            }
            else
            {
                System.out.println("Cannot be Transferred :(");
            }
        }

        public void showInfo()
        {
            System.out.println("ID: " + id + ", Name: " + name + ", Balance: " + balance);
        }

        public abstract boolean canWithdraw(double amount);
        public abstract boolean canTransfer();
    }


