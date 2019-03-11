package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.ChanceCard;

public class CardEffects {

	public static void message(ChanceCard chanceCard) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Card Effect");
		
		Text text = new Text();
		System.out.println("1");
		text.setText(chanceCard.toString());
		System.out.println("2");
		Button button = new Button("Okay");
		System.out.println("3");
		button.setOnAction(e -> stage.close());
		System.out.println("4");
		
		VBox layout = new VBox(15);
		System.out.println("5");
		layout.getChildren().addAll(text, button);
		System.out.println("6");
		Scene scene = new Scene(layout, 800, 110);
		System.out.println("7");
		stage.setScene(scene);
		System.out.println("8");
		stage.show();
		System.out.println("9");
	}
}
