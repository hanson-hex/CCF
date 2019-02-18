package joeph;

import java.util.*;


public class Joeph {
	public static void start() {
		Scanner input = new Scanner(System.in);
		String[] inputStr = input.nextLine().split(" ");
		int n = Integer.parseInt(inputStr[0]);
		int k = Integer.parseInt(inputStr[1]);
		Queue<Integer> persons = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			persons.add(i + 1);
		}
		int counts = 0;
		while (persons.size() > 1) {
			Integer person = persons.poll();
			counts++;
			if (counts % k == 0 || counts % 10 == k) {
				System.out.println("删除了" + person);
			} else {
				persons.add(person);
			}
		}
		System.out.println("剩余的是" + persons.poll());
	}
	public static void start2() {
		Scanner input = new Scanner(System.in);
		String inputNK = input.nextLine();
		String[] arrNK = inputNK.split("\\s");
		int n = Integer.parseInt(arrNK[0]);
		int k = Integer.parseInt(arrNK[1]);
		List<Kid> kidList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			Kid kidTemp = new Kid(i + 1);
			kidList.add(kidTemp);
		}
		int numIncrease = 1;
		int lastSize = kidList.size();
		int lastnum = numIncrease;
		int temp = 1;
		int kidIndex = 0;
		String kStr = String.valueOf(k);
		while (kidList.size() > 1) {
			kidIndex = (temp - 1) % kidList.size();
			String tempStr = String.valueOf(numIncrease);
			if (numIncrease % k == 0 || tempStr.endsWith(kStr)) {
				kidList.remove(kidIndex);
				temp--;
			}
			numIncrease++;
			temp++;
			if (numIncrease - lastnum == lastSize) {
				temp = 1;
				lastnum = numIncrease;;
				lastSize = kidList.size();
			}
		}
		System.out.println(kidList.get(0).number);
	}
	public static void start3() {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		Friend[] friends = new Friend[n];
		int count = 1;
		int check = 0;
		for (int i = 0; i < n; i++) {
			friends[i] = new Friend(i + 1, count++);
		}
		while (check < n - 1) {
			for (int i = 0; i < n; i++) {
				if (friends[i].getNumber() != 0 && (friends[i].getPosition() % k == 0 || friends[i].getPosition() % 10 == 0)) {
					friends[i].setNumber(0);
					check++;
				}
			}
			for (int i = 0; i < n; i++) {
				if (friends[i].getNumber() != 0) {
					friends[i].setPosition(count++);
				}
			}
		}
		for (int i = 0; i < n;i++) {
			if (friends[i].getNumber() != 0) {
				System.out.println(friends[i].getNumber());
			}
		}
	}
}

class Friend {
	private int number;
	private int position;
	public Friend (int n, int p) {
		number = n;
		position = p;
	}
	public void setNumber(int n) {
		number = n;
	}
	public void setPostion(int p) {
		position = p;
	}
	public int getNumber() {
		return number;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int p) {
		position = p;
	}
}

class Kid{
	public int number;
	public Kid(int n) {
		number = n;
	}
}
