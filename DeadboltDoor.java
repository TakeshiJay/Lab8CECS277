import java.util.Random;
/**DeadboltDoor is a door type that requires both bolts to be unlocked before door can open*/
public class DeadboltDoor implements Door {
  /** bolt1 is one of the bolts that the user is going to try to unlock if not already unlocked*/
  private boolean bolt1;
  /** bolt2 is one of the bolts that the user is going to try to unlock if not already unlocked*/
  private boolean bolt2;
  /**DeadboltDoor is the default constructor for the class and will give random value for bolt1 and bolt2*/
  public DeadboltDoor(){
    Random rand = new Random();
    this.bolt1 = rand.nextBoolean();
    this.bolt2 = rand.nextBoolean();
  }
  /**Examine just returns the String when you first encounter a DeadboltDoor
  * @return the String of the encounterment
  */
  public String examine(){
    return "You encounter a double deadbolt door, both deadbolts must be unlocked to open the door, but you can't tell if they're locked or unlocked.";
  }
  /** menu just returns the String value of the menu(re-loops)
  * @return the String value of the doors menu
  */
  public String menu(){
    return "1. Toggle Bolt 1\n2. Toggle Bolt 2";
  }
  /** unlock is the users attempt to unlock the door with bolt1 and bolt2 being true for both values
  * @param option is the current players option which is chosen in Main.java under the method getPositiveInt
  * @return the String value of whether the statement tested is true or if player needs a clue 
  */
  public String unlock(int option){
      String first = "You toggle the first bolt";
      String second = "You toggle the second bolt";
      if(option == 1 && this.bolt1 == false){
          this.bolt1 = true;
          return first;
      } else if(option == 2 && this.bolt2 == false){
          this.bolt2 = true;
          return second;
      } else if(option == 1 && this.bolt1 == true){    
          return first + clue();
      } else if(option == 2 && this.bolt2 == true){
          return second + clue();
      } return null;
  }
  /**open tests whether the users input is true to the value of the door being unlocked
  * @return boolean answer(true or false) based off of if the door is opened
  */
  public boolean open(){
    if (bolt1 == true && bolt2 == true){
      return true;
    } return false;
  }
  /**clue is just a helpful tip incase the player cannot get the correct answer
  * @return the string of the clue given to the player
  */
  public String clue(){
    return "You jiggle the door. It feels like one of the bolts is unlocked";
  }
  /**success just returns the winning line when the player unlocks the door
  * @return the String of the Congratulations you completed this door 
  */
  public String success(){
    return "Congratulations! You escaped...this time";
  }
}

