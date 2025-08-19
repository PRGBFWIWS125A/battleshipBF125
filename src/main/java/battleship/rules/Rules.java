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
        if (event.isShipPlacementEvent(player) &&
                ((ShipPlacement) event).type.equals(type) &&
                validShipPlacement((ShipPlacement) event, game.getShipCoordinates(player))) {
            game.addEvent(event);
            return true;
        }
        return false;
    }

    default boolean shot(
            final Game game,
            final Player player,
            final Event event
    ) {
        if (event.isShotEvent(player) && validCoordinate(((Shot) event).coordinate)) {
            game.addEvent(event);
            return true;
        }
        return false;
    }

    default boolean validCoordinate(final Coordinate coordinate) {

        return isBetween(0, coordinate.column(), getHorizontalLength()) &&
                isBetween(0, coordinate.row(), getVerticalLength());
    }

    default boolean validShipPlacement(
            final ShipPlacement placement,
            final Collection<Coordinate> shipCoordinates
    ) {
        return placement.toCoordinates().allMatch(coordinate -> validCoordinate(coordinate) &&
                shipCoordinates.stream().noneMatch(existingCoordinate -> placementConflict(coordinate, existingCoordinate)));
    }

    public static boolean isBetween(
            final int lowerBoundInclusive,
            final int number,
            final int upperBoundExclusive
    ) {
        return number >= lowerBoundInclusive && number < upperBoundExclusive;
    }

}
