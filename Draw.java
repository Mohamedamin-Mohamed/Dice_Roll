//class that will contain method to print divider and draw the players stats

class Draw {

  // method to draw board
  public void draw(int youHP, int theyHP, int baseHP) {

    drawDivider();
    System.out.print("Your HP: ");
    for (int i = 0; i <= youHP; i++) {
      System.out.print("+");
    }

    int numLineDraw = youHP;
    if (numLineDraw < 0) {
      numLineDraw = 0;
    }

    for (int i = 0; i < (baseHP - numLineDraw); i++) {
      System.out.print("-");
    }
    System.out.print(" (" + youHP + ")");

    System.out.println("");

    System.out.print("PC HP:   ");
    for (int i = 0; i <= theyHP; i++) {
      System.out.print("+");
    }

    numLineDraw = theyHP;
    if (numLineDraw < 0) {
      numLineDraw = 0;
    }
    for (int i = 0; i < (baseHP - numLineDraw); i++) {
      System.out.print("-");
    }
    System.out.print(" (" + theyHP + ")");
    System.out.println("");
  }

  // method to draw a divider that will divide display of user and opponent stats
  public void drawDivider(){
    System.out.println("+--------------------------------------" + 
    "----------------------------------------------------------" +
    "---------------------------+");
  }

}
