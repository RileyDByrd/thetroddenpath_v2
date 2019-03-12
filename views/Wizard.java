package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Wizard {

	public static void giveUp() {
		Stage prompt = new Stage();
		prompt.setTitle("Are You Sure?");
		prompt.initModality(Modality.APPLICATION_MODAL);
		
		Text label = new Text();
		label.setText("I wouldn't recommend that unless you like death by fire or water");
		Button ok = new Button("ok");
		ok.setOnAction(e -> prompt.close());
		
		VBox layout = new VBox(15);
		layout.getChildren().addAll(label, ok);
		Scene scene = new Scene(layout, 350, 100);
		prompt.setScene(scene);
		prompt.show();
	}
}
