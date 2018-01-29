package aop;
/*import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.anntation.Before;

@Aspect*/
public class MyBook {
	
	/*@Before(value="execution(* .aop.Book.*(..))")*/
	public void before1() {
		System.out.println("before.........");
	}

}
