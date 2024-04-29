package Model;

import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.MultipartStream;

public class StudentBean {
private String name;
private String id;
private String dob;
private String gender;
private String phone;
private String education;
private String attend;
private InputStream file;
private byte[] imageData;



public byte[] getImageData() {
	return imageData;
}
public void setImageData(byte[] imageData) {
	this.imageData = imageData;
}
public InputStream getFile() {
	return file;
}
public void setFile(InputStream file) {
	this.file = file;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public String getAttend() {
	return attend;
}
public void setAttend(String attend) {
	this.attend = attend;
}
public boolean hasFileData() {
    return file != null;
}

}
