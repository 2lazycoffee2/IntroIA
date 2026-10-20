package operateurs.mutation;

import java.util.Random;
import representation.Solution;

/** Mutation bit-flip : chaque bit est inversé avec la probabilité proba. */
public class BitFlip extends Mutation {
    public BitFlip(double proba, Random random) { super(proba, random); }

    @Override
    public void muter(Solution solution) {
        for (int i = 0; i < solution.getNb_variables_decision(); i++) {
            if (random.nextDouble() <= proba) {
                int bit = solution.getIntVariable(i);
                solution.setVariable(i, 1 - bit);
            }
        }
    }
}
