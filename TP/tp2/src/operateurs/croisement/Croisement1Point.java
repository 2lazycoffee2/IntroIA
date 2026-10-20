package operateurs.croisement;

import java.util.Random;
import representation.Solution;

public class Croisement1Point extends Croisement {
    public Croisement1Point(Solution p1, Solution p2, double proba, Random random) {
        super(p1, p2, proba, random);
    }

    @Override
    public void croiser() {
        enfant1 = new Solution(parent1);
        enfant2 = new Solution(parent2);
        int n = parent1.getNb_variables_decision();
        if (n < 2 || random.nextDouble() > proba) return;
        int point = 1 + random.nextInt(n - 1);
        for (int i = point; i < n; i++) {
            enfant1.setVariable(i, parent2.getDoubleVariable(i));
            enfant2.setVariable(i, parent1.getDoubleVariable(i));
        }
    }
}
