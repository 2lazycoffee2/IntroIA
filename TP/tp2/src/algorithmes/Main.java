package algorithmes;

import problemes.ChaineBinaire;
import problemes.Probleme;
import representation.Solution;

public class Main {
    public static void main(String[] args) {
        int nbBits = 16;
        int taillePopulation = 50;
        int nbGenerations = 200;
        double probaCroisement = 0.8;
        double probaMutation = 0.01;
        long graine = 12345L; // changer pour obtenir une autre exécution reproductible

        TypeSelection selection = TypeSelection.ROULETTE;
        TypeCroisement croisement = TypeCroisement.UN_POINT;

        Probleme probleme = new ChaineBinaire(nbBits);
        AlgorithmeGenetique ag = new AlgorithmeGenetique(probleme, taillePopulation,
                nbGenerations, probaCroisement, probaMutation,
                selection, croisement, graine);

        Solution meilleure = ag.executer();
        System.out.println("Meilleure solution : " + meilleure);
        System.out.println("Optimum théorique   : " + ((1L << nbBits) - 1));
    }
}
