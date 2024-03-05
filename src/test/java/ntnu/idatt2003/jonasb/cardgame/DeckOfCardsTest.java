package ntnu.idatt2003.jonasb.cardgame;

import org.junit.jupiter.api.Test;

import java.util.Collection;

/**
 * Unit test for DeckOfCards.
 */
public class DeckOfCardsTest {
  @Test
  public void testCreateDeck() {
    DeckOfCards deck = new DeckOfCards();
  }

  @Test
  public void testDealHand() {
    DeckOfCards deck = new DeckOfCards();
    deck.dealHand(5);
  }

  @Test
  public void testDealHandInvalid() {
    DeckOfCards deck = new DeckOfCards();
    try {
      deck.dealHand(-1);
    } catch (IllegalArgumentException e) {
      // Expected
    }
  }

  @Test
  public void testDealHandAssertUniqueCards() {
    DeckOfCards deck = new DeckOfCards();
    Collection<PlayingCard> cards = deck.dealHand(5);
    //Check that all cards in hand are unique using hashCode
    for (PlayingCard card1 : cards) {
      for (PlayingCard card2 : cards) {
        // Check that the cards are either the same exact card or have different hash codes
        assert card1 == card2 || (card1.hashCode() != card2.hashCode());
      }
    }
  }
}