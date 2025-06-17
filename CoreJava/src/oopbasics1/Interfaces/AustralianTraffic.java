package oopbasics1.Interfaces;

public class AustralianTraffic implements CentralTraffic, ContinentalTraffic {

	public static void main(String[] args) {
		
		CentralTraffic a = new AustralianTraffic();
		a.redStop();
		a.flashYellow();
		a.greenGo();

		AustralianTraffic at = new AustralianTraffic();
		ContinentalTraffic ct = new AustralianTraffic();
		at.walkOnSymbol();
		at.redStop();
		ct.trainsymbol();
	}

	@Override
	public void greenGo() {
		System.out.println("greenGo implementation");		
	}

	@Override
	public void redStop() {
		System.out.println("redStop implementation");				
		
	}

	@Override
	public void flashYellow() {
		System.out.println("flashYellow implementation");				
	}

	public void walkOnSymbol() {
		System.out.println("walking");
	}

	@Override
	public void trainsymbol() {
		System.out.println("trainsymbol implementation");	
	}
}
