
import java.io.*;

public class ElevatorSimulator1
{
	
	public static void main(String args[]) throws IOException, InterruptedException, NumberFormatException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		String str0 = "*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *";
		String str1 = "*          COMPUTER APPLICATIONS PROJECT WORK (JAVA)     *           ";
		String str2 = "*                                                        *";
		String str3 = "*             Project Name :- Elevator Simulation        *           ";
		String str4 = "*              Student Name :- Tarun Sriranga Paparaju   *          ";
		String str5 = "*               Roll Number :- 28                        *";
		String str6 = "*             Academic Year :- 2017 - 18                 *";
		String str7 = "*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *                        ";
		
		System.out.println(str0);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);      /* Print details. */
		System.out.println(str4);
		System.out.println(str5);
		System.out.println(str6);
		System.out.println(str7);
		
		Thread.sleep(5000);
		
		System.out.print('\f'); /* clear screen */
		
		System.out.println("W E L C O M E   T O   T H E");
		System.out.println("       ");
		
		Thread.sleep(50);
		
		System.out.println("E");
		System.out.println("  L");
		System.out.println("    E");
		System.out.println("      V");
		System.out.println("        A");
		System.out.println("          T");
		System.out.println("            O");
		System.out.println("              R");
		System.out.println("       ");
		
		Thread.sleep(50);
		
		Thread.sleep(500);
		
		System.out.println("HIT ENTER TO START");
		System.out.println("                         ");
		String enter = br.readLine();
		
		if(enter.equals(""))
		{
			Elevators1 elevator = new Elevators1(0, 8, 0, 1000, true, 0, 0, 0, 0.0); /* Create new elevator in a building with floors 0 to 8, maximum weight capacity 1000 kg, initial floor 0, initial direction upwards and with a closed door. */
			elevator.simulateElevator();
		}
	}
}

