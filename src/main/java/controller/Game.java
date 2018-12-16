package controller;
import logic.brick.*;
import logic.level.Level;
import logic.level.*;
import java.util.*;
/**
 * Game logic controller class.
 *
 * @author Juan-Pablo Silva
 * @author vale
 */
public class Game implements Observer{
    protected int balls;
    protected int totalscore;
    protected Level currentLevel;
    /**
     * Constructor de la clase Game
     * @param balls , que es la cantidad de pelotas que se tendran al partir el juego
     * Se inicializa el atributo balls con el parametro que se recibe, luego el totalscore
     * se inicializa en 0, tal como la lista del currentLevel como vacia y el currentLevel como
     * un NullLevel con nombre "".
     */
    public Game(int balls) {
        this.balls=balls;
        totalscore=0;
        List<Brick> list= new ArrayList<>();
        currentLevel=new NullLevel("",list);
    }
    /**
     * Agrega una nueva ball al juego.
     */
    public void addBall(){
        balls++;
    }

    /**
     * Crea un nivel con los tres tipos de Bricks
     * @param name , sera el nombre del nivel
     * @param numberOfBricks, sera la cantidad minima de bricks que se tendran
     * @param probOfGlass, probabilidad de obtener un glass
     * @param seed , semilla que permite obtener numeros
     * @return Level a, nuevo nivel creado
     * Empieza con una lista vacia, luego crea un generador que ira entregando los numeros random
     * que permite la semilla, luego mientras no se tenga la cantidad de brick pedidos, se haran
     * brick de glass y/o wooden segun lo indique la probabilidad y se iran agregando a la lista.
     * Luego realiza lo mismo pero de forma separada en otro while para obtener los metalBrick que
     * estaran en el nivel, agregandolos a la lista.
     * Finalmente crea y retorna el nivel con la lista y el nombre con el parametro name
     */
    public Level newLevelWithBricksFull(String name, int numberOfBricks, double probOfGlass, double probOfMetal, int seed) {
        List<Brick> lista=new ArrayList<>();
        Random generator = new Random(seed);
        int i=0;
        while (i!=numberOfBricks){
            double numero= generator.nextDouble();
            if (numero<=probOfGlass){
                Brick brick;
                brick= new GlassBrick();
                lista.add(brick);
            }
            else{
                Brick brick;
                brick= new WoodenBrick();
                lista.add(brick);
            }
            i++;
        }
        i=0;
        while (i!=numberOfBricks){
            if(generator.nextDouble()<=probOfMetal) {
                Brick brick1;
                brick1 = new MetalBrick();
                lista.add(brick1);
            }
            i++;
        }
        Level a= new ClassLevel(name,lista);
        return a;
    }

    /**
     * Crea un nivel con dos tipos de Bricks, los GlassBrick y WoodenBrick.
     * @param name , sera el nombre del nivel
     * @param numberOfBricks, sera la cantidad minima de bricks que se tendran
     * @param probOfGlass, probabilidad de obtener un glass
     * @param seed , semilla que permite obtener numeros
     * @return Level a, nuevo nivel creado
     * Empieza con una lista vacia, luego crea un generador que ira entregando los numeros random
     * que permite la semilla, luego mientras no se tenga la cantidad de brick pedidos, se haran
     * brick de glass y/o wooden segun lo indique la probabilidad y se iran agregando a la lista.
     * Finalmente crea y retorna el nivel con la lista y el nombre con el parametro name
     */
    public Level newLevelWithBricksNoMetal(String name, int numberOfBricks, double probOfGlass, int seed) {
        List<Brick> lista=new ArrayList<>();
        Random generator = new Random(seed);
        int i=0;
        while (i!=numberOfBricks){
            Brick brick;
            double numero= generator.nextDouble();
            if (numero<=probOfGlass){
                brick= new GlassBrick();
            }
            else{
                brick= new WoodenBrick();
            }
            lista.add(brick);
            i++;
        }
        Level a= new ClassLevel(name,lista);
        return a;
    }
    /**
     * Gets the number of {@link Brick} in the current level, that are still not destroyed
     * For each brick in the list of brick that has current level, check if the brick is
     * still alive. If it's alive, increase alive counter.
     * @return the number of intact bricks in the current level
     */
    public int numberOfBricks() {
        int alive=0;
        for(Brick brick: currentLevel.getBricks()){
            if (!brick.isDestroyed()){
                alive++;
            }
        }
        return alive;
    }

    /**
     * Gets the list of {@link Brick} in the current level.
     *
     * @return the list of bricks
     */
    public List<Brick> getBricks() {
        return  currentLevel.getBricks();
    }

    /**
     * Whether the current {@link Level}'s next level is playable or not.
     *
     * @return true if the current level's next level is playable, false otherwise
     */
    public boolean hasNextLevel() {
        return currentLevel.hasNextLevel();
    }

    /**
     * Pass to the next level of the current {@link Level}. Before to do that, totalscore
     * increase the points of the currentLevel
     */
    public void goNextLevel() {
        totalscore+=((AbstractLevel)currentLevel).getActualPoints();
        setCurrentLevel(currentLevel.getNextLevel());
    }

    /**
     * Gets whether the current {@link Level} is playable or not.
     *
     * @return true if the current level is playable, false otherwise
     */
    public boolean hasCurrentLevel() {
        return currentLevel.isPlayableLevel();
    }

    /**
     * Gets the name of the current {@link Level}.
     *
     * @return the name of the current level
     */
    public String getLevelName() {
        return currentLevel.getName();
    }

    /**
     * Gets the current {@link Level}.
     *
     * @return the current level
     * @see Level
     */
    public Level getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Sets a {@link Level} as the current playing level.
     * And subscribe game in the list of observers that
     * currentLevel has.
     * @param level the level to be used as the current level
     * @see Level
     */
    public void setCurrentLevel(Level level) {
        currentLevel=level;
        ((AbstractLevel)currentLevel).subscribe(this);
    }

    /**
     * Adds a level to the list of {@link Level} to play. This adds the level in the last position of the list.
     *
     * @param level the level to be added
     */
    public void addPlayingLevel(Level level){
        currentLevel=currentLevel.addPlayingLevel(level);
        ((AbstractLevel)currentLevel).subscribe(this);

    }
    /**
     * Gets the number of points required to pass to the next level. Gets the points obtainable in the current {@link Level}.
     *
     * @return the number of points in the current level
     */
    public int getLevelPoints() {
        return currentLevel.getPoints();
    }
    /**
     * Gets the accumulated points through all levels and current {@link Level}.
     *
     * @return the cumulative points
     */
    public int getCurrentPoints(){
        return totalscore+((AbstractLevel)currentLevel).getActualPoints();
    }

    /**
     * Gets the current number of available balls to play.
     *
     * @return the number of available balls
     */
    public int getBallsLeft() {
        return balls;
    }

    /**
     * Reduces the count of available balls and returns the new number.
     *
     * @return the new number of available balls
     */
    public int dropBall() {
        if (balls>0){
            balls--;
        }
        return balls;
    }

    /**
     * Checks whether the game is over or not. A game is over when the number of available balls are 0 or the player won the game.
     * Otherwise, return false
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        if(balls==0){return true;}
        else if (winner()) {
            return true;
        }
        return false;
    }
    /**
     * Checks whether the game has a winner or not
     * @return true if the game has a winner, false otherwise
     * if the currentLevel is playable and the totalscore>0, this means the gamer won, so return true.
     * Otherwise return false
     */
    public boolean winner() {
       if (!currentLevel.isPlayableLevel() && totalscore>0){
           return true;
        }
        else {
            return false;
        }
    }

    /**
     * Metodo update que permite actualizar el juego al ser notificado por el level que un
     * brick se destruyo. En este momento, verifica si el que le notifico fue un Level. Si es asi
     * ve si el ultimo Brick fue metal. Si lo fue, agrega una pelota al juego.
     * Luego revisa si los puntos actuales del currentlevel son iguales a los puntos que se pueden
     * obtener. De ser asi, pasa de nivel.
     * @param observable es el objeto que estaba observando
     * @param o objeto que recibe que puede contener informacion
     */
    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Level) {
            if (((Level)observable).getUltimo()=="metal"){
                this.addBall();
            }

            if(currentLevel.getPoints()==((AbstractLevel)currentLevel).getActualPoints()){
                this.goNextLevel();
            }
        }
    }
}
