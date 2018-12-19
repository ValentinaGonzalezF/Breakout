package logic.brick;

import logic.VisitorLevel;
/**
 * Clase GodenBrick que es una especializacion de la clase Abstracta AbstractBrick.
 * @author vale
 */
public class GoldenBrick extends AbstractBrick {
    /**
     * Constructor de GoldenBrick
     * Este constructor hace un llamado al constructor de la clase padre, el cual tiene los mismos atributos
     * y los inicializa según las especificaciones que debe tener un GoldenBrick, las cuales serian
     * que tiene hitPoints igual a 15 y el score es de 1000. Pero quita una vida al eliminarlo.
     */
    public GoldenBrick(){
        super(15,1000);
    }
    /**
     * Metodo que permite aceptar la visita de un level.
     * @param v es el visitor, el cual es tipo VisitorLevel.
     * Lo que hace el método es que el VisitorLevel v al querer visitar el GoldenBrick, debe ser aceptado.
     * Al ser aceptado realiza doble dispatch. Este level va a llamar al método interno que tiene,
     * el cual es visitGoldenBrick.
     */
    @Override
    public void accept(VisitorLevel v) {
        v.visitGoldenBrick(this);
    }

    /**
     * Método que permite saber si el brick es de tipo Golden
     * @ return true si es golden y false en cualquier otro caso.
     */
    public boolean isGolden(){return true;}
}
