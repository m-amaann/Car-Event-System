
public class CarStack {
	private Integer size;
	private Car head;

	public CarStack()
	{
		this.head = null;
		this.size = 0;
	}

	//return the top value
	public  void top()
	{
		this.head.displayCar();
	}
	
	//checks whether the structure is empty
	public boolean isEmpty()
	{
		return this.head == null;
	}
	
	//pushing the elements into the stack
	public void push(Car value)
	{
		while (isEmpty())
		{
			this.head = value;
            this.size++;
		}
			Car temp = this.head;
			value.setNext(temp);
			this.head=value;
			this.size++; //size = size + 1

	}
	
	//pops the recently inserted elemented from the stack
	public Car pop() {
		
		if(this.isEmpty())
		{
			System.out.println("stack is empty");
			return null;
		}
		else {
			Car last = this.head;
			this.head = this.head.getNext();
			this.size--;
			
			return last;
		}

	}
	
	//returns the size
	public int size() {

		return this.size;
	}
	
	//traverses the stack
	public void travers()
	{
		Car crt = this.head;

		while(crt != null)
		{
			crt.displayCar();
			crt.getDriver().displayDriver();
			crt=crt.getNext();
		}
	}
	
	//returns a element at a given index
	public Car searchAt(int index) {
		Car crt = this.head;
		
		while(crt!=null) {
			if(crt.getId()==index) {
				System.out.println("------- element found --------");
				crt.displayCar();
				crt.getDriver().displayDriver();
				return crt;
			};
			
			crt = crt.getNext();
		}
		
		System.out.println("element not found");
		return null;
	}
	
	//removes an element
	public void remove(Integer index) {
		
		Car crt = this.head;
		Car left=this.head;
		
		if(isEmpty()) {
			System.out.println("stack is empty");
		}
		else {
			Integer count = 0;
			
			while(crt!=null) {
				
			if(count==this.size&&crt.getId()!=index) {
				
				System.out.println("element not found");
				break;
				
			}
			if(left==crt) {
				if(crt.getId()==index) {
						Car right = crt.getNext();
						this.head=right;
						System.out.println("Successfully removed the specified id :"+index.toString());
						break;
						
				}
				else {
						crt=crt.getNext();
				}
			}
			else if(crt.getId()==index) {
					Car right = crt.getNext();
					left.setNext(right);
					break;
				}
			
			else{
					crt=crt.getNext();
					left=left.getNext();
				}
			count++;
			
			}
		}
	}
}
