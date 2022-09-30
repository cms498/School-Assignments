import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PlayingMain {
    public static void main(String[] args) {
        List<PlayingCard> cards = new LinkedList<>();
        cards.add(new PlayingCard(PlayingCard.Rank.TEN, PlayingCard.Suit.DIAMONDS));
        cards.add(new PlayingCard(PlayingCard.Rank.TWO, PlayingCard.Suit.SPADES));
        cards.add(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS));
        cards.add(new PlayingCard(PlayingCard.Rank.FIVE, PlayingCard.Suit.HEARTS));
        cards.add(new PlayingCard(PlayingCard.Rank.FIVE, PlayingCard.Suit.CLUBS));

        System.out.println(cards);

        Collections.sort(cards);

        System.out.println(cards);

        Collections.sort(cards, new RankComparator());

        System.out.println(cards);
    }
}