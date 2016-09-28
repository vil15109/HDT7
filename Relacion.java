import java.util.HashMap;

public class Relacion<K,V> implements Comparable<Relacion<K,V>> {

	private HashMap<K,V> dic;
 
	public Relacion(){
		dic = new HashMap<K,V>();
	}


	public void insertar(K key, V value){
		dic.put(key, value);
	}


	public V get(K key){
		return dic.get(key);
	}

	public boolean containsKey(K key){
		if(dic.containsKey(key)){
			System.out.println("Si existe!");
			return true;
		}else{
			System.out.println("No existe!");
			return false;
		}
	}

	@Override
	public int compareTo(Relacion o) {

		return 0;
	}
}