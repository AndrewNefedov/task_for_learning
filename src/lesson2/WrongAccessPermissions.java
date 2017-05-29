package lesson2;

class WrongAccessPermissions extends RuntimeException {

    WrongAccessPermissions(final String message) {
        super(message);
    }
}
