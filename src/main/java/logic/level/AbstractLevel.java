package logic.level;

import logic.VisitableBrick;
import logic.brick.AbstractBrick;
import logic.brick.Brick;
import java.util.List;
import java.util.Observable;
import controller.Game;
/**
 * Clase Abstracta que se crea para poder hacer especializaciones de los Levels. Se hace una implementacion
 * de los métodos de la interfaz Level y extiende la clase de la clase Observable, para poder compartir métodos.
 * @author vale
 */
public abstract class AbstractLevel extends Observable implements Level{
    protected String name;
    protected int bricksNumber;
    protected int points;
    protected int actualPoints;
    protected List<Brick> brickList;
    public Level nextLevel;
    protected String ultimo;
    /**
     * Constructor de AbstractLevel
     * @param n que será el nombre que tendrá el level
     * @param list que será la lista de brick que hay en el level
     * Este constructor inicializa los atributos name y brickList con los parámetros que
     * recibe el constructor,respectivamente.
     * Algunos atributos como bricksNumber y points se inicializan gracias a brickList, ya que
     * de ahi sacan la informacion. Los actualPoints se inicializan en 0.
     * El atributo ultimo se refiere al ultimo brick que se destruyo.
     * Luego de inicializar todos los atributos, se realiza un llamado al método suscribeAll(list)
     * lo que permite suscribir todos los brick de la lista al level que se le esta aplicando el método
     */
    public AbstractLevel(String n, List<Brick> list){
        brickList=list;
        bricksNumber=this.brickList.size();
        name=n;
        actualPoints=0;
        points=this.getPoints();
        ultimo="";
        this.subscribeAll(list);
    }
    /**
     * Gets the level's name. Each level must have a name.
     *
     * @return the table's name
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the number of {@link Brick} in the level.
     *
     * @return the number of Bricks in the level
     */
    public int getNumberOfBricks() {
        return bricksNumber;
    }
    /**
     * Gets the {@link List} of {@link Brick}s in the level.
     *
     * @return the bricks in the level
     */
    public List<Brick> getBricks() {
        return brickList;
    }
    /**
     * Gets the next level of a level object. Each level have a reference to the next level to play.
     *
     * @return the next level
     */
    public Level getNextLevel() {
        return nextLevel;
    }
    /**
     * Gets whether the level is playable or not.
     *
     * @return true if the level is playable, false otherwise
     */
    public boolean isPlayableLevel() {
        return true;
    }

    /**
     * Whether the level's next level is playable or not.
     *
     * @return true if the level's next level is playable, false otherwise
     */
    public abstract boolean hasNextLevel();

    /**
     * Método que permite obtener todos los puntos que pueden ser obtenidos en el Level,
     * es decir, la suma de todos los puntos de los Bricks que estan en brickList
     * @return points , que seran los puntos que se pueden alcanzar en el level
     */
    public int getPoints() {
        if (points==0){
            for(Brick brick: brickList) {
                points += brick.getScore();
            }
        }
        return points;
    }

    /**
     * Añade el nivel level a la lista enlazada que tiene level.
     * @param level el level que será añadido
     * @return this, que es el nivel en el que se esta
     * Esto lo realiza de manera recursiva, dandole al siguiente la responsabilidad
     * de agregar al level.
     */
    public Level addPlayingLevel(Level level) {
        nextLevel=nextLevel.addPlayingLevel(level);
        return this;
    }

    /**
     * Sets the reference for the next level of a level object.
     *
     * @param level the next level of a level object
     */
    public void setNextLevel(Level level) {
        nextLevel=level;
    }
    /**
     * Método que permite obtener los ActualPoints del level
     * @return actualPoints
     */
    public int getActualPoints() {
        return actualPoints;
    }

    /**
     * Método que permite agregar como observador al Level en cada ladrillo que esta
     * en la lista bricks.
     * @param bricks
     */
    public void subscribeAll( List<Brick> bricks){
        for(Brick brick: bricks){
            brick.subscribe(this);
        }
    }
    /**
     * Permite realizar una actualizacion, al ser notificado por el objeto que observa level.
     * @param observable
     * @param o
     * Si el que le envio el llamado fue un Brick, level hará un llamado a este brick para que
     * acepte su visita.
     */
    public void update(Observable observable, Object o) {
        if(observable instanceof Brick){
            ((AbstractBrick) observable).accept(this);
        }
    }
    /**
     * Método de permite agregar a la lista de observadores de level el observador game
     * @param game
     */
    public void subscribe(Game game){
        this.addObserver(game);
    }
    /**
     * Método que permite setear el ultimo Brick que se destruyo como s
     * @param s que es el numero string
     */
    public void setUltimo(String s){
        ultimo=s;
    }

    /**
     * Método que permite obtener el ultimo Brick que se destruyo
     * @return ultimo
     */
    public String getUltimo(){
        return ultimo;
    }

    /**
     * Método que visita un GlassBrick,el que es un tipo Visitable
     * @param b es el objeto que visitará
     * Al recibir un notify del brick al destruirse, este visita al brick y actualiza los puntos
     * actuales del level al sumarle el score que tiene el Brick. Luego setea el atributo ultimo como
     *  "glass", ya que fue el ultimo que se destruyo. Finalmente notifica a los observadores del level
     *  que en este juego sera la clase Game
     */
    public void visitGlassBrick(VisitableBrick b){
        actualPoints+= ((Brick)b).getScore();
        this.setUltimo("glass");
        setChanged();
        this.notifyObservers();
    }
    /**
     * Método que visita un WoodenBrick,el que es un tipo Visitable
     * @param b es el objeto que visitará
     * Al recibir un notify del brick al destruirse, este visita al brick y actualiza los puntos
     * actuales del level al sumarle el score que tiene el Brick. Luego setea el atributo ultimo como
     *  "wooden", ya que fue el ultimo que se destruyo. Finalmente notifica a los observadores del level
     *  que en este juego sera la clase Game
     */
    public void visitWoodenBrick(VisitableBrick b){
        actualPoints+= ((Brick)b).getScore();
        this.setUltimo("wooden");
        setChanged();
        this.notifyObservers();
    }
    /**
     * Método que visita un MetalBrick,el que es un tipo Visitable
     * @param b es el objeto que visitará
     * Al recibir un notify del brick al destruirse, este visita al brick y actualiza los puntos
     * actuales del level al sumarle el score que tiene el Brick. Luego setea el atributo ultimo como
     *  "metal", ya que fue el ultimo que se destruyo. Finalmente notifica a los observadores del level
     *  que en este juego sera la clase Game
     */
    public void visitMetalBrick(VisitableBrick b){
        actualPoints+= ((Brick)b).getScore();
        this.setUltimo("metal");
        setChanged();
        this.notifyObservers();
    }
}
