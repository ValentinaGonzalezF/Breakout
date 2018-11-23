package logic.brick;
import controller.Game;
import logic.VisitorLevel;


public class MetalBrick extends AbstracBrick {
    public MetalBrick(){
        super();
        hitPoints=10;
    }

    @Override
    public void accept(VisitorLevel v) {
        v.visitMetalBrick(this);
    }
}
