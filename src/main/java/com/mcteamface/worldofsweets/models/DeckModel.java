package com.mcteamface.worldofsweets;

import java.awt.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

public class DeckModel implements Serializable {
  public static final int NUM_SINGLE = 10;
  public static final int NUM_DOUBLE = 2;
  public static final int NUM_SPECIAL = 1;
  public static final int NUM_SKIP = 5;

  private ArrayList<Card> mCards = new ArrayList<Card>();

  public DeckModel() {
    initDeck();
  }

  private void initDeck() {
    for (int i = 0; i < NUM_SINGLE; i++) {
      mCards.add(Card.RED);
      mCards.add(Card.YELLOW);
      mCards.add(Card.BLUE);
      mCards.add(Card.GREEN);
      mCards.add(Card.ORANGE);
    }

    for (int i = 0; i < NUM_DOUBLE; i++) {
      mCards.add(Card.DOUBLE_RED);
      mCards.add(Card.DOUBLE_YELLOW);
      mCards.add(Card.DOUBLE_BLUE);
      mCards.add(Card.DOUBLE_GREEN);
      mCards.add(Card.DOUBLE_ORANGE);
    }

    for (int i = 0; i < NUM_SPECIAL; i++) {
      mCards.add(Card.SPECIAL_LOLLIPOP);
      mCards.add(Card.SPECIAL_CORDIAL);
      mCards.add(Card.SPECIAL_CANDY_CANE);
      mCards.add(Card.SPECIAL_GUM_DROP);
      mCards.add(Card.SPECIAL_NOUGAT);
    }

    for (int i = 0; i < NUM_SKIP; i++) {
      mCards.add(Card.SKIP);
    }

    Collections.shuffle(mCards);
  }

  public Card dequeCard() {
    return mCards.remove(0);
  }

  public Card dequeDadCard(PlayerModel dad){
      int location = dad.getLocation();
      int currentColor = location % 5; //color determined
      int offset = 0;

      Card[] colors = new Card[] {
    		Card.RED,
    		Card.YELLOW,
        Card.BLUE,
    		Card.GREEN,
    		Card.ORANGE
    	};
      Card[] doubles = new Card[] {
        Card.DOUBLE_RED,
        Card.DOUBLE_YELLOW,
        Card.DOUBLE_BLUE,
        Card.DOUBLE_GREEN,
        Card.DOUBLE_ORANGE
      };

      //whenever a specail spot is passed, there needs to be an offset to account for the space that
      //is colorless in order to keep the modulo accuarate. If passed a special, that special is now the worst
      //card the dad can draw since it will take him backwards.
      //if passed first special
      if(location > 9){
        offset++;
        for(int i = 0; i < mCards.size(); i++){
          if(mCards.get(i) == Card.SPECIAL_GUM_DROP) return mCards.remove(i);
        }
      }
      //if second special passed
      if(location > 18){
        offset++;
        for(int i = 0; i < mCards.size(); i++){
          if(mCards.get(i) == Card.SPECIAL_NOUGAT) return mCards.remove(i);
        }
      }
      //if third special passed
      if(location > 27){
        offset++;
        for(int i = 0; i < mCards.size(); i++){
          if(mCards.get(i) == Card.SPECIAL_CANDY_CANE) return mCards.remove(i);
        }
      }
      //if fourth special passed
      if(location > 36){
        offset++;
        for(int i = 0; i < mCards.size(); i++){
          if(mCards.get(i) == Card.SPECIAL_LOLLIPOP) return mCards.remove(i);
        }
      }
      //if fifth special passed
      if(location > 45){
        offset++;
        for(int i = 0; i < mCards.size(); i++){
          if(mCards.get(i) == Card.SPECIAL_CORDIAL) return mCards.remove(i);
        }
      }
      //if the dad is on a special, need an extra offset to account for the colorless ActionListener
      //this will ensure he doesn't skip the color after the special if that card can be drawn
      if(location % 9 == 0 && location != 0) offset++;
      location -= offset;

      //first all single cards are checked. It would be boring if the dad sat at the Start
      //for the first 5 turns only drawing skips. To make it more interesting, the dadDrawCard
      //only draws skips after all worst singles are exhausted. This allows the other players
      //to also possibly draw skips before the dad draws them all.
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == colors[(location) % 5]) return mCards.remove(i);
      }
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == colors[(location + 1) % 5]) return mCards.remove(i);
      }
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == colors[(location + 2) % 5]) return mCards.remove(i);
      }
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == colors[(location + 3) % 5]) return mCards.remove(i);
      }
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == colors[(location + 4) % 5]) return mCards.remove(i);
      }
      //all singles exhausted, draw skips
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == Card.SKIP) return mCards.remove(i);
      }
      //only doubles left in the deck, draw worst doubles until exhausted
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == doubles[(location) % 5]) return mCards.remove(i);
      }
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == doubles[(location + 1) % 5]) return mCards.remove(i);
      }
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == doubles[(location + 2) % 5]) return mCards.remove(i);
      }
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == doubles[(location + 3) % 5]) return mCards.remove(i);
      }
      for(int i = 0; i < mCards.size(); i++){
        if(mCards.get(i) == doubles[(location + 4) % 5]) return mCards.remove(i);
      }
      //just in case if we cannot find any card that is the worst we will just draw.
      //This return should never be hit.
      return mCards.remove(0);
  }
}
