public class MyQueue {
    private Car rear;
    private Car front;
    private Integer size;


    public MyQueue()
    {
        this.rear = null;
        this.front = null;
        this.size = 0;
    }

    public boolean isEmpty()
    {
        return this.rear == null && this.front == null;
    }

    public void enqueue(Car obj) {
        if (isEmpty()) {
            obj.setNext(null);
            this.rear = obj;
            this.front = obj;
            this.size++;
        }
        else {
            obj.setNext(null);
            Car temp = obj;
            this.rear.setNext(temp);
            this.rear = temp;
            this.size++;
        }
    }

    public Car dequeue() {

        if (this.front == null)
        {
            System.out.println("queue is empty");
        }

        if (this.front == this.rear) {
            Car temp = this.front;
            this.front = null;
            this.rear = null;
            this.size--;
            return temp;
        }
        else {
            Car temp = this.front;
            this.front = temp.getNext();
            this.size--;
            return temp;
        }
    }

    public void size()
    {
        System.out.println(this.size.toString());
    }

    public void traverse() {
        Car current = this.front;
        while (current != null) {
            current.displayCar();
            current = current.getNext();
        }
    }

    //searches a particular car
    public Car searchCar(Integer num) {
        Car current = this.front;
        while (current != null) {
            if (current.getId() == num) {
                System.out.println("element found");
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    /******************************************************************************/
    //remove an element having a particular id
    public void removeAt(Integer sid)
    {
        Car current = this.front;
        Car right = this.front.getNext();

        int count = 0;

        while (right != null)
        {
            if (sid == current.getId() && count == 0) {
                this.front = current.getNext();
                System.out.println("element has been removed successfully");
                break;
            }
            else if (sid == right.getId() && count != this.size - 2)
            {
                current.setNext(right.getNext());
                System.out.println("element has been removed successfully");
                break;
            }
            else if (sid == right.getId() && count == this.size - 2)
            {
                current.setNext(null);
                System.out.println("element has been removed successfully");
                break;
            }
            else
            {
                current = current.getNext();
                right = right.getNext();
                count++;
            }
        }
    }
}
