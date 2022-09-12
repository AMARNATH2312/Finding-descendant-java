package toFindDescendant;

import java.util.ArrayList;
import java.util.HashMap;

public class FamilyMember {
  public static HashMap<String, FamilyMember> familyRef = new HashMap<String, FamilyMember>();
  private String name;
  private ArrayList<FamilyMember> sons = new ArrayList<FamilyMember>();

  public FamilyMember(String name, String father) {
    this.name = name;
    familyRef.put(name, this);
    setFather(father, this);
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<FamilyMember> getSons() {
    return this.sons;
  }

  public void setFather(String father, FamilyMember son) {
    if (father == null) {
      return;
    }
    if (!familyRef.containsKey(father)) {
      familyRef.put(father, new FamilyMember(father, null));
    }
    familyRef.get(father).sons.add(son);
  }

  public static void findDescendant(String name, int level) {
    if (familyRef.get(name).getSons().size() <= 0) {
      return;
    }
    ArrayList<FamilyMember> descendants = familyRef.get(name).getSons();
    for (FamilyMember descendant : descendants) {
      if (level == 1) {
        System.out.println(descendant.getName());
        continue;
      }
      findDescendant(descendant.getName(), level - 1);
    }
  }
}
