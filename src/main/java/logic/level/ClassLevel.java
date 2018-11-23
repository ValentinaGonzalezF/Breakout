package logic.level;

import logic.brick.AbstracBrick;
import logic.brick.Brick;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ClassLevel extends AbstractLevel{
    public ClassLevel(String n, List<Brick> list){
        super(n,list);
        setNextLevel(new NullLevel("", new ArrayList<>()));
    }

    @Override
    public boolean hasNextLevel() {
        return this.nextLevel.isPlayableLevel();
    }

}
