package operateurs.mutation;

import java.util.Random;
import representation.Solution;

public abstract class Mutation {
    protected final double proba;
    protected final Random random;
    protected Mutation(double proba, Random random) { this.proba = proba; this.random = random; }
    public abstract void muter(Solution solution);
}
