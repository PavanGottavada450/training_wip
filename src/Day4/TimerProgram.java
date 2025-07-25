package Day4;

public class TimerProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tasks = {
				"Driniking Water",
				"Do Java Programs",
				"Complete Your Lunch",
				"Watch Movie",
				"Pratice Codes"
		};
		
		double[] times = { 9.00, 11.00, 13.00, 15.00, 17.00 };
		
		for(int i=0; i<times.length; i++) {
			double time = times[i];
			String period = (time < 12.00) ? "AM" : "PM";
			int displayHour = (int) time % 12;
			if(displayHour == 0) displayHour = 12;
			
			System.out.println("Now the time is : " + displayHour + ":00" + period);
			System.out.println("Task : " + tasks[i]);
			System.out.println("-------------------");
			
		}
	}

}
