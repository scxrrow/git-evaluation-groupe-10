import java.util.Scanner;
import java.io.Console;
import java.util.regex.Pattern;

public class Minitrice {

    private static boolean errorOccurred = false;

    private static void processLine(String line) {
        line = line.trim();
        String operator = "";

        if (line.contains("+")) operator = "+";
        else if (line.contains("-")) operator = "-";
        else if (line.contains("*")) operator = "*";
        else if (line.contains("/")) operator = "/";
        else {
            // Erreur de syntaxe si aucun opérateur valide n'est trouvé
            System.err.println("Erreur de syntaxe pour le calcul: \"" + line + "\""); 
            errorOccurred = true; 
            return;
        }

        try {
            String[] parts = line.split(Pattern.quote(operator));
            double num1 = Double.parseDouble(parts[0].trim());
            double num2 = Double.parseDouble(parts[1].trim());
            double result = 0;
            boolean operationDone = false; // Pour savoir si on doit afficher un résultat

            switch (operator) {
                case "+":
                case "-":
                case "*":
                    if (operator.equals("+")) result = num1 + num2;
                    if (operator.equals("-")) result = num1 - num2;
                    if (operator.equals("*")) result = num1 * num2;
                    operationDone = true;
                    break;
                
                case "/":
                    if (num2 == 0) {

                        System.err.println("Division par zéro"); 
                        errorOccurred = true; 
                    } else {
                        result = num1 / num2;
                        operationDone = true;
                    }
                    break;
            }
            

            if(operationDone) {
                System.out.printf("%.2f\n", result);
            }

        } catch (Exception e) {

            System.err.println("Erreur de syntaxe pour le calcul: \"" + line + "\"");
            errorOccurred = true;
        }
    }

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
        if (errorOccurred) {
            System.exit(1); // 
        }
    }

    
}