package ie.donedeal.beerapp.model;

import java.util.ArrayList;
import java.util.List;

public class BeerWrapper {
	private List<Beer> beers = new ArrayList<>();
	
	public BeerWrapper() {

	}

	public List<Beer> getBeers() {
		return beers;
	}

	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}
}
