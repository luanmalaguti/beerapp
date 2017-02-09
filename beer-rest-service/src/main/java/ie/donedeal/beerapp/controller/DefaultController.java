package ie.donedeal.beerapp.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ie.donedeal.beerapp.controller.builders.BeerBuilder;
import ie.donedeal.beerapp.model.Beer;
import ie.donedeal.beerapp.util.BeerException;
/**
 * Controller that handle the web requests 
 * 
 * @author Luan Reffatti
 */
@RestController
@RequestMapping(value="/")
public class DefaultController {

	private static final String CLIENT_HOST = "http://localhost:8000";
	Logger log = Logger.getLogger(this.getClass());
	
	@CrossOrigin(origins = CLIENT_HOST)
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String getRandomBeer() throws BeerException {
		return "Beer App :)";
	}
}
