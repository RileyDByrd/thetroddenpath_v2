package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.ChanceCard;

public class CardEffects {

	public static void message(ChanceCard chanceCard) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Card Effect");
		
		Text text = new Text();
		text.setText(chanceCard.toString());
		text.setTextAlignment(TextAlignment.CENTER);
		Button button = new Button("Okay");
		button.setOnAction(e -> {
			stage.close();
		});
		
		VBox layout = new VBox(15);
		layout.getChildren().addAll(text, button);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 800, 110);
		stage.setScene(scene);
		stage.show();
	}
}
