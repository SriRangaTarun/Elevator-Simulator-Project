
import java.util.*;
import java.io.*;

public class Elevators1
{
	int minFloor; // lowest floor of building
	int maxFloor; // highest floor of building
	int direction; // direction of motion of building
	double maxWeight; // maximum weight of passengers that can be carried by the elevator
	boolean closed; // true if the elevator door is closed, else false
	int position; // current position (floor) of the elevator
	int initFloor; // initial floor of elevator at the beginning of each time period
	int initDirection; // initial direction of motion of elevator at the beginning of each time period
	double currTime; 
	ArrayList<Integer> allFloors;
	ArrayList<UserAction1> requestList; // list of many UserAction objects, which are the requests 
	
	public Elevators1(int minFloor1, int maxFloor1, int direction1, double maxWeight1, boolean closed1, int position1, int initFloor1, int initDirection1, double currTime1)
	{
		minFloor = minFloor1;
		maxFloor = maxFloor1;
		direction = direction1;
		maxWeight = maxWeight1;
		closed = closed1;
		position = position1;
		initFloor = initFloor1;
		initDirection = initDirection1;
		currTime = currTime1;
	}
	
	public ArrayList<UserAction1> gatherElevatorUsersData() throws IOException /* Gets input (requests) from user every few milliseconds. */
	{
		System.out.println("One elevator request is one press of a floor button on any floor");
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int direction;
		int floorDestination;
		int floorSource;
		int i = 1;
		String no;
        
        ArrayList<UserAction1> requests = new ArrayList<UserAction1>();
		
		System.out.println("Enter the starting floor (floor at which the request is given), the destination floor (floor to which the user wants to go) and the direction (upwards or downwards) for each request one by one");
		
		System.out.println("Enter end of requests when the orders are complete");
		
		System.out.println("If there are are no new requests at this point of time, please enter no requests, else enter something random");
		no = br.readLine();
		
		if(requestList == null)
		{
		    requestList = new ArrayList<UserAction1>();
		    
			initFloor = 0;
			initDirection = 1;
		}
		
		if(allFloors == null)
		{
			allFloors = new ArrayList<Integer>();
		}
		
		if(!no.equalsIgnoreCase("no requests"))
		{
            String end = "";
			
			double weight;
			
			while(!end.equalsIgnoreCase("end of requests"))
			{
			    System.out.println("Enter starting floor in request number " + i);
				floorSource = Integer.parseInt(br.readLine());
				
				while(floorSource < minFloor || floorSource > maxFloor)
				{
					System.out.println("Wrong input for starting floor");
					
					System.out.println("Enter a floor from " + minFloor + " to " + maxFloor);
					floorSource = Integer.parseInt(br.readLine());
				}
					
				System.out.println("Enter destination floor in request number " + i);
				floorDestination = Integer.parseInt(br.readLine());
				
				while(floorDestination < minFloor || floorDestination > maxFloor)
				{
					System.out.println("Wrong input for destination floor");
					
					System.out.println("Enter a floor from " + minFloor + " to " + maxFloor);
					floorDestination = Integer.parseInt(br.readLine());
				}
				
				
				
				System.out.println("Enter direction in request number " + i + " (1 for upwards and -1 for downwards) " );
			    direction = Integer.parseInt(br.readLine());
			    
			    while(direction != 1 && direction != -1)
	   	        {
	   	    	       System.out.println("Wrong input for direction");
	   	    	      
	   	    	       System.out.println("Enter 1 for upwards or -1 for downwards");
	   	    	       direction = Integer.parseInt(br.readLine());
	   	        }
			    
			    System.out.println("Enter the collective weights of all passengers inside the elevator in request number " + i + " in kg");
			    weight = Double.parseDouble(br.readLine());
			    
			    while(weight > maxWeight)
	   	        {
	   	    	       System.out.println("Elevator will be overloaded");
	   	    	       System.out.println("Some people must get off immedeately");
	   	    	      
	   	    	       System.out.println("Enter the NEW collective weights of all passengers inside the elevator in kg");
	   	    	       weight = Double.parseDouble(br.readLine());
	   	        }

				UserAction1 userAction = new UserAction1(floorSource, floorDestination, direction, -1, -1, -1, -1);
				
				requests.add(userAction);
				
				i++;
				
				System.out.println("Enter end of requests if this is the last request, else enter something random");
				end = br.readLine();
			}
		}

	    return requests;
	}
	
	public void conductElevatorService() throws IOException

 /* Decides the direction of motion of the  every tenth of a millisecond based on current information like current request list, current position etc. Every time a user has already been picked up and then dropped in the correct floor, the corresponding UserAction object is removed from the array list and new objects are added on user request. The elevator does not move when it does not have any requests on its agenda */
	                                                 
	                                                           
	{
	    int index = 0;
	    
		ArrayList<UserAction1> requests = new ArrayList<UserAction1>();
		requests = gatherElevatorUsersData();
		
		for(int i = 0; i < requests.size(); i++)
		{
			requestList.add(requests.get(i));
		}
		
		position = initFloor;
		direction = initDirection;
		
		currTime = 0.0;
		
		while(currTime <= 0.02)
		{
               boolean flag = true;

               for(int k = 0; k < requestlist.size(); k++)
               {   
                   if(!((requestList.get(k).getFloorSource()< position && requestList.get(k).getFloorDestination > position && direction == 1) || (requestList.get(k).getFloorSource()> position && requestList.get(k).getFloorDestination < position && direction == -1)))
                   {
                      flag = false;
                   }

               }
 
               if(flag)
               {
                  direction = -direction; 
               } 
                      
		    if(requestList.size() == 1)
		    {
		        if(requestList.get(0).getPickedUp() == -1 && requestList.get(0).getFloorSource() != position)
		        {
		            direction = (requestList.get(0).getFloorSource() - position) / (Math.abs((requestList.get(0).getFloorSource() - position)));
		        }
		        
		        else if(requestList.get(0).getPickedUp() == 1 && requestList.get(0).getFloorDestination() != position)
		        {
		            direction = (requestList.get(0).getFloorDestination() - position) / (Math.abs((requestList.get(0).getFloorDestination() - position)));
		        }
		        
		        else
		        {
		            
		        }
		    }
			
			for(int i = 0; i < requestList.size(); i++)
		    {
			    allFloors.add(requestList.get(i).getFloorSource());
			    allFloors.add(requestList.get(i).getFloorDestination());
		    }
		    
		    if(position == maxFloor || position == Collections.max(allFloors) || position == minFloor || position == Collections.min(allFloors)) 
		    {
		        direction = -direction;
		    }
		    
			for(int i = 0; i < requestList.size(); i++)
			{
           
				if(position == Collections.min(allFloors) || position == minFloor) /*|| position == Collections.min(destinationFloors))*/
				{
					direction = 1;
				}      
					
				if(position == Collections.max(allFloors) || position == maxFloor) /*|| position == Collections.max(destinationFloors))*/
				{
					direction = -1;
				}
				
				if(Collections.max(allFloors) < initFloor && direction == 1)
				{
					direction = -1;
				}
				
				if(Collections.min(allFloors) > initFloor && direction == -1)
				{
					direction = 1;
				}
			}
			
            for(int i = 0; i < requestList.size(); i++)
            {
            if(position == requestList.get(i).getFloorSource())
	        {   
				if(!((requestList.get(i).getFloorSource() > requestList.get(i).getFloorDestination() && direction == 1) || (requestList.get(i).getFloorSource() < requestList.get(i).getFloorDestination() && direction ==-1)))
				{
				    requestList.get(i).pickedUp= 1;
                    requestList.get(i).checkPick = 1;
				}
		    }
                
            if(requestList.get(i).getPickedUp() == 1)
            {
                if(position == requestList.get(i).getFloorDestination())
                {
                    requestList.get(i).dropped = 1;
                    requestList.get(i).checkDrop = 1;
                }
            }
            
            
     
           }
           int j = 0;
           
           loop:
            while(j < requestList.size()) 
/* Open and then close elevator door for people to enter or exit at required floors */
            {
                if(requestList.get(j).getFloorSource() == position || (requestList.get(j).getFloorDestination() == position && requestList.get(j).getPickedUp() == 1))

 /* If the source floor of a user or the destination floor of an already picked up user is reached, then open and close elevator door for people to exit or enter
                {
                    closed = false;
                    
                    System.out.println("");
                    System.out.println("Floor number " + position + " has arrived, people concerned can step on or off the elevator");
                    System.out.println("");
                    
                    closed = true;
                    
                    break loop;
                }
                
                j++;
            }
			
			currTime += 0.01;
			
			if(position == maxFloor || position == Collections.max(allFloors) && requestList.size() > 0)
			{
			    direction = -1;
			}
			
			if(position == minFloor || position == Collections.min(allFloors) && requestList.size() > 0)
			{
			    direction = 1;
			}
			
			for(int i = 0; i < requestList.size(); i++) /* remove dropped users from request list */
			{
				if(requestList.get(i).getDropped() == 1)
				{
					requestList.remove(i);
				}
			}
			
			if(requestList.size() == 0) 

/* Break if no requests are left */ 
			{
				break;
			}
			
			if(requestList.size() == 0)
			{
			    direction = 0;
			}
			
			if(requestList.size() != 0)
			{
			    if(direction != 0)
			    {
			        position += direction;
			        
			        System.out.println("");
			        System.out.println(position); 
                                  
                                  /* print current position */

			        System.out.println("");
			    }
			}
		}
		
		
		initFloor = position;
        initDirection = direction;
        
        if(requestList.size() == 0)
        {
        	System.out.println("");
        	System.out.println("ELEVATOR CURRENTLY AT REST, WAITING FOR MORE REQUESTS");
        	System.out.println("");
        }
	}


	public void simulateElevator() throws IOException /* Conduct selevator service every few milliseconds */
	{
		double informationInterval = 0.02;
		double numberOfIntervals = 100.0; 
        /* conduct service 100 times */
		
		System.out.println("SYNOPSIS :");
		System.out.println("The elevator receives all requests passed to it every 0.02 seconds and acts according to the current list of requests on its agenda");
		System.out.println("The elevator can move one floor upwards or downwards in 0.01 seconds");
		System.out.println("The elevator starts at floor 0 moving upwards");
		System.out.println("The position of the elevator every 0.01 seconds is shown for a period of 0.02 seconds multiple times");
		System.out.println("");
		
		for(double time = 0.0; time <= numberOfIntervals*informationInterval;)
		{
			System.out.println("TIME STEP t = " + time);
			conductElevatorService();
			time = time + informationInterval;
		}
	}
}
