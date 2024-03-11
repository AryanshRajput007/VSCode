package JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class app extends Application {
	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		
		Text txt = new Text();
		txt.setText("Welcome");
		txt.setX(100);
		txt.setY(100);
		txt.setFont(Font.font("Times New Roman", 42));
		txt.setFill(Color.RED);
		txt.setStroke(Color.BLACK);
		txt.setStrokeWidth(1);
		//txt.setStrikethrough(true);
		root.getChildren().add(txt);
		stage.setScene(scene);
		stage.show();
		stage.setTitle("Graphic Programming");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

