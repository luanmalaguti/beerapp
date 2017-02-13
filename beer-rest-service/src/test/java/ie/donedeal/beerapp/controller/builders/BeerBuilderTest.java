package ie.donedeal.beerapp.controller.builders;

import org.junit.Assert;
import org.junit.Test;

import ie.donedeal.beerapp.util.BeerException;

public class BeerBuilderTest {

	@Test
	public void createRandomBeerNotNull() throws BeerException {
		Assert.assertNotNull(BeerBuilder.createRandomBeer());
	}
	
	@Test
	public void createRandomBeerImageNotEmpty() throws BeerException {
		Assert.assertFalse(BeerBuilder.createRandomBeer().getImg().isEmpty());
	}
	

}
