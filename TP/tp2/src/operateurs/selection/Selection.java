package operateurs.selection;

import java.util.List;
import java.util.Random;
import representation.Solution;

public abstract class Selection {
    protected final List<Solution> population;
    protected final Random random;
    protected final boolean minimisation;

    protected Selection(List<Solution> population, boolean minimisation, Random random) {
        this.population = population;
        this.minimisation = minimisation;
        this.random = random;
    }

    public abstract Solution selectionner();
}
