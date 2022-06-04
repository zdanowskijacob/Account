import com.jz.banking.*;

public class AccountTest {

    public static void main(String[] args) {


        Bank bank = new Bank();

        Customer cst = new Customer("Marian","Bielecki");
        bank.addCustomer(cst);
        bank.addCustomer(new Customer("Alina", "Wielicka"));

        cst = bank.findCustomer("alina", "wielicka");
        if (cst!=null) {
            BaseAccount acc;
            acc = bank.createAccount(cst, AccountType.STUDENT);
            acc.deposit(1000);
            acc.withdraw(100);

            acc = bank.createAccount(cst, AccountType.SENIOR);
            acc.deposit(400);
        }
        cst = bank.findCustomer("marian", "bielecki");
        if (cst!=null) {
            BaseAccount acc;
            acc = bank.createAccount(cst, AccountType.STUDENT);
            acc.deposit(400);
            acc = bank.createAccount(cst, AccountType.STUDENT);
            acc.deposit(500);
            acc = bank.createAccount(cst, AccountType.STUDENT);
            acc.deposit(700);
            acc = bank.createAccount(cst, AccountType.STUDENT);
            acc.deposit(800);
        }

        bank.showInfo();
        BaseAccount acc = bank.findAccount(101);
        acc.showOperations();
    }

}