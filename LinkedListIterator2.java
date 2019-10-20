import java.util.Iterator;

public class LinkedListIterator2 <T> implements Iterator<T>{

public position<T> curr;
	
	public LinkedListIterator2 (position<T> head){
		if(head == null)
			 curr = new position<T>(null);
		else {
			curr = new position<T>(head.val);
			curr.next = head.next;
		}
	}
	
	public boolean hasNext() {
		if(curr!= null)
			return true;
		else
			return false;
	}

	public position<T> Next(){
		position<T> data = curr;
		curr = curr.next;
		return data;
	}
	
	public T next(){
		position<T> data = curr;
		curr = curr.next;
		return data.value();
	}
}
