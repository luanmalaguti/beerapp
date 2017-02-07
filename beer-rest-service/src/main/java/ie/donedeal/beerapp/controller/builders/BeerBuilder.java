package ie.donedeal.beerapp.controller.builders;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import ie.donedeal.beerapp.model.Beer;
import ie.donedeal.beerapp.util.BeerException;

public class BeerBuilder {
	Logger log = Logger.getLogger(this.getClass());
	private static AtomicInteger id = new AtomicInteger(0);
	
	private static final String GUINESS = "Irish Dry Stout style beer brewed by Guinness Ltd. in Dublin, Ireland";
	private static final String ESTRELLA = "Estrella Damm is a Mediterranean beer, made with malt, rice and hop, "
			+ "brewed with 100% natural ingredients according to the original recipe from 1876.";
	
	public Beer createBeer() throws BeerException{
		List<Beer> list = new ArrayList<>();
    	
    	Beer beer1 = new Beer();
    	beer1.setId(0);
    	beer1.setName("Estrella");
    	beer1.setDescription(ESTRELLA);
    	beer1.setAbv(4.6);
    	beer1.setBreweryLocation("Barcelona");
    	beer1.setImg(loadImage("estrella.png"));
    	
    	Beer beer2 = new Beer();
    	beer2.setId(1);
    	beer2.setName("Guines");
    	beer2.setDescription(GUINESS);
    	beer2.setAbv(4.8);
    	beer2.setBreweryLocation("Dublin");
    	beer2.setImg(loadImage("guiness.png"));
    	
    	list.add(beer1);
    	list.add(beer2);
    	
    	if(id.get() > (list.size()-1))
    		id.set(0);
    	
    	return list.get(id.getAndIncrement());
	}

	private String loadImage(String path) throws BeerException {
		InputStream stream = getClass().getResourceAsStream("/" + path); 
		try {
			String base64 = Base64.getEncoder().encodeToString(IOUtils.toByteArray(stream));
			return base64;
		} catch (IOException e) {
			log.error("Error: ",e);
			throw new BeerException(e);
		}
	}
}
