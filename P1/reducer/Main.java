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
		List<Entry<Integer, Integer> > pairList = new ArrayList<>();
		boolean found = false;
		while ((s = in.readLine()) != null && s.length() != 0) {
			String[] line = s.split("\t");
			for(int i = 0; i < pairList.size(); i++) {
				if(pairList.get(i).getKey().equals(line[1])) {
					pairList.get(i).setValue(pairList.get(i).getValue() + 1);
					found = true;
					break;
				}
			}
			if(!found) {
				pairList.add(new SimpleEntry<Integer, Integer>(Integer.parseInt(line[1]), 1));
			}
			found = false;
		}
		
		for(int i = 0; i < pairList.size(); i++) {
			System.out.println(pairList.get(i).getKey() + "\t" + pairList.get(i).getValue());
		}
	}

}
