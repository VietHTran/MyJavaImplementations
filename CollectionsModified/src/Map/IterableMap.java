package Map;

import java.util.ArrayList;
import java.util.HashMap;

public class IterableMap {
	private HashMap map;
	private ArrayList<Object> valueList;
	private int index;
	
	public IterableMap() {
		map= new HashMap();
		valueList=new ArrayList<Object>();
		index=0;
	}
	
	public void put(Object key,Object value) {
		//if key already exists --> Replace current value with new value
		if (map.containsKey(key)) {
			int i=valueList.indexOf(map.get(key));
			valueList.set(i, value);
		} else {
			valueList.add(value);
		}
		map.put(key, value);
	}
	
	public void remove(Object key) {
		valueList.remove(map.get(key));
		//If removed object is the last element
		if (index>=valueList.size()) index=valueList.size()-1;
		map.remove(key);
	}
	
	public Object get(Object key) {
		return map.get(key);
	}
	
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}
	
	//Get current value[index] in valueList
	public Object get() throws IndexOutOfBoundsException {
		if (valueList.size()==0) throw new IndexOutOfBoundsException();
		return valueList.get(index);
	}
	
	public int size() {
		return valueList.size();
	}
	
	public void goToFirst() throws IndexOutOfBoundsException {
		if (valueList.size()==0) throw new IndexOutOfBoundsException();
		index=0;
 	}
	
	public void goToLast() throws IndexOutOfBoundsException {
		if (valueList.size()==0) throw new IndexOutOfBoundsException();
		index=valueList.size()-1;
 	}
	
	public boolean hasNext() {
		if (valueList.size()==0||valueList.size()==index+1) return false;
		return true;
 	}
	
	public boolean hasPrevious() {
		if (valueList.size()==0||index==0) return false;
		return true;
 	}
	
	//Go to next value
	public boolean next() {
		if (!hasNext()) return false;
		index++;
		return true;
	}
	
	//Go to previous value
	public boolean previous() {
		if (!hasPrevious()) return false;
		index--;
		return true;
	}
}
