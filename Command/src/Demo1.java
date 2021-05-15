import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        System.out.println(account);

        List<BankAccountCommand> prebuildCommands = List.of(
                new BankAccountCommand(account, 100, BankAccountCommand.Action.DEPOSIT),
                new BankAccountCommand(account, 100, BankAccountCommand.Action.WITHDRAW)
        );

        for (Command c : prebuildCommands) {
            c.call();
        }
        for (Command c : prebuildCommands){
            c.undo();
        }
    }
}

class BankAccount {
    private int balance;
    private int overDraftLimit = -500;
    private boolean succeed;


    public boolean deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depos. " + amount + " , balance: " + balance);
            return true;
        }
        return false;
    }

    public boolean withdraw(int amount) {
        if (balance - amount >= overDraftLimit) {
            balance -= amount;
            System.out.println("Depos. " + amount + " , balance: " + balance);
            return true;
        } else {
            System.out.println("Not possible limit...");
            return false;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", overDraftLimit=" + overDraftLimit +
                '}';
    }
}

interface Command {
    void call();

    void undo();
}

class BankAccountCommand implements Command {
    private BankAccount account;
    private int amount;
    private Action action;
    private boolean succeeded;

    @Override
    public void undo() {
        if (succeeded) {
            switch (action) {
                case DEPOSIT:
                    account.withdraw(amount);
                    break;
                case WITHDRAW:
                    account.deposit(amount);
                    break;
            }
        }
    }

    @Override
    public void call() {

        switch (action) {
            case DEPOSIT:
                succeeded = true;
                account.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    public enum Action {
        DEPOSIT,
        WITHDRAW
    }

    public BankAccountCommand(BankAccount account, int amount, Action action) {
        this.account = account;
        this.amount = amount;
        this.action = action;
    }
}