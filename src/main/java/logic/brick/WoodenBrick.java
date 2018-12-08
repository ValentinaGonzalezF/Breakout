package logic.brick;
import logic.VisitorLevel;
/**
 * Clase WoodenBrick que es una especializacion de la clase Abstracta AbstractBrick.
 * @author vale
 */
public class WoodenBrick extends AbstractBrick {
    /**
     * Constructor de WoodenBrick
     * Este constructor hace un llamado al constructor de la clase padre, el cual tiene los mismos atributos
     * y los inicializa según las especificaciones que debe tener un WoodenBrick, las cuales serian
     * que tiene hitPoints igual a 3 y el score es de 200.
     */
    public WoodenBrick(){
        super(3,200);
    }
    /**
     * Método que permite aceptar la visita de un level.
     * @param v es el visitor, el cual es tipo VisitorLevel.
     * Lo que hace el método es que el VisitorLevel v al querer visitar el WoodenBrick, debe ser aceptado
     * , al ser aceptado realiza doble dispatch. Este level va a llamar al método interno que tiene,
     * el cual es visitWoodenBrick,
     */
    public void accept(VisitorLevel v){
        v.visitWoodenBrick(this);
    }

    @Override
    public boolean isWooden() {
        return true;
    }

    @Override
    public boolean isMetal() {
        return false;
    }

    @Override
    public boolean isGlass() {
        return false;
    }
}