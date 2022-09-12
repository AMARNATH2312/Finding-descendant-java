package toFindDescendant;

public class TestBench {
  public static void main(String args[]) {
    new FamilyMember("ram", "thasarathan");
    new FamilyMember("lakshman", "thasarathan");
    new FamilyMember("lavan", "ram");
    new FamilyMember("kushan", "ram");
    FamilyMember.findDescendant("thasarathan", 2);
  }
}
