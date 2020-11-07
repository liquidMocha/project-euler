package poker.hands;

public enum Rank {
    High_Card(0),
    One_Pair(1),
    Two_Pairs(2),
    Three_of_a_Kind(3),
    Straight(4),
    Flush(5),
    Full_House(6),
    Four_of_a_Kind(7),
    Straight_Flush(8),
    Royal_Flush(9);

    int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
