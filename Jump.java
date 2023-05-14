public class Jump {
    Integer start;
    Integer end;
    //by default start, end are public in class Jump
    //if we declare them private we would have to define method like getter and setters

    public Jump(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }
}
