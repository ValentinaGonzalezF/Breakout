package graphics;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

public class PlayerControl extends Component {
    private PhysicsComponent physics;
    private boolean playerWallLeft;
    private boolean playerWallRight;

    public PlayerControl(){
        physics=null;
    }
    public void setPlayerWallLeft(boolean a){
        playerWallLeft=a;
    }
    public void setPlayerWallRight(boolean a){
        playerWallRight=a;
    }
    public void setVelocity(double d){
        physics.setVelocityX(d);
    }

    public void left() {
        if (!playerWallLeft){
            physics.setVelocityX(-70);
            if(playerWallRight){
                playerWallRight=false;
            }
        }
    }
    public void right() {
        if (!playerWallRight){
            physics.setVelocityX(70);
            if(playerWallLeft){
                playerWallLeft=false;
            }
        }
    }
    public void stop() {
        physics.setVelocityX(0);
    }
}
