import org.junit.*;

import java.util.*;

public class LettersTest {
	@Test
	public void size1() {
		Letters letters = new Letters("");
		Assert.assertEquals(0, letters.size());
	}

	@Test
	public void size2() {
		Letters letters = new Letters("Qwerty");
		Assert.assertEquals(6, letters.size());
	}

	@Test
	public void size3() {
		Letters letters = new Letters("Qwertyuiop");
		Assert.assertEquals(10, letters.size());
	}

	@Test
	public void size4() {
		Letters letters = new Letters("Qwertyuiopasd");
		Assert.assertEquals(13, letters.size());
	}


	@Test
	public void isEmpty1() {
		Letters letters = new Letters();
		Assert.assertTrue(letters.isEmpty());
	}

	@Test
	public void isEmpty2() {
		Letters letters = new Letters("Qwerty");
		Assert.assertFalse(letters.isEmpty());
	}

	@Test
	public void contains1() {
		Letters letters = new Letters("Hello world!");
		Assert.assertFalse(letters.contains('c'));

	}

	@Test
	public void contains2() {
		Letters letters = new Letters("Hello world!");
		Assert.assertTrue(letters.contains('!'));
	}

	@Test
	public void contains3() {
		Letters letters = new Letters("Hello world!");
		Assert.assertTrue(letters.contains('H'));
	}

	@Test
	public void contains4() {
		Letters letters = new Letters("Hello world!");
		Assert.assertTrue(letters.contains(' '));
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorRemove1() {
		Letters letters = new Letters("");
		Iterator iter = letters.iterator();
		iter.remove();
	}

	@Test
	public void iteratorRemove2() {
		Letters letters = new Letters("Hello world");
		Iterator iter = letters.iterator();
		iter.next();
		iter.remove();
		iter.next();
		iter.remove();
		Assert.assertEquals("llo world", letters.toString());
	}

	@Test
	public void iteratorRemove3() {
		Letters letters = new Letters("ABC");
		Iterator iter = letters.iterator();
		iter.next();
		iter.next();
		iter.remove();
		Assert.assertEquals("AC", letters.toString());
	}

	@Test
	public void iteratorRemove4() {
		Letters letters = new Letters("Qwertyuiop");
		Iterator iter = letters.iterator();
		while (iter.hasNext()) {
			iter.next();
			iter.remove();
		}
		Assert.assertEquals("", letters.toString());
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorRemove5() {
		Letters letters = new Letters("h");
		Iterator iter = letters.iterator();
		iter.next();
		iter.remove();
		iter.remove();
	}

	@Test
	public void iteratorNext1() {
		Letters letters = new Letters("Hello world!");
		Iterator iter = letters.iterator();
		Assert.assertEquals('H', iter.next());
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorNext2() {
		Letters letters = new Letters("H");
		Iterator iter = letters.iterator();
		iter.next();
		iter.next();
	}

	@Test(expected = NoSuchElementException.class)
	public void iteratorNext3() {
		Letters letters = new Letters("Hello world");
		Iterator iter = letters.iterator();
		while (iter.hasNext()) {
			iter.next();
		}
		iter.next();
	}


	@Test(expected = NoSuchElementException.class)
	public void iteratorNext4() {
		Letters letters = new Letters("");
		Iterator iter = letters.iterator();
		iter.next();
	}

	@Test
	public void add1() {
		Letters letters = new Letters("Hello world!");
		letters.add('a');
		Assert.assertEquals("Hello world!a", letters.toString());
	}


	@Test
	public void add2() {
		Letters letters = new Letters("");
		letters.add('a');
		Assert.assertEquals("a", letters.toString());
	}

	@Test
	public void remove1() {
		Letters letters = new Letters("Hello world!");
		Assert.assertFalse(letters.remove('a'));
	}

	@Test
	public void remove2() {
		Letters letters = new Letters("Hello world!");
		Assert.assertTrue(letters.remove('d'));
		Assert.assertEquals("Hello worl!", letters.toString());
	}

	@Test
	public void remove3() {
		Letters letters = new Letters("llo world!");
		Assert.assertTrue(letters.remove('!'));
		Assert.assertEquals("llo world", letters.toString());
	}

	@Test
	public void remove4() {
		Letters letters = new Letters("");
		Assert.assertFalse(letters.remove('!'));
	}

	@Test
	public void containsAll1() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = new Letters("lo world!");
		Assert.assertTrue(letters.containsAll(letters1));

	}

	@Test
	public void containsAll2() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = new Letters("lo world!");
		Assert.assertFalse(letters1.containsAll(letters));

	}

	@Test
	public void addAll1() {
		Letters letters = new Letters("Hello ");
		Letters letters1 = new Letters("world!");
		letters.addAll(letters1);
		Assert.assertEquals("Hello world!", letters.toString());
	}


	@Test
	public void addAll2() {
		Letters letters = new Letters("");
		Letters letters1 = new Letters("Qwerty");
		letters.addAll(letters1);
		Assert.assertEquals("Qwerty", letters.toString());
	}

	@Test
	public void removeAll1() {
		Letters letters = new Letters("Hello ");
		Letters letters1 = new Letters("world!");
		Assert.assertTrue(letters.removeAll(letters1));
		Assert.assertEquals("He ", letters.toString());
	}

	@Test
	public void removeAll2() {
		Letters letters = new Letters("Hello ");
		Letters letters1 = new Letters("wqrd!");
		Assert.assertTrue(letters.removeAll(letters1));
		Assert.assertEquals("Hello ", letters.toString());
	}


	@Test
	public void clear1() {
		Letters letters = new Letters("");
		letters.clear();
		Assert.assertEquals("", letters.toString());
		Assert.assertEquals(0, letters.size());
	}

	@Test
	public void clear2() {
		Letters letters = new Letters("ABCDEF");
		letters.clear();
		Assert.assertEquals("", letters.toString());
		Assert.assertEquals(0, letters.size());
	}

	@Test
	public void testToString1() {
		Letters letters = new Letters("Hello world!");
		Assert.assertEquals("Hello world!", letters.toString());
	}

	@Test
	public void testEquals1() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = new Letters("Hello world!");
		Assert.assertTrue(letters.equals(letters1));
	}

	@Test
	public void testEquals2() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = letters;
		Assert.assertTrue(letters.equals(letters1));
	}

	@Test
	public void testEquals3() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = null;
		Assert.assertFalse(letters.equals(letters1));
	}

	@Test
	public void testEquals4() {
		Letters letters = new Letters("Hello world!");
		Letters letters1 = new Letters("Hello wrld!");
		Assert.assertFalse(letters.equals(letters1));
	}

	@Test
	public void retainAll1() {
		Letters letters = new Letters("Hello ");
		Letters letters1 = new Letters("wqrd!");
		Assert.assertTrue(letters.retainAll(letters1));
		Assert.assertEquals("", letters.toString());
	}

	@Test
	public void retainAll2() {
		Letters letters = new Letters("Hewwl!lo ");
		Letters letters1 = new Letters("wqrd!");
		Assert.assertTrue(letters.retainAll(letters1));
		Assert.assertEquals("ww!", letters.toString());
	}

	@Test
	public void retainAll3() {
		Letters letters = new Letters("wqrd!");
		Letters letters1 = new Letters("Hewwl!lo ");
		Assert.assertTrue(letters.retainAll(letters1));
		Assert.assertEquals("w!", letters.toString());
	}
}