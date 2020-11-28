package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import thread.BallThread;

public class EclipseGUI {
	
	@FXML
	private Pane pane;

    @FXML
    private Circle sun;

    @FXML
    private Circle moon;
    
    @FXML
    private Slider bar;
    
    @FXML
    private Button move;

    @FXML
    private Button stop;

    BallThread bt;
    
    @FXML
    public void moveMoon(ActionEvent event) {
    	move.setDisable(true);
    	stop.setDisable(false);    	
    	bt.isMoving(false);
    	bt = new BallThread(moon, pane, bar, sun);
    	bt.setDaemon(true);
    	bt.isMoving(true);
    	bt.start();
    }

    @FXML
    public void stopMoon(ActionEvent event) {
    	move.setDisable(false);
    	stop.setDisable(true);
    	bt.isMoving(false);
    }
    
    public void initialize() {
    	bt = new BallThread(moon, pane, bar, sun);
    }

}
