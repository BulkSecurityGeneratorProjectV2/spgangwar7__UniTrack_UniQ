package com.digi.unitouch.em.Meta;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("name")
public class Name {
	@XStreamAlias("surname")
	private String surname;
	
	@XStreamAlias("given-names")
	private String givenNames;
	
	@XStreamAlias("prefix")
	private String prefix;
	
	

	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public String getGivenNames() {
		return givenNames;
	}



	public void setGivenNames(String givenNames) {
		this.givenNames = givenNames;
	}



	public String getPrefix() {
		return prefix;
	}



	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}



	@Override
	public String toString() {
		return "Name [surname=" + surname + ", givenNames=" + givenNames + ", prefix=" + prefix + "]";
	}

	
}
