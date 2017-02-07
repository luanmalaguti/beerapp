package ie.donedeal.beerapp.model;
/**
 * Representation of a model of Beer
 * 
 * @author Luan Reffatti
 */
public class Beer {

    private long id;
    private String name;
    private String description;
    private double abv;
    private String breweryLocation;
    private String img;

    public Beer() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAbv() {
		return abv;
	}

	public void setAbv(double abv) {
		this.abv = abv;
	}

	public String getBreweryLocation() {
		return breweryLocation;
	}

	public void setBreweryLocation(String breweryLocation) {
		this.breweryLocation = breweryLocation;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
