package publicKeyBox;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class PublicKeyBox {
	public static void start() {
		Scanner input = new Scanner(System.in);
		String[] inputStr = input.nextLine().split(" ");
		int n = Integer.parseInt(inputStr[0]);
		int k = Integer.parseInt(inputStr[1]);
		Teacher[] teachers = new Teacher[k];
		int lastTime = 0;
		for (int i = 0; i < k; i++) {
			String[] teacherMsg = input.nextLine().split(" ");
			int keyNum = Integer.parseInt(teacherMsg[0]);
			int startTime = Integer.parseInt(teacherMsg[1]);
			int endTime = Integer.parseInt(teacherMsg[2]) + Integer.parseInt(teacherMsg[1]);
			Teacher teacherTemp = new Teacher(keyNum, startTime, endTime);
			teachers[i] = teacherTemp;
			if (endTime > lastTime) {
				lastTime = endTime;
			}
		}
		int[] keyList = new int[n];
		int pastTime = 0;
		for(int i = 0; i < n; i++) {
			keyList[i] = i + 1;
		}
		System.out.println("lastTime:" + lastTime);
		while (pastTime <= lastTime) {
			checkReturnKey(pastTime, teachers, keyList);
			checkLenkey(pastTime, teachers, keyList);
			System.out.println("pastTime为:" + pastTime);
			printKey(keyList);
			pastTime++;
		}
	}
	public static void printKey(int[] keyList) {
		for (int i : keyList) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	public static void checkReturnKey(int pastTime, Teacher[] teachers, int[] keyList) {
		List<Teacher> teacherList = new LinkedList<Teacher>();
		for (int i = 0;i < teachers.length; i++) {
			if (teachers[i].endTime == pastTime) {
				teacherList.add(teachers[i]);
			}
		}
		if (!teacherList.isEmpty()) {
			Collections.sort(teacherList);
			returnKeys(teacherList, keyList);
		}
	}
	public static void returnKeys(List<Teacher> teacherList, int[] keyList) {
		for (int j = 0; j < teacherList.size(); j++) {
			for (int i = 0; i < keyList.length; i++) {
				if (keyList[i] == 0) {
					keyList[i] = teacherList.get(j).keyNum;
					break;
				}
			}
		}
	}
	public static void checkLenkey(int pastTime, Teacher[] teachers, int[] keyList) {
		for (int i = 0; i < teachers.length; i++) {
			if (teachers[i].startTime == pastTime) {
				for (int j = 0; j < keyList.length; j++) {
					if (keyList[j] == teachers[i].keyNum) {
						keyList[j] = 0;
						break;
					}
				}
			}
		}
	}
}

class Teacher implements Comparable<Teacher> {
	public int keyNum;
	public int startTime;
	public int endTime;
	public Teacher(int akeyNum, int aStartTime, int aTime) {
		keyNum = akeyNum;
		startTime = aStartTime;
		endTime = aTime; 
	}
	@Override
	public int compareTo(Teacher otherTeacher) {
		int value = this.keyNum - otherTeacher.keyNum;
		return value;
	}
}
