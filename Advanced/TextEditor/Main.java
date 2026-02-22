package text_editor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert\n2. Delete Characters\n3. Delete Line\n4. Search\n5. Find and Replace\n6. Print Text\n7. Number of Words\n8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter line number: ");
                    int lineNo = scanner.nextInt();
                    System.out.print("Enter column position: ");
                    int column = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter text to insert: ");
                    String text = scanner.nextLine();
                    editor.insertAt(lineNo, column, text);
                    break;

                case 2:
                    System.out.print("Enter line number: ");
                    lineNo = scanner.nextInt();
                    System.out.print("Enter start position: ");
                    int start = scanner.nextInt();
                    System.out.print("Enter end position: ");
                    int end = scanner.nextInt();
                    editor.deleteCharacters(lineNo, start, end);
                    break;

                case 3:
                    System.out.print("Enter line number to delete: ");
                    lineNo = scanner.nextInt();
                    editor.deleteLine(lineNo);
                    break;

                case 4:
                    System.out.print("Enter word to search: ");
                    String word = scanner.nextLine();
                    editor.search(word);
                    break;

                case 5:
                    System.out.print("Enter word to find: ");
                    String find = scanner.nextLine();
                    System.out.print("Enter word to replace: ");
                    String replace = scanner.nextLine();
                    editor.findAndReplace(find, replace);
                    break;

                case 6:
                    editor.printText();
                    break;

                case 7:
                    System.out.println("Number of words: " + editor.countWords());
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}