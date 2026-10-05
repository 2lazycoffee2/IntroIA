import java.util.Arrays;

public class RendueMonaie {
    public static void main(String[] args) {
        int montant = 283;

        int[] piecesRendu = {1, 2, 10, 100, 200};
        int[] tab = new int[piecesRendu.length];
        Arrays.fill(tab, 0);

        for (int i = piecesRendu.length - 1; i >= 0; i--) {
            while (montant - piecesRendu[i] >= 0) {
                montant -= piecesRendu[i];
                tab[i]++;
            }
        } 

        for (int j = 0; j < tab.length; j++) {
            System.out.println("Pièces de " + piecesRendu[j] + " : " + tab[j]);
        }
    }
}