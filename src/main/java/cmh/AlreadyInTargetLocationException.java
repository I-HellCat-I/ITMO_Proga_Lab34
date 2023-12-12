package cmh;

class AlreadyInTargetLocationException extends Exception {

    public AlreadyInTargetLocationException(Entity entity, Location loc) {
        super(entity + " уже в " + loc);
    }
}
