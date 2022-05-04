package P3;

import static org.junit.Assert.*;

import org.junit.Test;

import P3.FriendshipGraph;
import P3.Person;

public class FriendshipGraphTest {

@Test(expected = AssertionError.class)
	
	public void testAssertionsEnabled() {
		assert false;
	}
	@Test
	public void addVertexTest() {
		Person a=new Person("a");
		Person b=new Person("b");
		Person c=new Person("a");
		FriendshipGraph Result=new FriendshipGraph() ;
		Result.addVertex(a);
		assertEquals(true,Result.partner().contains(a));
		assertEquals(false,Result.partner().contains(b));
		Result.addVertex(b);
		assertEquals(true,Result.partner().contains(a));
		assertEquals(true,Result.partner().contains(b));
		Result.addVertex(a);
		assertEquals(true,Result.partner().contains(a));
		assertEquals(true,Result.partner().contains(b));
		Result.addVertex(c);
		assertEquals(true,Result.partner().contains(a));
		assertEquals(false,Result.partner().contains(c));
	}

	@Test
	public void addEdgeTest() {
		Person a=new Person("a");
		Person b=new Person("b");
		Person c=new Person("c");
		FriendshipGraph Result=new FriendshipGraph() ;
		Result.addEdge(a, b);
		assertEquals(false, a.frind().contains(b));
		assertEquals(false, b.frind().contains(a));
		Result.addVertex(a);
		assertEquals(false, a.frind().contains(b));
		assertEquals(false, b.frind().contains(a));
		Result.addVertex(b);
		Result.addEdge(a, b);
		assertEquals(true, a.frind().contains(b));
		assertEquals(false, b.frind().contains(a));
		Result.addEdge(b, a);
		assertEquals(true, a.frind().contains(b));
		assertEquals(true, b.frind().contains(a));
	}
	
	@Test
	public void getDistance() {
		Person a=new Person("a");
		Person b=new Person("b");
		Person c=new Person("c");
		Person d=new Person("d");
		Person e=new Person("e");
		Person f=new Person("f");
		Person g=new Person("g");
		Person h=new Person("h");
		FriendshipGraph Result=new FriendshipGraph() ;
		Result.addVertex(a);
		assertEquals(0, Result.getDistance(a, a));
		assertEquals(-1, Result.getDistance(a, b));
		Result.addVertex(b);
		assertEquals(-1, Result.getDistance(a, b));
		Result.addEdge(a, b);
		Result.addEdge(b, a);
		assertEquals(1, Result.getDistance(a, b));
		assertEquals(1, Result.getDistance(b, a));
		Result.addVertex(c);
		Result.addVertex(d);
		Result.addVertex(e);
		Result.addVertex(f);
		Result.addVertex(g);
		Result.addVertex(h);
		Result.addEdge(f, b);
		Result.addEdge(b, f);
		Result.addEdge(a, e);
		Result.addEdge(e, a);
		Result.addEdge(c, f);
		Result.addEdge(f, c);
		Result.addEdge(f, g);
		Result.addEdge(g, f);
		Result.addEdge(c, g);
		Result.addEdge(g, c);
		Result.addEdge(c, d);
		Result.addEdge(d, c);
		Result.addEdge(d, g);
		Result.addEdge(g, d);
		Result.addEdge(g, h);
		Result.addEdge(h, g);
		Result.addEdge(h, d);
		Result.addEdge(d, h);
		assertEquals(2, Result.getDistance(e, b));
		assertEquals(2, Result.getDistance(b, e));
		assertEquals(2, Result.getDistance(c, b));
		assertEquals(2, Result.getDistance(b, c));
		assertEquals(2, Result.getDistance(g, b));
		assertEquals(2, Result.getDistance(b, g));
		assertEquals(3, Result.getDistance(d, b));
		assertEquals(3, Result.getDistance(b, d));
		assertEquals(3, Result.getDistance(h, b));
		assertEquals(3, Result.getDistance(b, h));
	}
}
