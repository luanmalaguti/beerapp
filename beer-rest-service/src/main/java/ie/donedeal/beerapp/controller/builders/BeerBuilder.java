package ie.donedeal.beerapp.controller.builders;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import ie.donedeal.beerapp.model.Beer;
import ie.donedeal.beerapp.model.BeerWrapper;
import ie.donedeal.beerapp.util.BeerException;

/**
 * Builder that provides an abstract step for construction of beers instances
 * 
 * @author Luan Reffatti
 */
public class BeerBuilder {
	static Logger log = Logger.getLogger(BeerBuilder.class);
	private static AtomicInteger id = new AtomicInteger(0);

	private static final String JSON_FILE = "/beers.json";

	public static Beer createRandomBeer() throws BeerException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonUrl = BeerBuilder.class.getClass().getResource(JSON_FILE).getFile();
			File beersFile = new File(jsonUrl);
			BeerWrapper beerWrapper = mapper.readValue(beersFile, BeerWrapper.class);
			
			List<Beer> list = beerWrapper.getBeers();

			if (id.get() > (list.size() - 1))
				id.set(0);

			Beer beer = list.get(id.getAndIncrement());
			beer.setImg(loadImageBase64(beer.getImg()));
			return beer;
		} catch (Exception e) {
			log.error("Error: ",e);
			throw new BeerException(e);
		}
	}
	
	public static void main(String[] args) throws BeerException {
		BeerBuilder.createRandomBeer();
	}

	private static String loadImageBase64(String path) throws BeerException {
		InputStream stream = BeerBuilder.class.getResourceAsStream("/" + path);
		try {
			String base64 = Base64.getEncoder().encodeToString(IOUtils.toByteArray(stream));
			return base64;
		} catch (IOException e) {
			log.error("Error: ", e);
			throw new BeerException(e);
		}
	}
}
