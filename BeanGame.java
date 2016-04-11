import javafx.application.Application;
import javafx.event.*;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.security.SecureRandom;

public class BeanGame extends Application{
	@Override
		public void start(Stage primaryStage){
			//Create main Pane
			Pane pane1= new Pane();
			
			//Draw the frame
			Polyline polyline = new Polyline();
			polyline.getPoints().addAll(new Double[]{
					50.0, 100.0,
					50.0, 400.0,
					400.0,400.0,
					400.0,100.0});
			
			pane1.getChildren().add(polyline);

			
			//put dots in game
			Circle[] dots = new Circle[20];
			for(double i =0;i<=19;i++){
				dots[(int)i]=new Circle(10);
	            dots[(int)i].setFill(Color.RED);
	            
	            if(i<=6){
	            	dots[(int)i].setLayoutX(50+(((350/8)*(i+1))));
	            	dots[(int)i].setLayoutY(45+(400/3));
	            }
	            
	            else if (i>6&&i<=12) {
	            	dots[(int)i].setLayoutX(50+(50*(i-6)));
	            	dots[(int)i].setLayoutY(120+(400/3));
					
				}
	            
	            else{
	            	dots[(int)i].setLayoutX(50+((350/8)*(i-12)));
	            	dots[(int)i].setLayoutY(195+(400/3));	            	
	            }

	            
	            pane1.getChildren().add(dots[(int)i]);
			}
			//Line
			Line[] line = new Line[7];
			for(int i = 0;i<7;i++){
				line[i] = new Line(50+(((350/8)*(i+1))),195+(400/3),50+(((350/8)*(i+1))),400);
				line[i].setStroke(Color.RED);
				pane1.getChildren().add(line[i]);
			}
			
			Button play = new Button("throw");
			play.setLayoutX(150.0);
			play.setLayoutY(50.0);
			play.setPrefSize(100, 20);
			pane1.getChildren().add(play);
			
			play.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					Timeline timeline = new Timeline();
					SecureRandom srand = new SecureRandom();
					
					int c = srand.nextInt(8)+1;
					Circle circle = new Circle(60.0,170.0,12);
					circle.setFill(Color.rgb(srand.nextInt(256), srand.nextInt(256), srand.nextInt(256)));
					pane1.getChildren().add(circle);
					timeline.getKeyFrames().addAll(new KeyFrame(new Duration(500),new KeyValue(circle.translateXProperty(),0),new KeyValue(circle.translateYProperty(),135))
					,new KeyFrame(new Duration(1000),new KeyValue(circle.translateXProperty(),0),new KeyValue(circle.translateYProperty(),220)));
					
					timeline.play();
				}
			});
			
			
			//Create main Scene
			Scene bean = new Scene(pane1,500,500);
			
			
			
			//Stage settings
			primaryStage.setTitle("U10416016 BeanGame");
			primaryStage.setScene(bean);
			primaryStage.show();
	}
    public static void main(String[] args) {
        launch(args);
    }
    
}
