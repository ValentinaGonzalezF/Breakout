package main.java.logic.level;

import main.java.logic.brick.AbstracBrick;
import main.java.logic.brick.Brick;

import java.util.List;
import java.util.Observable;

public class ClassLevel extends AbstractLevel{
    public ClassLevel(String n, List<Brick> list){
        super(n,list);
    }

    @Override
    public boolean hasNextLevel() {
        return nextLevel!=null;
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
