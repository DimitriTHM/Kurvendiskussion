package kurvendiskussion;

import java.util.Arrays;
/**
 *
 * @author frank
 * Erlaubnis wurde �ber GitHub erteilt.
 */


public class Polynomdivision {
	
	
	  public static double[] division(double[] a, double[] b) {	//Wir �bergeben b schon in der richtigen l�nge...
	    // Koeffizienten und Grad f�r divisor ermitteln
		//Bsp.: (3x^3-22x^2+53x-90):(x-5)	=(3x^2-7x+18)	+0/(x-5)
		//       divident          :divisor	=quotient 		+ Rest
			
		int grad=a.length-1;
		double[] quotient = new double[grad];	//nur grad!
		double[] rest = new double[grad + 1];
	    int i = b.length-1;
	    int gradDivisor = i;
	    double koeff = b[i];
	    /*
	     * f�r alle Koeffizienten
	     *  1. Faktor ermitteln
	     *  2. ausmultiplizieren
	     *  3. subtrahieren
	     */
	    double faktor;
	    rest = Arrays.copyOf(a, a.length);
	    
	    for (int j = grad; j >= gradDivisor; j--) {
	      faktor = rest[j] / koeff;
	      quotient[j - gradDivisor] = faktor;
	      
	      if (faktor != 0.0) {
	        // ausmultiplizieren
	    	  double[] zwischenErgebnis = new double[grad + 1];	
	        for (int k = 0; k <= gradDivisor; k++) {
	          zwischenErgebnis[k+ j - gradDivisor] = faktor * b[k];   //stimmt bis jz    
	        }
	        // subtrahieren
	        for (int k = 0; k <= grad; k++) {
	          rest[k] -= zwischenErgebnis[k];
	        }
	      }
	    }
	   return quotient;
	   
	  }
	  
}
