package exam;

import exam.task1.Deserializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileDBUtils {
    public static <T> Map<Integer, T> parseMapFromFile(String filename, Deserializer<T> deserializer, Function<T, Integer> keyMapper) throws IOException {
        return Files.readAllLines(Paths.get(filename))
                .stream()
                .map(line -> line.split(" ", 3))
                .map(deserializer::deserialize)
                .collect(Collectors.toMap(keyMapper, t -> t));
    }

    public static <T> List<T> parseListFromFile(String filename, Deserializer<T> deserializer) throws IOException {
        return Files.readAllLines(Paths.get(filename))
                .stream()
                .map(line -> line.split(" ", 3))
                .map(deserializer::deserialize)
                .collect(Collectors.toList());
    }
}
