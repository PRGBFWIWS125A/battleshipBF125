package battleship.model;

import java.util.UUID;

public abstract class Event implements Comparable<Event> {
    private final UUID id;
    private final long timestamp;

    public Event() {
        this(UUID.randomUUID(), System.currentTimeMillis());
    }

    public Event(UUID id, long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    public int compareTo(Event other) {
        int result = Long.compare(this.timestamp, other.timestamp);
        return result != 0 ? result : this.id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Event)) return false;
        return this.id.equals(((Event) obj).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode() * 3;
    }

    public abstract boolean isShipPlacementEvent(Player player);

    public abstract boolean isShotEvent(Player player);
}
