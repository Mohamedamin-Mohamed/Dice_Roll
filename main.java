import java.util.*;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    boolean rollAgain = true;

    // instantiate an object of class Game and Play, and use it methods 
appropriately
    Game game = new Game();
    Play play = new Play();

    //loop that will run until game its either a tie, win or lose
    while (rollAgain) {
      
      // call method playGame of class Play until game cannot be played
      rollAgain = play.playGame(game, rollAgain, scan);

    }
    
    afterGame(game);
  }
  
  // method to decide whether the game its either a tie, win or lose
  public static void afterGame(Game game) {
    //draw method of class draw to draw divdier
    game.draw();
    
    //if users HP is greater than opponents HP, user wins 
    if (game.getYourHP() > game.getPcHP()) {
      System.out.println("You win!");
    } else if (game.getYourHP() == game.getPcHP()) {
      System.out.println("It's a tie!");
    } 
      //user lost
    else {
      System.out.println("You lose!");
    }
  }
}
