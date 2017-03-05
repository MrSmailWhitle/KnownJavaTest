package test.data.interactive;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class TestSysSet {
	private String browstyle=System.getProperty("BROWSER_TYPE");
	@Test
	public void test() {
		assertEquals(browstyle,null);
	}

}
