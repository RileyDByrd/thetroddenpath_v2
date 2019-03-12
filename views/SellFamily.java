package views;

import controllers.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Player;

public class SellFamily {

	//connected to button to sell family. calls method in controllers.Controller depending on which family they want to sell
	public static void sellFamily(Player currentPlayer){
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("Sell Family Member");
		
		Text label = new Text();
		label.setText("Which kind of family member do you want to sell?");
		Text error = new Text();
		error.setText("");
		Button spouse = new Button("Spouse");
		Button son = new Button("Son");
		Button daughter = new Button("Daughter");
		
		spouse.setOnAction(e -> {
//			if(currentPlayer.hasSpouse){
				Controller.sellSpouse();
				prompt.close();
//			}
//			else{
//				error.setText("You don't have a spouse!");
//			}
		});
		son.setOnAction(e -> {
//			if(currentPlayer.hasSon){
			Controller.sellSon();
			prompt.close();
//			}
//			else{
//				error.setText("You don't have a son!");
//			}
		});
		daughter.setOnAction(e -> {
//			if(currentPlayer.hasDaughter){
			Controller.sellDaughter();
			prompt.close();
//			}
//			else{
//				error.setText("You don't have a daughter!");
//			}
		});
		
		HBox buttons = new HBox(20);
		buttons.getChildren().addAll(spouse, son, daughter);
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, buttons, error);
		Scene scene = new Scene(layout, 400, 300);
		prompt.setScene(scene);
		prompt.show();
	}
	
	public static void familyError() {
		Stage prompt = new Stage();
		
		prompt.initModality(Modality.APPLICATION_MODAL);
		prompt.setTitle("Wait a Minute!");
		prompt.setResizable(false);
		
		Text label = new Text();
		label.setText("You don't have any family to sell.");
		Button close = new Button("Close");
		close.setOnAction(e -> prompt.close());
		
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, close);
		Scene scene = new Scene(layout, 300, 100);
		prompt.setScene(scene);
		prompt.show();
	}
}