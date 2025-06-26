public class DepositPremiumAccount extends Account {

    private int installments;

    public DepositPremiumAccount(String id, String name, double balance)
    {
        super(id, name, balance);
        this.installments = 0;
    }

    @Override
    public void credit(double amount)
    {
        installments++;
        balance += amount;
        balance += balance * 0.07;
    }

    @Override
    public boolean canWithdraw(double amount)
    {
        if(installments >= 5 && amount <= balance)
            return true;
        else
            return false;
    }

    @Override
    public boolean canTransfer()
    {
        return false ;
    }

    @Override
    public void showInfo()
    {
        super.showInfo();
        System.out.println("Installments Deposited: " + installments + "out of 5");
    }
}
