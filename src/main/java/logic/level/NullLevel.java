package main.java.logic.level;
import main.java.logic.brick.AbstracBrick;
import main.java.logic.brick.Brick;
import java.util.*;

public class NullLevel implements Level{

    protected String name;
    protected int bricksNumber;
    protected int points;
    protected List<Brick> brickList;
    protected Level nextLevel;
    public NullLevel(){
        bricksNumber=0;
        name="";
        points=0;
        brickList= new ArrayList<Brick>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfBricks() {
        return 0;
    }

    @Override
    public List<Brick> getBricks() {
        return null;
    }

    @Override
    public Level getNextLevel() {
        return null;
    }

    @Override
    public boolean isPlayableLevel() {
        return false;
    }

    @Override
    public boolean hasNextLevel() {
        return false;
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public Level addPlayingLevel(Level level) {
        return null;
    }

    @Override
    public void setNextLevel(Level level) {

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
