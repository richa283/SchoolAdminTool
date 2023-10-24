package com.school.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class AdmissionDto {

	public int id;
	public String name;
	public String fName;
	public String fOccupation;
	public String mName;
	public String mOccupation;
	public String contact;
	public String altContact;
	public Date dob;
	public String samagraId;
	public String aadhar;
	public String bankName;
	public String accNo;
	public String ifsc;
	public String address;
	public String lastClassAttended;
	public String city;
	public String state;
	public String zip;
	public String branch;
	public String stuClass;
	public int fees;
	public String gender;
	public String category;
	public Date admissionDate;
	public String scholarNumber;
	public String lastSchoolStudied;
	public String birthPlace;
	public String religion;
	public String session;
	public String aadharPhoto;		
	public String studentPhoto;
	public String samagraPhoto;
	public String castPhoto ;
	public String tcPhoto;
	public String migrationPhoto;

	
public String getStudentPhoto() {
	return studentPhoto;
}
public void setStudentPhoto(String studentPhoto) {
	this.studentPhoto = studentPhoto;
}
public String getSamagraPhoto() {
	return samagraPhoto;
}
public void setSamagraPhoto(String samagraPhoto) {
	this.samagraPhoto = samagraPhoto;
}
public String getCastPhoto() {
	return castPhoto;
}
public void setCastPhoto(String castPhoto) {
	this.castPhoto = castPhoto;
}
public String getTcPhoto() {
	return tcPhoto;
}
public void setTcPhoto(String tcPhoto) {
	this.tcPhoto = tcPhoto;
}
public String getMigrationPhoto() {
	return migrationPhoto;
}
public void setMigrationPhoto(String migrationPhoto) {
	this.migrationPhoto = migrationPhoto;
}
public String getAadharPhoto() {
		return aadharPhoto;
	}
	public void setAadharPhoto(String aadharPhoto) {
		this.aadharPhoto = aadharPhoto;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}

	
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfOccupation() {
		return fOccupation;
	}
	public void setfOccupation(String fOccupation) {
		this.fOccupation = fOccupation;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmOccupation() {
		return mOccupation;
	}
	public void setmOccupation(String mOccupation) {
		this.mOccupation = mOccupation;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAltContact() {
		return altContact;
	}
	public void setAltContact(String altContact) {
		this.altContact = altContact;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSamagraId() {
		return samagraId;
	}
	public void setSamagraId(String samagraId) {
		this.samagraId = samagraId;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLastClassAttended() {
		return lastClassAttended;
	}
	public void setLastClassAttended(String lastClassAttended) {
		this.lastClassAttended = lastClassAttended;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getScholarNumber() {
		return scholarNumber;
	}
	public void setScholarNumber(String scholarNumber) {
		this.scholarNumber = scholarNumber;
	}
	public String getLastSchoolStudied() {
		return lastSchoolStudied;
	}
	public void setLastSchoolStudied(String lastSchoolStudied) {
		this.lastSchoolStudied = lastSchoolStudied;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	@Override
	public String toString() {
		return "AdmissionDto [id=" + id + ", name=" + name + ", fName=" + fName + ", fOccupation=" + fOccupation
				+ ", mName=" + mName + ", mOccupation=" + mOccupation + ", contact=" + contact + ", altContact="
				+ altContact + ", dob=" + dob + ", samagraId=" + samagraId + ", aadhar=" + aadhar + ", bankName="
				+ bankName + ", accNo=" + accNo + ", ifsc=" + ifsc + ", address=" + address + ", lastClassAttended="
				+ lastClassAttended + ", city=" + city + ", state=" + state + ", zip=" + zip + ", branch=" + branch
				+ ", stuClass=" + stuClass + ", fees=" + fees + ", gender=" + gender + ", category=" + category
				+ ", admissionDate=" + admissionDate + ", scholarNumber=" + scholarNumber + ", lastSchoolStudied="
				+ lastSchoolStudied + ", birthPlace=" + birthPlace + ", religion=" + religion + ", session=" + session
				+ "]";
	}
	
	
	
	
	
}
