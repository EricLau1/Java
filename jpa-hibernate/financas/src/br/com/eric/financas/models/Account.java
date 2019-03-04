package br.com.eric.financas.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String owner;
	private String number;
	private String bank;
	private String agency;
	
	@OneToMany(mappedBy="account")
	private List<Movement> movements;
	
	public Account() { }
	
	public Account(String owner, String number, String bank, String agency) {
		this.owner = owner;
		this.number = number;
		this.bank = bank;
		this.agency = agency;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	
	
	public List<Movement> getMovements() {
		return movements;
	}

}
