public class CurrentAccount  extends Account {
    public CurrentAccount(String id, String name, double balance)
    {
        super(id, name, balance);
    }

        @Override
        public void credit(double amount)
        {
            balance +=amount;
        }

        @Override
        public boolean canWithdraw(double amount)
        {
            if(amount<=balance)
                return true;
            else
                return false;
        }

        @Override
        public boolean canTransfer()
        {
            return true;
        }



}
