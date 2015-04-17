package bshields.istation.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import bshields.istation.interfaces.Shelf;
import bshields.istation.interfaces.VendingMachine;

/**
 * Default implementation of {@link VendingMachine}
 * 
 * @author Brian
 */
public class DefaultVendingMachine implements VendingMachine {
	private List<Shelf> shelves;
	private BigDecimal cash;
	private BigDecimal reserve;
	
	/**
	 * Creates an empty vending machine
	 * 
	 * @see #DefaultVendingMachine(BigDecimal, List)
	 */
	public DefaultVendingMachine() { this(BigDecimal.ZERO, new ArrayList<Shelf>()); }
	/**
	 * Creates a vending machine with no shelves.
	 * 
	 * @param reserve a reserve of money already in the machine
	 * @see #DefaultVendingMachine(BigDecimal, List)
	 */
	public DefaultVendingMachine(BigDecimal reserve) { this(reserve, new ArrayList<Shelf>()); }
	/**
	 * Creates a new vending machine
	 * 
	 * @param reserve a reserve of money already in the machine
	 * @param shelves the shelves of snacks in the machine
	 */
	public DefaultVendingMachine(BigDecimal reserve, List<Shelf> shelves) {
		this.shelves = new ArrayList<Shelf>(shelves);
		this.reserve = reserve;
		this.cash = BigDecimal.ZERO;
	}

	@Override
	public List<Shelf> getShelves() { return new ArrayList<Shelf>(shelves); }

	@Override
	public void addShelf(Shelf shelf) { shelves.add(shelf); }

	@Override
	public void addShelf(Shelf shelf, int index) { shelves.add(index, shelf); }

	@Override
	public boolean removeShelf(Shelf shelf) { return shelves.remove(shelf); }

	@Override
	public Shelf removeShelf(int index) { return shelves.remove(index); }

	@Override
	public BigDecimal getCash() { return cash; }

	@Override
	public void addCash(BigDecimal cash) {
		this.cash = this.cash.add(cash);
		reserve = reserve.add(cash);
	}

	@Override
	public BigDecimal refundCash() {
		BigDecimal refund = new BigDecimal(cash.doubleValue());
		reserve = reserve.subtract(cash);
		cash = BigDecimal.ZERO;
		return refund;
	}

	@Override
	public BigDecimal getReserve() { return reserve; }
	
	@Override
	public void chargeCash(BigDecimal charge) { cash = cash.subtract(charge); }
}
