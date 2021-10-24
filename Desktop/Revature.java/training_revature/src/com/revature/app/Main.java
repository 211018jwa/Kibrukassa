package com.revature.app; // This line of code is specifying what package this class belongs to
// It belongs to the com.revature.app package
// packages follow a "reverse domain" naming convention
// So, if you work for google, your package names will usually start with com.google.<whatever else you want>.<even more of what you want>

import com.revature.model.*;

public class Main {

	// The shortcut we can use to create our main method is by typing main followed by ctrl + space
	// ctrl + space will give you a dropdown containing suggestions that you can use

	public static void main(String[] args) {

		// A shortcut to create a System.out.println() method statement is to type
		// sysout followed by ctrl + space
		System.out.println("Hi there!");

		Reimbursement reimbursement1 = new Reimbursement(); // This is how you create a new object. the new keyword followed by what is known as a constructor will instantiate an object
		// based on that particular class.
		// Since the Reimbursement class (com.revature.model) is contained in a separate package from the package this class is in (com.revature.app), we need to import the Reimbursement
		// class

		Reimbursement reimbursement2 = new Reimbursement();

		reimbursement2.approved = false;
		reimbursement2.description = "This is a reimbursement for lodging expenses";
		reimbursement2.submitter = "John Doe";
		reimbursement2.amount = 100.58;

		reimbursement1.approved = true;
		reimbursement1.description = "This is a reimbursement for travel expenses using Uber";
		reimbursement1.submitter = "Bach Tran";
		reimbursement1.amount = 32.43;

		System.out.println(reimbursement1.approved);
		System.out.println(reimbursement1.description);
		System.out.println(reimbursement1.submitter);
		System.out.println(reimbursement1.amount);

		System.out.println();

		System.out.println(reimbursement2.approved);
		System.out.println(reimbursement2.description);
		System.out.println(reimbursement2.submitter);
		System.out.println(reimbursement2.amount);

	}

}