//class that will contain methods and instance variables associated with the players.
class Game {
  // instance variables
  private int baseHP;
  private int pcHP;
  private int yourHP;
  private boolean isCrit;

  // use of composition to access methods of the class Draw
  Draw draw;

  // no-argument constructor to assign the instance variables
  Game() {
    this.baseHP = 150;
    this.yourHP = baseHP;
    pcHP = baseHP;

    // when a new object is instantiated, we will also instantiate an object of the
    // class draw
    draw = new Draw();
  }

  // getters and setters to set and get instance variables appropriately
  public int getYourHP() {
    return yourHP;
  }

  public int getPcHP() {
    return pcHP;
  }

  public void setYourHP(int yourHP) {
    this.yourHP -= yourHP;
  }

  public void setPcHP(int pcHP) {
    this.pcHP -= pcHP;
  }

  // method to check if a crit was rolled and return a boolean
  public boolean checkCrit(int rolled, int hp, int wager) {
    if (rolled == 1)
      isCrit = true;
    else
      isCrit = false;
    return isCrit;
  }

  // method to display information if the user rolled a crit else, reset HP of
  // user to baseHP
  public void usersCrit(boolean isCrit, int wager) {
    if (isCrit) {
      System.out.println("You rolled a crit!");
      System.out.println("You were awarded a " + (2 * wager) + " hp bonus.");
      if ((getYourHP() + wager) < baseHP) {
        yourHP += 2 * wager;
      } else {
        yourHP = baseHP;
      }

    }
  }

  // method to display information if the opponent rolled a crit else, reset HP of
  // opponent to baseHP
  public void opponentsCrit(boolean isCrit, int wager) {
    if (isCrit) {
      System.out.println("Opponent rolled a crit!");
      System.out.println("Opponent was awarded a " + (2 * wager) + " hp bonus.");

      if ((getPcHP() + wager) < baseHP) {
        pcHP += 2 * wager;
      } else {
        pcHP = baseHP;
      }

    }
  }

  // method to check how many HP left between user and opponent
  public void checkStatus() {
    if (getYourHP() > 0 && getPcHP() > 0) {
      System.out.println("You have " + getYourHP() + " left!");
      System.out.println("Your opponent has " + getPcHP() + " left!");
      draw.draw(getYourHP(), getPcHP(), baseHP);
    }
    draw.drawDivider();
  }

  // method to draw that will call method draw of class Draw
  public void draw() {
    // call
    draw.draw(getYourHP(), getPcHP(), baseHP);
    draw.drawDivider();
  }

}
