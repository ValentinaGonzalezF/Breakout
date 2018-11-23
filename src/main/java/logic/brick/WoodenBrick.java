package logic.brick;
import controller.Game;
import logic.VisitorLevel;

public class WoodenBrick extends AbstracBrick {
    public WoodenBrick(){
        super();
        hitPoints=3;
        score=200;
    }

    public void accept(VisitorLevel v){
        v.visitWoodenBrick(this);
    }
}