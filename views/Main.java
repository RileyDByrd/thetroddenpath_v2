package views;
	
import java.io.IOException;

import controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage window = new Stage();
	private Scene startScene, boardGame;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		window = primaryStage;
		window.setTitle("The Trodden Path");
		Parent start = null;
		try {
			start = FXMLLoader.load(getClass().getResource("Start.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		startScene = new Scene(start, 600, 300);
		window.setResizable(false);
		window.setScene(startScene);
		window.show();
		PlayerInit.playerNum();
	}
	
	public void startGame() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("Game.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
		boardGame = new Scene(root, 1300, 700);
		window.setResizable(false);
		window.setScene(boardGame);
		window.show();
		Controller.run();
		Controller.initPlayers(PlayerInit.getNames());
	}
	
	public static void endGame() {
		window.setTitle("You've reached the end!");
		window.setResizable(false);
		
		Text label = new Text();
		label.setText("These are the players' rankings:");
//		print players in order of most to least points
		
		VBox layout = new VBox(20);
		layout.getChildren().addAll(label);
		Scene scene = new Scene(layout, 300, 500);
		window.setScene(scene);
		window.show();
	}
}