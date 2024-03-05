package ntnu.idatt2003.jonasb.cardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for PlayingCard.
 */
public class PlayingCardTest {
  @Test
  public void testCreateCard() {
    PlayingCard card = new PlayingCard('S', 1);
    assertEquals('S', card.getSuit());
    assertEquals(1, card.getFace());
  }

  @Test
  public void testToString() {
    PlayingCard card = new PlayingCard('S', 1);
    assertEquals("S1", card.getAsString());
  }

  @Test
  public void testEquals() {
    PlayingCard card1 = new PlayingCard('C', 3);
    PlayingCard card2 = new PlayingCard('C', 3);
    assertEquals(card1, card2);
  }

  @Test
  public void testHashCode() {
    PlayingCard card1 = new PlayingCard('H', 11);
    PlayingCard card2 = new PlayingCard('H', 11);
    assertEquals(card1.hashCode(), card2.hashCode());
  }

  @Test
  public void testCreateCardInvalidSuit() {
    try {
      new PlayingCard('X', 1);
    } catch (IllegalArgumentException e) {
      assertEquals("Parameter suit must be one of H, D, C or S", e.getMessage());
    }
  }

  @Test
  public void testCreateCardInvalidFace() {
    try {
      new PlayingCard('H', 0);
    } catch (IllegalArgumentException e) {
      assertEquals("Parameter face must be a number between 1 to 13", e.getMessage());
    }
  }
}