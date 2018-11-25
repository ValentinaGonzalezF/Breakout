package logic.brick;
import java.util.Observable;
import logic.VisitorLevel;
import logic.level.*;

/**
 * Clase Abstracta que se crea para poder hacer especializaciones de las Bricks. Se hace una implementacion
 * de los métodos de interfaz Brick, para poder compartir métodos.
 * @author vale
 */
public abstract class AbstractBrick extends Observable implements Brick{
    protected int hitPoints;
    protected int score;
    protected boolean destroyed;
    /**
     * Constructor de AbstractBrick
     * @param hitP que serán los hitPoints que tendrá el Brick
     * @param score que será el score que tendrá el Brick
     * Este constructor inicializa los atributos hitPoints y score con los parámetros que
     * recibe el constructor,respectivamente.
     * El último se inicializa en false, ya que el brick aun no está destruido.
     */
    public AbstractBrick(int hitP, int score){
        this.hitPoints=hitP;
        this.score=score;
        destroyed=false;
    }
    /**
     * Define cuando un brick es golpeado. Si no está destruido, disminuye sus hitPoints.
     * En caso contrario, los hitPoints son igual a 0, por lo que setea destroyed en verdadero
     * y notifica a los observadores del brick que fue destruido.     *
     */
    @Override
    public void hit(){
        if(!destroyed){
            hitPoints--;
        }
        if(hitPoints==0){
            if(!destroyed) {
                destroyed = true;
                this.setChanged();
                this.notifyObservers();
            }
        }
    }
    /**
     * Gets whether the brick object is destroyed or not.
     *
     * @return true if the brick is destroyed, false otherwise
     */
    @Override
    public boolean isDestroyed(){
        return destroyed;
    }
    /**
     * Gets the points corresponding to the destroying of a brick object.
     *
     * @return the associated points of a brick object
     */
    @Override
    public int getScore(){
        return score;
    }
    /**
     * Gets the remaining hits the brick has to receive before being destroyed.
     *
     * @return the remaining hits to destroy de brick
     */
    @Override
    public int remainingHits(){
        return hitPoints;
    }
    /**
     * Metodo abstracto que permitira aceptar la visita de un level.
     * @param v es el visitor, el cual es tipo VisitorLevel.
     */
    public abstract void accept(VisitorLevel v);
    /**
     * Método que permite agrega un level a la lista de observadores que tiene un brick
     * @param level es el level que se añadirá a la lista.
     */
    public void subscribe(Level level){
        addObserver(level);
    }
}
