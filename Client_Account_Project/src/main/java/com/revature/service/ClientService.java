package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.ClientDAO;
import com.revature.dto.AddOrUpdateAccountDTO;
import com.revature.dto.AddOrUpdateClientDTO;
import com.revature.exceptions.ClientNotFoundException;
import com.revature.exceptions.InvalidInputException;
import com.revature.model.Account;
import com.revature.model.Client;

public class ClientService {

	public ClientDAO ClientDao;

	public ClientService() {
		this.ClientDao = new ClientDAO();
	}

	public Client addNewClient(AddOrUpdateClientDTO addDto) throws SQLException, InvalidInputException {

		if (addDto.getFirst_Name().trim().equals("") || addDto.getLast_Name().trim().equals("")
				|| addDto.getAddress().trim().equals("")  || addDto.getPhone_Number().trim().equals("")) {
			throw new InvalidInputException("All fields cannot be empty!");
		}

		Client insertClient = this.ClientDao.insertClient(addDto);

		return insertClient;
	}

	public List<Client> getAllClients() throws SQLException {

		return this.ClientDao.selectAllClient();
	}

	public Client getClientById(String id) throws SQLException, InvalidInputException, ClientNotFoundException {

		try {
			int clientsId = Integer.parseInt(id);

			Client c = this.ClientDao.selectClientById(Client_id);

			if (c == null) {
				throw new ClientNotFoundException("Client id of " + id + " does not exist!");
			}
			return c;

		} catch (NumberFormatException e) {
			throw new InvalidInputException("Entered id cannot be converted to int value! ");
		}

	}

	public boolean removeClientById(String id) throws SQLException, ClientNotFoundException, InvalidInputException {

		try {
			int clientsId = Integer.parseInt(id);

			Client c = this.ClientDao.selectClientById(Client_id);

			if (c == null) {
				throw new ClientNotFoundException(
						"Can't delete a client with a client id of " + id + " because the client does not exist");
			}

			return (this.ClientDao.deleteClientsById(clientsId));

		} catch (NumberFormatException e) {
			throw new InvalidInputException("Entered id cannot be converted to int value! ");
		}

	}

	public Client modifyClientsById(String cId, AddOrUpdateClientDTO dto)
			throws SQLException, InvalidInputException, ClientNotFoundException {

		try {
			int Client_id = Integer.parseInt(cId);

			Client id = this.ClientDao.selectClientById(Client_id);

			if (id == null) {
				throw new ClientNotFoundException("Client id of " + Client_id + " does not exist!");
			}

			Client updateClient = this.ClientDao.updateClientById(Client_id, dto);

			return updateClient;

		} catch (NumberFormatException e) {
			throw new InvalidInputException("Entered id cannot be converted to int value!");
		}

		// Clients modifyClient = clientsDao.selectClientsById(client_id);
		// AddOrUpdateClientDTO updateClient = new AddOrUpdateClientDTO(firstName,
		// lastName);

	}
	
}
