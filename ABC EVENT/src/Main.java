import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		//flags
		int option;
		Scanner sc = new Scanner(System.in);
		CarStack array = new CarStack();


		while(true)
		{
			System.out.println("\t \t   WELCOME");
			System.out.println("\t ABC CAR RACING EVENT");
			System.out.println("------------------------------------------");
			System.out.println("1: Register a car");
			System.out.println("2: Delete a car from registered list");
			System.out.println("3: Display all cars");
			System.out.println("4: Display the last car");
			System.out.println("5: Search for a particular car");
			System.out.println("6: Insert 1st lap results");
			System.out.println("7: Insert 2 lap results");
			System.out.println("8: Insert 3rd lap results");
			System.out.println("9: Display the winners");
			System.out.println("10: Exit");
			System.out.println("----------------------------------------------------------------------");

			System.out.println("Enter option: ");
			option = sc.nextInt();
			sc.nextLine();

			switch(option)
			{
				case 1:
					for(int count = 0; count < 6; count++)
					{
						System.out.println("---- Registration " +(count + 1) + " ----");
						System.out.println("");
						
						System.out.println("Enter Driver Name: ");
						String name = sc.nextLine();
						
						System.out.println("Enter Driver ID: ");
						Integer id = sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter Car Name: ");
						String carName = sc.nextLine();
						
						System.out.println("Enter Competitor Num: ");
						Integer carId = sc.nextInt();
						
						sc.nextLine();
						
						System.out.println("Enter Sponsor Name");
						String sponsor = sc.nextLine();


						array.push(new Car(new Driver(name,id),sponsor,carId,carName));
						System.out.println("Successfully registered"+"\n");
					}
					break;
					
				case 2:
					array.travers();
					System.out.println("enter the car id");
					Integer id = sc.nextInt();
					sc.nextLine();
					array.remove(id);
					break;
					
				case 3:
					System.out.println("----------registered cars-----------");
					array.travers();
					break;
				
				case 4:
					array.top();
					break;
					
				case 5:
					System.out.println("Enter car ID: ");
					int carid = sc.nextInt();
					sc.nextLine();

					array.searchAt(carid);
					break;
					
				case 6:
					//tracks the position ids
					ArrayList<Car> carIds = new ArrayList<Car>();
					System.out.println("---- Results for 1st round ----");
					array.travers();

					try
					{
						for(int pos = 0; pos < 5; pos++)
						{
							boolean found = false;
							
							while(!found)
							{

								System.out.println("Enter the car that came at position " +(pos + 1)+ " : ");
								int crid = sc.nextInt();
								sc.nextLine();
								
								Car obj = array.searchAt(crid);
								if(obj!=null && !carIds.contains((Car)obj))
								{
									carIds.add(obj);
									found=true;
								}
							}
						}

						System.out.println("the following car is eliminated from the race ");
						array.pop().displayCar();
						
						//emptying the stack and refill with the new position and steadying it to the next round
						array = new CarStack();
						
						for(Car cr : carIds)
						{
							array.push(cr);
						}

					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Error " +e.toString());
					}
					
					break;

				case 7:
					
					ArrayList<Car> carIds2 = new ArrayList<Car>();
					System.out.println("---- Results for 2nd round ----");
					array.travers();
					
					try
					{
						for(int pos = 0; pos < 4; pos++)
						{
							
							boolean found = false;
							
							while(!found) {
								
								System.out.println("Enter the car that came at position " +(pos + 1)+ ": ");
								int crid = sc.nextInt();
								sc.nextLine();
								
								Car obj = array.searchAt(crid);
								
								if(obj!=null && !carIds2.contains((Car)obj)){
									carIds2.add(obj);
									found=true;
								}
							}
						}


						System.out.println("The following car is eliminated from the race...");
						array.pop().displayCar();

						array = new CarStack();
						
						for(Car cr : carIds2)
						{
							array.push(cr);
						}
					}

					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Error " + e.toString());
					}
					break;

				case 8:

					ArrayList<Car> carIds3 = new ArrayList<Car>();
					System.out.println("---- Results for 3rd round ----");
					array.travers();
					
					try
					{
						for(int pos = 0; pos < 3; pos++)
						{
							boolean found = false;
							
							while(!found)
							{
								System.out.println("Enter the car that came at position " +(pos + 1)+ ": ");
								int crid = sc.nextInt();
								sc.nextLine();
								
								Car obj = array.searchAt(crid);
								
								if(obj!=null && !carIds3.contains((Car)obj)){
									carIds3.add(obj);
									found=true;
								}
							}
						}
						
						System.out.println("the following car is eliminated from the race ");
						array.pop().displayCar();
						
						array = new CarStack();
						
						for(Car cr : carIds3)
						{
							array.push(cr);
						}
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Error " + e.toString());
					}
					break;

				case 9:
					//display winners
					System.out.println("hooray here we have the winners");
					
					Integer cnt = 1;
					while(!array.isEmpty())
					{
						System.out.println(cnt.toString()+" place");
						array.pop();
						cnt++;
					}

				default:
					return;
			}
		}
	}
}
