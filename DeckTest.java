

public class DeckTest{



  public static void main(String[] args) {
      boolean allPassed = testDeckDraw();
      if(allPassed){
        System.out.println("All Tests Passed");
      }
      System.exit(0);
   }


  public static boolean testDeckDraw(){
    Deck testDeck = new Deck();

    int blue_singles = 0;
    int blue_doubles = 0;
    int red_singles = 0;
    int red_doubles = 0;
    int green_singles = 0;
    int green_doubles = 0;
    int yellow_singles = 0;
    int yellow_doubles = 0;
    int orange_singles = 0;
    int orange_doubles = 0;

    for(int i = 0; i < 60; i++){
      testDeck.simulateDraw();
      Card drawn = testDeck.lastDraw();
      if(drawn.color == Color.BLUE)
      {
        if(drawn.single) blue_singles++;
        if(!drawn.single) blue_doubles++;
      }
      else if(drawn.color == Color.RED){
        if(drawn.single) red_singles++;
        if(!drawn.single) red_doubles++;
      }
      else if(drawn.color == Color.GREEN){
        if(drawn.single) green_singles++;
        if(!drawn.single) green_doubles++;
      }
      else if(drawn.color == Color.YELLOW){
        if(drawn.single) yellow_singles++;
        if(!drawn.single) yellow_doubles++;
      }
      else if(drawn.color == Color.ORANGE){
        if(drawn.single) orange_singles++;
        if(!drawn.single) orange_doubles++;
      }
    }


    boolean allPassed = true;
    if(blue_singles != 10){
      System.out.println("Blue singles Failed");
      allPassed = false;
    }
    if(yellow_singles != 10){
      System.out.println("Yellow singles Failed");
      allPassed = false;
    }
    if(green_singles != 10) {
      System.out.println("Green singles Failed");
      allPassed = false;
    }
    if(red_singles != 10) {
      System.out.println("Red singles Failed");
      allPassed = false;
    }
    if(orange_singles != 10) {
      System.out.println("Orange singles Failed");
      allPassed = false;
    }

    if(blue_doubles != 2) {
      System.out.println("Blue doubles Failed");
      allPassed = false;
    }
    if(yellow_doubles != 2) {
      System.out.println("Yellow doubles Failed");
      allPassed = false;
    }
    if(red_doubles != 2) {
      System.out.println("Red doubles Failed");
      allPassed = false;
    }
    if(green_doubles != 2) {
      System.out.println("Green doubles Failed");
      allPassed = false;
    }
    if(orange_doubles != 2) {
      System.out.println("Orange doubles Failed");
      allPassed = false;
    }
    return allPassed;
  }

}
