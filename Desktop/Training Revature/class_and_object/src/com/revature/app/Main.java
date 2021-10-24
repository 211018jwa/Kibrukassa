package com.revature.app;
import com.revature.model.Reimbursement; 
public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Hi there!");
		
		Reimbursement reimbursement1 = new Reimbursement(); 
		
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