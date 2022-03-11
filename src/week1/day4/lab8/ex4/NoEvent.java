package week1.day4.lab8.ex4;
class NoEvent extends Event{

    NoEvent() {
        super(EventType.NONE);
    }

    @Override
    public String toString() {
        return "NoEvent{}";
    }
}