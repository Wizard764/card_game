package ntnu.idatt2003.jonasb.cardgame;

import java.util.Collection;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CardGameApplication extends Application {
  private final DeckOfCards deck = new DeckOfCards();
  private Collection<PlayingCard> hand;
  TextField sumOfFacesTextField = new TextField();
  TextField heartsCountTextField = new TextField();
  TextField flushTextField = new TextField();
  TextField queenOfSpadesTextField = new TextField();
  @Override
  public void start(Stage stage) throws IOException {

    sumOfFacesTextField.setEditable(false);
    heartsCountTextField.setEditable(false);
    flushTextField.setEditable(false);
    queenOfSpadesTextField.setEditable(false);

    BorderPane root = new BorderPane();

    HBox leftBox = new HBox();
    leftBox.setPrefWidth(440);
    root.setLeft(leftBox);
    VBox rightBox = new VBox();

    Button btnDeal = new Button("Deal hand");
    btnDeal.setOnAction(e -> {
      hand = deck.dealHand(5);
      leftBox.getChildren().clear(); // Clear previous cards/labels
      leftBox.setSpacing(10); // Set spacing between labels
      leftBox.setAlignment(Pos.CENTER); // Center the labels in the HBox

      for (PlayingCard card : hand) {
        Label label = new Label(card.getAsString());
        // Increase the font size of the label text
        label.setStyle("-fx-font-size: 40px;"); // You can adjust the font size as needed

        leftBox.getChildren().add(label);
      }
    });

    Button btnCheck = new Button("Check hand");
    btnCheck.setOnAction(e -> {
      if (hand != null && !hand.isEmpty()) {
        // Sum of the faces
        int sumOfFaces = hand.stream()
            .mapToInt(PlayingCard::getFace)
            .sum();
        sumOfFacesTextField.setText(String.valueOf(sumOfFaces));

        // Cards of hearts
        String hearts = hand.stream()
            .filter(card -> card.getSuit() == 'H') // Assuming 'H' represents hearts
            .map(card -> "H" + card.getFace()) // Map each card to its string representation
            .collect(Collectors.joining(" ")); // Join them with a space
        heartsCountTextField.setText(hearts);

        // Check for flush (all cards of the same suit)
        boolean isFlush = hand.stream()
            .map(PlayingCard::getSuit)
            .distinct()
            .count() == 1;
        flushTextField.setText(isFlush ? "Yes" : "No");

        // Check for Queen of Spades
        boolean hasQueenOfSpades = hand.stream()
            .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12); // Assuming 'S' represents spades and 12 represents queen
        queenOfSpadesTextField.setText(hasQueenOfSpades ? "Yes" : "No");
      }
    });
    String buttonStyle = "-fx-font-size: 16px; -fx-padding: 10px; -fx-min-width: 100px;";
    btnDeal.setStyle(buttonStyle);
    btnCheck.setStyle(buttonStyle);

    rightBox.getChildren().addAll(btnDeal, btnCheck);
    root.setRight(rightBox);

    VBox bottomBox = new VBox();
    bottomBox.setAlignment(Pos.CENTER);
    bottomBox.setPrefHeight(100);

    HBox bottomTopBox = new HBox();
    bottomTopBox.setAlignment(Pos.CENTER);
    bottomTopBox.setPrefHeight(50);
    Label bottomTopLeftText = new Label("Sum of the faces:");
    sumOfFacesTextField.setPrefWidth(60);
    Label bottomTopRightText = new Label("Cards of hearts:");
    heartsCountTextField.setPrefWidth(60);
    bottomTopBox.getChildren().addAll(bottomTopLeftText, sumOfFacesTextField, bottomTopRightText, heartsCountTextField);

    HBox bottomBottomBox = new HBox();
    bottomBottomBox.setAlignment(Pos.CENTER);
    bottomBottomBox.setPrefHeight(50);
    Label bottomBottomLeftText = new Label("Flush:");
    flushTextField.setPrefWidth(60);
    Label bottomBottomRightText = new Label("Queen of spades:");
    queenOfSpadesTextField.setPrefWidth(60);
    bottomBottomBox.getChildren().addAll(bottomBottomLeftText, flushTextField, bottomBottomRightText, queenOfSpadesTextField);

    bottomBox.getChildren().addAll(bottomTopBox, bottomBottomBox);

    root.setBottom(bottomBox);

    Scene scene = new Scene(root, 640.0f, 360.0f);

    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}