package logic.brick;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WoodenBrickTest {
    private Brick woodenBrick;

    @Before
    public void setUp() throws Exception {
        woodenBrick=new WoodenBrick();
    }

    @Test
    public void hit() {
        woodenBrick.hit();
        woodenBrick.hit();
        assertEquals(1,woodenBrick.remainingHits());
    }

    @Test
    public void isDestroyed() {
        woodenBrick.hit();
        assertFalse(woodenBrick.isDestroyed());

    }

    @Test
    public void getScore() {
        assertEquals(200,woodenBrick.getScore());
    }

    @Test
    public void remainingHits() {
        woodenBrick.hit();

    }
    @Test
    public void isWooden(){
        assert(woodenBrick.isWooden());
    }
    @Test
    public void isMetal(){
        assertFalse(woodenBrick.isMetal());
    }
    @Test
    public void isGlass(){
        assertFalse(woodenBrick.isGlass());
    }
    @Test
    public void isGolden(){
        assertFalse(woodenBrick.isGolden());
    }

}