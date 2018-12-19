package graphics;

import com.almasb.fxgl.app.FXGL;
import logic.brick.Brick;
import com.almasb.fxgl.entity.component.Component;

/**
 * Clase BrickComponent que extiende de Component. Este permitira a la entity tener un brick asociado para
 * poder relacionarlos y usar los metodos de brick y facade
 * @author vale
 */
public class BrickComponent extends Component {
    private Brick brickC;
    private String string;

    /**
     * Constructor de BrickComponent que permite setear el atributo brickC con el parametro B
     * @param B que es tipo Brick que será el brick asociado que tendrá la entidad
     */
    public BrickComponent(Brick B){
        brickC=B;
    }

    /**
     * Método que retorna el atributo brickC para poder aplicar los métodos de brick
     * para poder realizar la interacción del juego.
     * @return brickC que es el brick que tiene asociado la entidad
     */
    public Brick getComponent(){
        return brickC;
    }

    /**
     * Método que permite cambiar la vista de la entity que se encuentra en el juego.
     * Cambia la vista de los brick Wood, Metal y Golden según que tipo de brick sea el atributo
     * brickC. El wood tiene solo una vista distinta al original que reflejan los golpes de ball,
     * que lo van debilitando. EL metal tiene dos vistas distintas y el golden es el que hay que pegarle
     * más, por lo que tiene 3 vistas distintas antes que se destruya.
     */
    public void crackedBrickset() {
        if(brickC.isWooden()){
            if(brickC.remainingHits()==2){
                string="woodcracked.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }
        }
        else if(brickC.isMetal()) {
            if(brickC.remainingHits()==3){
                string="metalcracked2.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }
            else if(brickC.remainingHits()==6){
                string="metalcracked1.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }
        }
        else if(brickC.isGolden()){
            if(brickC.remainingHits()==4){
                string="goldencracked3.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }
            else if(brickC.remainingHits()==8){
                string="goldencracked2.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }
            else if(brickC.remainingHits()==12){
                string="goldencracked1.png";
                entity.setView(FXGL.getAssetLoader().loadTexture(string, 100, 30));
            }
        }
    }
}
