package com.mcteamface.worldofsweets;

public class GameHelperUtil {
  // Arrays are mutable so please don't mutate.
  private static final Spot[] board = new Spot[] {
    Spot.START, Spot.RED, Spot.YELLOW, Spot.BLUE, Spot.GREEN, Spot.ORANGE, Spot.RED, Spot.YELLOW, Spot.BLUE, Spot.SPECIAL_GUM_DROP,
    Spot.GREEN, Spot.ORANGE, Spot.RED, Spot.YELLOW, Spot.BLUE, Spot.GREEN, Spot.ORANGE, Spot.RED, Spot.SPECIAL_NOUGAT, Spot.YELLOW,
    Spot.BLUE, Spot.GREEN, Spot.ORANGE, Spot.RED, Spot.YELLOW, Spot.BLUE, Spot.GREEN, Spot.SPECIAL_CANDY_CANE, Spot.ORANGE, Spot.RED,
    Spot.YELLOW, Spot.BLUE, Spot.GREEN, Spot.ORANGE, Spot.RED, Spot.YELLOW, Spot.SPECIAL_LOLLIPOP, Spot.BLUE, Spot.GREEN, Spot.ORANGE,
    Spot.RED, Spot.YELLOW, Spot.BLUE, Spot.GREEN, Spot.ORANGE, Spot.SPECIAL_CORDIAL, Spot.RED,
    Spot.YELLOW, Spot.BLUE, Spot.GREEN, Spot.ORANGE, Spot.RED, Spot.YELLOW, Spot.GRANDMA
  };

  public static int getNext(int currentSpot, Card card) {
    // Start at position + 1 incase we are on that color.
    int numFound = 0;
    for (int i = currentSpot + 1; i < board.length; i++) {
      if (board[i].equals(Spot.GRANDMA)) {
        return board.length - 1;
      }
      switch (card) {
        case RED:
          if (board[i].equals(Spot.RED)) {
            return i;
          }
          break;
        case YELLOW:
          if (board[i].equals(Spot.YELLOW)) {
            return i;
          }
          break;
        case BLUE:
          if (board[i].equals(Spot.BLUE)) {
            return i;
          }
          break;
        case GREEN:
          if (board[i].equals(Spot.GREEN)) {
            return i;
          }
          break;
        case ORANGE:
          if (board[i].equals(Spot.ORANGE)) {
            return i;
          }
          break;
        case DOUBLE_RED:
          if (board[i].equals(Spot.RED) && numFound > 0) {
            return i;
          } else if (board[i].equals(Spot.RED)) {
            numFound++;
          }
          break;
        case DOUBLE_YELLOW:
          if (board[i].equals(Spot.YELLOW) && numFound > 0) {
            return i;
          } else if (board[i].equals(Spot.YELLOW)) {
            numFound++;
          }
          break;
        case DOUBLE_BLUE:
          if (board[i].equals(Spot.BLUE) && numFound > 0) {
            return i;
          } else if (board[i].equals(Spot.BLUE)) {
            numFound++;
          }
          break;
        case DOUBLE_GREEN:
          if (board[i].equals(Spot.GREEN) && numFound > 0) {
            return i;
          } else if (board[i].equals(Spot.GREEN)) {
            numFound++;
          }
          break;
        case DOUBLE_ORANGE:
          if (board[i].equals(Spot.ORANGE) && numFound > 0) {
            return i;
          } else if (board[i].equals(Spot.ORANGE)) {
            numFound++;
          }
          break;
        case SPECIAL_LOLLIPOP:
          if (board[i].equals(Spot.SPECIAL_LOLLIPOP)) {
            return i;
          }
          break;
        case SPECIAL_CORDIAL:
          if (board[i].equals(Spot.SPECIAL_CORDIAL)) {
            return i;
          }
          break;
        case SPECIAL_CANDY_CANE:
          if (board[i].equals(Spot.SPECIAL_CANDY_CANE)) {
            return i;
          }
          break;
        case SPECIAL_GUM_DROP:
          if (board[i].equals(Spot.SPECIAL_GUM_DROP)) {
            return i;
          }
          break;
        case SPECIAL_NOUGAT:
          if (board[i].equals(Spot.SPECIAL_NOUGAT)) {
            return i;
          }
          break;
      }
    }
    return 0;
  }
}
