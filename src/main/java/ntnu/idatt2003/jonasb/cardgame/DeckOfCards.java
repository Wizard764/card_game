package ntnu.idatt2003.jonasb.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Class representing a deck of playing cards.
 */
public class DeckOfCards {
  /**
   * The deck of cards.
   */
  private final ArrayList<PlayingCard> deck;

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

  /**
   * Deals a hand of cards from the deck.
   *
   * @param n the number of cards to deal
   * @return a hand of n cards
   * @throws IllegalArgumentException if n is negative or greater than the number of cards in the deck
   */
  public Collection<PlayingCard> dealHand(int n) throws IllegalArgumentException {
    if (n < 0 || n > deck.size()) {
      throw new IllegalArgumentException("Invalid number of cards to deal");
    }

    Collection<PlayingCard> hand = new ArrayList<>();
    while (hand.size() < n) {
      // Pick random card from deck, but only add it if it is not already in the hand
      Random random = new Random();
      PlayingCard card = deck.get(random.nextInt(deck.size()));
      if (!hand.contains(card)) {
        hand.add(card);
      }
    }
    return hand;
  }
}