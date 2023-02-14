package nanda.vatsal.kafka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity 
@Table(name="wikimedia_recentchange")
public class WikimediaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Lob //used when the data is very large 
	
	//The @Lob annotation is used to specify that the currently annotated entity
	 // attribute represents a large object type. LOB or Large OBject refers to a variable-length datatype for storing large objects.
	private String wikiEventData;

	public WikimediaEntity() {
		
	}

	public WikimediaEntity(int id, String wikiEventData) {
		super();
		this.id = id;
		this.wikiEventData = wikiEventData;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getWikiEventData() {
		return wikiEventData;
	}


	public void setWikiEventData(String wikiEventData) {
		this.wikiEventData = wikiEventData;
	}
	
	
	
	

}
