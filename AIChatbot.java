import java.util.Locale;
import java.util.Scanner;

public class AIChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Java FAQ Chatbot ===");
        System.out.println("Hello! Ask me about Java, programming, or this chatbot.");
        System.out.println("Type 'help' to see topics or 'exit' to quit.");

        while (true) {
            System.out.print("\\nYou: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Bot: Please type a question or 'help'.");
                continue;
            }

            String normalized = normalize(input);
            if (normalized.equals("exit") || normalized.equals("quit") || normalized.equals("bye")) {
                System.out.println("Bot: Goodbye! Keep learning and coding.");
                break;
            }
            System.out.println("Bot: " + respond(normalized));
        }
        scanner.close();
    }

    // Lightweight rule-based NLP: normalize text, match keywords and simple phrases.
    private static String normalize(String input) {
        return input.toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9\\s]", " ")
                .replaceAll("\\\\s+", " ")
                .trim();
    }

    private static String respond(String text) {
        if (text.equals("help") || text.contains("what can you do"))
            return "I can answer common questions about Java, OOP, arrays, loops, and this chatbot.";
        if (containsAny(text, "hello", "hi", "hey", "good morning", "good evening"))
            return "Hello! How can I help you today?";
        if (text.contains("your name") || text.contains("who are you"))
            return "I'm a simple Java FAQ chatbot built with rule-based natural language processing.";
        if (text.contains("java")) {
            if (text.contains("what is") || text.contains("explain"))
                return "Java is a high-level, class-based programming language designed to run on many platforms using the JVM.";
            if (text.contains("jvm"))
                return "The Java Virtual Machine (JVM) executes Java bytecode and enables platform independence.";
            return "Java is commonly used for backend services, desktop tools, Android development, and enterprise software.";
        }
        if (text.contains("object oriented") || text.equals("oop") || text.contains("oops"))
            return "OOP organizes programs around objects. Four common principles are encapsulation, inheritance, polymorphism, and abstraction.";
        if (text.contains("array"))
            return "An array stores a fixed-size sequence of values of the same type. Use ArrayList when you need a resizable collection.";
        if (text.contains("loop") || text.contains("for loop") || text.contains("while loop"))
            return "Loops repeat code. Use for when iteration is count-controlled, and while when repetition depends on a condition.";
        if (text.contains("internship") || text.contains("codealpha"))
            return "This project is a CodeAlpha Java task demonstrating an interactive, rule-based chatbot.";
        if (text.contains("thank"))
            return "You're welcome! Ask me another programming question.";
        if (text.contains("how are you"))
            return "I'm running well and ready to answer questions!";
        return "I'm not sure about that yet. Try asking about Java, JVM, OOP, arrays, loops, or type 'help'.";
    }

    private static boolean containsAny(String text, String... phrases) {
        for (String phrase : phrases) {
            if (text.equals(phrase) || text.startsWith(phrase + " ") || text.contains(" " + phrase + " "))
                return true;
        }
        return false;
    }
}
