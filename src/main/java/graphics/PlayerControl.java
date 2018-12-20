package graphics;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

/**
 * Clase PlayerControl que se extiende de Component que permite mover al Player en la GUI
 * @author vale
 */
public class PlayerControl extends Component {
    private PhysicsComponent physics;
    private boolean playerWallLeft;
    private boolean playerWallRight;
    /**
     * Constructor de la clase PlayerControl que inicializa la variable physics en null
     * Esta permitirá después mover el player en el eje X
     */
    public PlayerControl(){
        physics=null;
    }

    /**
     * Método que setea el atributo playerWallRight en a
     * @param a que representa true o false, según si hay contacto entre player-WallRight o no
     */
    public void setPlayerWallLeft(boolean a){
        playerWallLeft=a;
    }

    /**
     * Método que setea el atributo playerWallRight en a
     * @param a que representa true o false, según si hay contacto entre player-WallRight o no
     */
    public void setPlayerWallRight(boolean a){
        playerWallRight=a;
    }

    /**
     * Método que permite setear la velocidad del player con el parametro d
     * @param d que es un double, el cual indica la velocidad que se desea poner
     */
    public void setVelocity(double d){
        physics.setVelocityX(d);
    }

    /**
     * Método que permite obtener el atributo playerWallRight
     * @return playerWallLeft , que puede ser true o false. True si estan en contacto el player con la muralla
     * derecha o en otro caso, false.
     */
    public boolean getPlayerWallRight() {
        return playerWallRight;
    }

    /**
     * Método que permite obtener el atributo playerWallLeft
     * @return playerWallLeft , que puede ser true o false.True si estan en contacto el player con la muralla
     *      * derecha o en otro caso, false.
     */
    public boolean getPlayerWallLeft(){
        return playerWallLeft;
    }
    /**
     *Método que permite mover al player hacia la izquierda mientrans no este colisionando con la muralla.
     * Si no ha colisionado con la muralla, la velocidad se setea en 130 hacia la izquierda. Luego si se estaba
     * tocando la muralla derecha y como nos queremos mover hacia la izquierda, el atributo playerWallRight se
     * cambia a false
     */
    public void left() {
        if (!playerWallLeft){
            physics.setVelocityX(-130);
            if(playerWallRight){
                playerWallRight=false;

            }
        }
    }

    /**
     *Método que permite mover al player hacia la derecha mientrans no este colisionando con la muralla.
     * Si no ha colisionado con la muralla, la velocidad se setea en 130 hacia la derecha. Luego si se estaba
     * tocando la muralla izquierda y como nos queremos mover hacia la derecha, el atributo playerWallLeft se
     * cambia a false
     */
    public void right() {
        if (!playerWallRight){
            physics.setVelocityX(130);
            if(playerWallLeft){
                playerWallLeft=false;
            }
        }
    }

    /**
     * Método que permite detener la velocidad del player
     */
    public void stop() {
        physics.setVelocityX(0);
    }

}
