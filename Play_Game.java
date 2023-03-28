import java.util.*;

//class that we'll contain a boolean returning method that we'll use it to play the game
class Play {
  
  // method to play game that returns a boolean that stats if game can be played
  // or not
  public boolean playGame(Game game, boolean rollAgain, Scanner scan) {
    int pcDamage = 0;
    
    // call to check if both user and opponents HP is a positive integer
    if (game.getYourHP() > 0 && game.getPcHP() > 0) {
      // game is on
      rollAgain = true;
      System.out.println("How much HP would you like to wager (up to 10 HP)? ");
      int wager = Integer.parseInt(scan.nextLine());

      // players can only wager 10 or less HP
      if (wager > 10) {
        System.out.println("You can only wager up to 10 HP! Wagering 10 HP.");
        wager = 10;
      }
      // pass the wager points and reset the players hp
      game.setYourHP(wager);
      
      // roll dice and return the result
      int thisRoll = diceRoll();

      System.out.println("You rolled a: " + thisRoll);
      int playerDamage = thisRoll * wager;
      System.out.println("You did " + playerDamage + " damage to your opponent!");
      game.setPcHP(playerDamage);

      // check to see if user rolled a crit
      boolean isCrit = game.checkCrit(thisRoll, game.getYourHP(), wager);

      // if user rollled a crit, display information that the user rolled a crit and
      // was awarded HP bonus
      game.usersCrit(isCrit, wager);

      // get a random number for wager of the opponent
      wager = (int) (Math.random() * 10);
      System.out.println("Your opponent wagers " + wager + " hp!");

      // reset HP of opponent
      game.setPcHP(wager);
      thisRoll = diceRoll();
      System.out.println("Your opponent rolls a " + thisRoll);

      pcDamage = thisRoll * wager;
      System.out.println("Your opponent did " + pcDamage + " damage to you!");
      
      // subtract the damage incured by user by pcDamage and reset the users HP
      game.setYourHP(pcDamage);
      
      // check to see if opponent rolled a crit
      isCrit = game.checkCrit(thisRoll, game.getPcHP(), wager);

      // if opponent rolled a crit, display information that the opponent rolled a
      // crit and was awarded HP bonus
      game.opponentsCrit(isCrit, wager);

      // method to check how many hitpoints do the players left with
      game.checkStatus();
    }
    // if we get to here, the game is over (meaning a tie, win or lose)
    else {
      rollAgain = false;
    }
    
    // return if the game can be still be played or not . While loop in class Main
    // will decide
    return rollAgain;

    // return call to main method
  }

  // method to roll dice with random numbers
  public int diceRoll() {
    return (int) (Math.random() * 6) + 1;

  }
}
