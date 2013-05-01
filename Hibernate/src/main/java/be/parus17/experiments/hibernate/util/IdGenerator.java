package be.parus17.experiments.hibernate.util;

import java.util.UUID;

public final class IdGenerator {

    private IdGenerator() {
    }

    public static String createId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
