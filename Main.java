import java.util.Scanner;
import java.util.Random;
/**
* Group 10
* @author Jacob Sunia
* @author Giovanni Contreras
*/
class Main {
  /**Main method where 3 doors are randomly selected and user has to get through random doors
  * @param args no comman arguments for this method
  */
  public static void main(String[] args) {
    Random rand = new Random();

    int j = 3;
    do {
      int i = rand.nextInt(4);
      if (i == 0){
        BasicDoor bd = new BasicDoor();
        System.out.println(bd.examine());
        openDoor(bd);
        System.out.println();
        j -= 1;
      } else if (i == 1){
        DeadboltDoor ded = new DeadboltDoor();
        System.out.println(ded.examine());
        openDoor(ded);
        System.out.println();
        j -= 1;
      } else if (i == 2){
        LockedDoor ld = new LockedDoor();
        System.out.println(ld.examine());
        openDoor(ld);
        System.out.println();
        j -= 1;
      } else {
        ComboDoor cd = new ComboDoor();
        System.out.println(cd.examine());
        openDoor(cd);
        System.out.println();
        j -= 1;
      }
    } while(j != 0);
    System.out.println("\nYou have escaped and beat the impossible doors");
  }
  /** openDoor method tries to unlock and will take getPositiveInt to attempt to unlock the door
  * @param d the door type that will try to be opened
  */
  public static void openDoor(Door d){
    while(d.open() == false){
      System.out.println(d.menu());
      System.out.println(d.unlock(getPositiveInt()));
    } System.out.println(d.success());
  }
  /** getPositiveInt takes the user input between 1-10 but varies based off of type of door.
  */
  public static int getPositiveInt(){
    Scanner sc = new Scanner(System.in);
    int input = CheckInput.getIntRange(1,10);
    return input;
  }
}