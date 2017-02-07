package ie.donedeal.beerapp.util;
/**
 * Throwable that specifics the behavior of an BeerException
 * 
 * @author Luan Reffatti
 */
public class BeerException extends Exception{

	private static final long serialVersionUID = -909781563043677610L;
	
	public BeerException(String msg) {
		super(msg);
	}
	
	public BeerException(Throwable t) {
		super(t);
	}
	
	public BeerException(Throwable t, String msg) {
		super(msg, t);
	}

}
