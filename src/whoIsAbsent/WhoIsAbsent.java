package whoIsAbsent;
import java.util.*;
public class WhoIsAbsent {
	public static void start() {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		List<TestItem> alist = new ArrayList<TestItem> ();
		while(n != 0) {
			TestItem oneTest = new TestItem(n);
			for (int i = 0; i < 2 * n - 1; i++) {
				oneTest.check(input.nextLine());
			}
			alist.add(oneTest);
			n = Integer.parseInt(input.nextLine());
		}
		for (int i = 0; i < alist.size(); i++) {
			TestItem oneTest = alist.get(i);
			Iterator<Map.Entry<String, Integer>> entryIt = oneTest.nameCount.entrySet().iterator();
			while(entryIt.hasNext()) {
				Map.Entry<String, Integer> entry = entryIt.next();
				System.out.println(entry.getKey());
			}
		}
	}
}

class TestItem {
	public int num;
	public Map<String, Integer> nameCount = new HashMap<String, Integer> ();
	public TestItem (int n) {
		this.num = n;
	}
	public void check (String name) {
		if (this.nameCount.containsKey(name)) {
			this.nameCount.remove(name);
		} else {
			this.nameCount.put(name, 1);
		}
	} 
}