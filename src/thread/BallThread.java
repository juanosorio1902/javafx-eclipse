package thread;

import javafx.application.Platform;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class BallThread extends Thread {
	
	private Circle moon;
	private Pane pane;
	private Slider bar;
	private boolean moving;
	private Circle sun;

	public BallThread(Circle moon, Pane pane, Slider bar, Circle sun) {
		this.moon = moon;
		this.pane = pane;
		this.bar = bar;
		moving = false;
		this.sun = sun;
	}
	
	@Override
	public void run() {
		while(moving){
			if(moon.getLayoutX()<pane.getWidth()+moon.getRadius()) {
				try {
					Thread.sleep(-1*(int)bar.getValue()+101);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				moon.setLayoutX((int)moon.getLayoutX()+1);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						if(moon.getLayoutX()>sun.getLayoutX()+2*sun.getRadius()) {
							pane.setStyle("-fx-background-color: #EEEEBC;");
						} else if(moon.getLayoutX()>sun.getLayoutX()+2*2*sun.getRadius()/3) {
							pane.setStyle("-fx-background-color: #B3B38D;");
						} else if(moon.getLayoutX()>sun.getLayoutX()+1*2*sun.getRadius()/3) {
							pane.setStyle("-fx-background-color: #77775E;");
						} else if(moon.getLayoutX()>sun.getLayoutX()) {
							pane.setStyle("-fx-background-color: #1E1E18;");
						} else if(moon.getLayoutX()>sun.getLayoutX()-1*2*sun.getRadius()/3) {
							pane.setStyle("-fx-background-color: #77775E;");
						} else if(moon.getLayoutX()>sun.getLayoutX()-2*2*sun.getRadius()/3) {
							pane.setStyle("-fx-background-color: #B3B38D;");
						}
					}
				});
				
			}else {
				moon.setLayoutX(-1*moon.getRadius());
			}
		}
	}
	
	public void isMoving(boolean move) {
		moving = move;
	}
}
