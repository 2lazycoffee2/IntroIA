package operateurs.selection;

import java.util.List;
import java.util.Random;

import representation.Solution;

public class SelectionTournois extends Selection {
    public SelectionTournois(List<Solution> population, boolean minimisation, Random random) {
        super(population, minimisation, random);
    }

    @Override
    public Solution selectionner() {
        return population.get(random.nextInt(population.size()));
    }
}