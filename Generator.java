import java.util.Random;

public class Generator {

    public static void main(String[] args) {
        
        if (args.length == 0) {
            System.err.println("Erreur: Vous devez fournir un nombre d'expressions à générer.");
            System.err.println("Usage: ./generator <nombre>");
            System.exit(1); 
        }

        int numToGenerate = 0;

        try {
            numToGenerate = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erreur: L'argument '" + args[0] + "' n'est pas un nombre entier valide.");
            System.exit(1);
        }

        Random rand = new Random();
        String[] operators = {"+", "-", "*", "/"}; 

        for (int i = 0; i < numToGenerate; i++) {
            
            int num1 = rand.nextInt(1000) + 1; 
            int num2 = rand.nextInt(1000) + 1;

            String operator = operators[rand.nextInt(4)]; 

            System.out.println(num1 + operator + num2);
        }
    }
}