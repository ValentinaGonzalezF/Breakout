package logic.brick;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GlassBrickTest {
    private Brick glassBrick;

    @Before
    public void setUp() throws Exception {
        glassBrick=new GlassBrick();
    }

    @Test
    public void isDestroyed(){
        assertFalse(glassBrick.isDestroyed());
        glassBrick.hit();
        assert(glassBrick.isDestroyed());
    }

    @Test
    public void hit() {
        glassBrick.hit();
        assertEquals(0,glassBrick.remainingHits());
    }

    @Test
    public void getScore() {
        assertEquals(50,glassBrick.getScore());
    }

    @Test
    public void remainingHits() {
        assertEquals(1,glassBrick.remainingHits());
    }

    @Test
    public void isWooden(){
        assertFalse(glassBrick.isWooden());
    }
    @Test
    public void isMetal(){
        assertFalse(glassBrick.isMetal());
    }
    @Test
    public void isGlass(){
        assert(glassBrick.isGlass());
    }
    @Test
    public void isGolden(){
        assertFalse(glassBrick.isGolden());
    }

}