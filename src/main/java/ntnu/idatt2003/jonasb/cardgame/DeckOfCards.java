package ntnu.idatt2003.jonasb.cardgame;

import java.util.ArrayList;

/**
 * Class representing a deck of playing cards.
 */
public class DeckOfCards {
  /**
   * The deck of cards.
   */
  private ArrayList<PlayingCard> deck;

  /**
   * Creates a new deck of cards.
   */
  public DeckOfCards() {
    deck = new ArrayList<>();
    // Add all 52 cards to the deck
    for (final char suit : PlayingCard.suits) {
      for (int face = 1; face <= 13; face++) {
        deck.add(new PlayingCard(suit, face));
      }
    }
    assert(deck.size() == 52);
  }
}