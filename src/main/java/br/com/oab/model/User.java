package br.com.oab.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String name;
	private Integer age;
	private Boolean isMarried;
	private List<String> hobbies;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Boolean isMarried() {
		return isMarried;
	}
	
	@XmlElement(name = "isMarried")
	public void setMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	@XmlElementWrapper(name = "hobbies")
	@XmlElement(name = "element")
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", isMarried=" + isMarried + ", hobbies=" + hobbies + "]";
	}
	
}
