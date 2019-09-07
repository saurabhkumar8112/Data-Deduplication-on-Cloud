package javaapplication161;
public interface methods<E>
{
	public int size();
	public void insertFirst(E data);
	public void insertLast(E data);
	public String toString();
	public void printList();
	public void deleteFirst() throws EmptyListException;
	public void deleteLast() throws EmptyListException;

	class EmptyListException extends Exception
	{
		public EmptyListException(String s)
		{
			super(s);
		}
	}
}