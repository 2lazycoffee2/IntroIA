import java.util.Arrays;

public class Bipartition {

    public static void main(String[] args)
    {
        // deux tableaux à tester :  {771, 121, 281, 854, 885, 734, 486, 1003, 83, 62}; & {2, 10, 3, 8, 5, 7, 9, 5, 3, 2}; 
        int[] E = {771, 121, 281, 854, 885, 734, 486, 1003, 83, 62};
        int[] E1 = new int[E.length];
        int[] E2 = new int[E.length];
        System.out.print("Tableau E : \n");
        System.out.println(Arrays.toString(E2));


        int S1 = 0;

        int S2 = 0;
        
        for (int i = 0; i < E.length; i ++)
        {
            if(S1<=S2)
            {
                E1[i] = E[i];
                S1 += E[i];
            }
            else 
            {
                E2[i] = E[i];
                S2 += E[i];
            }
        }
        System.out.print("Tableau E1 : \n");
        System.out.println(Arrays.toString(E1));
        System.out.println("Somme de E1 = " + S1);

        System.out.print("Tableau E2 : \n");

        System.out.println(Arrays.toString(E2));
        System.out.println("Somme de E2 = " + S2);
    }
}