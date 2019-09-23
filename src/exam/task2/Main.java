package exam.task2;

import exam.task1.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static exam.Config.USERS_FILENAME;
import static exam.FileDBUtils.parseListFromFile;

public class Main {
    public static void main(String[] args) throws IOException {
        List<User> users = parseListFromFile(USERS_FILENAME,
                parts -> new User(Integer.parseInt(parts[0]), parts[1], parts[2])
        );

        users.sort(new UsersCityComparator());

        OutputStream outputStream = Files.newOutputStream(Paths.get("assets/sorted.users"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (User user : users) {
            writer.write(user.toString());
            writer.newLine();
        }
        writer.close();
    }
}
