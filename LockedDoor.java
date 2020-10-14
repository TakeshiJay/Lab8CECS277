/**LockedDoor class implements the Door class and asks the user to look around for the key to open the door*/
import java.util.Random;

public class LockedDoor implements Door{
  /** KeyLocation is a randomly generated number that holds the key*/
  private int KeyLocation;
  /** KeyChoice the users choice that is used within the main but tested in the method open()*/
  private int KeyChoice;
  /**LockedDoor constructor generates a random number from 1-3 for the key location and sets *KeyChoice to 0; */
  public LockedDoor(){
    Random r = new Random();
    int big = 3;
    int small = 1;
    KeyLocation = r.nextInt(big)+small;
    KeyChoice = 0;
  }

  /** examine just returns the String when you first encounter a LockedDoor
  * @return a string describing the door type
  */
  @Override
  public String examine(){
    return "A door that can be opened with a key. Look around to see if you can find it";
  }

  /** menu just returns the String value of the menu(re-loops)
  *@return String message of the menu options for the locked door
  */
  @Override
  public String menu(){
    return "1. Look under the mat\n2. Look under the flower pot\n3. Look under fake rock";
  }

  /**The users option becomes the the KeyChoice and calls on the open method if the door is unlocked
  * @param option is decided in the main by the user
  * @return String message that you have found the key
  */
  @Override
  public String unlock(int option){
    this.KeyChoice = option;
    if (option == 1){
      if (open()==true){
        return "You have found the key";
      } else return clue();
    } else if (option == 2){
      if (open() == true){
        return "You have found the key";
      } else return clue();
    } else if (option == 3 ){
      if (open() == true){
        return "You have found the key";
      } else return clue();
    } return "Invalid option";
  } 
  /** If the keychoice matches the key location then open will return true else false
  * @return boolean 
  */
  @Override
  public boolean open(){
    if (KeyChoice == KeyLocation){
        return true;
    } else return false;
  }

  /** clue is just a helpful tip incase the player cannot get the correct answer
  *@return String message that the key is somewhere else
  */
  @Override
  public String clue(){
    return " Look somewhere else ";
  }

  /** success just returns the winning line when the player unlocks the door
  *@return String message that you have found the key and unlocked the door
  */
  @Override
  public String success(){
    return "Congratulations, you found the key and opened door";
  }
}



