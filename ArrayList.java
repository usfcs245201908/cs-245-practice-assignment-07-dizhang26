import java.util.Arrays; 
public class ArrayList <T> implements List<T>{
	private T[] arr; //initialize array
	private int size; //initialize size

	public ArrayList(){
		arr = (T[]) new Object[10]; 
		size = 0; 
	}
	public void growArray(){
		int doub = arr.length; 
		T[] new_array = (T[]) new Object[doub*2]; //double the length of the array
		for(int i = 0; i < arr.length; i++){
			new_array[i] = arr[i]; //copy the elements into the new array
		}
		arr = new_array; 
	}
	public T get(int pos)throws IndexOutOfBoundsException{
		if(pos<0||pos>=size){
			throw new IndexOutOfBoundsException("out of bounds");//indicate the position does not exist in the array
		}
		return arr[pos]; 
	}
	public void add(Object item){
		if(size == arr.length){
			growArray(); 
		}
		arr[size++] = (T) item; 
	}
	public void add(int pos, Object item) throws IndexOutOfBoundsException{
		if(pos < 0 || pos>size){
			throw new IndexOutOfBoundsException("out of bounds");//indicate the position does not exist in the array
		}

		if(size == arr.length){
			growArray(); //extend the array when there is no space for another element
		}

		for(int i =size; i >pos; i--){
			arr[i] = arr[i-1]; //after the element is added, move every element after the new added element one position back
		}
		arr[pos] = (T) item; 
		size++; 
	}
	public T remove(int pos)throws IndexOutOfBoundsException{
		if(pos<0 || pos>=size){
			throw new IndexOutOfBoundsException("out of bounds");//indicate the position does not exist in the array
		}
		T item = arr[pos]; 
		for(int i =pos; i<size-1; i++){ //need to move every element after the element being removed forward one position
			arr[i] = arr[i+1]; 
		}
		size--;//shink the size of the array
		return item; 
	}

	public int size(){
		return size; 
	}
}