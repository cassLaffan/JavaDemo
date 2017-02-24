public class BankTester{

  public static void main(String[] args){
    //acounts for later use
    Account firstAcc = new Account("Laffan, Cassandra", "123ABC", 0);
    Account secondAcc = new Account("Ali-Clarke, Jinnah", "122AAC", 1000);
    Account thirdAcc = new Account("MacLellan, Erin", "123a3a", 1000);
    Account fourthAcc = new Account("Lasiandra, Rose", "123a32", 1030);
    Account fifthAcc = new Account("Snowbell, Violet", "123a31", 1020);

    //bank objects being initialized
    Bank firstBank = new Bank("PokeBank", 6);
    Bank secondBank = new Bank("pOKebANK", 3);
    Bank emptyBank = new Bank();

    //checking the empty sates

    System.out.println(firstBank.toString());
    System.out.println(secondBank.toString());
    System.out.println(emptyBank.toString());

    //add to the banks
    firstBank.addAccount(firstAcc);
    firstBank.addAccount(secondAcc);
    firstBank.addAccount(thirdAcc);
    firstBank.addAccount(fourthAcc);
    firstBank.addAccount(fifthAcc);

    secondBank.addAccount(firstAcc);
    secondBank.addAccount(secondAcc);
    secondBank.addAccount(thirdAcc);

    //check if the values are added

    System.out.println(firstBank.toString());
    System.out.println(secondBank.toString());

    System.out.println("-------------------------------------\n");

    //Attempt to add values that won't work

    System.out.println("Let's try to add something to the size 0 bank.\n");
    boolean tryOne = emptyBank.addAccount(secondAcc);
    if(!tryOne){
      System.out.println("Could not add to the bank with size 0!\n");
    }

    System.out.println("Let's try to add something to the full bank!\n");
    boolean tryTwo = secondBank.addAccount(fourthAcc);
    if(!tryTwo){
      System.out.println("Could not add to the bank! It's full!\n");
    }

    System.out.println("Let's try to add a duplicate!\n");
    boolean tryThree = firstBank.addAccount(fifthAcc);
    if(!tryThree){
      System.out.println("Could not add duplicate account!\n");
    }

    Account tryAccount = new Account("SNOWBELL, VIOLET", "123A31", 1020);

    System.out.println("Let's try to add a duplicate with different capital letters!\n");
    boolean tryFour = firstBank.addAccount(tryAccount);
    if(!tryFour){
      System.out.println("Could not add duplicate account!\n");
    }

    System.out.println("Let's try to add something of non-type Account\n");
    boolean tryFive = firstBank.addAccount(12);
    if(!tryFive){
      System.out.println("Cannot add an object of non Account type!\n");
    }
    System.out.println("-------------------------------------\n");

    //Remove account

    System.out.println("Let's remove an account:\n");
    Account removedAcc = secondBank.removeAccount("123abc");
    System.out.println("The account removed was: " + removedAcc.toString() + "\n");

    System.out.println("The bank now looks like:\n");
    System.out.println(secondBank.toString());
    System.out.println("-------------------------------------\n");
    System.out.println("\n");


    System.out.println("Let's try to remove an account that doesn't exist:\n");
    Account notRemoved = secondBank.removeAccount("123a31");
    if(notRemoved == null){
      System.out.println("Can't remove something that isn't there!");
    }
    System.out.println("The bank now looks like:\n");
    System.out.println(secondBank.toString());
    System.out.println("\n");
    System.out.println("-------------------------------------\n");

    //search tests

    int balanceSearch = 1000;
    System.out.println("Searching for accounts with the balance of 1000...");
    Account[] foundAccs = firstBank.search(balanceSearch);
    if(foundAccs != null){
      System.out.println("Number of matches found: " + foundAccs.length);
    }

    System.out.println("Searching for accounts with the balance of 50...");
    Account[] notAccs = firstBank.search(50);
    if(notAccs.length == 0){
      System.out.println("No matches found!");
    }
  }

}
