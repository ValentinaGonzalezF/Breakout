package main.java.logic.level;
import main.java.logic.brick.AbstracBrick;
import main.java.logic.brick.Brick;
import java.util.*;

public class NullLevel extends AbstractLevel{

    public NullLevel(String n, List<Brick> list) {
        //valores cero
        super(n,list);
        this.nextLevel=this;
    }

    @Override
    public boolean isPlayableLevel() {
        return false;
    }
    //no se
    @Override
    public boolean hasNextLevel() {
        return false;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public Level addPlayingLevel(Level level) {
        return level;
    }

    @Override
    public void setNextLevel(Level level) {
        nextLevel=level;
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    @Override
    public void visitGlassBrick(AbstracBrick b) {

    }

    @Override
    public void visitWoodenBrick(AbstracBrick b) {

    }

    @Override
    public void visitMetalBrick(AbstracBrick b) {

    }
}
