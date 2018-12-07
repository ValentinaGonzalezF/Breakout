package graphics;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.NodeBuilder;
import javafx.scene.input.KeyCode;

import static graphics.ExampleGameFactory.newBackground;
import static graphics.ExampleGameFactory.newBall;
import static graphics.ExampleGameFactory.newPlayer;


public class BasicApp extends GameApplication {
    private Entity player;
    public enum ExampleType {
        PLAYER,BALL,WALL
    }
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(800);
        gameSettings.setTitle("Break Out");
        gameSettings.setVersion("");
    }

    public static void main(String... args) {
        launch(args);
    }
    @Override
    protected void initPhysics() {
        getPhysicsWorld().setGravity(0,0);
        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(ExampleType.BALL, ExampleType.WALL) {
                    @Override
                    protected void onHitBoxTrigger(Entity ball, Entity wall,
                                                   HitBox boxBall, HitBox boxWall) {
                        if (boxWall.getName().equals("BOT")) {
                            ball.removeFromWorld();
                        }
                    }
                });
    }
    @Override
    protected void initGame() {
        Entity bg= newBackground();
        player = newPlayer(350, 550);
        Entity ba=newBall(350,200);
        getGameWorld().addEntities(bg,player,ba);
    }

    @Override
    protected void initInput() {
        Input input = getInput();
        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                getGameWorld().getEntitiesByType(ExampleType.PLAYER)
                        .forEach(e -> e.translateX(5));
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                getGameWorld().getEntitiesByType(ExampleType.PLAYER)
                        .forEach(e -> e.translateX(-5));
            }
        }, KeyCode.LEFT);

    }


}