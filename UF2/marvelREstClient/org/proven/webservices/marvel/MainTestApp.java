package org.proven.webservices.marvel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

/**
 * Main program to test WebService
 *
 * @author Albert Mallada
 */
public class MainTestApp {

    private static BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
    // Private keys from Albert Mallada (Institut Provençana)
    private static String marvelPublicKey = "b6aec6f6d66e3026db1bea85ba6dbfce";
    private static String marvelPrivateKey = "8038f55dc1188291e07c6143427ccc75bdd4c14b";


    /**
     * Main program
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        CharacterMarvelRestClient restClient = new CharacterMarvelRestClient(marvelPublicKey, marvelPrivateKey);
        CharacterComic[] characterComics;
        int opcioMenu;
        do {
            opcioMenu = printMenu();
            switch (opcioMenu) {
                case 1:
                    characterComics = restClient.ListCharacters();
                    for (int i = 0; i < characterComics.length; i++) {
                        System.out.println("id: " + characterComics[i].id + " Name: " + characterComics[i].name);
                        System.out.println("URL image: "
                                + characterComics[i].thumbnail.path + "." + characterComics[i].thumbnail.extension);
                    }
                    break;
                case 2:
                    System.out.println("Indica l'id que vols buscar: ");
                    int id = Integer.parseInt(teclat.readLine());
                    CharacterComic c = restClient.FindById(id);
                    System.out.println("id: " + c.id + " name: " + c.name);
                    break;
                case 3:
                    System.out.println("Indica el personatge que vols buscar: ");
                    String cerca = teclat.readLine();
                    characterComics = restClient.FindByName(cerca);
                    for (int i = 0; i < characterComics.length; i++)
                        System.out.println("id: " + characterComics[i].id + " Name: " + characterComics[i].name);
                    break;
                case 4:
                    restClient.ParseToObject();
                    break;
                default:
                    break;
            }

        } while (opcioMenu != 0);
    }

    /**
     * Menu to test Marvel API
     *
     * @return -1 if there are and error getting int value in options menú
     * @throws IOException
     */
    private static int printMenu() throws IOException {
        int result;
        do {
            System.out.println("========= Menu =========");
            System.out.println("1. List characters");
            System.out.println("2. Find character by id");
            System.out.println("3. Find character by name");
            System.out.println("0. Exit");
            System.out.println("========================");
            System.out.print("Choose an option: ");
            try {
                result = Integer.parseInt(teclat.readLine());
            } catch (NumberFormatException e) {
                result = -1;
            }
        } while (result == -1);

        return result;
    }

}
