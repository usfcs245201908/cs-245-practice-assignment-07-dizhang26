class Node<T>{
	T data; 
	Node next; 

	public Node(Object data){
		this.data = (T) data; 
	}
}
public class LinkedList <T> implements List<T>{

	Node<T> head; 
	int size; 

	public LinkedList(){
		T head = null; //initilize the head to null
		int size = 0; //and size to 0
	}
	public int size(){
		return size; 
	}
	public T get(int pos)throws IndexOutOfBoundsException{
		if(pos>=size||pos<0){
			throw new IndexOutOfBoundsException("out of bounds"); //indicate the position does not exist in the list
		}
		Node prev = head;  
		for(int i =0; i <pos; i++){
			prev = prev.next; 
		}
		return (T)prev.data; 
	}

	public void add(int pos, T item){
		if(pos>size|| pos<0){
			System.out.println("out of bounds!!!"); //indicate the position does not exist in the list
		}
		if(pos == 0){//the elememt is added to the head of the list
			Node<T>current = new Node<T>(item);
			current.next = head; 
			head = current; 
			++size; 
		}
		else{//not the head of the list
			Node<T> current = new Node<T>(item); 
			Node<T> prev = head; 
			for(int i = 0; i <pos-1; i++){//use the previous node of the position where the element will be added
				prev = prev.next; //point to the element to be added
			}
			current.next = prev.next; 
			prev.next = current; 
			++size; 
		}
	}
	public void add(T item){
		if(head == null){//if the list is empty, make the head to be the added element
			head = new Node<T>(item); 
			++size;//incement size of the list
		}
		else{
			Node<T>prev = head; 
			while(prev.next != null){
				prev = prev.next; 
			}
		
			Node<T>curr = new Node<T>(item); 
			prev.next = curr; 
			++size; 
		}
	}
	public T remove(int pos)throws IndexOutOfBoundsException{
		if(pos > size-1 || pos <0){
			throw new IndexOutOfBoundsException("out of bounds"); //indicate the position does not exist in the array
		}
		if(pos == 0){//when the item is removed at position 0
			T item = (T) head.data; //make item equal to the head of the list
			head = head.next; 
			size--; 
			return item; 
		}
		else{//when the item is removed at other positions
			Node prev = head; //set the node that is before the item will be remove point to the item after the item will
			Node<T>current = prev;//be removed
			for(int i =0; i < pos-1; i++){
				prev = prev.next; 
			}
			Node curr = prev.next;
			T item = (T) curr.data; 
			size--; 
			return item; 
		}
	}
}