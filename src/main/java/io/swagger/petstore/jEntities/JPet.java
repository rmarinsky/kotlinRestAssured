package io.swagger.petstore.jEntities;

import java.util.List;
import java.util.Objects;

public class JPet{

	private List<String> photoUrls;

	private String name;

	private String id;

	private JCategory category;

	private List<JTag> tags;

	private String status;

	public JPet() {
	}

	public JPet(List<String> photoUrls, String name, String id, JCategory category, List<JTag> tags, String status) {

		this.photoUrls = photoUrls;
		this.name = name;
		this.id = id;
		this.category = category;
		this.tags = tags;
		this.status = status;
	}

	public void setPhotoUrls(List<String> photoUrls){
		this.photoUrls = photoUrls;
	}

	public List<String> getPhotoUrls(){
		return photoUrls;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategory(JCategory category){
		this.category = category;
	}

	public JCategory getCategory(){
		return category;
	}

	public void setTags(List<JTag> tags){
		this.tags = tags;
	}

	public List<JTag> getTags(){
		return tags;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		JPet pet = (JPet) o;
		return Objects.equals(this.id, pet.id) &&
				Objects.equals(this.category, pet.category) &&
				Objects.equals(this.name, pet.name) &&
				Objects.equals(this.photoUrls, pet.photoUrls) &&
				Objects.equals(this.tags, pet.tags) &&
				Objects.equals(this.status, pet.status);
	}

	@Override
 	public String toString(){
		return 
			"JPet{" + 
			"photoUrls = '" + photoUrls + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",tags = '" + tags + '\'' + 
			",status = '" + status + '\'' + 
			"}";
	}

}