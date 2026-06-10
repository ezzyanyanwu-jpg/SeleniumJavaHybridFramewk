package utils;

import java.util.function.Supplier;

public class RetryAnalyzer {

    private static final int MAX_RETRIES = 3;

    public static void executeWithRetry(
            Runnable action) {

        int attempts = 0;

        while (attempts < MAX_RETRIES) {

            try {

                action.run();
                return;

            } catch (Exception e) {

                attempts++;

                if (attempts == MAX_RETRIES) {

                    throw e;
                }

                System.out.println(
                        "Retry Attempt: "
                                + attempts);
            }
        }
    }

    public static <T> T executeWithRetry(
            Supplier<T> action) {

        int attempts = 0;

        while (attempts < MAX_RETRIES) {

            try {

                return action.get();

            } catch (Exception e) {

                attempts++;

                if (attempts == MAX_RETRIES) {

                    throw e;
                }
            }
        }

        return null;
    }
}