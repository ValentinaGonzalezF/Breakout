package main.java.controller;

/**
 * Game logic controller class.
 *
 * @author Juan-Pablo Silva
 */
public class Game {
    protected int balls;
    protected int totalscore;

    public Game(int balls) {
        this.balls=balls;
        totalscore=0;
    }

    public void aumentBalls(){
        balls++;
    }
    /**
     * This method is just an example. Change it or delete it at wish.
     * <p>
     * Checks whether the game has a winner or not
     *
     * @return true if the game has a winner, false otherwise
     */
    public boolean winner() {
        if (balls==0){
            return false;
        }
        //else if ()
        //si todos los niveles se pasaron
        return true;
    }








}
