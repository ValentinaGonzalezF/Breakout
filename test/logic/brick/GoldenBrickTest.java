package logic.brick;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GoldenBrickTest {
    private Brick goldenBrick;

    @Before
    public void setUp() throws Exception {
        goldenBrick=new GoldenBrick();
    }

    @Test
    public void isDestroyed(){
        assertFalse(goldenBrick.isDestroyed());
        goldenBrick.hit();
        goldenBrick.hit();
        goldenBrick.hit();
        goldenBrick.hit();
        goldenBrick.hit();
        goldenBrick.hit();
        assertFalse(goldenBrick.isDestroyed());
    }

    @Test
    public void hit() {
        goldenBrick.hit();
        assertEquals(14,goldenBrick.remainingHits());
    }

    @Test
    public void getScore() {
        assertEquals(1000,goldenBrick.getScore());
    }

    @Test
    public void remainingHits() {
        assertEquals(15,goldenBrick.remainingHits());
    }
    @Test
    public void isWooden(){
        assertFalse(goldenBrick.isWooden());
    }
    @Test
    public void isMetal(){
        assertFalse(goldenBrick.isMetal());
    }
    @Test
    public void isGlass(){
        assertFalse(goldenBrick.isGlass());
    }
    @Test
    public void isGolden(){
        assert(goldenBrick.isGolden());
    }
}