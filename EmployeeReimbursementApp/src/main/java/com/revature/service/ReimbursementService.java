package com.revature.service;

import java.io.InputStream;
import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.revature.dao.ReimbursementDAO;
import com.revature.exceptions.ReimbursementAlreadyResolvedException;
import com.revature.exceptions.ReimbursementImageNotFoundException;
import com.revature.exceptions.ReimbursementNotFoundException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.model.Reimbursement;
import com.revature.model.User;

public class ReimbursementService {

	private ReimbursementDAO reimbursementDao;

	public ReimbursementService() {
		this.reimbursementDao = new ReimbursementDAO();
	}

	public ReimbursementService(ReimbursementDAO ReimbursementDao) {
		this.reimbursementDao = reimbursementDao;
	}

	public List<Reimbursement> getReimbursements(User currentlyLoggedInUser)
			throws SQLException, ReimbursementNotFoundException, UnauthorizedException {
		List<Reimbursement> reimbursement = this.reimbursementDao.getAllReimbursement();
		try {
			if (reimbursement == null) {
				throw new ReimbursementNotFoundException("Reimbursement not found");
			}
			if (currentlyLoggedInUser.getUser_role().equals("employee")) {
				throw new UnauthorizedException("Unauthorized");
			}
			return reimbursement;
		} catch (NumberFormatException e) {
			throw new UnauthorizedException("Unauthorized");
		}

	}

	public Reimbursement changedStatus(User currentlyLoggedInUser, String id, String status)
			throws SQLException, ReimbursementNotFoundException, ReimbursementAlreadyResolvedException {
		try {
			int Id = Integer.parseInt(id);
			Reimbursement reimbursement = this.changedStatus(currentlyLoggedInUser, id, status);

			if (reimbursement == null) {
				throw new ReimbursementNotFoundException();
			}

			// 1
			if (reimbursement.getResolver() == 0) {
				this.reimbursementDao.changedStatus(currentlyLoggedInUser.getUser_id(), status, Id);
			} else {
				throw new ReimbursementAlreadyResolvedException();
			}

			return this.reimbursementDao.getReimbursementById(Id);

		} catch (NumberFormatException e) {
			throw new InvalidParameterException(" id supplied must be an int");
		}

	}

	public Reimbursement addReimbursements(User currentlyLoggedInUser, String mimeType, String reimb_type,
			String amount, String description, InputStream receipt) throws SQLException {
		Set<String> allowedFileTypes = new HashSet<>();
		allowedFileTypes.add("image/jpeg");
		allowedFileTypes.add("image/png");
		allowedFileTypes.add("image/gif");

		if (!allowedFileTypes.contains(mimeType)) {
			throw new InvalidParameterException(
					"When adding an reimbursement receipt, only PNG, JPEG, or GIF are allowed");
		}
		int user_id = currentlyLoggedInUser.getUser_id();
		int amt = Integer.parseInt(amount);

		Reimbursement addedReimbursements = this.reimbursementDao.addReimbursements(reimb_type, description, amt,
				user_id, receipt);

		return addedReimbursements;
	}

	public InputStream getReceiptFromReimbursementById(User currentlyLoggedInUser, String id)
			throws SQLException, UnauthorizedException, ReimbursementImageNotFoundException {

		try {
			int resolver_Id = Integer.parseInt(id);

			if (currentlyLoggedInUser.getUser_role().equals("employee")) {

				int user_id = currentlyLoggedInUser.getUser_id();

				List<Reimbursement> reimbursementThatBelongToEmployee = this.reimbursementDao
						.getAllReimbursementByEmployee(user_id);
				Set<Integer> reimbursementEncountered = new HashSet<>();
				for (Reimbursement a : reimbursementThatBelongToEmployee) {
					reimbursementEncountered.add(a.getId());
				}

				if (!reimbursementEncountered.contains(resolver_Id)) {
					throw new UnauthorizedException(
							"You cannot access the reimbursement that do not belong to yourself");
				}
			}

			InputStream reciept = (InputStream) this.reimbursementDao.getReceiptFromReimbursementById(resolver_Id);
			if (reciept == null) {
				throw new ReimbursementImageNotFoundException();
			}

			return reciept;

		} catch (NumberFormatException e) {
			throw new InvalidParameterException(" id supplied must be an int");
		}

	}
}
