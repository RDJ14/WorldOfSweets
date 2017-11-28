package com.mcteamface.worldofsweets;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class CardTest{

  @Test
  public void redSingleTest(){
    Card redSingle = new Card(true, Color.RED);
    redSingle.draw();
    assert(redSingle.getColor() == Color.RED);
    assert(redSingle.isSingle() == true);
    redSingle.discard();
  }

  @Test
  public void redDoubleTest(){
    Card redDouble = new Card(false, Color.RED);
    redDouble.draw();
    assert(redDouble.getColor() == Color.RED);
    assert(redDouble.isSingle() == false);
    redDouble.discard();
  }

  @Test
  public void blueSingleTest(){
    Card blueSingle = new Card(true, Color.BLUE);
    blueSingle.draw();
    assert(blueSingle.getColor() == Color.BLUE);
    assert(blueSingle.isSingle() == true);
    blueSingle.discard();
  }

  @Test
  public void blueDoubleTest(){
    Card blueDouble = new Card(false, Color.BLUE);
    blueDouble.draw();
    assert(blueDouble.getColor() == Color.BLUE);
    assert(blueDouble.isSingle() == false);
    blueDouble.discard();
  }

  @Test
  public void yellowSingleTest(){
    Card yellowSingle = new Card(true, Color.YELLOW);
    yellowSingle.draw();
    assert(yellowSingle.getColor() == Color.YELLOW);
    assert(yellowSingle.isSingle() == true);
    yellowSingle.discard();
  }

  @Test
  public void yellowDoubleTest(){
    Card yellowDouble = new Card(false, Color.YELLOW);
    yellowDouble.draw();
    assert(yellowDouble.getColor() == Color.YELLOW);
    assert(yellowDouble.isSingle() == false);
    yellowDouble.discard();
  }

  @Test
  public void greenSingleTest(){
    Card greenSingle = new Card(true, Color.GREEN);
    greenSingle.draw();
    assert(greenSingle.getColor() == Color.GREEN);
    assert(greenSingle.isSingle() == true);
    greenSingle.discard();
  }

  @Test
  public void greenDoubleTest(){
    Card greenDouble = new Card(false, Color.GREEN);
    greenDouble.draw();
    assert(greenDouble.getColor() == Color.GREEN);
    assert(greenDouble.isSingle() == false);
    greenDouble.discard();
  }

  @Test
  public void orangeSingleTest(){
    Card orangeSingle = new Card(true, Color.ORANGE);
    orangeSingle.draw();
    assert(orangeSingle.getColor() == Color.ORANGE);
    assert(orangeSingle.isSingle() == true);
    orangeSingle.discard();
  }

  @Test
  public void orangeDoubleTest(){
    Card orangeDouble = new Card(false, Color.ORANGE);
    orangeDouble.draw();
    assert(orangeDouble.getColor() == Color.ORANGE);
    assert(orangeDouble.isSingle() == false);
    orangeDouble.discard();
  }

  @Test
  public void licoriceTest(){
    Card licorice = new Card(SpecialType.LICORICE);
    licorice.draw();
    assert(licorice.isSpecial());
    assert(licorice.type == SpecialType.LICORICE);
    licorice.discard();
  }

  @Test
  public void mintTest(){
    Card mint = new Card(SpecialType.MINT);
    mint.draw();
    assert(mint.isSpecial());
    assert(mint.type == SpecialType.MINT);
    mint.discard();
  }

  @Test
  public void iceCreamTest(){
    Card iceCream = new Card(SpecialType.ICECREAM);
    iceCream.draw();
    assert(iceCream.isSpecial());
    assert(iceCream.type == SpecialType.ICECREAM);
    iceCream.discard();
  }

  @Test
  public void chocolateTest(){
    Card choc = new Card(SpecialType.CHOCOLATE);
    choc.draw();
    assert(choc.isSpecial());
    assert(choc.type == SpecialType.CHOCOLATE);
    choc.discard();
  }

  @Test
  public void skipTest(){
    Card skip = new Card(SpecialType.SKIP);
    skip.draw();
    assert(skip.isSpecial());
    assert(skip.type == SpecialType.SKIP);
    skip.discard();
  }

}
