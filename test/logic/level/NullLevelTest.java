package logic.level;

import logic.brick.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NullLevelTest {
    private Level level;
    private List<Brick> lista;
    private List<Brick> l;
    private AbstractBrick a;
    private AbstractBrick b;
    private Level brickLevel;
    @Before
    public void setUp() throws Exception {
        lista= new ArrayList<>();
        l= new ArrayList<>();
        a=new MetalBrick();
        b=new GlassBrick();
        lista.add(a);
        lista.add(b);
        level=new NullLevel("",l);
        brickLevel=new ClassLevel("n",lista);
    }

    @Test
    public void getName() {
        assertEquals("",level.getName());
    }

    @Test
    public void getNumberOfBricks() {
        assertEquals(0,level.getNumberOfBricks());
    }

    @Test
    public void getBricks() {
        assertEquals(l,level.getBricks());
    }

    @Test
    public void getNextLevel() {
        assertEquals(level,level.getNextLevel());
    }

    @Test
    public void isPlayableLevel() {
        assertFalse(level.isPlayableLevel());
    }

    @Test
    public void hasNextLevel() {
        assertFalse(level.hasNextLevel());
    }

    @Test
    public void getPoints() {
        assertEquals(0,level.getActualPoints());
    }

    @Test
    public void addPlayingLevel() {
        assertEquals(level,level.getNextLevel());
        level.addPlayingLevel(brickLevel);
        assertEquals(brickLevel,level.getNextLevel());
    }

    @Test
    public void setNextLevel() {
        level.setNextLevel(brickLevel);
        assertEquals(brickLevel,level.getNextLevel());
    }

    @Test
    public void getActualPoints() {
        assertEquals(0,level.getActualPoints());
    }

}