import java.time.LocalDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {
	private String name;
	private int ID;
	private Date DOB;

	public Driver(String name, int ID)
	{
		this.name = name;
		this.ID = ID;
		this.DOB = null;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Integer getID()
	{
		return this.ID;
	}
	
	private String getBirth()
	{
		return this.DOB.toString();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	private void setDOB(String date)
	{
		try
		{
			this.DOB = new SimpleDateFormat("mm-dd-yyyy").parse(date);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayDriver() {

		System.out.println("======== DRIVER DETAILS =========");
		System.out.println("DRIVER NAME : "+this.getName());
		System.out.println("DRIVER ID : "+this.getID());
		System.out.println("---------------------------------");
	}
}
