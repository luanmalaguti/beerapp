package ie.donedeal.beerapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ie.donedeal.beerapp.util.BeerException;
@RestController
@RequestMapping(value="/")
public class DefaultController {

	@RequestMapping(value="/", method=RequestMethod.GET)
    public String getRandomBeer() throws BeerException {
		return "Beer App :)";
	}
}
