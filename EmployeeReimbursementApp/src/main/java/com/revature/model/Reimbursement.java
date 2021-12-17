package com.revature.model;
import java.util.Objects;
import java.sql.Blob;
import java.sql.Timestamp;

public class Reimbursement {
	
		private int id;
		private int amount;
		private String submitted;
		private String resolved;
		private String status;
		private String reimb_type;
		private String description;
		private int author;
		private int resolver;
		public Reimbursement() {
		}
		public Reimbursement(int id, int amount, String submitted, String resolved, String status, String reimb_type,
				String description, int author, int resolver) {
			super();
			this.id = id;
			this.amount = amount;
			this.submitted = submitted;
			this.resolved = resolved;
			this.status = status;
			this.reimb_type = reimb_type;
			this.description = description;
			this.author = author;
			this.resolver = resolver;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getSubmitted() {
			return submitted;
		}
		public void setSubmitted(String submitted) {
			this.submitted = submitted;
		}
		public String getResolved() {
			return resolved;
		}
		public void setResolved(String resolved) {
			this.resolved = resolved;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getReimb_type() {
			return reimb_type;
		}
		public void setReimb_type(String reimb_type) {
			this.reimb_type = reimb_type;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getAuthor() {
			return author;
		}
		public void setAuthor(int author) {
			this.author = author;
		}
		public int getResolver() {
			return resolver;
		}
		public void setResolver(int resolver) {
			this.resolver = resolver;
		}
		@Override
		public int hashCode() {
			return Objects.hash(amount, author, description, id, reimb_type, resolved, resolver, status, submitted);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Reimbursement other = (Reimbursement) obj;
			return amount == other.amount && author == other.author && Objects.equals(description, other.description)
					&& id == other.id && Objects.equals(reimb_type, other.reimb_type)
					&& Objects.equals(resolved, other.resolved) && resolver == other.resolver
					&& Objects.equals(status, other.status) && Objects.equals(submitted, other.submitted);
		}
		@Override
		public String toString() {
			return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
					+ resolved + ", status=" + status + ", reimb_type=" + reimb_type + ", description=" + description
					+ ", author=" + author + ", resolver=" + resolver + "]";
		}

		
}