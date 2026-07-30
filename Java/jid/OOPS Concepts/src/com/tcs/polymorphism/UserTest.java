package com.tcs.polymorphism;

public class UserTest {
	public void printUserType(User u/* Staff s */) {
		u.printUserType();
		/*
		 * if (s instanceof Editor) { ((Staff) s).printUserType(); } else {
		 * System.out.println("ok"); }
		 */
	}

	public static void approveReview(Staff s) {
		if (s instanceof Editor) {
			((Editor) s).approveReview();
			System.out.println("\n");
		} else {
			System.out.println("Invalid object passed1 !!\n");
		}

	}

	/*
	 * The only diff between above and below example is Staff and chiefEditor
	 * classes does not have any approveReview() method but Editor class has
	 * approveReview() method.
	 * 
	 * 1.We are getting Invalid Object Passed output coz Editor is not supertype to
	 * Staff class that we passed as parameter (Staff s) Note:- based on above
	 * example
	 * 
	 * 
	 * 2.We are getting Editor: approveReview as output coz Editor is supertype to
	 * chiefEditor class that we passed as parameter (chiefEditor ce) Note:- based
	 * on below example.
	 * 
	 * 
	 * 
	 */
	
	public static void approveReview(chiefEditor ce) { 
	  if (ce instanceof Editor) {
		  System.out.println("the below outputs belongs to chiefeditor ce parameter");
		  ((Editor) ce).approveReview(); // chiefEditor is not super to Editor u will get correct outputs !! 
		  ((Editor) ce).printUserType(); 
	  } else {
		  System.out.println("Invalid object passed2 !!\n");
	  }  
	  
	}

	/*
	 * public static void approveReview(Editor e) { if (e instanceof chiefEditor) {
	 * // Editor is super to chiefEditor u will get Invalid object passed3 !!.
	 * ((chiefEditor) e).approveReviewprintUserType(); } else {
	 * System.out.println("Invalid object passed3 !!"); }
	 * 
	 * }
	 */
	public static void main(String[] args) {
		// part 1
		User user = new User();
		User/* Staff */ staff = new Staff();
		User editor = new Editor();
		Staff stator = new Editor();
		Staff st=new Staff();
		staff.postAReview(" ");
		st.staticMethod();
		//st.getId(); // User class does not have getId() method,thats why we r getting compiler error
		((Staff) staff).getId();           // to avoid we can do 2 things 1.add cast to staff object & 2.use st coz st is Staff type

		// method binding concepts
		
		((Staff) staff).instanceMethod(10);
		staff.instanceMethod(10); // staff is reftype of User so it called User instanceMethod of double
		st.instanceMethod(10); //  st is reftype of Staff so it called Staff instanceMethod of int
		staff.instanceMethod(new Staff());
		st.instanceMethod(new Staff());
		st.instanceMethod(new User());
		st.instanceMethod(new Editor());// Editor() is reftype of User so it called User instanceMethod of User
		//editor.ameer(); it asks to create ameer() method in User coz editor ref type is User
		//st.ameer(); it asks to create ameer() method in Staff coz st ref type is Staff
		((Editor) stator).ameer();
		
		// what is not overidden
		staff.saveWebLink();
		
		/*
		 * UserTest ut = new UserTest(); ut.printUserType(user);
		 * ut.printUserType(staff); ut.printUserType(editor);
		 */
		// Part 2
		// editor.approveReview; Note:- Won't work coz compiler checks Reference
		// type(User)
		// staff.postAReview(); // for better understanding disable comments of
		// postAReview() method from Editor class
		// editor.postAReview(); // jvm checks object type(User(),Staff()) from subclass
		// only

		// for example
		// 1.editor does not have postAReview method but jvm invokes by object
		// type(Editor())
		// subclass here subclass is(Staff()) whose having postAReview Method

		// editor.saveWebLink();
		// this invokes Staff type instead of User type coz we discussed jvm checks from
		// below(subclass)
		// ((Editor) s).approveReview();
		// approveReview();
		/*
		 * Staff s=new Editor(); // s.approveReview(); // compiler error ((Editor)
		 * s).approveReview();
		 */
		/*
		 * Staff s=new Editor(); Staff s1 = new Staff(); s1.postAReview();
		 * approveReview(s);
		 */

		// Casting & instanceof demo
		/*
		 * UserTest ut1=new UserTest(); ut1.approveReview(s1); ut1.approveReview(new
		 * Staff()); ut1.approveReview(s);
		 */
		Editor e = new Editor();
		/*
		 * chiefEditor ce=new chiefEditor(); ce.approveReview();
		 */

		//approveReview(new Staff()); 
		                             /*
									 * i cheated compiler thats why i got runtime error. I promised compiler that i
									 * will pass explicit cast object. means i inserted Editor cast to var s,i have
									 * to pass (new Editor()) but i passed (new Staff())
									 */
		//approveReview(new Editor()); // Here i passed Editor() as i promised to compiler
		
		//approveReview(new chiefEditor()); // I promised compiler that i will pass
		// explicit cast object.
		// means i inserted chiefEditor cast to var e.
		// approveReview(new chiefEditor());

		/* next task is pass parametr as User u and apply explicit cast as Staff later
		pass parametr as editor and cast as
		Staff. */ // this task is completed.
		
		// overriding of instance variables(fields)
		staff.displayUserInfo();
		//((Staff) staff).displayUserInfo();
		//((Editor) editor).displayUserInfo();
		System.out.println("userType directly: " + staff.userType);
		
		
	}

}
