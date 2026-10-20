package operateurs.croisement;

import java.util.Random;
import representation.Solution;

/** À compléter pendant le TP. */
public class Croisement2Points extends Croisement {
    public Croisement2Points(Solution p1, Solution p2, double proba, Random random) {
        super(p1, p2, proba, random);
    }

    @Override
    public void croiser() {
        enfant1 = new Solution(parent1);
        enfant2 = new Solution(parent2);
        /* TODO TP :
         * - tirer deux points distincts ;
         * - les ordonner ;
         * - échanger entre les deux points si le croisement est déclenché.
         */
        throw new UnsupportedOperationException("Croisement2Points à implémenter");
    }
}
