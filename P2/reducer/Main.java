package reducer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		List<Entry<String, Integer> > pairList = new ArrayList<>();
		boolean found = false;
		while ((s = in.readLine()) != null && s.length() != 0) {
			String[] line = s.split("\t");
			String[] four_gram = line[0].split(" ");
			String[] two_grams = new String[3];
			two_grams[0] = four_gram[0] + " " + four_gram[1];
			two_grams[1] = four_gram[1] + " " + four_gram[2];
			two_grams[2] = four_gram[2] + " " + four_gram[3];
			
			for(int i = 0; i < two_grams.length; i++) {
				for(int j = 0; j < pairList.size(); j++) {
					if(two_grams[i].equals(pairList.get(j).getKey())) {
						pairList.get(j).setValue(pairList.get(j).getValue() + Integer.parseInt(line[1]));
						found = true;
						break;
					}
				}
				if(!found) {
					pairList.add(new SimpleEntry<String, Integer>(two_grams[i], Integer.parseInt(line[1])));
				}
				found = false;
			}
		}
		
		for(int i = 0; i < pairList.size(); i++) {
			System.out.println(pairList.get(i).getKey() + "\t" + pairList.get(i).getValue());
		}
	}
}
