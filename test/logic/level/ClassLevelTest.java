package logic.level;

import logic.brick.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClassLevelTest {
    private ClassLevel level;
    private List<Brick> lista;
    private List<Brick> l;
    private List<Brick> l1;
    private AbstractBrick a;
    private AbstractBrick b;
    private AbstractBrick c;
    private Level otroLevel;
    private Level brickLevel;
    private AbstractBrick e;

    @Before
    public void setUp() throws Exception {
        lista= new ArrayList<>();
        l= new ArrayList<>();
        l1= new ArrayList<>();
        a=new MetalBrick();
        b=new GlassBrick();
        c=new WoodenBrick();
        e=new WoodenBrick();
        lista.add(a);
        lista.add(b);
        lista.add(c);
        l1.add(e);
        level=new ClassLevel("0", lista);
        otroLevel=new NullLevel("",l);
        brickLevel=new ClassLevel("",l1);
    }

    @Test
    public void getName() {
        assertEquals("0",level.getName());
    }

    @Test
    public void getNumberOfBricks() {
        assertEquals(3,level.getNumberOfBricks());
    }

    @Test
    public void getBricks() {
        assertEquals(lista,level.getBricks());
    }

    @Test
    public void getNextLevel() {
        level.setNextLevel(otroLevel);
        assertEquals(otroLevel,level.getNextLevel());
    }

    @Test
    public void isPlayableLevel() {
        assertTrue(level.isPlayableLevel());
    }

    @Test
    public void hasNextLevel() {
        assertFalse(level.hasNextLevel());
    }

    @Test
    public void getPoints() {
        assertEquals(250,level.getPoints());
    }

    @Test
    public void addPlayingLevel() {
        level.addPlayingLevel(brickLevel);
        assertEquals(brickLevel,level.getNextLevel());
    }

    @Test
    public void setNextLevel() {
        level.setNextLevel(otroLevel);
        assertEquals(otroLevel,level.getNextLevel());
        level.setNextLevel(brickLevel);
        assertEquals(brickLevel,level.getNextLevel());
    }

    @Test
    public void getActualPoints() {
        assertEquals(0,level.getActualPoints());
        b.hit();
        assertEquals(50,level.getActualPoints());
        a.hit();
        a.hit();
        a.hit();
        a.hit();
        a.hit();
        a.hit();
        a.hit();
        a.hit();
        a.hit();
        a.hit();
        assertEquals(50,level.getActualPoints());
        c.hit();
        c.hit();
        c.hit();
        assertEquals(250,level.getActualPoints());
    }

    @Test
    public void setUltimo() {
        level.setUltimo(new GlassBrick());
        assert(level.getUltimo().isGlass());
        level.setUltimo(new WoodenBrick());
        assert(level.getUltimo().isWooden());
    }

    @Test
    public void getUltimo() {
        level.setUltimo(new WoodenBrick());
        assert(level.getUltimo().isWooden());
    }

}