package graphics;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.gameplay.GameState;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.settings.GameSettings;
import com.sun.javafx.scene.control.skin.LabeledText;
import facade.HomeworkTwoFacade;
import javafx.beans.binding.Bindings;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.brick.Brick;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static graphics.ExampleGameFactory.*;


public class BasicApp extends GameApplication {
    private boolean initMovement=false;
    private boolean initContact=true;
    private Entity player;
    private Entity ball;
    private PlayerControl playerControl;
    private HomeworkTwoFacade facade;
    public enum ExampleType {
        PLAYER,BALL,WALL,BRICK,BRICKMETAL,LEVEL
    }
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(1000);
        gameSettings.setHeight(780);
        gameSettings.setTitle("BreakOut");
        gameSettings.setVersion("");
    }


    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(ExampleType.BALL, ExampleType.WALL) {
                    @Override
                    protected void onHitBoxTrigger(Entity ball, Entity wall,
                                                   HitBox boxBall, HitBox boxWall) {
                        if (boxWall.getName().equals("BOT")) {
                            ball.removeFromWorld();
                            facade.dropBall();
                            getGameState().setValue("lives", facade.getBallsLeft());
                            if(facade.getBallsLeft()>0){
                                ball.setPosition(player.getX()+50,player.getY()+50);
                                getGameWorld().addEntity(ball);
                                initMovement=false;
                                initContact=true;
                            }
                        }
                    }
                });

        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(ExampleType.PLAYER, ExampleType.WALL) {
                    @Override
                    protected void onHitBoxTrigger(Entity player, Entity wall,
                                                   HitBox boxPlayer, HitBox boxWall) {
                        if (boxWall.getName().equals("RIGHT")) {
                            playerControl.setVelocity(0);
                            playerControl.setPlayerWallRight(true);
                        }
                        if (boxWall.getName().equals("LEFT")) {
                            playerControl.setVelocity(0);
                            playerControl.setPlayerWallLeft(true);

                        }
                    }
                });
        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(ExampleType.BALL, ExampleType.BRICK) {
                    @Override
                    protected void onHitBoxTrigger(Entity ball, Entity brick,
                                                   HitBox boxBall, HitBox boxBrick) {
                            brick.removeFromWorld();
                            getAudioPlayer().playSound("Block_Destroy.wav");
                    }
                });
        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(ExampleType.BALL, ExampleType.BRICKMETAL) {
                    @Override
                    protected void onHitBoxTrigger(Entity ball, Entity brickMetal,
                                                   HitBox boxBall, HitBox boxBrickMetal) {
                        brickMetal.removeFromWorld();
                        getAudioPlayer().playSound("Block_Destroy.wav");
                    }
                });

        getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(ExampleType.BALL, ExampleType.PLAYER) {
                    @Override
                    protected void onHitBoxTrigger(Entity ball, Entity player,
                                                   HitBox boxBall, HitBox boxPlayer) {
                        if(initMovement){
                            getAudioPlayer().playSound("Ball_Bounce.wav");
                        }
                    }
                });


    }
    @Override
    protected void initGame() {
        Entity bg= newBackground();
        player = newPlayer(460, 710);
        playerControl = player.getComponent(PlayerControl.class);
        Entity walls=newWalls();
        ball=newBall(player.getX()+50,player.getY()-3);
        facade= new HomeworkTwoFacade();
        getGameWorld().addEntities(bg,player,ball,walls);
    }

    @Override
    protected void initInput() {
        Input input = getInput();
        input.addAction(new UserAction("Move Right") {
            @Override
            protected void onAction() {
                playerControl.right();
                if(initContact ){
                    ball.getComponent(PhysicsComponent.class).setLinearVelocity(70,0);
                }
            }
            @Override
            protected void onActionEnd() {
                playerControl.stop();
                if(!initMovement){
                    ball.getComponent(PhysicsComponent.class).setLinearVelocity(0,0);

                }
            }
        }, KeyCode.RIGHT);

        input.addAction(new UserAction("Move Left") {
            @Override
            protected void onAction() {
                playerControl.left();
                if(initContact){
                    ball.getComponent(PhysicsComponent.class).setLinearVelocity(-70,0);
                }

            }
            @Override
            protected void onActionEnd() {
                playerControl.stop();
                if(!initMovement){
                    ball.getComponent(PhysicsComponent.class).setLinearVelocity(0,0);
                }
            }
        }, KeyCode.LEFT);

        input.addAction(new UserAction("Move Ball") {
            @Override
            protected void onAction() {
                ball.getComponent(PhysicsComponent.class).setLinearVelocity(55,-55);
                initMovement=true;
                getPhysicsWorld().setGravity(0.2,0.2);
                initContact=false;
            }
        }, KeyCode.SPACE);

        input.addAction(new UserAction("New Level") {
            @Override
            protected void onAction() {
                int seed= 1;
                double probB= Math.random();
                double nivel=Math.random();
                if(nivel>0.5){
                    int numberOfB=(int)( Math.random() * (96 - 75+ 1 ) ) + 75;
                    double probM= Math.random();
                    facade.setCurrentLevel(facade.newLevelWithBricksFull("1",numberOfB,probB,probM,seed));
                }
                else{
                    int numberOfB=(int)( Math.random() * (120 - 90+ 1 ) ) + 90;
                    facade.setCurrentLevel(facade.newLevelWithBricksNoMetal("1",numberOfB,probB,seed));
                }
                List<Entity> listE =createLevel(facade.getBricks());
                for(Entity en:listE){
                    getGameWorld().addEntity(en);
                }
                System.out.print(nivel);
            }
        }, KeyCode.N);

    }

    @Override
    protected void initUI() {
        Text textLive=new Text("LIVES");
        textLive.setFont(Font.font(40));
        textLive.setTranslateX(50);
        textLive.setTranslateY(50);
        textLive.setFill(Color.WHITE);
        getGameScene().addUINode(textLive);

        Text textScore=new Text("SCORE");
        textScore.setFont(Font.font(40));
        textScore.setTranslateX(350);
        textScore.setTranslateY(50);
        textScore.setFill(Color.WHITE);
        getGameScene().addUINode(textScore);

        Text tscore = getUIFactory().newText("", Color.WHITE, 40);
        tscore.setTranslateY(50);
        tscore.setTranslateX(500);
        tscore.textProperty().bind(getGameState().intProperty("score").asString());
        getGameScene().addUINode(tscore);

        Text text = getUIFactory().newText("", Color.WHITE, 40);
        text.setTranslateY(50);
        text.setTranslateX(170);
        text.textProperty().bind(getGameState().intProperty("lives").asString());
        getGameScene().addUINode(text);
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("lives", 3);
        vars.put("score", 0);
    }

    public static List createLevel(List <Brick> listBrick){
        List <Entity> listBrickEntities=new ArrayList();
        int x=0;
        int y=120;
        int dx=100;
        int dy=30;
        Collections.shuffle(listBrick);
        for(Brick brick:listBrick) {
            if (x >= 1000) {
                x = 0;
                y += dy;
            }
            if (brick.isGlass()) {
                listBrickEntities.add(newBrickGlass(x, y));
            } else if (brick.isWooden()) {
                listBrickEntities.add(newBrickWooden(x, y));
            } else {
                listBrickEntities.add(newBrickMetal(x, y));
            }
            x += dx;
        }
        return listBrickEntities;
    }

    public static void main(String... args) {
        launch(args);
    }


}