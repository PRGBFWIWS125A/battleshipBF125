package battleship.model;

import battleship.rules.Rules;

public record EventAndState(Rules rules, Game game, Event event) {
}
