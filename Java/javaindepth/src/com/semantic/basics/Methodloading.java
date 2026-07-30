/* Method overloading

Declaring two methods within same class with different parameters.
1.Must change parameter list
  -> parameters or parameters  types both muyust vary
2.Changing only return type does not matter
3.Applies to Instance and static methods

->Valid Examples
  1.void updateprofile(int newid)              --> updateprofile(1000)
  2.void updateprofile(int newid,char gender)  --> updateprofile(1000,'F')
  3.void updateprofile(char gender,int newid)  --> updateprofile('F',1000)
  4.void updateprofile(short newid)            --> updateprofile(50)
  
-> Invalid Examples
  1.boolean updateprofile(int newid)
  2.void updateprofile(int id)
  3.static void updateprofile(int newid) compiler gives error.
      duplicate method 
*/
class Methodloading {
	void updateprofile(long newid) {   //long range 2147483648 to 9223372036854775808
		System.out.println("long method:" + newid);
	}
	void updateprofile(int newid) {
		System.out.println("Integer method:" + newid);
	}
	void updateprofile(int newid,char gender) {
		System.out.println("Integer followed by char:" + newid + "\t" + gender);
	}
	void updateprofile(char gender,int newid) {
		System.out.println("char followed by Integer:"  + gender + newid);
	}
	void updateprofile(short newid) {
		System.out.println("short method:" + newid);
	}
	void updateprofile(byte newid) {
	System.out.println("byte method:" + newid);
	}
	public static void main(String[] args) {
		Methodloading m=new Methodloading();
		m.updateprofile(9223372036854775807L);
		m.updateprofile(2147483647);  // int range 32768 to 2147483648
		m.updateprofile(1000,'F');
		m.updateprofile('M',1200);
		short b=32767;   // short range 128 to 32767
		m.updateprofile(b);
		byte d=127;   // short range 0 to 127
		m.updateprofile(d);
		
		
	}
}
	