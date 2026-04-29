import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        try {
            File file = new File("../diccionario.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                // Ignorar líneas vacías
                if (line.trim().isEmpty()) continue;

                line = line.replace("(", "").replace(")", "");

                String[] parts = line.split(",");

                // Verificar que hay suficientes partes
                if (parts.length < 2) continue;

                String english = parts[0].trim();
                String spanish = parts[1].trim();

                tree.insert(english, spanish);
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error leyendo archivo");
        }

        System.out.println("Diccionario ordenado:");
        tree.inOrder();

        try {
            File file2 = new File("../texto.txt");
            Scanner sc2 = new Scanner(file2);

            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                String[] words = line.split(" ");

                for (String word : words) {
                    String clean = word.replaceAll("[^a-zA-Z]", "");
                    if (clean.isEmpty()) continue;

                    String translation = tree.search(clean);

                    if (translation != null) {
                        System.out.print(translation + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }

            }

            sc2.close();

        } catch (Exception e) {
            System.out.println("Error leyendo texto");
        }
    }
}