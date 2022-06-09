
public class SampleTest {
	
	String basePath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
	
	public static void main(String[] args) {
		
		SampleTest s = new SampleTest();
		// just the comment
		//just the comment
		
		//one more comment
		System.out.println(System.getProperty("user.dir"));
		try {
			System.out.println(s.basePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
