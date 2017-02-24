/**
  The bank class stores an array of Accounts, the name of the bank and
  the maximum number of accounts it can hold. It also has a currAccounts integer
  that allows for us to see how many objects are currently in the array.
*/

public class Bank{
  private Account[] bankAccounts;
  private String bankName;
  private int maxAccounts;
  private int currAccounts;

/**
  The default constructor creates an empty array of accounts,
  the maxAccounts at size 0 and the default name as Senega@York.
*/

  public Bank(){
    this("Seneca@York", 0);
  }

/**
  This constructor takes two arguments, where it then creates
  an array of size Numofelements and plugs any accounts into it
  @param name A string that represents the bank's name.
  @param accs The maximum number of accounts that can be held at this particular bank.
*/

  public Bank(String name, int accs){
    bankAccounts = new Account[accs];
    bankName = name;
    maxAccounts = accs;
    currAccounts = 0; //empty
  }

/**
  The equals() method takes on argument, which is a generic object
  and checks for equality. It returns a boolean.
  @return A boolean value of whether or not the current object and the other object are equal.
  @param other A generic object.
*/
  public boolean equals(Object other){
    if(other == null){
      return false;
    }
    else if(!(other instanceof Bank)){
      return false;
    }
    else{
      Bank tempBank = (Bank)other;
      if(tempBank.maxAccounts != maxAccounts || tempBank.bankName.equalsIgnoreCase(bankName) || tempBank.currAccounts != currAccounts){
        return false;
      }
      else{
        boolean flag = true;
        int i = 0;
        do{
          flag = bankAccounts[i].equals(tempBank.bankAccounts[i]);
          i++;
        }while(flag && i < maxAccounts);
        return flag;
        }
      }
  }

/**
  The toSring() method returns a formatted string representing the current
  java object.
  @return A formatted string representation of the bank object.
*/
  public String toString(){
    String finalString = bankName;
    finalString += "\n";
    finalString += "-----\n";
    finalString += "This bank has a maximum account storage of: ";
    finalString += maxAccounts;
    finalString += "\n";
    if(currAccounts != 0){
      finalString += "This bank currently has ";
      finalString += currAccounts;
      finalString += " opened accounts.\n";
      finalString += "This is the list of currently opened accounts:\n";
    }

    //won't start this forloop if i == 0
    for(int i = 0; i < currAccounts; i++){
      finalString += (i + 1);
      finalString += ": ";
      finalString += bankAccounts[i].toString();
      finalString += "\n";
    }
    if(currAccounts == 0){
      finalString += "This bank hasn't had any accounts opened yet!\n";
    }

    return finalString;
  }

/**
  The addAccount() method returns a boolean after attempting to add
  a new object account to the bank array. It will return false if it recieves an
  object of not type Account.
  @return A boolean representation of whether or not the account object was appended to the array.
  @param Account The object that is to be appended to the bankAccounts array.
*/
  public boolean addAccount(Object obj){

    if(!(obj instanceof Account) || currAccounts == (maxAccounts)){
      return false;
    }
    else{
      Account tempAccount = (Account)obj;
      //checking for duplicate account
      for(int i = 0; i < currAccounts; i++){
        if(bankAccounts[i].equals(tempAccount)){
          //exits if a duplicate is found
          return false;
        }
      }
      //since all other plces would have exited by now,
      //we can now append this account to the array
      bankAccounts[currAccounts] = tempAccount;
      currAccounts++;
      return true;
    }
  }

/**
  The removeAccount() method takes in a string representtion of a bank account number then attempts to remove
  it from the bankAccounts array. It returns a boolean indicating its success.
  @return Account Returns an account object that was removed from the array. Null if the object didn't exist.
  @param String Accepts a string representation of a bank account number.
*/

  public Account removeAccount(String tempNum){
    Account tempAccount = null;
    int i = 0;
    while(tempAccount == null && i < currAccounts){
      if(bankAccounts[i].getNum().equalsIgnoreCase(tempNum)){
        tempAccount = bankAccounts[i];
      }
      i++;
    }
    //shifts all the accounts over in bankAccounts if an account is found
    if(tempAccount != null){
      for(int j = i + 1; j < maxAccounts; j++){
        bankAccounts[j - 1] = bankAccounts[j];
      }
      currAccounts--;
      bankAccounts[currAccounts] = null;
    }
    return tempAccount;
  }

/**
 The search() method takes in an interger and returns an array of Account objects with
 that balance.
 @return An array of Account objects. It will return an empty array if no matches are found.
 @param int Takes an integer value that will be checked against the integet values of the balance in every account object.
*/

  public Account[] search(int findBalance){
    //will find the size of the account array, then create
    //the according account array size
    int sizeAcc = 0;
    for(int i = 0; i < currAccounts; i++){
      if(bankAccounts[i].getBal() == findBalance){
        sizeAcc++;
      }
    }
    Account[] foundMatches = new Account[sizeAcc];
    //now constructs the array
    int counter = 0;
    for(int i = 0; i < currAccounts; i++){
      //don't need to check if the counter is at max
      //because we already found all the matches required
      if(bankAccounts[i].getBal() == findBalance){
        foundMatches[counter] = bankAccounts[i];
      }
    }

    return foundMatches;
  }
}
