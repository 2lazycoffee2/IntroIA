package representation;

public class Gene {
    private double valeur;
    private final double min;
    private final double max;

    public Gene(double valeur, double min, double max) {
        
        if (min > max) throw new IllegalArgumentException("min > max");
        
        if (valeur < min || valeur > max) throw new IllegalArgumentException("Valeur hors bornes");
        
        this.valeur = valeur;
        this.min = min;
        this.max = max;
    }

    public Gene(Gene autre) {
      this(autre.valeur, autre.min, autre.max); 
    }
    
    public double getDoubleValue() { 
      return valeur; 
    }
    
    public int getIntValue() { 
      return (int) Math.round(valeur); 
    }
    
    public double getMin() { 
      return min; 
    }
    
    public double getMax() { 
      return max; 
    }

    public void setValue(double valeur) {
        if (valeur < min || valeur > max) throw new IllegalArgumentException("Valeur hors bornes");
        this.valeur = valeur;
    }
}
