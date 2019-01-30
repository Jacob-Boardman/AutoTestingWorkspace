import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Para {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {{"ja", "visuv", 2, true}, {"de", "yoop", 10, false} });
	}
	
	private String a;
	private String b;
	int c;
	boolean d;
	
	public Para(String a, String b, int c, boolean d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	@Test
	public void test() {
		System.out.println(a+" "+b+" "+c+" "+d);
	}
	
	
}
