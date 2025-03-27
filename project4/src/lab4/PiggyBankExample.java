package lab4;

public class PiggyBankExample
{

  /**
   * @param args
   * The problem was that it isSmased() sets busted as true then return true
   * So the change is to check if its true by adding extra "="
   */
  public static void main(String[] args)
  {
    PiggyBank piggy = new PiggyBank(5);
    piggy.addCoins(1);
    piggy.addCoins(1);
    System.out.println("Should contain 2 coins: " + piggy.getNumCoins());
    System.out.println("Should be false (not smashed): " + piggy.isSmashed());
    piggy.addCoins(1);
    System.out.println("Should now contain 3 coins: " + piggy.getNumCoins());
  }

}
