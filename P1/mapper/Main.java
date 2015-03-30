package mapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		List<Entry<String, Integer> > pairList = new ArrayList<>();
		boolean found = false;
		while ((s = in.readLine()) != null && s.length() != 0) {
			String[] line = s.split("\t");
			for(int i = 0; i < pairList.size(); i++) {
				//if the list already contains the current 4-gram
				if(pairList.get(i).getKey().equals(line[0])) {
					pairList.get(i).setValue(pairList.get(i).getValue() + Integer.parseInt(line[2]));
					found = true;
					break;
				}
			}
			if(!found) {
				pairList.add(new SimpleEntry<String, Integer>(line[0], Integer.parseInt(line[2])));
			}
			found = false;
		}
		
		for(int i = 0; i < pairList.size(); i++) {
			System.out.println(pairList.get(i).getKey() + "\t" + pairList.get(i).getValue());
		}
	}
}
