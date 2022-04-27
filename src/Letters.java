import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Letters implements Collection<Character>, Iterable<Character> {
	private int size = 0;
	private Character[] letters;

	private class MyIterator implements Iterator<Character> {
		private int current = -1;
		private boolean hasPrev = false;

		public static void main(String[] args) {
			System.out.println("Hello world!");
		}

		@Override
		public boolean hasNext() {
			return current < letters.length && letters[current + 1] != null;
		}

		@Override
		public Character next() throws NoSuchElementException {
			System.out.println(current);
			if (hasNext()) {
				hasPrev = true;
				return letters[++current];
			} else
				throw new NoSuchElementException();
		}

		@Override
		public void remove() throws NoSuchElementException {
			Character[] result = new Character[letters.length - 1];
			if (current != -1) {
				if (!hasPrev)
					throw new NoSuchElementException();
				else {
					for (int i = 0; i < current; i++) {
						result[i] = letters[i];
					}
					for (int i = current; i < result.length; i++) {
						result[i] = letters[i + 1];
					}
				}
				current--;
				size--;
				hasPrev = false;
				System.arraycopy(result, 0, letters, 0, result.length);
				return;
			}
			throw new NoSuchElementException();
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < current; ++i)
				s.append(letters[i]);
			return s.toString();
		}
	}

	public Letters() {
		letters = new Character[10];
	}

	public Letters(String s) {
		letters = new Character[10];
		char[] s_array = s.toCharArray();
		for (Character chr : s_array) {
			add(chr);
		}
	}

	private void resize(int newLength) {
		Character[] chars = new Character[newLength];
		for (int i = 0; i < letters.length; i++) {
			chars[i] = letters[i];
		}
		letters = chars;
	}

	private int find(Character ch) {
		for (int i = 0; i < size; i++) {
			if (letters[i].equals(ch))
				return i;
		}
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object obj) {
		Character ch = (Character) obj;
		for (Character chr : letters) {
			if (chr != null) {
				if (chr.equals(ch))
					return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<Character> iterator() {
		return new MyIterator();
	}

	@Override
	public Object[] toArray() {
		return letters;
	}

	@Override
	public <T> T[] toArray(T[] arr) {
		if (arr.length < letters.length)
			return (T[]) letters;
		System.arraycopy(letters, 0, arr, 0, letters.length);
		if (arr.length > letters.length)
			arr[letters.length] = null;
		return arr;
	}

	@Override
	public boolean add(Character chr) {
		if (size == letters.length)
			resize(letters.length * 2);
		letters[size++] = chr;
		return letters[size - 1] == chr;
	}

	@Override
	public boolean remove(Object obj) {
		Character chr = (Character) obj;
		if (obj == null)
			return false;
		if (contains(obj)) {
			for (int i = find(chr); i < size - 1; i++)
				letters[i] = letters[i + 1];
			letters[--size] = null;
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		for (Object element : collection) {
			Character chr = (Character) element;
			if (!contains(chr))
				return false;
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends Character> collection) {
		for (Character element : collection) {
			boolean canAdd = add(element);
			if (!canAdd)
				return false;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		Object[] collectArray = collection.toArray();
		for (Object element : collectArray) {
			while (contains(element)) {
				remove(element);
			}
		}
		return !containsAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		Letters letters = new Letters("");
		String s = toString();
		removeAll(collection);
		for (Character chr : s.toCharArray()) {
			if (!contains(chr)) {
				letters.add(chr);
			}
		}
		clear();
		addAll(letters);
		return collection.containsAll(this);
	}

	@Override
	public void clear() {
		Iterator<Character> iterator = iterator();
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Character ch : letters) {
			if (ch != null)
				s.append(ch);
		}
		return s.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		Letters ch = (Letters) obj;
		if (size != ch.size)
			return false;
		else {
			for (int i = 0; i < size; i++) {
				if (ch.letters[i] != this.letters[i])
					return false;
			}
			return true;
		}
	}

	public int getSize() {
		return size;
	}
}
