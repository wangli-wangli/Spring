package Property;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Predicate;

import javax.management.loading.PrivateClassLoader;

public class Person {
	private String pname;
	public void setPname(String pname) {
		this.pname=pname;
	}
   private String[] arrs;
   private List<String> list;
   private Map<String, String> map;
   private Properties properties;
   
	

	public void setArrs(String[] arrs) {
		this.arrs = arrs;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

     public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}


  public void test1() {
		System.out.println("arrs........"+arrs);
		System.out.println("list........"+list);
		System.out.println("map........"+map);
		System.out.println("propertproperties........"+properties);
	}

}
