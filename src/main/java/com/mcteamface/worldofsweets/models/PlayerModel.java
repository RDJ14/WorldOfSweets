package com.mcteamface.worldofsweets;

import java.util.UUID;
import java.io.Serializable;

public class PlayerModel implements Serializable {
  private String mId;
  private String mName;
  private String mPieceId;
  private int mLocation;

  public PlayerModel(String name) {
    mId = UUID.randomUUID().toString();
    mName = name;
    mLocation = 0;
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
}
