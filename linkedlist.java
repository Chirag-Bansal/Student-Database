import java.util.Iterator;

public class linkedlist<T> implements LinkedList_<T> {
	
	position<T> head;
	int count;
	
	public Position_<T> add(T e){
		position<T> naya = new position<T>(e);
		
		if(head == null) {
			head = naya;
		}
		else {
			position<T> inter = head;
			while(inter.next != null) {
				inter = inter.next;
			}
			naya.next = null;
			inter.next = naya;			
		}
		count++;
		return naya;	
	}
	
	public Iterator<Position_<T>>  positions(){
		return (new LinkedListIterator(head));
	}
	
	public Iterator<T>  pos(){
		return (new LinkedListIterator2(head));
	}
	public int  count() {
		return count;
	}
	public position<T> getHead(){
		return head;
	}
	
}
