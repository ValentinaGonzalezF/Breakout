package logic.brick;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GlassBrickTest {
    private Brick glassBrick;

    @Before
    public void create(){
        glassBrick=new GlassBrick();
    }

    @Test
    public void isDestroy(){
        assertFalse(glassBrick.isDestroyed());
        glassBrick.hit();
        assert(glassBrick.isDestroyed());
    }

    @Test
    public void remainingHits(){
        assertEquals(1, glassBrick.remainingHits());
    }


    @Test
    public void accept() {
    }
}