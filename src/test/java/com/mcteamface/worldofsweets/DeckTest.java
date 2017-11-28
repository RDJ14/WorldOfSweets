package com.mcteamface.worldofsweets;
import com.mcteamface.worldofsweets.Deck;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DeckTest{


  @Test
  public void fullDraw(){
    Deck testDeck = new Deck();
    int redSingles = 0;
    int blueSingles = 0;
    int greenSingles = 0;
    int yellowSingles = 0;
    int orangeSingles = 0;

    int redDoubles = 0;
    int blueDoubles = 0;
    int greenDoubles = 0;
    int yellowDoubles = 0;
    int orangeDoubles = 0;

    int special = 0;
    for(int i = 0; i < 62; i++){
      testDeck.simulateDraw();
      Card drawn = testDeck.lastDraw();
      if(drawn.isSpecial()){
        special++;
      }
      else if((drawn.getColor() == Color.RED) && (drawn.isSingle())) redSingles++;
      else if((drawn.getColor() == Color.RED) && !(drawn.isSingle())) redDoubles++;
      else if((drawn.getColor() == Color.BLUE) && (drawn.isSingle())) blueSingles++;
      else if((drawn.getColor() == Color.BLUE) && !(drawn.isSingle())) blueDoubles++;
      else if((drawn.getColor() == Color.GREEN) && (drawn.isSingle())) greenSingles++;
      else if((drawn.getColor() == Color.GREEN) && !(drawn.isSingle())) greenDoubles++;
      else if((drawn.getColor() == Color.YELLOW) && (drawn.isSingle())) yellowSingles++;
      else if((drawn.getColor() == Color.YELLOW) && !(drawn.isSingle())) yellowDoubles++;
      else if((drawn.getColor() == Color.ORANGE) && (drawn.isSingle())) orangeSingles++;
      else if((drawn.getColor() == Color.ORANGE) && !(drawn.isSingle())) orangeDoubles++;

    }
    assert(redSingles == 10);
    assert(blueSingles == 10);
    assert(greenSingles == 10);
    assert(yellowSingles == 10);
    assert(orangeSingles == 10);

    assert(redDoubles == 2);
    assert(blueDoubles == 2);
    assert(greenDoubles == 2);
    assert(yellowDoubles == 2);
    assert(orangeDoubles == 2);

    assert(special == 2);
    testDeck.dispose();
  }

  @Test
  public void disableDeckTest(){
    Deck testDeck = new Deck();
    testDeck.disableDraw();
    testDeck.simulateDraw();

    Card testCard = testDeck.lastDraw();

    assert(testCard == null);

  }

  @Test
  public void enablingDeckTest(){
    Deck testDeck = new Deck();
    testDeck.disableDraw();

    testDeck.enableDraw();
    testDeck.simulateDraw();
    Card testCard = testDeck.lastDraw();

    assert(testCard != null);
  }

}
