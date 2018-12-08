package logic.brick;
import controller.Game;
import logic.VisitorLevel;

/**
* Clase MetalBrick que es una especializacion de la clase Abstracta AbstractBrick.
* @author vale
*/
public class MetalBrick extends AbstractBrick {
    /**
     * Constructor de MetalBrick
     * Este constructor hace un llamado al constructor de la clase padre, el cual tiene los mismos atributos
     * y los inicializa según las especificaciones que debe tener un MetalBrick, las cuales serian
     * que tiene hitPoints igual a 10 y el score es de 0.
     */
    public MetalBrick(){
        super(10,0);
    }
    /**
     * Metodo que permite aceptar la visita de un level.
     * @param v es el visitor, el cual es tipo VisitorLevel.
     * Lo que hace el método es que el VisitorLevel v al querer visitar el MetalBrick, debe ser aceptado.
     * Al ser aceptado realiza doble dispatch. Este level va a llamar al método interno que tiene,
     * el cual es visitMetalBrick.
     */
    @Override
    public void accept(VisitorLevel v) {
        v.visitMetalBrick(this);
    }

    @Override
    public boolean isWooden() {
        return false;
    }

    @Override
    public boolean isMetal() {
        return true;
    }

    @Override
    public boolean isGlass() {
        return false;
    }
}
