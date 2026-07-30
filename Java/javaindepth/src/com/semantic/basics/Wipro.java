import java.util.*;
class Wipro {
	int low=1;
	int high=101;
	void com() {
		for(int i=low;i<=high+1;i++) {
			for(int j=0;j<=1000;j++) {
				if (i/j==j) {
					System.out.println(i*i);
				}
			}
		}
	}
	public static void main(String[] args) {
		Wipro s=new Wipro();
		s.com();
	}
}	