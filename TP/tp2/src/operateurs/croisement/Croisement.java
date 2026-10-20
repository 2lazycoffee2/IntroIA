package operateurs.croisement;

import java.util.Random;
import representation.Solution;

public abstract class Croisement {
    protected final Solution parent1;
    protected final Solution parent2;
    protected Solution enfant1;
    protected Solution enfant2;
    protected final double proba;
    protected final Random random;

    protected Croisement(Solution parent1, Solution parent2, double proba, Random random) {
        this.parent1 = parent1; this.parent2 = parent2; this.proba = proba; this.random = random;
    }

    public abstract void croiser();
    public Solution getEnfant1() { return enfant1; }
    public Solution getEnfant2() { return enfant2; }
}
