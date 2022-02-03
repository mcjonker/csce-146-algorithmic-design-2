/*
 * Property of Mitchell Jonker
 */

public class WordHelper {
	
	public static String[] sortByVowels(String[] words) {
		
		char la = 'a', le = 'e', li = 'i', lo = 'o', lu = 'u', ly = 'y';
		char ua = 'A', ue = 'E', ui = 'I', uo = 'O', uu = 'U', uy = 'Y';
		
		String[] aW = words.clone();
		int[] tracker = new int[aW.length];
		
		for(int i = 0; i < aW.length; i++) {
			
			int rec = 0;
			for(int p = 0; p < aW[i].length(); p++) {
				if(aW[i].charAt(p) == la 
						|| aW[i].charAt(p) == le
						|| aW[i].charAt(p) == li
						|| aW[i].charAt(p) == lo
						|| aW[i].charAt(p) == lu
						|| aW[i].charAt(p) == ly
						|| aW[i].charAt(p) == ua
						|| aW[i].charAt(p) == ue
						|| aW[i].charAt(p) == ui
						|| aW[i].charAt(p) == uo
						|| aW[i].charAt(p) == uu
						|| aW[i].charAt(p) == uy) {
					rec++;
				}
			}
			
			tracker[i] = rec;
			rec = 0; // reset vowel recorder
			
		}
		
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int s = 0; s < aW.length-1; s++) {
				if(tracker[s] > tracker[s+1]) {
					
					// Sorts from least to most vowels, using the tracker array as a mirror'd array.
					// This mirrored array keeps track of how many vowels exist in each string of the array.
					int tempt = tracker[s];
					tracker[s] = tracker[s+1];
					tracker[s+1] = tempt;
					
					String temp = aW[s];
					aW[s] = aW[s+1];
					aW[s+1] = temp;
					
					hasSwapped = true;
				}
			}
		}
		
		return aW;
		
	}
	
	public static String[] sortByConsonants(String[] words) {
		
		char la = 'a', le = 'e', li = 'i', lo = 'o', lu = 'u', ly = 'y';
		char ua = 'A', ue = 'E', ui = 'I', uo = 'O', uu = 'U', uy = 'Y';
		
		String[] cW = words.clone();
		int[] constracker = new int[cW.length];
		
		for(int c = 0; c < cW.length; c++) {
			
			int constrec = 0;
			// This code block determines that if a character in a position is not a vowel,
			// it must be a consonant, since we are disregarding the possibility of special characters.
			for(int b = 0; b < cW[c].length(); b++) {
				if(cW[c].charAt(b) != la
						&& cW[c].charAt(b) != le
						&& cW[c].charAt(b) != li
						&& cW[c].charAt(b) != lo
						&& cW[c].charAt(b) != lu
						&& cW[c].charAt(b) != ly
						&& cW[c].charAt(b) != ua
						&& cW[c].charAt(b) != ue
						&& cW[c].charAt(b) != ui
						&& cW[c].charAt(b) != uo
						&& cW[c].charAt(b) != uu
						&& cW[c].charAt(b) != uy) {
					constrec++;
				}
			}
			
			constracker[c] = constrec;
			constrec = 0; // Reset consonant recorder
			
		}
		
		boolean consSwapped = true;
		while(consSwapped) {
			consSwapped = false;
			for(int y = 0; y < cW.length-1; y++) {
				if(constracker[y] > constracker[y+1]) {
					
					// Sorts from least to most consonants, using the tracker array as a mirror'd array.
					// This mirrored array keeps track of how many consonants exist in each string of the array.
					// The "mirroring" allows us to track each word, and its # of consonants, as long as the arrays are edited identically.
					int tempc = constracker[y];
					constracker[y] = constracker[y+1];
					constracker[y+1] = tempc;
					
					String tempcw = cW[y];
					cW[y] = cW[y+1];
					cW[y+1] = tempcw;
					
					consSwapped = true;
				}
			}
		}
		
		return cW;
		
	}
	
	public static String[] sortByLength(String[] words) {
		
		String[] lW = words.clone();
		int[] trleng = new int[lW.length];
		
		for(int l = 0; l < lW.length; l++) {
			trleng[l] = lW[l].length();
		}
		
		// Sort from smallest to largest in word count.
		boolean lengSwap = true;
		while(lengSwap) {
			lengSwap = false;
			for(int k = 0; k < lW.length-1; k++) {
				if(trleng[k] > trleng[k+1]) {
					
					int ltemp = trleng[k];
					trleng[k] = trleng[k+1];
					trleng[k+1] = ltemp;
					
					String ltemps = lW[k];
					lW[k] = lW[k+1];
					lW[k+1] = ltemps;
					
					lengSwap = true;
				}
			}
		}
		
		return lW;
		
	}
}