package app.mapl.models;

import app.mapl.service.CoinService;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "offerlogic")
@NoArgsConstructor
public class OfferLogic   {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	private int offerid;
	private int coinid;

	@Column(name = "username")
	String username;
	private Double pricetotal;
	private Double offeramt;

	private Double balance;
	private int offermos;
	@Column(name="monthsremaining")
	private int monthsRemaining;
	@Column(name="monthlypayments")
	private double monthlyPayments;

	private static int i = 31; // used later to generate randomized id's

	private static int MONTH_TIME =
			0; // Month-Time variable // T = Date Month + T(Month purchased);
								// Based on Current Date, variable T will increment by 1 each month.

	static double roundIt(double value, int places) { // Dollar-Cents decimals (pre-db formatting)
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}

	public static OfferLogic makeElectro(Offer o) {

		Coin coinid = CoinService.getCoin(o.getCoinId());
		double balDayOne = coinid.getPriceTotal() - o.getOfferAmt(); // Calculate balance by dividing Total-price by
		balDayOne = roundIt(balDayOne, 2);
		System.out.println("Balance Day 1: $" + balDayOne);

		int monthsRemaining = (o.getOfferMos() - MONTH_TIME);
		System.out.println("Months Remaining: " + monthsRemaining);

		double monthlyPayments = balDayOne / monthsRemaining;
		monthlyPayments = roundIt(monthlyPayments, 2); // Cents (& avoid anomalous large-precision problems with SQL
		System.out.println("Monthly Payments: $" + monthlyPayments);

		double balance = monthlyPayments * monthsRemaining;
		balance = roundIt(balance, 2); // Cents (& avoid anomalous large-precision problems with SQL
		System.out.println("Balance: $" + balance);

		i = (int) (Math.random() * i); // Random id generator (Overwritten in DB in any case)

		OfferLogic newest = new OfferLogic(i, o.getOfferID(), coinid.getCoinId(), o.getUsername(), coinid.getPriceTotal(),
				o.getOfferAmt(), balance, o.getOfferMos(), monthsRemaining, monthlyPayments);

		System.out.println(o.getUsername() + "'s " + coinid.getCoinToken() + " " + coinid.getCoinSymbol() + " Balance:"
				+ newest.getBalance() + " " + " monthly payments: $" + newest.getMonthlyPayments());

		return newest;

	}

	public static int getI() {
		return i;
	}

	public static void setI(int i) {
		OfferLogic.i = i;
	}

	public static int getT() {
		return MONTH_TIME;
	}

	public static void setT(int t) {
		MONTH_TIME = t;
	}

	public OfferLogic(int id, int offerid, int coinid, String username, Double pricetotal, Double offeramt,
			Double balance, int offermos, int monthsRemaining, double monthlyPayments) {
		super();
		this.id = id;
		this.offerid = offerid;
		this.coinid = coinid;
		this.username =	username;

		this.pricetotal = pricetotal;
		this.offeramt = offeramt;
		this.offermos = offermos;

		this.balance = balance;
		this.monthsRemaining = monthsRemaining;
		this.monthlyPayments = monthlyPayments;
	}

//	public int getMonthsRemaining() {
//		return monthsRemaining;
//	}
//
//	public void setMonthsRemaining(int monthsRemaining) {
//		this.monthsRemaining = monthsRemaining;
//	}
//
//	public double getMonthlyPayments() {
//		return monthlyPayments;
//	}
//
//	public void setMonthlyPayments(double monthlyPayments) {
//		this.monthlyPayments = monthlyPayments;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public int getOfferid() {
//		return offerid;
//	}
//
//	public void setOfferid(int offerid) {
//		this.offerid = offerid;
//	}
//
//	public int getCoinid() {
//		return coinid;
//	}
//
//	public void setCoinid(int coinid) {
//		this.coinid = coinid;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public Double getPricetotal() {
//		return pricetotal;
//	}
//
//	public void setPricetotal(Double pricetotal) {
//		this.pricetotal = pricetotal;
//	}
//
//	public Double getOfferamt() {
//		return offeramt;
//	}
//
//	public void setOfferamt(Double offeramt) {
//		this.offeramt = offeramt;
//	}
//
//	public Double getBalance() {
//		return balance;
//	}
//
//	public void setBalance(Double balance) {
//		this.balance = balance;
//	}
//
//	public int getOffermos() {
//		return offermos;
//	}
//
//	public void setOffermos(int offermos) {
//		this.offermos = offermos;
//	}
//
//	@Override
//	public String toString() {
//		return "\nContract #" + id + ", Offer #" + offerid + ", Coin #" + coinid + ", Owner=" + username
//				+ ",\n      price: $" + pricetotal + ", Offer: $" + offeramt + ", Balance: $" + balance + ", Pay plan: "
//				+ offermos + " mos.,\n      Months remaining=" + monthsRemaining + ", Monthly Pay: $" + monthlyPayments
//				+ " \n"
//				+ "-------------------------";
//	}
 
}
