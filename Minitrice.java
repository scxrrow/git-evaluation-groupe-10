import java.util.Scanner;
import java.io.Console;
import java.util.regex.Pattern;

public class Minitrice {

    public static void main(String[] args) {
        
        Console console = System.console();

        if (console != null) {
            String line;
            
            while ((line = console.readLine("> ")) != null) {
                if (!line.trim().isEmpty()) {
                    processLine(line);
                }
            }
            
            System.out.println("Fin des calculs");
            
        } else {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processLine(line);
            }
            scanner.close();
        }
    }

    private static void processLine(String line) {
        line = line.trim();
        String operator = "";

        if (line.contains("+")) operator = "+";
        else if (line.contains("-")) operator = "-";
        else if (line.contains("*")) operator = "*";
        else if (line.contains("/")) operator = "/";
        else {
            return;
        }

        try {
            String[] parts = line.split(Pattern.quote(operator));
            double num1 = Double.parseDouble(parts[0].trim());
            double num2 = Double.parseDouble(parts[1].trim());
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    result = num1 / num2; 
                    break;
            }
            
            System.out.printf("%.2f\n", result);

        } catch (Exception e) {
            System.err.println("Erreur de syntaxe.");
        }
    }
}