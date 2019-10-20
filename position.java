public class position<T> implements Position_<T>{
	
	T val;
	position<T> next;
	
	public position(T e){
		val = e;
		next = null;
	}
	public T value(){
		return val;
	}
	
	public position<T> after(){
		return next;
	}

}
