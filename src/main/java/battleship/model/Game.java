package battleship.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

    private final List<Event> events;

    public Game (){
        events = new ArrayList<Event>();
    }

    public void addEvent (final Event event){
        events.add(event);
    }

    public Stream<Event> getEvents(){
        return events.stream();
    }

    public Set<Coordinate> getActualShotCoordinates(final Player hitPlayer){
        return getEvents()
                .filter(event -> event.isShotEvent(hitPlayer.inverse()))
                .map(event -> ((Shot)event).coordinate)
                .collect(Collectors.toSet());
    }
}
