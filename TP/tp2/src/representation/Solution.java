package representation;

//import java.util.Arrays;

public class Solution {
    private final String type;
    private final Gene[] chromosome;
    private double f;

    public Solution(String type, Gene[] chromosome) {
        this.type = type;
        this.chromosome = new Gene[chromosome.length];
        for (int i = 0; i < chromosome.length; i++) this.chromosome[i] = new Gene(chromosome[i]);
    }

    public Solution(Solution autre) {
        this(autre.type, autre.chromosome);
        this.f = autre.f;
    }

    public int getNb_variables_decision() { return chromosome.length; }
    public double getF() { return f; }
    public void setF(double f) { this.f = f; }
    public int getIntVariable(int i) { return chromosome[i].getIntValue(); }
    public double getDoubleVariable(int i) { return chromosome[i].getDoubleValue(); }
    public void setVariable(int i, double valeur) { chromosome[i].setValue(valeur); }
    public String getType() { return type; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Gene gene : chromosome) {
            if (type.equalsIgnoreCase("int")) sb.append(gene.getIntValue());
            else sb.append(String.format("%.3f ", gene.getDoubleValue()));
        }
        return sb.append("  f=").append(f).toString();
    }
}
