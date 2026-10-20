package operateurs.selection;

import java.util.List;
import java.util.Random;
import representation.Solution;

public class SelectionAleatoire extends Selection {
    public SelectionAleatoire(List<Solution> population, boolean minimisation, Random random) {
        super(population, minimisation, random);
    }

    @Override
    public Solution selectionner() {
        return population.get(random.nextInt(population.size()));
    }
}
