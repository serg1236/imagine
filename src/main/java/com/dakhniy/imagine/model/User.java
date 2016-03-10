package com.dakhniy.imagine.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.dakhniy.imagine.util.PersistenceUtils;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="customer")
@NamedQueries({
	@NamedQuery(query="Select user from User user Where user.fbId != :excludedUser", name="User.getAllExceptOne")
})
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class User {
	
	@GeneratedValue
	@Id
	@JsonIgnore
	private int id;
	
	@Column(unique=true, name="fbLogin")
	@JsonProperty("id")
	private String fbId;
	
	@OneToMany(mappedBy="author", cascade=CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Image> images;
	
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFbId() {
		return fbId;
	}
	public void setFbId(String fbId) {
		this.fbId = fbId;
	}
	public List<Image> getImages() {
		return images;
	}
	public void setImages(List<Image> images) {
		this.images = images;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", fbId=" + fbId + ", images=" + images
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	public void addImage(String imageUrl, String publicId){
		Image image = new Image();
		image.setAuthor(this);
		image.setUrl(imageUrl);
		image.setPublicId(publicId);
		if(getImages()==null){
			setImages(new ArrayList<Image>());
		}
		images.add(image);
		//PersistenceUtils.save(image);
	}
	
	

}
