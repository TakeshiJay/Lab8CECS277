import java.util.Random;

public class ComboDoor implements Door { 
  private int comboValue;
  private int guess;
  
  public ComboDoor(){
    Random r = new Random();
    int big = 10;
    int small = 1;
    comboValue = r.nextInt(big)+small;
    guess = 0;
  }
  /** examine just returns the String when you first encounter
  * @return the String of the encounterment
  */
  public String examine(){
    return "You encounter a door with a combination lock.";
  }
  /** menu just returns the String value of the menu(re-loops) */
  public String menu(){
    return "Enter a number between(1-10):";
  }
  /** unlock is the users attempt to unlock the door trying to solve for the true answer
  * @param option is the current players option which is chosen in Main.java under the method getPositiveInt
  */
  public String unlock(int option){
    String yDial = "you turn the dial...";
    this.guess = option;
    if (open() == true){
      System.out.println(yDial);
      return "You have entered the correct number";
    }
    return clue();    
  }
  /**open tests whether the users input is true to the value of the door being unlocked
  * @return boolean values based off of whether the comboValue is equivalent to the guess value
  */
  public boolean open(){
    if (guess == comboValue){
      return true;
    } return false;
  }
  /**clue is just a helpful tip incase the player cannot get the correct answer
  * @return the string of the clue given to the player
  */
  public String clue(){
    if (comboValue < guess){
      return "You feel resistance as you turn the dial, it must be lower.";
    } return "You feel resistance as you turn the dial, it must be higher.";
  }
  /**success just returns the winning line when the player unlocks the door
  * @return the String of the Congratulations you completed this door 
  */
  public String success(){
    return "You found the right value and opened the door.";
  }
}