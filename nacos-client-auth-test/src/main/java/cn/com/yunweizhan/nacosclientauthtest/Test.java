package cn.com.yunweizhan.nacosclientauthtest;

/**
 * @author Weizhan▪Yun
 * @date 2022/9/16 12:25
 */
public class Test {
	public static int num = 1;

	static {
		System.out.println("静态代码块：" + num);
		num *= 2;
	}

	public static Test test = new Test();

	private Test() {
		System.out.println("构造函数：" + num);
		num += 1;
		System.out.println("构造函数：" + num);
	}

	public static Test getInstance() {
		return test;
	}

	public static void main(String[] args) {
		Test.getInstance();
		System.out.println("main thread: " + Test.num);
	}

}
