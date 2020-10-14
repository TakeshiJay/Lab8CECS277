/**Door is the interface class where all subtypes may be extended upon it*/
public interface Door {
  /** examine just returns the String when you first encounter*/
  public String examine();
  /** menu just returns the String value of the menu(re-loops) */
  public String menu();
  /** unlock is the users attempt to unlock the door trying to solve for the true answer
  * @param option is the current players option which is chosen in Main.java under the method getPositiveInt
  */
  public String unlock(int option);
  /**open tests whether the users input is true to the value of the door being unlocked*/
  public boolean open();
  /**clue is just a helpful tip incase the player cannot get the correct answer*/
  public String clue();
  /** success just returns the message that you have unlocked the door*/
  public String success();
}