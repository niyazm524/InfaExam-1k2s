package exam.task1;

@FunctionalInterface
public interface Deserializer<T> {
    T deserialize(String[] parts);
}
