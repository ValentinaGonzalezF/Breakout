package main.java.controller;

import main.java.logic.brick.Brick;
import main.java.logic.brick.GlassBrick;
import main.java.logic.brick.MetalBrick;
import main.java.logic.brick.WoodenBrick;
import main.java.logic.level.ClassLevel;
import main.java.logic.level.Level;
import main.java.logic.level.NullLevel;

import java.util.*;
/**
 * Game logic controller class.
 *
 * @author Juan-Pablo Silva
 */
public class Game implements Observer{
    protected int balls;
    protected int totalscore;
    protected Level currentLevel;
    protected int counter;

    public Game(int balls) {
        this.balls=balls;
        totalscore=0;
        List<Brick> list= new ArrayList<>();
        currentLevel=new NullLevel("",list);
        counter=0;
    }

    public void addBall(){
        balls++;
    }

    public Level newLevelWithBricksFull(String name, int numberOfBricks, double probOfGlass, double probOfMetal, int seed) {
        List<Brick> lista=new ArrayList<>();
        Random generator = new Random(seed);
        int i=0;
        int wooden,glaas,metal;
        wooden=glaas=metal=0;
        while (i!=numberOfBricks){
            double numero= generator.nextDouble();
            if (numero<=probOfGlass){
                Brick brick;
                brick= new GlassBrick();
                lista.add(brick);
                glaas++;
            }
            else{
                Brick brick;
                brick= new WoodenBrick();
                lista.add(brick);
                wooden++;
            }
            i++;
        }
        i=0;
        while (i!=numberOfBricks){
            if(generator.nextDouble()<=probOfMetal) {
                Brick brick1;
                brick1 = new MetalBrick();
                lista.add(brick1);
                metal++;
            }
            i++;
        }
        Level a= new ClassLevel(name,lista);
        return a;
    }

    public Level newLevelWithBricksNoMetal(String name, int numberOfBricks, double probOfGlass, int seed) {
        List<Brick> lista=new ArrayList<>();
        Random generator = new Random(seed);
        int i=0;
        int wooden,glaas,metal;
        wooden=glaas=metal=0;
        while (i!=numberOfBricks){
            Brick brick;
            double numero= generator.nextDouble();
            if (numero<=probOfGlass){
                brick= new GlassBrick();
                glaas++;
            }
            else{
                brick= new WoodenBrick();
                wooden++;
            }
            lista.add(brick);
            i++;
        }
        Level a= new ClassLevel(name,lista);
        return a;
    }
    /**
     * Gets the number of {@link Brick} in the current level, that are still not destroyed
     *
     *
     * @return the number of intact bricks in the current level
     */
    public int numberOfBricks() {
        int alive=0;
        for(Brick brick: currentLevel.getBricks()){
            if (!brick.isDestroyed()){
                alive++;
            }
        }
        return alive;
    }

    /**
     * Gets the list of {@link Brick} in the current level.
     *
     * @return the list of bricks
     */
    public List<Brick> getBricks() {
        return  currentLevel.getBricks();
    }

    /**
     * Whether the current {@link Level}'s next level is playable or not.
     *
     * @return true if the current level's next level is playable, false otherwise
     */
    public boolean hasNextLevel() {
        return currentLevel.hasNextLevel();
    }

    /**
     * Pass to the next level of the current {@link Level}. Ignores all conditions and skip to the next level.
     */
    public void goNextLevel() {
        currentLevel=currentLevel.getNextLevel();
    }

    /**
     * Gets whether the current {@link Level} is playable or not.
     *
     * @return true if the current level is playable, false otherwise
     */
    public boolean hasCurrentLevel() {
        return false;
    }

    /**
     * Gets the name of the current {@link Level}.
     *
     * @return the name of the current level
     */
    public String getLevelName() {
        return currentLevel.getName();
    }

    /**
     * Gets the current {@link Level}.
     *
     * @return the current level
     * @see Level
     */
    public Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Sets a {@link Level} as the current playing level.
     *
     * @param level the level to be used as the current level
     * @see Level
     */
    public void setCurrentLevel(Level level) {
        currentLevel=level;
    }

    /**
     * Adds a level to the list of {@link Level} to play. This adds the level in the last position of the list.
     *
     * @param level the level to be added
     */
    public void addPlayingLevel(Level level) {
        currentLevel.addPlayingLevel(level);

    }

    /**
     * Gets the number of points required to pass to the next level. Gets the points obtainable in the current {@link Level}.
     *
     * @return the number of points in the current level
     */
    public int getLevelPoints() {
        return currentLevel.getPoints();
    }
    /**
     * Gets the accumulated points through all levels and current {@link Level}.
     *
     * @return the cumulative points
     */
    public int getCurrentPoints() {
        return totalscore;
    }

    /**
     * Gets the current number of available balls to play.
     *
     * @return the number of available balls
     */
    public int getBallsLeft() {
        return balls;
    }

    /**
     * Reduces the count of available balls and returns the new number.
     *
     * @return the new number of available balls
     */
    public int dropBall() {
        balls--;
        return balls;
    }

    /**
     * Checks whether the game is over or not. A game is over when the number of available balls are 0 or the player won the game.
     *
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return false;
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

    @Override
    public void update(Observable observable, Object o) {

    }
}
