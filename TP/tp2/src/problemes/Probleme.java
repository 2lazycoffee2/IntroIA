package problemes;

import representation.Solution;

public abstract class Probleme {
    protected final int nb_variables_decision;
    protected final boolean minimisation;
    protected final String type;
    protected final double[] min;
    protected final double[] max;

    protected Probleme(String type, int nbVariablesDecision, boolean minimisation) {
        this.type = type;
        this.nb_variables_decision = nbVariablesDecision;
        this.minimisation = minimisation;
        this.min = new double[nbVariablesDecision];
        this.max = new double[nbVariablesDecision];
        definirBornes();
    }

    protected abstract void definirBornes();
    
    public abstract void evaluer(Solution solution);
    
    public int getNb_variables_decision() { 
      return nb_variables_decision; 
    }
    
    public boolean isMinimisation() { 
      return minimisation; 
    }
    
    public String getType() { 
      return type; 
    }
    
    public double[] getMin() { 
      return min; 
    }
    
    public double[] getMax() { 
      return max; 
    }
}
