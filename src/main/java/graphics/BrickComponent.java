package graphics;

import logic.brick.Brick;
import com.almasb.fxgl.entity.component.Component;

public class BrickComponent extends Component {
    private Brick brickC;
    public BrickComponent(Brick B){
        brickC=B;
    }

    public Brick getComponent(){
        return brickC;
    }
}
