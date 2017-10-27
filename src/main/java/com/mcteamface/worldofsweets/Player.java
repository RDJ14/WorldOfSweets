package com.mcteamface.worldofsweets;

public class Player{

  int playersNumber;
  String playersName;
  int position;
  //Image playersToken;

  public Player(int playersNumber, String playersName, int position){
      this.playersNumber = playersNumber;
      this.playersName = playersName;
      this.position = position;
  }

  public void setPlayersName(String playersName){
    this.playersName = playersName;
  }

  public void setPosition(int position){
    this.position = position;
  }

  //TODO
  public void setToken(String filePath){

  }

  public int getPosition(){
    return position;
  }

  public String getName(){
    return playersName;
  }

}
