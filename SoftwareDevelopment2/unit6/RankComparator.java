import java.util.Comparator;

public class RankComparator implements Comparator<PlayingCard>{

    @Override
    public int compare(PlayingCard a, PlayingCard b) {
        PlayingCard.Rank aRank = a.getRank();
        PlayingCard.Rank bRank = b.getRank();
        return aRank.getRank() - bRank.getRank();
    }
}