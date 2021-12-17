package com.revature.controller;
import org.apache.tika.Tika;
import java.io.InputStream;
import java.util.List;
import com.revature.dto.ChangeReimbursementAmountDTO;
import com.revature.dto.MessageDTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.service.ReimbursementService;
import com.revature.service.AuthorizationService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.UploadedFile;

public class ReimbursementController implements Controller {

	private AuthorizationService authService;
	private ReimbursementService reimbursementService;
	
	public ReimbursementController() {
		this.authService = new AuthorizationService();
		this.reimbursementService = new ReimbursementService();
	}
	
	private Handler getReimbursements = (ctx) -> {
		
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeEmployeeAndFinanceManager(currentlyLoggedInUser);

		List <Reimbursement> reimbursements = this.reimbursementService.getReimbursements(currentlyLoggedInUser);
		
		ctx.json(reimbursements);
		ctx.status (201);
	};
	
	private Handler getReimbursementById = (ctx) -> {
		
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeEmployeeAndFinanceManager(currentlyLoggedInUser);

		List <Reimbursement> reimbursements = this.reimbursementService.getReimbursements(currentlyLoggedInUser);
		
		ctx.json(reimbursements);
	};
	

	private Handler changedReimbursementStatus = (ctx) -> {
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeFinanceManager(currentlyLoggedInUser);
		
		String id = ctx.formParam("id");
		String status = ctx.formParam("status");
		 this.reimbursementService.changedStatus(currentlyLoggedInUser, id, status);	
		
		ctx.json("Reiembersment sucessfuly changed");
		ctx.status (201);
	
	};
	
	
	private Handler addReimbursement = (ctx) -> {
		
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeEmployeeAndFinanceManager(currentlyLoggedInUser);
		
		
		String reimb_type = ctx.formParam("reimb_type");
		String amount = ctx.formParam("amount");
		String description = ctx.formParam("description");
		UploadedFile file = ctx.uploadedFile("image");
		System.out.println(file);
		
		if (file == null) {
			ctx.status(400);
			ctx.json(new MessageDTO("Must have a receipt to upload"));
			return;
		}
		
		InputStream receipt = file.getContent(); // This is the most important. It is the actual content of the file

		Tika tika = new Tika();

		String mimeType = tika.detect(receipt);
		
		Reimbursement addedReimbursement = this.reimbursementService.addReimbursements(currentlyLoggedInUser, mimeType, reimb_type, amount, description,receipt);
		
		ctx.json(addedReimbursement);
		ctx.status(201);
		
	};

		
	private Handler getImageFromReimbursementById = (ctx) -> {
	
		User currentlyLoggedInUser = (User) ctx.req.getSession().getAttribute("currentuser");
		this.authService.authorizeEmployeeAndFinanceManager(currentlyLoggedInUser);
		
		String Id = ctx.pathParam("id");
		
		
		InputStream receipt = this.reimbursementService.getReceiptFromReimbursementById(currentlyLoggedInUser,Id);
		
		Tika tika = new Tika();
		String mimeType = tika.detect(receipt);
		
		ctx.contentType(mimeType); // specifying to the client what the type of the content actually is
		ctx.result(receipt); // Sending the image back to the client
	};
	

	@Override
	public void mapEndpoints(Javalin app) {
			app.get("/reimbursements", getReimbursements);
			app.get ("/reimbursements/{id}", getReimbursements);// Manager can approve or deny reimbursement
			app.post("/changereimbursements", changedReimbursementStatus);// manager can change the status of reimbursement
			app.post("/reimbursements", addReimbursement);	
			app.get("/reimbursement/{id}/image", getImageFromReimbursementById);
	}
	}	


