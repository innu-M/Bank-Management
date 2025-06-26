public class SavingsAccount extends Account {
    public SavingsAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void credit(double amount)
    {
        balance += amount;
        balance += balance * 0.025;
    }

    @Override
    public boolean canWithdraw(double amount)
    {
        if((amount-balance)>1000)
            return true;

        else
            return  false;

    }

    @Override
    public boolean canTransfer()
    {
        return true;
    }
}
