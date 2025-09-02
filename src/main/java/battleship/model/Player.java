package battleship.model;

public enum Player {
    FIRST,
    SECOND;

    public Player inverse() {
        switch (this) {
            case FIRST:
                return SECOND;
            case SECOND:
                return FIRST;
        }
        return null; //default
    }
}
