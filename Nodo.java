import java.util.Comparator;

public class Nodo <T>{
	
	T dato;
	Nodo<T> i;
	Nodo<T> d;

	public Nodo(T dato, Nodo<T> i, Nodo<T> d)
	{
		this.i = i; 
		this.d = d;
		this.dato = dato;
	}

	public Nodo(T dato)
	{
		this(dato, null, null);
	}

	public String toString()
	{
		return dato.toString();
	}
	class MyComp1 implements Comparator<Integer>
	{
		public int compare(Integer x, Integer y)
		{
			return y-x;
		}
	}
}