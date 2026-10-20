package algorithmes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import operateurs.croisement.*;
import operateurs.mutation.BitFlip;
import operateurs.selection.*;
import problemes.Probleme;
import representation.Gene;
import representation.Solution;

public class AlgorithmeGenetique {
    private final Probleme probleme;
    private final int taillePopulation;
    private final int nbGenerations;
    private final double probaCroisement;
    private final double probaMutation;
    private final TypeSelection typeSelection;
    private final TypeCroisement typeCroisement;
    private final Random random;
    private List<Solution> population;

    public AlgorithmeGenetique(Probleme probleme, int taillePopulation, int nbGenerations,
            double probaCroisement, double probaMutation,
            TypeSelection typeSelection, TypeCroisement typeCroisement, long graine) {
        if (taillePopulation < 2 || taillePopulation % 2 != 0)
            throw new IllegalArgumentException("La taille de population doit être paire et >= 2.");
        this.probleme = probleme; this.taillePopulation = taillePopulation;
        this.nbGenerations = nbGenerations; this.probaCroisement = probaCroisement;
        this.probaMutation = probaMutation; this.typeSelection = typeSelection;
        this.typeCroisement = typeCroisement; this.random = new Random(graine);
    }

    public Solution executer() {
        population = genererPopulationInitiale();
        evaluer(population);
        Solution meilleureGlobale = new Solution(meilleure(population));
        BitFlip mutation = new BitFlip(probaMutation, random);

        for (int generation = 1; generation <= nbGenerations; generation++) {
            Selection selection = creerSelection();
            List<Solution> enfants = new ArrayList<>(taillePopulation);

            while (enfants.size() < taillePopulation) {
                Solution p1 = selection.selectionner();
                Solution p2 = selection.selectionner();
                Croisement croisement = creerCroisement(p1, p2);
                croisement.croiser();
                Solution e1 = croisement.getEnfant1();
                Solution e2 = croisement.getEnfant2();
                mutation.muter(e1); mutation.muter(e2);
                probleme.evaluer(e1); probleme.evaluer(e2);
                enfants.add(e1); enfants.add(e2);
            }
            population = enfants;
            Solution meilleureGeneration = meilleure(population);
            if (estMeilleure(meilleureGeneration, meilleureGlobale))
                meilleureGlobale = new Solution(meilleureGeneration);
        }
        return meilleureGlobale;
    }

    private List<Solution> genererPopulationInitiale() {
        List<Solution> resultat = new ArrayList<>(taillePopulation);
        double[] min = probleme.getMin(), max = probleme.getMax();
        for (int i = 0; i < taillePopulation; i++) {
            Gene[] chromosome = new Gene[probleme.getNb_variables_decision()];
            for (int j = 0; j < chromosome.length; j++) {
                double valeur;
                if (probleme.getType().equalsIgnoreCase("Int"))
                    valeur = (int) min[j] + random.nextInt((int) (max[j] - min[j] + 1));
                else valeur = min[j] + random.nextDouble() * (max[j] - min[j]);
                chromosome[j] = new Gene(valeur, min[j], max[j]);
            }
            resultat.add(new Solution(probleme.getType(), chromosome));
        }
        return resultat;
    }

    private void evaluer(List<Solution> pop) { for (Solution s : pop) probleme.evaluer(s); }

    private Selection creerSelection() {
        if (typeSelection == TypeSelection.ROULETTE)
            return new SelectionRoulette(population, probleme.isMinimisation(), random);
        return new SelectionAleatoire(population, probleme.isMinimisation(), random);
    }

    private Croisement creerCroisement(Solution p1, Solution p2) {
        if (typeCroisement == TypeCroisement.DEUX_POINTS)
            return new Croisement2Points(p1, p2, probaCroisement, random);
        return new Croisement1Point(p1, p2, probaCroisement, random);
    }

    private Solution meilleure(List<Solution> pop) {
        Solution best = pop.get(0);
        for (int i = 1; i < pop.size(); i++) if (estMeilleure(pop.get(i), best)) best = pop.get(i);
        return best;
    }

    private boolean estMeilleure(Solution a, Solution b) {
        return probleme.isMinimisation() ? a.getF() < b.getF() : a.getF() > b.getF();
    }
}
