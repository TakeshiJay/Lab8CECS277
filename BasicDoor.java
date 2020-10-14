import java.util.Random;
/**BasicDoor class is a simple door that opens or closes based off of it being pushed or pulled */
public class BasicDoor implements Door{
  /**push can be true or false based off of what kind of door it is(randomly selected)*/
  private boolean push;
  /**input will be verified/tested by the user in the main*/
  private boolean input;
  /**BasicDoor is the default constructor for the class and will give random value for push*/
  public BasicDoor(){
    Random ran = new Random();
    this.push = ran.nextBoolean();
  }
  /** examine just returns the String when you first encounter a BasicDoor
  * @return the String of the encounterment
  */
  @Override
  public String examine(){
    return "You encountered a basic door";
  }
  /** menu just returns the String value of the menu(re-loops)
  * @return the String value of the doors menu
  */
  @Override
  public String menu(){
    return "1. Push\n2. Pull";
  }
  /** unlock is the users attempt to unlock the door with pushing or pulling being the true answer
  * @param option is the current players option which is chosen in Main.java under the method getPositiveInt
  * @return the String value of whether the statement tested is true or not 
  */
  @Override
  public String unlock(int option){
    while(option >= 1 && option <= 2){
      if(option == 1 && this.push == true){
        this.input = true;
        return "You push the door";
    } else if (option == 1 && this.push == false){
        return "You push the door\n" +clue();
      } else if (option == 2 && this.push == false){
        this.input = true;
        return "You pull the door";
      } 
      return "You pull the door\n" +clue();
    } return null;
  }
  /**open tests whether the users input is true to the value of the door being unlocked*/
  @Override
  public boolean open(){
    if (this.input == true){
      return true;
    } 
    return false;
  }
  /**clue is just a helpful tip incase the player cannot get the correct answer
  * @return the string of the clue given to the player
  */
  @Override
  public String clue(){
    return "Try the other option";
  }
  /**success just returns the winning line when the player unlocks the door
  * @return the String of the Congratulations you completed this door 
  */
  @Override
  public String success(){
    return "Congratulations, you opened a door";
  }
}