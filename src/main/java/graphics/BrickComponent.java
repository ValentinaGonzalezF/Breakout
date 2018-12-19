package graphics;

import com.almasb.fxgl.app.FXGL;
import logic.brick.Brick;
import com.almasb.fxgl.entity.component.Component;

public class BrickComponent extends Component {
    private Brick brickC;
    private String string;
    public BrickComponent(Brick B){
        brickC=B;
    }

    public Brick getComponent(){
        return brickC;
    }
    public void crackedBrickset() {
        if(brickC.isWooden()){
            if(brickC.remainingHits()==2){
                string="bonus.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }
        }
        else if(brickC.isMetal()) {
            if(brickC.remainingHits()==3){
                string="metalcracked2.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }
            else if(brickC.remainingHits()==6){
                string="metalcracked1.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }// uno a los 3 y otro a los 7

        }


    }
}
