package models;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import models.Car;
import models.Offer;
import models.ElectroLot;

import service.CarService;

public class ElectroLot implements List<ElectroLot> {

	public static void main(String[] args) {

	}

	public int id;
	private int offerid;
	private int carid;
	private String username;
	private Double pricetotal;
	private Double offeramt;
	private Double balance;
	private int offermos;
	private int monthsRemaining;
	private double monthlyPayments;

	private static int i = 1234; // used later to generate randomized id's

	private static int T = 0; // Month-Time variable // T = Date Month + T(Month purchased);
								// Based on Current Date, variable T will increment by 1 each month.

	static double roundIt(double value, int places) { // Dollar-Cents decimals (pre-db formatting)
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}

	public static ElectroLot makeElectro(Offer o) {

		Car carid = CarService.getCar(o.getCarID());
		double balDayOne = carid.getPriceTotal() - o.getOfferAmt(); // Calculate balance by dividing Total-price by
		balDayOne = roundIt(balDayOne, 2);
		System.out.println("Balance Day 1: $" + balDayOne);

		int monthsRemaining = (o.getOfferMos() - T);
		System.out.println("Months Remaining: " + monthsRemaining);

		double monthlyPayments = balDayOne / monthsRemaining;
		monthlyPayments = roundIt(monthlyPayments, 2); // Cents (& avoid anomalous large-precision problems with SQL
		System.out.println("Monthly Payments: $" + monthlyPayments);

		double balance = monthlyPayments * monthsRemaining;
		balance = roundIt(balance, 2); // Cents (& avoid anomalous large-precision problems with SQL
		System.out.println("Balance: $" + balance);

		i = (int) (Math.random() * i); // Random id generator (Overwritten in DB in any case)

		ElectroLot newest = new ElectroLot(i, o.getOfferID(), carid.getCarID(), o.getUserName(), carid.getPriceTotal(),
				o.getOfferAmt(), balance, o.getOfferMos(), monthsRemaining, monthlyPayments);

		System.out.println(o.getUserName() + "'s " + carid.getCarMake() + " " + carid.getCarModel() + " Balance:"
				+ newest.getBalance() + " " + " monthly payments: $" + newest.getMonthlyPayments());

		return newest;

	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		ElectroLot.i = i;
	}

	public static int getT() {
		return T;
	}

	public static void setT(int t) {
		T = t;
	}

	public ElectroLot(int id, int offerid, int carid, String username, Double pricetotal, Double offeramt,
			Double balance, int offermos, int monthsRemaining, double monthlyPayments) {
		super();
		this.id = id;
		this.offerid = offerid;
		this.carid = carid;
		this.username = username;

		this.pricetotal = pricetotal;
		this.offeramt = offeramt;
		this.offermos = offermos;

		this.balance = balance;
		this.monthsRemaining = monthsRemaining;
		this.monthlyPayments = monthlyPayments;
	}

	public int getMonthsRemaining() {
		return monthsRemaining;
	}

	public void setMonthsRemaining(int monthsRemaining) {
		this.monthsRemaining = monthsRemaining;
	}

	public double getMonthlyPayments() {
		return monthlyPayments;
	}

	public void setMonthlyPayments(double monthlyPayments) {
		this.monthlyPayments = monthlyPayments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOfferid() {
		return offerid;
	}

	public void setOfferid(int offerid) {
		this.offerid = offerid;
	}

	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getPricetotal() {
		return pricetotal;
	}

	public void setPricetotal(Double pricetotal) {
		this.pricetotal = pricetotal;
	}

	public Double getOfferamt() {
		return offeramt;
	}

	public void setOfferamt(Double offeramt) {
		this.offeramt = offeramt;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getOffermos() {
		return offermos;
	}

	public void setOffermos(int offermos) {
		this.offermos = offermos;
	}

	@Override
	public String toString() {
		return "\nContract #" + id + ", Offer #" + offerid + ", Car #" + carid + ", Owner=" + username
				+ ",\n      price: $" + pricetotal + ", Offer: $" + offeramt + ", Balance: $" + balance + ", Pay plan: "
				+ offermos + " mos.,\n      Months remaining=" + monthsRemaining + ", Monthly Pay: $" + monthlyPayments
				+ " \n"
				+ "-------------------------";
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator<ElectroLot> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean add(ElectroLot e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends ElectroLot> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends ElectroLot> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub
		
	}

	public ElectroLot get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public ElectroLot set(int index, ElectroLot element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, ElectroLot element) {
		// TODO Auto-generated method stub
		
	}

	public ElectroLot remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<ElectroLot> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<ElectroLot> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ElectroLot> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
