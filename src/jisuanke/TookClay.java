package jisuanke;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class TookClay {
	
	public static void main(String[] args) {
		List<String> result = new ArrayList<String>();
		Map<String, Integer> childrenMap = new LinkedHashMap<String, Integer>();
		
		Scanner scanner = new Scanner(System.in);
		int childrenCount = -1;
		while ((childrenCount = Integer.parseInt(scanner.nextLine())) != -1) {
			childrenMap.clear();
			
			int readLine = 0;
			int preVolume = 0;
			while (readLine < childrenCount) {
				String[] clays = scanner.nextLine().split(" ");
				int l = Integer.parseInt(clays[0]);
				int w = Integer.parseInt(clays[1]);
				int h = Integer.parseInt(clays[2]);
				int volume = l * w * h;
				childrenMap.put(clays[3], volume);
				preVolume += volume;
				readLine++;
			}
			preVolume /= childrenCount;
			
			String takeChildName = null;
			String tookChildName = null;
			for (Entry<String, Integer> entry : childrenMap.entrySet()) {
				int diff = entry.getValue() - preVolume;
				if (diff > 0) {
					takeChildName = entry.getKey();
				} else if (diff < 0) {
					tookChildName = entry.getKey();
				}
			}
			result.add(String.format("%s took clay from %s.", takeChildName, tookChildName));
		}
		scanner.close();
		
		for (String str : result) {
			System.out.println(str);
		}
	}
}
