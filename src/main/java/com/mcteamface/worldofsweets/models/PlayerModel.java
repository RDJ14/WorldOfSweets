package com.mcteamface.worldofsweets;

import java.util.UUID;
import java.io.Serializable;

public class PlayerModel implements Serializable {
  private String mId;
  private String mName;
  private String mPieceId;
  private int mLocation;
  private boolean mAI;
  private int mBoomerangs;

  public PlayerModel(String name) {
    mId = UUID.randomUUID().toString();
    mName = name;
    mLocation = 0;
    mBoomerangs = 0;
  }

  public void setBoomerangs(int boomerangs) {
		mBoomerangs = boomerangs;
  }

  public int getBoomerangs() {
		return mBoomerangs;
  }

  public boolean hasBoomerang() {
		return mBoomerangs != 0;
  }

  public boolean useBoomerang() {
	  if (mBoomerangs == 0) {
		  return false;
	  }
	  mBoomerangs--;
	  return true;
  }

  public String getId() {
		return mId;
	}

  public String getName() {
		return mName;
	}

  public void assignPiece(String pieceId) {
    mPieceId = pieceId;
  }

  public boolean checkPiece(String pieceId) {
    return mPieceId.equals(pieceId);
  }

  public void setLocation(int location) {
    mLocation = location;
  }

  public int getLocation() {
    return mLocation;
  }

  public void setAI(boolean ai) {
    mAI = ai;
  }

  public boolean isAI() {
    return mAI;
  }
}
