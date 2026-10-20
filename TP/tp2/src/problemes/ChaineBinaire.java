package problemes;

import representation.Solution;

/** Maximise la valeur décimale représentée par une chaîne binaire. */
public class ChaineBinaire extends Probleme {
    public ChaineBinaire(int nbBits) { super("Int", nbBits, false); }

    @Override
    protected void definirBornes() {
        for (int i = 0; i < nb_variables_decision; i++) { min[i] = 0; max[i] = 1; }
    }

    @Override
    public void evaluer(Solution solution) {
        long decimal = 0;
        for (int i = 0; i < nb_variables_decision; i++) {
            decimal = 2 * decimal + solution.getIntVariable(i);
        }
        solution.setF(decimal);
    }
}
