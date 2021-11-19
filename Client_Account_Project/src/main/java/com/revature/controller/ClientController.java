package com.revature.controller;

import com.revature.dto.AddOrUpdateBankAccountDTO;
import com.revature.dto.AddOrUpdateClientDTO;
import com.revature.exceptions.BankAccountNotFoundException;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.exceptions.InvalidInputException;
import com.revature.models.BankAccounts;
import com.revature.models.Clients;
import com.revature.service.BankAccountsService;
import com.revature.service.ClientsService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ClientController {

	public ClientService clientsService;
	public AccountService bankAccountsService;

	public ClientController() {

		this.ClientService = new ClientService();
		this.AccountService = new AccountService();
	}


	public Handler clients = (ctx) -> {

		try {
			AddOrUpdateClientDTO addDto = ctx.bodyAsClass(AddOrUpdateClientDTO.class);

			Client c = this.clientsService.addNewClient(addDto);

			ctx.json(c);
			ctx.status(201);
		} catch (InvalidInputException e) {
			ctx.status(400);
			ctx.json(e);
		}

	};

	public Handler getAllClient = (ctx) -> {

		ctx.json(this.ClientService.getAllClient());

	};

	public Handler getClientById = (ctx) -> {

		try {
			String id = ctx.pathParam("client_id");

			Client c = this.clientService.getClientById(id);
			ctx.json(c);

		} catch (InvalidInputException e) {
			ctx.status(400);
			ctx.json(e);
		} catch (ClientNotFoundException e) {
			ctx.status(404);
			ctx.json(e);
		}

	};

	public Handler updateClientById = (ctx) -> {

		try {
			String id = ctx.pathParam("client_id");
			AddOrUpdateClientDTO dto = ctx.bodyAsClass(AddOrUpdateClientDTO.class);

			Clients clientThatNeedsToBeUpdated = this.clientsService.modifyClientsById(id, dto);

			ctx.json(clientThatNeedsToBeUpdated);

		} catch (InvalidInputException e) {
			ctx.status(400);
			ctx.json(e);
		} catch (ClientNotFoundException e) {
			ctx.status(404);
			ctx.json(e);
		}

	};

	public Handler deleteClientById = (ctx) -> {

		try {
			String id = ctx.pathParam("client_id");
			if (this.clientsService.removeClientById(id)) {
				ctx.result("Client with an id of " + id + " has been deleted");
			}

		} catch (InvalidInputException e) {
			ctx.status(400);
			ctx.json(e);
		} catch (ClientNotFoundException e) {
			ctx.status(404);
			ctx.json(e);
		}

	};

	// -------------------------------------- Bank Account Related
	// -----------------------------------

	public Handler newAccountForAClient = (ctx) -> {

		try {
			String id = ctx.pathParam("client_id");

			if (this.clientsService.getClientById(id) != null) {

				AddOrUpdateBankAccountDTO bankDto = ctx.bodyAsClass(AddOrUpdateBankAccountDTO.class);

				BankAccounts bankAccount = this.bankAccountsService.addBankAccount(id, bankDto);
				ctx.json(bankAccount);

			}

		} catch (InvalidInputException e) {
			ctx.status(400);
			ctx.json(e);
		} catch (ClientNotFoundException e) {
			ctx.status(404);
			ctx.json(e);
		}

	};

//	public Handler viewAccountOfAClient = (ctx) -> {
//		try {
//			String clientId = ctx.pathParam("client_id");
//
//			if (this.clientsService.getClientById(clientId) != null) {
//				ctx.json(this.bankAccountsService.getAccountsById(clientId));
//			}
//
//		} catch (ClientNotFoundException e) {
//			ctx.status(404);
//			ctx.json(e);
//		}
//
//	};

	public Handler getAllAccountsWithSpecificAmountOrAllAccounts = (ctx) -> {

		try {
		String clientId = ctx.pathParam("client_id");

		String amountGreaterThan = ctx.queryParam("amountGreaterThan");
		String amountLessThan = ctx.queryParam("amountLessThan");

//		System.out.println("amount greater" + amountGreaterThan);
//		System.out.println("amount less" + amountLessThan);

		if (this.clientsService.getClientById(clientId) != null) {

			if (amountGreaterThan != null && amountLessThan != null) {
				ctx.json(this.bankAccountsService.getAccountsWithSpecificAmount(clientId, amountGreaterThan,
						amountLessThan));
			} else {
				ctx.json(this.bankAccountsService.getAccountsById(clientId));
			}		
		}
		} catch (InvalidInputException e) {
			ctx.status(400);
			ctx.json(e);
		} catch (ClientNotFoundException e) {
			ctx.status(404);
			ctx.json(e);
		}

	};

	public Handler getASpecificAccountOfAClient = (ctx) -> {
		
		try {
		String clientId = ctx.pathParam("client_id");
		String accountId = ctx.pathParam("account_id");
		
		if (this.clientsService.getClientById(clientId) != null) {			
			ctx.json(this.bankAccountsService.getBankAccount(clientId, accountId));
			
		}
		} catch (InvalidInputException e) {
			ctx.status(400);
			ctx.json(e);
		} catch (ClientNotFoundException e) {
			ctx.status(404);
			ctx.json(e);
		} catch (BankAccountNotFoundException e) {
			ctx.status(404);
			ctx.json(e);
		}
	};
	
	public Handler updateBankAccountByClientAndAccountId = (ctx) -> {
		
		String clientId = ctx.pathParam("client_id");
		String accountId = ctx.pathParam("account_id");
		
		if (this.bankAccountsService.getBankAccount(clientId, accountId) != null) {	
			
			AddOrUpdateBankAccountDTO bankDto = ctx.bodyAsClass(AddOrUpdateBankAccountDTO.class);
			
			BankAccounts updatedBankAccount = this.bankAccountsService.editBankAccount(clientId, accountId, bankDto);
			
			ctx.json(updatedBankAccount);			
		}
		
	};

	public Handler removeBankAccountByClientAndAccountId = (ctx) -> {
		
	};
	
	
	public void registerEndpoint(Javalin app) {
		// ------------------------------ Client Information Related -----------------------------------
		app.post("/Client", Client);
		app.get("/Client", getAllClient);
		app.get("/clients/{client_id}", getClientById);
		app.put("/clients/{client_id}", updateClientsById);
		app.delete("/clients/{client_id}", deleteClientById);
		
		// --------------------------------- Bank Account Related --------------------------------------
		app.post("/clients/{client_id}/accounts", newAccountForAClient);
		// app.get("/clients/{client_id}/accounts", viewAccountOfAClient);
		app.get("/clients/{client_id}/accounts", getAllAccountsWithSpecificAmountOrAllAccounts);
		app.get("/clients/{client_id}/accounts/{account_id}",getASpecificAccountOfAClient);
		app.put("/clients/{client_id}/accounts/{account_id}", updateBankAccountByClientAndAccountId);
		app.delete("/clients/{client_id}/accounts/{account_id}", removeBankAccountByClientAndAccountId);

	}
}