package battleship.rules;

import java.util.*;

import battleship.model.*;

public class StandardRules implements Rules {

    public static final StandardRules INSTANCE = null;

    @Override
    public int getHorizontalLength() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Set<Coordinate> getImpossibleCoordinatesAfterShot(Player playerWhoShot, Coordinate shot, Game game) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Turn> getNextTurn(Game game) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public int getVerticalLength() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Optional<Player> getWinner(Game game) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public boolean placementConflict(Coordinate first, Coordinate second) {
        // TODO Auto-generated method stub
        return false;
    }

}
