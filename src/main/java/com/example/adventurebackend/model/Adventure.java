package com.example.adventurebackend.model;

import javax.persistence.*;

@Entity
public class Adventure {

  @Id
  @Column(name = "adventurecode")
  private String adventureCode;

  private String adventureName;
  private String groupName;

  public String getAdventureCode() {
    return adventureCode;
  }

  public void setAdventureCode(String adventureCode) {
    this.adventureCode = adventureCode;
  }

  public String getAdventureName() {
    return adventureName;
  }

  public void setAdventureName(String adventureName) {
    this.adventureCode = adventureName;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  @Override
  public String toString() {
    return "Adventure{"
        + "adventureCode='"
        + adventureCode
        + '\''
        + ", adventureName='"
        + adventureName
        + '\''
        + ", groupName='"
        + groupName
        + '\''
        + '}';
  }
}
