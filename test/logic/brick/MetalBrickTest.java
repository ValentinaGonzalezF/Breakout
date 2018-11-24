package logic.brick;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MetalBrickTest {
    private Brick metalBrick;

    @Before
    public void setUp() throws Exception {
        metalBrick=new MetalBrick();
    }

    @Test
    public void isDestroyed(){
        assertFalse(metalBrick.isDestroyed());
        metalBrick.hit();
        assertFalse(metalBrick.isDestroyed());
        metalBrick.hit();
        metalBrick.hit();
        metalBrick.hit();
        metalBrick.hit();
        metalBrick.hit();
        metalBrick.hit();
        metalBrick.hit();
        metalBrick.hit();
        metalBrick.hit();
        assert(metalBrick.isDestroyed());
    }

    @Test
    public void hit() {
        metalBrick.hit();
        assertEquals(9,metalBrick.remainingHits());
    }

    @Test
    public void getScore() {
        assertEquals(0,metalBrick.getScore());
    }

    @Test
    public void remainingHits() {
        assertEquals(10,metalBrick.remainingHits());
    }
 }