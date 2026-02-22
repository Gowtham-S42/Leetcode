package text_editor;

import java.util.*;

public class TextEditor {
    private static final int LINE_WIDTH = 40;
    private List<String> lines;

    public TextEditor() {
        lines = new ArrayList<>();
        String defaultText = "Independence Day, observed annually on 15 August, is a national holiday in India " +
                "commemorating the nation's independence from British rule on 15 August 1947.";
        insertText(defaultText);
    }

    // Insert text with word wrapping
    public void insertText(String text) {
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentLine.length() + word.length() + 1 <= LINE_WIDTH) {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                lines.add(currentLine.toString());
                currentLine = new StringBuilder(word);
            }
        }
        if (currentLine.length() > 0) {
            lines.add(currentLine.toString());
        }
    }

    // Insert characters at a specific position
    public void insertAt(int lineNo, int column, String text) {
        if (lineNo < 1 || lineNo > lines.size()) {
            System.out.println("Invalid line number.");
            return;
        }

        String line = lines.get(lineNo - 1);
        if (column < 0 || column > line.length()) {
            System.out.println("Invalid column position.");
            return;
        }

        String newLine = line.substring(0, column) + text + line.substring(column);
        lines.set(lineNo - 1, newLine);
        rewrapLines();
    }

    // Delete characters from a specific range
    public void deleteCharacters(int lineNo, int start, int end) {
        if (lineNo < 1 || lineNo > lines.size()) {
            System.out.println("Invalid line number.");
            return;
        }

        String line = lines.get(lineNo - 1);
        if (start < 0 || end > line.length() || start > end) {
            System.out.println("Invalid start or end position.");
            return;
        }

        String newLine = line.substring(0, start) + line.substring(end);
        lines.set(lineNo - 1, newLine);
        rewrapLines();
    }

    // Delete a whole line
    public void deleteLine(int lineNo) {
        if (lineNo < 1 || lineNo > lines.size()) {
            System.out.println("Invalid line number.");
            return;
        }
        lines.remove(lineNo - 1);
        rewrapLines();
    }

    // Search for a word and print its locations
    public void search(String word) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            int index = line.indexOf(word);
            while (index != -1) {
                System.out.println("Line " + (i + 1) + ", Column " + (index + 1));
                index = line.indexOf(word, index + 1);
            }
        }
    }

    // Find and replace a word in the whole text
    public void findAndReplace(String find, String replace) {
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains(find)) {
                lines.set(i, line.replace(find, replace));
            }
        }
        rewrapLines();
    }

    // Print all text
    public void printText() {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    // Count the number of words in the text
    public int countWords() {
        int wordCount = 0;
        for (String line : lines) {
            String[] words = line.split(" ");
            wordCount += words.length;
        }
        return wordCount;
    }

    // Rewrap lines to ensure word wrapping
    private void rewrapLines() {
        List<String> newLines = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();

        for (String line : lines) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (currentLine.length() + word.length() + 1 <= LINE_WIDTH) {
                    if (currentLine.length() > 0) {
                        currentLine.append(" ");
                    }
                    currentLine.append(word);
                } else {
                    newLines.add(currentLine.toString());
                    currentLine = new StringBuilder(word);
                }
            }
        }
        if (currentLine.length() > 0) {
            newLines.add(currentLine.toString());
        }
        lines = newLines;
    }
}