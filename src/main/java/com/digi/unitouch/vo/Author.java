package com.digi.unitouch.vo;

public class Author {
	String title;
	String suffix;
	String fname;
	String lname;
	String mname;
	String email;
	String institute;
	String address_1;
	String address_2;
	String address_3;
	String city;
	String state;
	String country;
	String zip;
	String corresponding_address_1;
	String corresponding_address_2;
	String corresponding_address_3;
	String corresponding_city;
	String corresponding_state;
	String corresponding_country;
	String is_corresponding;
	String corresponding_zip;
	String phone;
	String fax;
	String contrubution;
	String orcid;
	String rid;
	String author_order;
	String copyright_agreement="NO";
	String copyright_agreement_content="";
	public Author() {
	}

	public Author(String title, String fName, String mName, String lName, String eMail, 
			String is_corresponding,String orcid,
			String author_order/*String copyright_agreement,String copyright_agreement_content*/) {
		super();
		this.title = title;
		this.fname = fName;
		this.mname = mName;
		this.lname = lName;
		this.email = eMail;
		this.is_corresponding = is_corresponding;
		this.orcid = orcid;
		this.author_order = author_order;
		//this.copyright_agreement=copyright_agreement;
		//this.copyright_agreement_content=copyright_agreement_content;
	}
	public Author(String title, String fName, String mName, String lName, String eMail, 
			String is_corresponding,String orcid,
			String author_order,String copyright_agreement,String copyright_agreement_content) {
		super();
		this.title = title;
		this.fname = fName;
		this.mname = mName;
		this.lname = lName;
		this.email = eMail;
		this.is_corresponding = is_corresponding;
		this.orcid = orcid;
		this.author_order = author_order;
		this.copyright_agreement=copyright_agreement;
		this.copyright_agreement_content=copyright_agreement_content;
	}
	public Author(String title, String suffix, String fname, String lname, String mname, String email, String institute,
			String address_1, String address_2, String address_3, String city, String state, String country, String zip,
			String corresponding_address_1, String corresponding_address_2, String corresponding_address_3,
			String corresponding_city, String corresponding_state, String corresponding_country,
			String is_corresponding, String corresponding_zip, String phone, String fax, String contrubution,
			String orcid, String rid, String author_order) {
		super();
		this.title = title;
		this.suffix = suffix;
		this.fname = fname;
		this.lname = lname;
		this.mname = mname;
		this.email = email;
		this.institute = institute;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.address_3 = address_3;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.corresponding_address_1 = corresponding_address_1;
		this.corresponding_address_2 = corresponding_address_2;
		this.corresponding_address_3 = corresponding_address_3;
		this.corresponding_city = corresponding_city;
		this.corresponding_state = corresponding_state;
		this.corresponding_country = corresponding_country;
		this.is_corresponding = is_corresponding;
		this.corresponding_zip = corresponding_zip;
		this.phone = phone;
		this.fax = fax;
		this.contrubution = contrubution;
		this.orcid = orcid;
		this.rid = rid;
		this.author_order = author_order;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getAddress_3() {
		return address_3;
	}

	public void setAddress_3(String address_3) {
		this.address_3 = address_3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCorresponding_address_1() {
		return corresponding_address_1;
	}

	public void setCorresponding_address_1(String corresponding_address_1) {
		this.corresponding_address_1 = corresponding_address_1;
	}

	public String getCorresponding_address_2() {
		return corresponding_address_2;
	}

	public void setCorresponding_address_2(String corresponding_address_2) {
		this.corresponding_address_2 = corresponding_address_2;
	}

	public String getCorresponding_address_3() {
		return corresponding_address_3;
	}

	public void setCorresponding_address_3(String corresponding_address_3) {
		this.corresponding_address_3 = corresponding_address_3;
	}

	public String getCorresponding_city() {
		return corresponding_city;
	}

	public void setCorresponding_city(String corresponding_city) {
		this.corresponding_city = corresponding_city;
	}

	public String getCorresponding_state() {
		return corresponding_state;
	}

	public void setCorresponding_state(String corresponding_state) {
		this.corresponding_state = corresponding_state;
	}

	public String getCorresponding_country() {
		return corresponding_country;
	}

	public void setCorresponding_country(String corresponding_country) {
		this.corresponding_country = corresponding_country;
	}

	public String getIs_corresponding() {
		return is_corresponding;
	}

	public void setIs_corresponding(String is_corresponding) {
		this.is_corresponding = is_corresponding;
	}

	public String getCorresponding_zip() {
		return corresponding_zip;
	}

	public void setCorresponding_zip(String corresponding_zip) {
		this.corresponding_zip = corresponding_zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContrubution() {
		return contrubution;
	}

	public void setContrubution(String contrubution) {
		this.contrubution = contrubution;
	}

	public String getOrcid() {
		return orcid;
	}

	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getAuthor_order() {
		return author_order;
	}

	public void setAuthor_order(String author_order) {
		this.author_order = author_order;
	}


	
	public String getCopyright_agreement() {
		return copyright_agreement;
	}

	public void setCopyright_agreement(String copyright_agreement) {
		this.copyright_agreement = copyright_agreement;
	}

	public String getCopyright_agreement_content() {
		return copyright_agreement_content;
	}

	public void setCopyright_agreement_content(String copyright_agreement_content) {
		this.copyright_agreement_content = copyright_agreement_content;
	}

	@Override
	public String toString() {
		return "Author [title=" + title + ", suffix=" + suffix + ", fname=" + fname + ", lname=" + lname + ", mname="
				+ mname + ", email=" + email + ", institute=" + institute + ", address_1=" + address_1 + ", address_2="
				+ address_2 + ", address_3=" + address_3 + ", city=" + city + ", state=" + state + ", country="
				+ country + ", zip=" + zip + ", corresponding_address_1=" + corresponding_address_1
				+ ", corresponding_address_2=" + corresponding_address_2 + ", corresponding_address_3="
				+ corresponding_address_3 + ", corresponding_city=" + corresponding_city + ", corresponding_state="
				+ corresponding_state + ", corresponding_country=" + corresponding_country + ", is_corresponding="
				+ is_corresponding + ", corresponding_zip=" + corresponding_zip + ", phone=" + phone + ", fax=" + fax
				+ ", contrubution=" + contrubution + ", orcid=" + orcid + ", rid=" + rid + ", author_order="
				+ author_order + ", copyright_agreement=" + copyright_agreement + ", copyright_agreement_content="
				+ copyright_agreement_content + "]";
	}

	
}
