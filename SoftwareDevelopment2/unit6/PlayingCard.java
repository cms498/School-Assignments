public class PlayingCard implements Comparable<PlayingCard>{
    enum Suit{
        CLUBS("Clubs"),
        DIAMONDS("Diamonds"),
        HEARTS("Hearts"),
        SPADES("Spades");

        private final String name;

        private Suit(String name){
            this.name = name;
        }

        public String getSuit() {
            return name;
        }
    }

    enum Rank{
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private final int rank;

        private Rank(int rank){
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }
    }

    private final Rank rank;
    private final Suit suit;

    public PlayingCard(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString(){
        return rank.getRank() + " of " + suit.getSuit();
    }

    @Override
    public int compareTo(PlayingCard other) {
        String mySuit = suit.getSuit().toLowerCase();
        String otherSuit = other.suit.getSuit().toLowerCase();

        int result = mySuit.compareTo(otherSuit);
        if(result == 0){
            return rank.getRank() - other.rank.getRank();
        } else {
            return result;
        }
    }
}