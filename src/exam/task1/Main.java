package exam.task1;

import static exam.Config.*;
import static exam.FileDBUtils.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Integer, User> users = parseMapFromFile(USERS_FILENAME,
                parts -> new User(Integer.parseInt(parts[0]), parts[1], parts[2]),
                user -> user.ID
        );

        Map<Integer, Tweet> tweets = parseMapFromFile(TWEETS_FILENAME,
                parts -> new Tweet(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2])),
                tweet -> tweet.ID
        );

        List<Retweet> retweets = parseListFromFile(RETWEETS_FILENAME,
                parts -> new Retweet(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]))
        );

        users.values()
                .stream()
                .filter(user -> user.birthCity.equals("Екатеринбург"))
                .forEach(user -> {
                    System.out.printf("Пользователь: %s", user.username);
                    retweets.stream()
                            .filter(retweet -> retweet.userID == user.ID)
                            .forEach(retweet -> {
                                Tweet tweet = tweets.get(retweet.tweetID);
                                if (users.get(tweet.authorID).birthCity.equals("Москва")) {
                                    System.out.printf("\t%s\n", tweet.body);
                                }
                            });
                });
    }
}

