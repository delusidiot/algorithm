package test;

public class jvmTest {

	public static void main(String[] args) {
		ClassLoader classLoader = jvmTest.class.getClassLoader();
		System.out.println(classLoader.getParent());
		System.out.println(classLoader.getParent().getParent());
		System.out.println(classLoader.getParent().getParent());
	}

}
