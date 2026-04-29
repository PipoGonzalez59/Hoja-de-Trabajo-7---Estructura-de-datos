import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        try {
            File file = new File("diccionario.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                line = line.replace("(", "").replace(")", "");

                String[] parts = line.split(",");

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
    }
    try {
        File file2 = new File("texto.txt");
        Scanner sc2 = new Scanner(file2);

        while (sc2.hasNext()) {
            String word = sc2.next();

            String clean = word.replaceAll("[^a-zA-Z]", "");

            String translation = tree.search(clean);

            if (translation != null) {
                System.out.print(translation + " ");
            } else {
                System.out.print("*" + word + "* ");
            }
        }

        sc2.close();

    } catch (Exception e) {
        System.out.println("Error leyendo texto");
    }
}