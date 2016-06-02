package ProblemSetII;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
//int  start[]  =  {1, 3, 0, 5, 8, 5};
// sorted activities by finished time , activity{start,finish} 0{1,2} , 1{3,4} 
//int finish[] =  {2, 4, 6, 7, 9, 9};

public class ActivitySelection {
	static class Time {
		int start;
		int end;
	}

	public void maxSetActivity(Map<Integer, Time> activitiy) {

		Iterator it = activitiy.entrySet().iterator();
		Time previours = activitiy.get(0);
		int keyPrevious = 0;
		System.out.println("Activity" + keyPrevious);
		while (it.hasNext()) {
			Map.Entry value = (Map.Entry) it.next();
			if ((int) value.getKey() != 0) {

				Time time = (Time) value.getValue();
				if (time.start > previours.end) {
					System.out.println("Activity" + value.getKey());
				}
				previours = (Time) value.getValue();
				keyPrevious = (int) value.getKey();
			}
		}

	}

	public static void main(String arg[]) {
		Time time0 = new Time();
		Time time1 = new Time();
		Time time2 = new Time();
		Time time3 = new Time();
		Time time4 = new Time();
		Time time5 = new Time();
		time0.start = 1;
		time0.end = 2;
		time1.start = 3;
		time1.end = 4;
		time2.start = 0;
		time2.end = 6;
		time3.start = 5;
		time3.end = 7;
		time4.start = 8;
		time4.end = 9;
		time5.start = 5;
		time5.end = 9;
		Map<Integer, Time> activitiy = new HashMap<Integer, Time>();
		activitiy.put(0, time0);
		activitiy.put(1, time1);
		activitiy.put(2, time2);
		activitiy.put(3, time3);
		activitiy.put(4, time4);
		activitiy.put(5, time5);
		ActivitySelection as = new ActivitySelection();
		as.maxSetActivity(activitiy);

	}
}
