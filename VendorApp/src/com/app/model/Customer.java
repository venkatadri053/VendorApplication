package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUST_TAB")
public class Customer implements Comparable<Customer>{
	
	@Id
	@GeneratedValue(generator="cust")
	@SequenceGenerator(name="cust",sequenceName="CUST_SEQ")
	@Column(name="c_id")
	private int custId;
	@Column(name="c_name")
	private String custName;
	@Column(name="c_email")
	private String custEmail;
	@Column(name="c_type")
	private String custType;
	@Column(name="c_addr")
	private String custAddr;
	
	@Column(name="c_pwd")
	private String password;
	@Column(name="c_token")
	private String accToken;

	public Customer() {
	}

	public Customer(int custId) {
		this.custId = custId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getCustAddr() {
		return custAddr;
	}

	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccToken() {
		return accToken;
	}

	public void setAccToken(String accToken) {
		this.accToken = accToken;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custEmail=" + custEmail + ", custType=" + custType
				+ ", custAddr=" + custAddr + ", password=" + password
				+ ", accToken=" + accToken + "]";
	}
	
	
	@Override
	public int compareTo(Customer o) {
		return getCustId()-o.getCustId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accToken == null) ? 0 : accToken.hashCode());
		result = prime * result
				+ ((custAddr == null) ? 0 : custAddr.hashCode());
		result = prime * result
				+ ((custEmail == null) ? 0 : custEmail.hashCode());
		result = prime * result + custId;
		result = prime * result
				+ ((custName == null) ? 0 : custName.hashCode());
		result = prime * result
				+ ((custType == null) ? 0 : custType.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (accToken == null) {
			if (other.accToken != null)
				return false;
		} else if (!accToken.equals(other.accToken))
			return false;
		if (custAddr == null) {
			if (other.custAddr != null)
				return false;
		} else if (!custAddr.equals(other.custAddr))
			return false;
		if (custEmail == null) {
			if (other.custEmail != null)
				return false;
		} else if (!custEmail.equals(other.custEmail))
			return false;
		if (custId != other.custId)
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custType == null) {
			if (other.custType != null)
				return false;
		} else if (!custType.equals(other.custType))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
}