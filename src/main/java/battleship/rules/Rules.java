package battleship.rules;

import battleship.model.*;

import java.util.*;

public interface Rules {
    int getHorizontalLength();

    Set<Coordinate> getImpossibleCoordinatesAfterShot(
            final Player playerWhoShot,
            final Coordinate shot,
            final Game game
    );

    Optional<Turn> getNextTurn(final Game game);

    int getVerticalLength();

    Optional<Player> getWinner(final Game game);

    boolean placementConflict(
            final Coordinate first,
            final Coordinate second
    );

    default boolean shipPlacement(
            final Game game,
            final ShipType type,
            final Player player,
            final Event event
    ) {
        return false;
    }

    default boolean shot(
            final Game game,
            final Player player,
            final Event event
    ) {
        return false;
    }

    default boolean validCoordinate(final Coordinate coordinate) {
        return false;
    }

    default boolean validShipPlacement(
            final ShipPlacement placement,
            final Collection<Coordinate> shipCoordinates
    ) {
        return false;
    }

    public static boolean isBetween(
            final int lowerBoundInclusive,
            final int number,
            final int upperBoundExclusive
    ) {
        return false;
    }

}
