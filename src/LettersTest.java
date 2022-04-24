import org.junit.*;

import java.util.*;

public class LettersTest {
	@Test
	public void size0() {
		Letters letters = new Letters("");
		Assert.assertEquals(0, letters.size());
	}

	@Test
	public void size() {
		Letters letters = new Letters("Acd ;!l \'");
		Assert.assertEquals(9, letters.size());
	}

	@Test
	public void size1() {
		Letters letters = new Letters("Acd ; !l '");
		Assert.assertEquals(10, letters.size());
	}

	@Test
	public void size2() {
		Letters letters = new Letters("Acd ;!l   '");
		Assert.assertEquals(11, letters.size());
	}

	@Test
	public void size3() {
		Letters letters = new Letters("");
		Assert.assertEquals(0, letters.size());
	}

	@Test
	public void isEmpty() {
		Letters letters = new Letters();
		Assert.assertEquals(true, letters.isEmpty());
	}

	@Test
	public void isEmpty1() {
		Letters letters = new Letters("");
		Assert.assertEquals(true, letters.isEmpty());
	}

	@Test
	public void contains() {
		Letters letters = new Letters("Hello world!");
		Assert.assertEquals(false, letters.contains('c'));

	}

	@Test
	public void contains1() {
		Letters letters = new Letters("Hello world!");
		Assert.assertEquals(true, letters.contains('!'));
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorRemove() {
		Letters letters = new Letters("");
		Iterator iter = letters.iterator();
		iter.remove();
	}

	@Test
	public void iteratorRemove1() {
		Letters letters = new Letters("Hello world");
		Iterator iter = letters.iterator();
		iter.next();
		iter.remove();
		iter.next();
		iter.remove();
		Assert.assertEquals("llo world", letters.toString());
	}

	@Test
	public void iteratorRemove2() {
		Letters letters = new Letters("123");
		Iterator iter = letters.iterator();
		iter.next();
		iter.next();
		iter.remove();
		Assert.assertEquals("13", letters.toString());
	}

	@Test
	public void iteratorRemove3() {
		Letters letters = new Letters("Hello world");
		Iterator iter = letters.iterator();
		while (iter.hasNext()) {
			iter.next();
		}
		while (!letters.isEmpty())
			iter.remove();
		Assert.assertEquals("", letters.toString());
	}

	@Test
	public void iteratorRemove4() {
		Letters letters = new Letters("Hello world");
		Iterator iter = letters.iterator();
		iter.next();
		iter.remove();
		iter.next();
		iter.remove();
		Assert.assertEquals("llo world", letters.toString());
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorRemove5() {
		Letters letters = new Letters("h");
		Iterator iter = letters.iterator();
		iter.remove();
		iter.remove();
	}

	@Test
	public void iteratorNext() {
		Letters letters = new Letters("Hello world!");
		Iterator iter = letters.iterator();
		Assert.assertEquals('H', iter.next());
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorNext1() {
		Letters letters = new Letters("H");
		Iterator iter = letters.iterator();
		iter.next();
		iter.next();
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorNext2() {
		Letters letters = new Letters("Hello world");
		Iterator iter = letters.iterator();
		while (iter.hasNext()) {
			iter.next();
		}
		iter.next();
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorNext3() {
		Letters letters = new Letters("");
		Iterator iter = letters.iterator();
		iter.next();
	}

	@Test
	public void add() {
		Letters letters = new Letters("Hello world!");
		letters.add('a');
		Assert.assertEquals("Hello world!a", letters.toString());
	}

	@Test
	public void add1() {
		Letters letters = new Letters("llo world!");
		letters.add('a');
		Assert.assertEquals("llo world!a", letters.toString());
	}

	@Test
	public void add2() {
		Letters letters = new Letters(" world!");
		letters.add('a');
		Assert.assertEquals(" world!a", letters.toString());
	}

	@Test
	public void remove() {
		Letters letters = new Letters("Hello world!");
		Assert.assertEquals(false, letters.remove('a'));
	}

	@Test
	public void remove1() {
		Letters letters = new Letters("Hello world!");
		Assert.assertEquals(true, letters.remove('d'));
		Assert.assertEquals("Hello worl!", letters.toString());
	}

	@Test
	public void remove2() {
		Letters letters = new Letters("llo world!");
		Assert.assertEquals(true, letters.remove('!'));
		Assert.assertEquals("llo world", letters.toString());
	}

	@Test
	public void containsAll() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = new Letters("lo world!");
		Assert.assertEquals(true, letters.containsAll(letters1));

	}

	@Test
	public void containsAll1() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = new Letters("lo world!");
		Assert.assertEquals(false, letters1.containsAll(letters));

	}

	@Test
	public void addAll() {
		Letters letters = new Letters("Hello ");
		Letters letters1 = new Letters("world!");
		letters.addAll(letters1);
		Assert.assertEquals("Hello world!", letters.toString());
	}

	@Test
	public void removeAll() {
		Letters letters = new Letters("Hello ");
		Letters letters1 = new Letters("world!");
		Assert.assertEquals(true, letters.removeAll(letters1));
		Assert.assertEquals("He ", letters.toString());
	}

	@Test
	public void removeAll1() {
		Letters letters = new Letters("Hello ");
		Letters letters1 = new Letters("wqrd!");
		Assert.assertEquals(true, letters.removeAll(letters1));
		Assert.assertEquals("Hello ", letters.toString());
	}

	@Test
	public void retainAll() {
		Letters letters = new Letters("Hello ");
		Letters letters1 = new Letters("wqrd!");
		Assert.assertEquals(true, letters.retainAll(letters1));
		Assert.assertEquals("", letters.toString());
	}

	@Test
	public void retainAll1() {
		Letters letters = new Letters("Hewwl!lo ");
		Letters letters1 = new Letters("wqrd!");
		Assert.assertEquals(true, letters.retainAll(letters1));
		Assert.assertEquals("ww!", letters.toString());
	}

	@Test
	public void clear() {
		Letters letters = new Letters("Hello world!");
		letters.clear();
		Assert.assertEquals("", letters.toString());
		Assert.assertEquals(0, letters.size());
	}

	@Test
	public void clear1() {
		Letters letters = new Letters("");
		letters.clear();
		Assert.assertEquals("", letters.toString());
		Assert.assertEquals(0, letters.size());
	}

	@Test
	public void testToString() {
		Letters letters = new Letters("Hello world!");
		Assert.assertEquals("Hello world!", letters.toString());
	}

	@Test
	public void testEquals() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = new Letters("Hello world!");
		Assert.assertEquals(true, letters.equals(letters1));
	}

	@Test
	public void testEquals1() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = letters;
		Assert.assertEquals(true, letters.equals(letters1));
	}

	@Test
	public void testEquals2() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = null;
		Assert.assertEquals(false, letters.equals(letters1));
	}

	@Test
	public void testEquals3() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = new Letters("Hello wrld!");
		Assert.assertEquals(false, letters.equals(letters1));
	}
}