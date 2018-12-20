package controller;

import logic.brick.*;
import org.junit.Before;
import org.junit.Test;
import logic.level.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class GameTest {
    private Game game;
    private Level level;
    private List<Brick> lista;
    private final int seed = 0;
    private Level level2;
    private Level level3;
    private Level level4;
    private Level level5;
    private List<Brick> lista2;
    private AbstractBrick a;
    private AbstractBrick b;
    private AbstractBrick c;
    private AbstractBrick d;
    private AbstractBrick e;
    private List<Brick> lista3;
    private List<Brick> lista5;

    @Before
    public void setUp() throws Exception {
        game=new Game(3);
        lista= new ArrayList<>();
        lista2= new ArrayList<>();
        lista3= new ArrayList<>();
        a=new GlassBrick();
        b=new MetalBrick();
        c= new WoodenBrick();
        d=new WoodenBrick();
        e=new GoldenBrick();
        lista2.add(a);
        lista2.add(b);
        lista2.add(c);
        lista3.add(d);
        level=new NullLevel("",lista);
        level2=new NullLevel("",lista);
        level3=new ClassLevel("Level 3", lista2);
        level4=new ClassLevel("Level 4", lista3);
        lista3.add(e);
        level5= new ClassLevel("Level 5",lista3);
    }

    @Test
    public void addBall() {
        assertEquals(3,game.getBallsLeft());
        game.addBall();
        assertEquals(4,game.getBallsLeft());
        game.setCurrentLevel(level3);
        b.hit();
        b.hit();
        b.hit();
        b.hit();
        b.hit();
        b.hit();
        b.hit();
        b.hit();
        b.hit();
        b.hit();
        assertEquals(5,game.getBallsLeft());
    }

    @Test
    public void newLevelWithBricksFull() {
        //produce nivel solo con WoodenBricks
        level2 = game.newLevelWithBricksFull("Level 2", 10, 0, 0.0, seed);
        assertEquals("Level 2", level2.getName());
        assertEquals(10,level2.getNumberOfBricks());
        assertEquals(10*200,level2.getPoints());
    }

    @Test
    public void newLevelWithBricksNoMetal() {
        level2 = game.newLevelWithBricksNoMetal("Level 1", 20, 1, seed);
        assertEquals(20,level2.getNumberOfBricks());
        assertEquals(50*20,level2.getPoints());
        assertEquals("Level 1", level2.getName());
    }
    @Test
    public void newLevelWithBricks(){
        level2=game.newLevelWithBricks("Level 1",20,1,0.5,seed);
        assertEquals(30,level2.getNumberOfBricks());
        assertEquals(2000,level2.getPoints());

        level2=game.newLevelWithBricks("Level 1",20,0.9,0.5,seed);
        assertEquals(30,level2.getNumberOfBricks());
        assertEquals(2450,level2.getPoints());


    }

    @Test
    public void numberOfBricks() {
        level2 = game.newLevelWithBricksNoMetal("Level 3", 5,1,seed);
        game.setCurrentLevel(level2);
        assertEquals(5,game.numberOfBricks());
    }

    @Test
    public void getBricks(){
        level2=new ClassLevel("Level 5", lista2);
        game.setCurrentLevel(level2);
        assertEquals(lista2,game.getBricks());
    }

    @Test
    public void hasNextLevel() {
        assertFalse(game.currentLevel.hasNextLevel());
        level2 = game.newLevelWithBricksFull("Level 3", 5,0.4,0,seed);
        game.addPlayingLevel(level2);
        assertFalse(game.hasNextLevel());
    }

    @Test
    public void goNextLevel() {
        game.setCurrentLevel(level3);
        assertEquals(level3,game.getCurrentLevel());
        game.addPlayingLevel(level4);
        game.goNextLevel();
        assertEquals(level4,game.getCurrentLevel());
    }

    @Test
    public void hasCurrentLevel() {
        assertFalse(game.hasCurrentLevel());
        level2 = game.newLevelWithBricksFull("Level 3", 5,0.1,1,seed);
        game.addPlayingLevel(level2);
        assert(game.hasCurrentLevel());
    }

    @Test
    public void getLevelName() {
        assertEquals("",game.getLevelName());
        level2 = game.newLevelWithBricksNoMetal("Level 3", 5,1,seed);
        game.addPlayingLevel(level2);
        assertEquals("Level 3",game.getLevelName());
    }

    @Test
    public void getCurrentLevel() {
        game.setCurrentLevel(level);
        assertEquals(level,game.currentLevel);
    }

    @Test
    public void setCurrentLevel() {
        game.setCurrentLevel(level);
        assertEquals(level,game.currentLevel);
        level2 = game.newLevelWithBricksNoMetal("Level 3", 5,0.4,seed);
        game.setCurrentLevel(level2);
        assertEquals(level2,game.getCurrentLevel());
    }

    @Test
    public void addPlayingLevel() {
        game.setCurrentLevel(level);
        level3=new ClassLevel("Level 5", lista2);
        game.addPlayingLevel(level2);
        assertEquals(level2,game.getCurrentLevel());
    }

    @Test
    public void getLevelPoints() {
        level3=new ClassLevel("Level 5", lista2);
        game.setCurrentLevel(level3);
        assertEquals(a.getScore()+b.getScore()+c.getScore(),game.getLevelPoints());
    }

    @Test
    public void getCurrentPoints() {
        assertEquals(0,game.getCurrentPoints());
        game.setCurrentLevel(level3);
        a.hit();
        assertEquals(50,game.getCurrentPoints());
    }

    @Test
    public void getBallsLeft() {
        assertEquals(3,game.getBallsLeft());
    }

    @Test
    public void dropBall() {
        assertEquals(3,game.getBallsLeft());
        game.dropBall();
        assertEquals(2,game.getBallsLeft());
        game.setCurrentLevel(level5);
        repeat(15, () -> e.hit());
        assertEquals(1,game.getBallsLeft());
    }

    @Test
    public void isGameOver() {
        assertFalse(game.isGameOver());
        game.dropBall();
        game.dropBall();
        game.dropBall();
        assert(game.isGameOver());

        game.addBall();
        game.setCurrentLevel(level4);
        d.hit();
        d.hit();
        d.hit();
        assert(game.isGameOver());
    }

    @Test
    public void winner() {
        assertFalse(game.winner());
        game.setCurrentLevel(level4);
        d.hit();
        d.hit();
        d.hit();
        assert(game.winner());
    }
    private void repeat(int n, Runnable action) {
        IntStream.range(0, n).forEach(i -> action.run());
    }

}