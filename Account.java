/**
  Account is a class that contains a client's full name, account number and
  current account balance. It contains three parameters. Their full name,
  their account number, and their current account balance.
*/

public class Account{
  private String fullName;
  private String accNumber;
  private int currentAcc;
  private String firstName;
  private String lastName;
/**
  Default constructor. Creates an instance of an account object with empty
  variables.
*/
  public Account(){
    fullName = "";
    lastName = "";
    firstName = "";
    accNumber = "";
    currentAcc = 0;
  }
/**
  Constructor with all three arguments. It will also check to see if the first name
  is in the correct format. If not, it will initialize the fullname and the names to empty
  strings.
  @param name The person's full name.
  @param num The person's account number.
  @param bal The person's account balance.
*/
  public Account(String name, String num, int bal){
    if(name == null || num == null){
      firstName = "";
      lastName = "";
      fullName = "";
      accNumber = "";
      currentAcc = 0;
    }
    else{
      String[] splitString = name.split(", ");
      if(splitString.length == 2){
        firstName = splitString[1];
        lastName = splitString[0];
        fullName = name;
      }
      else{
        firstName = "";
        lastName = "";
        fullName = "";
      }
      accNumber = num;
      currentAcc = bal;
    }

  }
/**
  The toString() method converts the Account object to a readable string.
  @return The current object formatted into a string.
*/
  public String toString(){

    String tempString = "";

    tempString += fullName;
    tempString += " ";

    tempString += accNumber;
    tempString += " ";

    tempString += currentAcc;

    return tempString;
  }

/**
  The equals(other) checks if the object fed into the method is an account object,
  and if it is, casts it to an instance of an account object, then checks for
  equality.
  @return Whether or not the current object equals the other object.
  @param other A generic java object that may or may not be an Account object.
*/
  public boolean equals(Object other){

    if(other == null){
      return false;
    }

    else if(!(other instanceof Account)){
      return false;
    }
    else{
      Account tempAcc = (Account)other;
      return (tempAcc.fullName.equalsIgnoreCase(fullName) && tempAcc.firstName.equalsIgnoreCase(firstName) && tempAcc.lastName.equalsIgnoreCase(lastName) && tempAcc.accNumber.equalsIgnoreCase(accNumber) && tempAcc.currentAcc == currentAcc);
    }
  }

  //setters

  /**
    A setter method that sets the Account object's name to the newName argument.
    @param newName The name that will be set to the fullName varaible.
  */
  public void setName(String name){
    String[] splitString = name.split(", ");
    if(splitString.length == 2){
      firstName = splitString[1];
      lastName = splitString[0];
      fullName = name;
    }
    else{
      firstName = "";
      lastName = "";
      fullName = "";
    }
  }

/**
  A setter method that sets the account's number to the newAcc argument.
  @param newAcc The new account number for the Account object.
*/
  public void setAcc(String newAcc){
    accNumber = newAcc;
  }

/**
  A setter that sets the account's balance to the newBal argument.
  @param newBal The new account balance for the Account object.
*/
  public void setBal(int newBal){
    currentAcc = newBal;
  }

  //getters
/**
  A getter function that returns the Account's name.
  @return The Account name
*/
  public String getName(){
    return fullName;
  }
/**
  A getter function that returns the Account's number.
  @return The Account Number
*/
  public String getNum(){
    return accNumber;
  }
/**
  A getter function that returns the balance of the Account.
  @return the int value of the account balance.
*/
  public int getBal(){
    return currentAcc;
  }

/**
  Returns the first name from the full name, after splitting the fullname and
  checking for an empty string or a null value.
  @return Client's first name.
*/
  public String getFirst(){
    return firstName;
  }

/**
  Returns the last name from the full name, after splitting the fullname and
  checking for an empty string or a null value.
  @return Client's last name.
*/
  public String getLast(){
    return lastName;
  }

}
