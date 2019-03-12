package views;

import controllers.Controller;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import models.Player;
import models.Wheel;
import models.enums.TileDirection;

public class Connection {

	@FXML
	private Circle player1;

	@FXML
	private Circle player2;

	@FXML
	private Circle player3;

	@FXML
	private Circle player4;

	@FXML
	private Pane spinner;

    @FXML
    private Text charClass;
	
	@FXML
	private Text playerName = new Text();

	@FXML
	private Text shekels = new Text();

	@FXML
	private Text prestige = new Text();

	@FXML
	private Text wellness = new Text();

	@FXML
	private Text limbsRemaining = new Text();

	@FXML
	private Text family = new Text();

	@FXML
	private Text position = new Text();

	public static void updateView() {
//    	playerName.setText(Controller.currentPlayer.toString());
	}

	public void spinWheel() {
		if(Controller.checkForWin()) {
			views.Main.endGame();
		} else if(Controller.currentPlayer.getChars().size() < 1 || Controller.currentPlayer.getChars().get(0).getOccupiedTile() >= 100 || Controller.currentPlayer.getChars().get(0).getWellness() <= 0) {
			Controller.changeTurn();
		}
		int spunNumber = Wheel.spinWheel();
		// animation to move that many spaces
		animateWheel(spunNumber);
		for (int i = 0; i < spunNumber; i++) {
			if(Controller.currentPlayer.getChars().size() > 0 && Controller.currentPlayer.getChars().get(0).getOccupiedTile() < 100) {
				animatePiece();
			}
		}
		if(Controller.currentPlayer.getChars().size() > 0 && Controller.currentPlayer.getChars().get(0).getOccupiedTile() < 100) {
			Controller.drawCard();
		}
	}

public void animateWheel(int spinAmount) {
        RotateTransition transition = new RotateTransition(Duration.seconds(2.5), spinner);
        transition.getNode().setRotate(0);
        switch (spinAmount) {
        case 1:
            transition.setByAngle(342);
            transition.play();
            
            break;
        case 2:
            transition.setByAngle(306);
            transition.play();
            break;
        case 3:
            transition.setByAngle(270);
            transition.play();
            break;
        case 4:
            transition.setByAngle(234);
            transition.play();
            break;
        case 5:
            transition.setByAngle(198);
            transition.play();
            break;
        case 6:
            transition.setByAngle(162);
            transition.play();
            break;
        case 7:
            transition.setByAngle(126);
            transition.play();
            break;
        case 8:
            transition.setByAngle(90);
            transition.play();
            break;
        case 9:
            transition.setByAngle(54);
            transition.play();
            break;
        case 10:
            transition.setByAngle(18);
            transition.play();
            break;

        }

    }

	private static double player1X = 0;
	private static double player1Y = 0;
	private static double player2X = 0;
	private static double player2Y = 0;
	private static double player3X = 0;
	private static double player3Y = 0;
	private static double player4X = 0;
	private static double player4Y = 0;

	public void animatePiece() {

		Player currentPlayer = Controller.currentPlayer;
		int playerNum = currentPlayer.getPlayerID();
		int occupiedTile = currentPlayer.getChars().get(0).getOccupiedTile();
		TileDirection ntd = Controller.TILES.get(occupiedTile).getValue();
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.millis(1000));
		currentPlayer.getChars().get(0).changeTile(1);

		double currentX;
		double currentY;

		switch (playerNum) {
		case 2:
			transition.setNode(player2);
			currentX = player2X;
			currentY = player2Y;
			break;
		case 3:
			transition.setNode(player3);
			currentX = player3X;
			currentY = player3Y;
			break;
		case 4:
			transition.setNode(player4);
			currentX = player4X;
			currentY = player4Y;
			break;
		default:
			transition.setNode(player1);
			currentX = player1X;
			currentY = player1Y;
		}

		switch (ntd) {
		case DOWN:
			transition.setToY(currentY + 40);
			currentY += 40;
			break;
		case UP:
			transition.setToY(currentY - 40);
			currentY -= 40;
			break;
		case LEFT:
			transition.setToX(currentX - 40);
			currentX -= 40;
			break;
		case RIGHT:
			transition.setToX(currentX + 40);
			currentX += 40;
			break;
		}
		transition.play();

		switch (playerNum) {
		case 1:
			player1X = currentX;
			player1Y = currentY;
			break;
		case 2:
			player2X = currentX;
			player2Y = currentY;
			break;
		case 3:
			player3X = currentX;
			player3Y = currentY;
			break;
		case 4:
			player4X = currentX;
			player4Y = currentY;
			break;
		}

		// updating the view because no other choice
		playerName.setText(currentPlayer.NAME);
		// CharName playerName.setText(currentPlayer.getChars().get(0).CHARNAME);
		shekels.setText("Shekels: " + currentPlayer.getChars().get(0).getShekels());
		prestige.setText("Prestige: " + currentPlayer.getChars().get(0).getPrestige());
		wellness.setText("Wellness: " + currentPlayer.getChars().get(0).getWellness());
//		limbsRemaining.setText("Limbs Remaining: " + currentPlayer.getChars().get(0).getLimbs().size());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < currentPlayer.getChars().size(); i++) {
			sb.append(currentPlayer.getChars().get(i).getRole() + ": " + currentPlayer.getChars().get(i).CHARNAME).append(" ");
		}
		family.setText(sb.toString());
		charClass.setText("Class: " + currentPlayer.getChars().get(0).getCharClass());

	}

	public void sellFamily() {
		controllers.Controller.checkForFam();
	}

	public void giveUp() {
		views.Wizard.giveUp();
	}
}