package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Auto extends Rectangle {
    public Auto(boolean isVerticale) {
        super();
        if(isVerticale) {
            super.setWidth(10);
            super.setHeight(20);
        }else{
            super.setWidth(20);
            super.setHeight(10);
        }
        super.setFill(Color.WHITE);
    }
}
