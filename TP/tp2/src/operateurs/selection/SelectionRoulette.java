package operateurs.selection;

import java.util.List;
import java.util.Random;
import representation.Solution;

/** À compléter pendant le TP. */
public class SelectionRoulette extends Selection {
    public SelectionRoulette(List<Solution> population, boolean minimisation, Random random) {
        super(population, minimisation, random);

    }


    @Override
    public Solution selectionner() {

        int somme = 0;
        double cumul = 0;
        /* TODO TP : implémenter la roulette biaisée.
            
         * 1. Construire un poids positif pour chaque solution.
         * 2. Calculer la somme des poids.
         * 3. Tirer r dans [0, somme[.
         * 4. Parcourir les poids cumulés jusqu'à atteindre r.
         */
        for(Solution s : population)
        {
            somme += s.getF();
        }
        int rvalue = random.nextInt(somme);
        for(int i = 0; i < population.size(); i++)
        {
            cumul += population.get(i).getF();
            if (cumul > rvalue)
            {
                return population.get(i);
            }
            else 
            {
                continue;
            }
        }   
        
        throw new UnsupportedOperationException("SelectionRoulette à implémenter");
    }
}
