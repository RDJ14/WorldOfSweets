import java.util.Scanner;

public class CardTest{

  public static void main(String[] args) {
    Card testCardBlueSingle = new Card(true, Color.BLUE);
    Card testCardBlueDouble = new Card(false, Color.BLUE);
    Card testCardRedSingle = new Card(true, Color.RED);
    Card testCardRedDouble = new Card(false, Color.RED);
    Card testCardYellowSingle = new Card(true, Color.YELLOW);
    Card testCardYellowDouble = new Card(false, Color.YELLOW);
    Card testCardGreenSingle= new Card(true, Color.GREEN);
    Card testCardGreenDouble = new Card(false, Color.GREEN);
    Card testCardOrangeSingle = new Card(true, Color.ORANGE);
    Card testCardOrangeDouble = new Card(false, Color.ORANGE);

    testCardBlueSingle.draw();
    testCardBlueDouble.draw();
    testCardRedSingle.draw();
    testCardRedDouble.draw();
    testCardYellowSingle.draw();
    testCardYellowDouble.draw();
    testCardGreenSingle.draw();
    testCardGreenDouble.draw();
    testCardOrangeSingle.draw();
    testCardOrangeDouble.draw();

    System.out.println("Press enter to discard all cards");

    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();

    testCardBlueSingle.discard();
    testCardBlueDouble.discard();
    testCardRedSingle.discard();
    testCardRedDouble.discard();
    testCardYellowSingle.discard();
    testCardYellowDouble.discard();
    testCardGreenSingle.discard();
    testCardGreenDouble.discard();
    testCardOrangeDouble.discard();
    testCardOrangeSingle.discard();

    exit(0);
  }
}
