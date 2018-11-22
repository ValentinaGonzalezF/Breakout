package main.java.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private int seed;
    @Before
    public void create(){
        game=new Game(3);
        seed=0;
    }

    @Test
    public void addBall() {
        game.addBall();
        assertEquals(4,game.balls);
    }

    @Test
    public void newLevelWithBricksFull() {
        game.newLevelWithBricksFull("Level 2",20,0.5,0.1,seed);
    }

    //@Test
    //public void newLevelWithBricksNoMetal() {
        //game.newLevelWithBricksNoMetal("Level 2",20,0,seed);
    //}

    //@Test
    //public void winner() {

    //}

    //@Test
    //public void update() {
    //}
}