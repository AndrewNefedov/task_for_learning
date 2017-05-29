package lesson2;

public class NotRegisteredSerializer extends RuntimeException {

    public NotRegisteredSerializer(String msg) {
        super(msg);
    }
}
