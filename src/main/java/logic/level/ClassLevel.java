package main.java.logic.level;

import main.java.logic.brick.AbstracBrick;
import main.java.logic.brick.Brick;

import java.util.List;
import java.util.Observable;

public class ClassLevel extends Observable implements Level {
    protected String name;
    protected int bricksNumber;
    protected int points;
    protected List<Brick> brickList;
    public Level nextLevel;
    public ClassLevel(String n,int b,int p, List<Brick> list){
        bricksNumber=b;
        name=n;
        points=p;
        brickList=list;
        nextLevel=null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumberOfBricks() {
        return bricksNumber;
    }

    @Override
    public List<Brick> getBricks() {
        return brickList;
    }

    @Override
    public Level getNextLevel() {
        return nextLevel;
    }

    @Override
    //duda
    public boolean isPlayableLevel() {
        return true;
    }

    @Override
    public boolean hasNextLevel() {
        return nextLevel!=null;
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public Level addPlayingLevel(Level level) {
        Level t = level;
        while (!(t.getNextLevel() instanceof NullLevel)){
           t=t.getNextLevel();
        }
        t.setNextLevel(level);
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
