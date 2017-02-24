public class AccountTester{
  public static void main(String[] args){

    //part 1
    Account nullAcc = new Account(null, null, -1);
    Account firstAcc = new Account("Laffan, Cassandra", "123ABC", 0);
    //should not ilitialize correctly; gives empty strings for Jinnah's name
    Account secondAcc = new Account("Jinnah Ali-Clarke", "122AAC", 1000);
    Account spaceAcc = new Account("       ", "           ", 12);
    Account noAcc = new Account("", "", 0);

    //part 2
    System.out.println("\n");
    System.out.println("The following should all be true, as they are simply checking if the values were all set accordingly: ");
    System.out.println("\n");

    String tempNull = nullAcc.getName();
    String tempNull2 = nullAcc.getNum();
    int tempNull3 = nullAcc.getBal();
    boolean tempTrueNull = (tempNull == "" && tempNull2 == "" && tempNull3 == 0);
    if(tempTrueNull){
      System.out.println("The null account initialized fine!");
    }

    System.out.println("\n");

    String tempFirst = firstAcc.getName();
    String tempFirst2 = firstAcc.getNum();
    int tempFirst3 = firstAcc.getBal();
    boolean tempTrueFirst = (tempFirst == "Laffan, Cassandra" && tempFirst2 == "123ABC" && tempFirst3 == 0);
    if(tempTrueFirst){
      System.out.println("Cassandra's account initialized fine!");
    }

    System.out.println("\n");


    String tempSecond = secondAcc.getName();
    String tempSecond2 = secondAcc.getNum();
    int tempSecond3 = secondAcc.getBal();
    boolean tempTrueSecond = (tempSecond == "" && tempSecond2 == "122AAC" && tempSecond3 == 1000);
    if(tempTrueSecond){
      System.out.println("Jinnah's account initialized fine!");
    }

    System.out.println("\n");


    String tempSpace = spaceAcc.getName();
    String tempSpace2 = spaceAcc.getNum();
    int tempSpace3 = spaceAcc.getBal();
    boolean tempTrueBlank = (tempSpace == "" && tempSpace2 == "           " && tempSpace3 == 12);
    if(tempTrueBlank){
      System.out.println("The blank account initialized fine!");
    }

    System.out.println("\n");

    String tempNone = noAcc.getName();
    String tempNone2 = noAcc.getNum();
    int tempNone3 = noAcc.getBal();
    boolean tempTrueNo = (tempNone == "" && tempNone2 == "" && tempNone3 == 0);
    if(tempTrueNo){
      System.out.println("The empty account initialized fine!");
    }

    System.out.println("\n");

    //part 3
    System.out.println("The toString function for the null returns: " + nullAcc.toString());
    System.out.println("The toString function for Cassandra returns: " + firstAcc.toString());
    System.out.println("The toString function for Jinnah returns: " + secondAcc.toString());
    System.out.println("The toString function for spaces returns: " + spaceAcc.toString());
    System.out.println("The toString function for the empty strings returns: " + noAcc.toString());

    System.out.println("\n");

    //part 4
    boolean checkNull = false;
    checkNull = nullAcc.equals(nullAcc);
    System.out.println("This should be true: " + checkNull);

    boolean checkFirst = false;
    checkFirst = firstAcc.equals(firstAcc);
    System.out.println("This should be true: " + checkFirst);

    boolean checkSecond = false;
    checkSecond = secondAcc.equals(firstAcc);
    System.out.println("This should be false: " + checkSecond);

    boolean checkSpace = false;
    checkSpace = spaceAcc.equals(spaceAcc);
    System.out.println("This should be true: " + checkSpace);

    boolean checkNo = false;
    checkSpace = noAcc.equals(secondAcc);
    System.out.println("This should be false: " + checkSpace);
    System.out.println("\n");

    //part 5
    System.out.println("The getter for the first name on Null is: " + nullAcc.getFirst());
    System.out.println("The getter for the last name on Null is: " + nullAcc.getLast());
    System.out.println("\n");

    System.out.println("The getter for Cassandra's first name is: " + firstAcc.getFirst());
    System.out.println("The getter for Cassandra's last name is: " + firstAcc.getLast());
    System.out.println("\n");

    System.out.println("The getter for Jinnah's first name is: " + secondAcc.getFirst());
    System.out.println("The getter for Jinnah's last name is: " + secondAcc.getLast());
    System.out.println("\n");

    System.out.println("The getter for the Spaces first name is: " + spaceAcc.getFirst());
    System.out.println("The getter for the Spaces last name is: " + spaceAcc.getLast());
    System.out.println("\n");

    System.out.println("The getter for the empty first name is: " + spaceAcc.getFirst());
    System.out.println("The getter for the empty last name is: " + spaceAcc.getLast());
    System.out.println("\n");

  }
}
