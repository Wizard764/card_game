module ntnu.idatt2003.jonasb.cardgame {
  requires javafx.controls;
  requires javafx.fxml;


  opens ntnu.idatt2003.jonasb.cardgame to javafx.fxml;
  exports ntnu.idatt2003.jonasb.cardgame;
}