package ie.donedeal.beerapp.controller.builders;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

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

	private static final String JSON_FILE = "beers.json";
	
	public static Beer createRandomBeer() throws BeerException {
			List<Beer> list = extractDataFromJsonFile();
			
			//reset the index if there are no more new beeers to show
			if (id.get() > (list.size() - 1))
				id.set(0);

			Beer beer = list.get(id.getAndIncrement());
			beer.setImg(loadImageAsBase64(beer.getImg()));
			return beer;
	}
	/**
	 * Extract the beers data from the json file and convert to a list of beers 
	 *
	 * @return {@link List} of {@link Beer} 
	 * @throws BeerException
	 */
	private static List<Beer> extractDataFromJsonFile() throws BeerException{
		try {
			ObjectMapper mapper = new ObjectMapper();
			ClassPathResource resource = new ClassPathResource(JSON_FILE);
			InputStream stream = resource.getInputStream();
			BeerWrapper beerWrapper = mapper.readValue(stream, BeerWrapper.class);
			List<Beer> list = beerWrapper.getBeers();
			return list;
		} catch (IOException e) {
			log.error("An error occurred when tried to load data from json",e);
			throw new BeerException(e);
		}
		
	}
	
	/**
	 * Load image from classpath and conver to base64 format
	 * 
	 * @return image in base64 format
	 * @throws BeerException
	 */
	private static String loadImageAsBase64(String path) throws BeerException {
		try {
			InputStream stream = new ClassPathResource(path).getInputStream();
			String base64 = Base64.getEncoder().encodeToString(IOUtils.toByteArray(stream));
			return base64;
		} catch (IOException e) {
			log.error("An error has ocurred when tried to load image and convert to base64 format: ", e);
			return "";
		}
	}
}
