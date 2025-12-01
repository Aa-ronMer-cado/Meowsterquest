package util;

public class TextUtil {

    public static final int DEFAULT_WIDTH = 160;

    /* ---------------------- CENTERED PRINT ---------------------- */

    public static void printCentered(String text) {
        printCentered(text, DEFAULT_WIDTH);
    }

    public static void printCentered(String text, int width) {
        int padding = Math.max(0, (width - text.length()) / 2);
        System.out.println(" ".repeat(padding) + text);
    }

    /* ---------------------- MULTILINE CENTER ---------------------- */

    public static void printMiddle(String text) {
        printMiddle(text, DEFAULT_WIDTH);
    }

    public static void printMiddle(String text, int width) {
        for (String line : text.split("\n")) {
            int padding = Math.max(0, (width - line.length()) / 2);
            System.out.println(" ".repeat(padding) + line);
        }
    }

    /* ---------------------- TYPEWRITER PRINT ---------------------- */

    public static void typewriterPrint(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(50);
        }
        System.out.println();
    }

    /* ---------------------- TITLES ---------------------- */

    public static void printTitle(String title) {
        printTitle(title, DEFAULT_WIDTH);
    }

    public static void printTitle(String title, int width) {
        int padding = Math.max(0, (width - title.length()) / 2);
        String spacing = " ".repeat(padding);

        System.out.println("=".repeat(width));
        System.out.println(spacing + title);
        System.out.println("=".repeat(width));
    }

    /* ---------------------- CLEAR SCREEN ---------------------- */

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /* ---------------------- UTILITY ---------------------- */

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void pause(int ms) {
        sleep(ms);
    }
}