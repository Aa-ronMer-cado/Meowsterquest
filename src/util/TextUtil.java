package util;

public class TextUtil {

    private static final String TYPING_SFX_PATH = "src/resource/TypingSound.wav";
    public static final int DEFAULT_WIDTH = 160;

    /* ---------------------- CENTERED PRINTING ---------------------- */

    public static void printCentered(String text) {
        printCentered(text, DEFAULT_WIDTH);
    }

    public static void printCentered(String text, int width) {
        System.out.println(getCenteredText(text, width));
    }

    private static String getCenteredText(String text, int width) {
        int padding = Math.max(0, (width - text.length()) / 2);
        return " ".repeat(padding) + text;
    }

    /* ---------------------- TYPEWRITER PRINTING (NO SOUND) ---------------------- */

    public static void typewriterPrint(String text) {
        typewriterPrint(text, 40);
    }

    public static void typewriterPrint(String text, int delayMs) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delayMs);
        }
        System.out.println();
    }

    public static void typewriterPrintCentered(String text, int delayMs) {
        typewriterPrintCentered(text, delayMs, DEFAULT_WIDTH);
    }

    public static void typewriterPrintCentered(String text, int delayMs, int width) {
        int padding = Math.max(0, (width - text.length()) / 2);
        System.out.print(" ".repeat(padding));
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delayMs);
        }
        System.out.println();
    }

    /* ---------------------- TYPEWRITER PRINTING (WITH SOUND) ---------------------- */

    public static void typewriterPrint(String text, int delayMs, MusicUtil musicUtil) {
        musicUtil.startTypingSFX(TYPING_SFX_PATH);
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delayMs);
        }
        System.out.println();
        musicUtil.stopTypingSFX();
    }

    public static void typewriterPrint(String text, MusicUtil musicUtil) {
        typewriterPrint(text, 40, musicUtil);
    }

    public static void typewriterPrintCentered(String text, int delayMs, int width, MusicUtil musicUtil) {
        int padding = Math.max(0, (width - text.length()) / 2);
        
        musicUtil.startTypingSFX(TYPING_SFX_PATH);
        System.out.print(" ".repeat(padding));
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delayMs);
        }
        System.out.println();
        musicUtil.stopTypingSFX();
    }

    /* ---------------------- TITLES AND FORMATTING ---------------------- */

    public static void printTitle(String title) {
        printTitle(title, DEFAULT_WIDTH);
    }

    public static void printTitle(String title, int width) {
        int spacing = Math.max(0, (width - title.length()) / 2);
        String space = " ".repeat(spacing);

        System.out.println("=".repeat(width));
        System.out.println(space + title);
        System.out.println("=".repeat(width));
    }

    public static void printMiddle(String text, int width) {
        int spacing = Math.max(0, (text.split("\n")[0].length() - text.length()) / 2);
        for (String line : text.split("\n")) {
            System.out.println(" ".repeat(Math.max(0, (width - line.length()) / 2)) + line);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /* ---------------------- UTILITY METHODS ---------------------- */

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void pause(int milliseconds) {
        sleep(milliseconds);
    }
}