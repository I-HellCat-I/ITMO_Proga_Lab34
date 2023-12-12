package cmh;

public class SquadNotInTheAirException extends RuntimeException{
    public SquadNotInTheAirException(String s) {
        super(s + " не в воздухе");
    }
}

