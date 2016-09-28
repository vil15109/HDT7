import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class Tree <T extends Comparable<T>>  implements Iterable<T>{
	private Nodo<T> raiz;
	private Comparator<T> comparator;
	ArrayList<String> recorrido = new ArrayList<String>();

	public Tree(){
		this.raiz=null;
		this.comparator = null; 
	}

	public Tree(Comparator<T> comp)
	{
		this.raiz = null;
		comparator = comp;
	}

	private int compare(T x, T y)
	{
		if(comparator == null) return x.compareTo(y);
		else
			return comparator.compare(x,y);
	}

	public void agregar(T dato){
		raiz = insert(raiz, dato);
	}
	private Nodo<T> insert(Nodo<T> p, T toInsert)
	{
		if (p == null)
			return new Nodo<T>(toInsert);

		if (compare(toInsert, p.dato) == 0)
			return p;

		if (compare(toInsert, p.dato) < 0)
			p.i = insert(p.i, toInsert);
		else
			p.d = insert(p.d, toInsert);

		return p;
	}

	public boolean search(T toSearch)
	{
		return search(raiz, toSearch);
	}
	private boolean search(Nodo<T> p, T toSearch)
	{
		if (p == null)
			return false;
		else
			if (compare(toSearch, p.dato) == 0)
				return true;
			else
				if (compare(toSearch, p.dato) < 0)
					return search(p.i, toSearch);
				else
					return search(p.d, toSearch);
	}


	public void borrar(T toDelete)
	{
		raiz = borrar(raiz, toDelete);
	}
	private Nodo<T> borrar(Nodo<T> p, T toDelete)
	{
		if (p == null)  throw new RuntimeException("Error no puede borrar");
		else
			if (compare(toDelete, p.dato) < 0)
				p.i = borrar (p.i, toDelete);
			else
				if (compare(toDelete, p.dato)  > 0)
					p.d = borrar (p.d, toDelete);
				else
				{
					if (p.i == null) return p.d;
					else
						if (p.d == null) return p.i;
						else
						{
						
							p.dato = retrieveData(p.i);
						
							p.i =  borrar(p.i, p.dato) ;
						}
				}
		return p;
	}
	private T retrieveData(Nodo<T> p)
	{
		while (p.d != null) p = p.d;

		return p.dato;
	}

   public void preOrderTraversal()
   {
      preOrderHelper(raiz);
   }
   private void preOrderHelper(Nodo r)
   {
      if (r != null)
      {
         
         preOrderHelper(r.i);
         preOrderHelper(r.d);
      }
   }

	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		for(T dato : this) sb.append(dato.toString());

		return sb.toString();
	}

   public void inOrderTraversal()
   {
      inOrderHelper(raiz);
   }
   private void inOrderHelper(Nodo r)
   {
      if (r != null)
      {
         inOrderHelper(r.i);
         
         recorrido.add(r.toString());
         inOrderHelper(r.d);
      }
   }


	public Iterator<T> iterator()
	{
		return new MyIterator();
	}

	private class MyIterator implements Iterator<T>
	{
		Stack<Nodo<T>> stk = new Stack<Nodo<T>>();

		public MyIterator()
		{
			if(raiz != null) stk.push(raiz);
		}
		public boolean hasNext()
		{
			return !stk.isEmpty();
		}

		public T next()
		{
			Nodo<T> cur = stk.peek();
			if(cur.i != null)
			{
				stk.push(cur.i);
			}
			else
			{
				Nodo<T> tmp = stk.pop();
				while( tmp.d == null )
				{
					if(stk.isEmpty()) return cur.dato;
					tmp = stk.pop();
				}
				stk.push(tmp.d);
			}

			return cur.dato;
		}
	}
}