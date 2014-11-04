import model.calendar.GetCalendarData;
import GUI.GUILogic;
import config.Configurations;

public class Main {
	//Starts public main method.
	
	public static void main(String[] args) {
		GetCalendarData test = new GetCalendarData();
		try {
			test.getDataFromCalendar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	/*	Configurations cf = new Configurations();
		
		cf.ReadFile();
		
		System.out.println(cf.getPassword());
		
		new GUILogic().run();*/
	}

}
