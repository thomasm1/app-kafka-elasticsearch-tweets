
package xyz.cryptomaven.app.consoles;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xyz.cryptomaven.app.commands.MaPL;
import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.commands.MaPLInvoker;
import xyz.cryptomaven.app.models.Car;
import xyz.cryptomaven.app.models.ElectroLot;
import xyz.cryptomaven.app.models.Offer;

import xyz.cryptomaven.app.service.CarService;
import xyz.cryptomaven.app.service.ElectroLotService;
import xyz.cryptomaven.app.service.OfferService;
import xyz.cryptomaven.app.service.UserService;

public class AdminDashboard {

    public static final int OPTION_COUNT_MAX = 7;
    private static final int MIN_OPTIONS = 0;

    // RECURSIVE LOOP, breaks out at option 0
    public static void adminConsole() throws SQLException {
        System.out.println(
                "*---------------------------------*\n" +
                        "Welcome to your Admin dashboard\n " + " ... What's Next? \n"
                        + Cmds.ONE + "View Financials and Payments\n"
                        + Cmds.TWO + "View Car Lot\n"
                        + Cmds.THREE+"Add Car\n"
                        + Cmds.FOUR +"Remove Unpurchased Car\n"
                        + Cmds.FIVE + "View and/or Accept Offers\n"
                        + Cmds.SIX + "get Users With Cars\n"
                        + OPTION_COUNT_MAX + ".) open MaPL Control(); \n"
                        + Cmds.ZERO + "Logout");
        try (Scanner scan = new Scanner(System.in)) {
            int val = scan.nextInt();
            if (val < MIN_OPTIONS && val > OPTION_COUNT_MAX) {
                System.out.println("Please enter digits " + MIN_OPTIONS + "-" + OPTION_COUNT_MAX);
                adminConsole();
            } else {
                switch (val) {
                    case 0: {
                        System.out.println("At your service, back to MainDashboard ...\n");
                        MainDashboard.mainConsole();
                        break;
                    }
                    case 1: {
                        scan.nextLine();
                        System.out.println(ElectroLotService.getAllElectroLot());
                        adminConsole();
                    }
                    case 2: {
                        System.out.println("Entering CarLot View...");
                        System.out.println(CarService.getAllCars());
                        System.out.println(Cmds.ADMIN_PERKS);
                        adminConsole();
                    }
                    case 3: {
                        scan.nextLine();
                        System.out.println("Adding a car? Let me get my notepad ...");
                        System.out.println("Car ID?");
                        while (true) {
                            try {
                                scan.nextInt();
                                scan.nextLine();
                                System.out.println("Car Make?");
                                String make = scan.nextLine();
                                System.out.println("Car Model?");
                                String model = scan.nextLine();
                                System.out.println("Car Price?");
                                double price = scan.nextDouble();
                                scan.nextLine();
                                if (price > 999999.99) {
                                    System.out.println("price must be less than $1 million, please.");
                                    System.out.println("Car Price?");
                                    price = scan.nextDouble();
                                    scan.nextLine();
                                }
                                System.out.println("Umkay,car's make is *" + make + "*,\n model is *" + model
                                        + "*,\n and price at *$" + price + "*\n");
                                System.out.println("   Everything look right? (y) or (no)\n");
                                while (true) {
                                    String decide = scan.next();
                                    if (decide.contentEquals("y")) {
                                        Car createdCar = new Car(999, make, model, price, 0); //CarId overwritten later
                                        CarService.createCar(createdCar);
                                        System.out.println(
                                                "This " + createdCar.getCarModel() + " has been Successfully added!!\n");
                                        adminConsole();
                                    } else {
                                        adminConsole();
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println(Cmds.OOPS_TRY_AGAIN);
                            }
                            adminConsole();
                        }
                    }
                    case 4: {
                        System.out.println(CarService.getAllCars());
                        scan.nextLine();
                        System.out.println("Removing a car? \nLet me get my notepad ...");
                        System.out.println("\nCar ID to be removed?");
                        while (true) {
                            try {
                                val = scan.nextInt();
                                Car uCar = CarService.getCar(val);
                                scan.nextLine();
                                System.out.println("1.) Remove car #" + uCar.getCarId() + "? Type \"y\" or \"yes\"."
                                        + "\n\n2.)To permanently delete from records?\n" + "If so, type \"delete\" \n");

                                String decide = scan.next();
                                if ((decide.contentEquals("y")) | (decide.contentEquals("yes"))) {
                                    Car removeCar = new Car(uCar.getCarId(), uCar.getCarMake(), uCar.getCarModel(),
                                            uCar.getPriceTotal(), 2); // 2 = remove unpurchased
                                    try {
                                        CarService.updateCar(removeCar);
                                        System.out.println(removeCar.toString() + "\n" + " ...\n..#" + uCar.getCarId()
                                                + " Successfully removed!!\n");

                                    } catch (Exception e) {
                                        System.out.println("Oops, something went wrong, try again please\n");
                                    }
                                } else if (decide.contentEquals("delete")) {// delete & unpurchased
                                    try {
                                        int deleted = uCar.getCarId();
                                        CarService.deleteCar(deleted);
                                        System.out.println("\n" + "\n...#" + deleted + " Permanently deleted!\n");

                                    } catch (Exception e) {
                                        System.out.println("Oops, something went wrong, try again please\n");
                                    }
                                } else {
                                    System.out.println("Not implemented, returning to dashboard");
                                    adminConsole();
                                }
                            } catch (Exception e) {
                                System.out.println("I could not find that car ...\nTry again. Here's the current lot:");
                                List<Car> carList = CarService.getAllCars();
                                System.out.println(carList);
                                adminConsole();
                            }
                            adminConsole();
                        }
                    }
                    case 5: {
                        System.out.println(OfferService.getAllOffers());
                        checkOffer();
                        adminConsole();
                        break;
                    }
                    case 6: {
                        System.out.println(UserService.getUsersWithCars());
                        adminConsole();
                        break;
                    }
                    case OPTION_COUNT_MAX: {
                        openMaPLControl();
                        adminConsole();
                        break;
                    }
                } // end switch
            }
        } catch (InputMismatchException e) {
            // go round again. Read past the end of line in the input first
            System.out.println("Please enter digits 0 to 5");
            adminConsole();
        }
    }

    private static void openMaPLControl() throws SQLException {
        System.out.println(Cmds.WELCOME_TO_MY_PERSONAL_LIBRARIAN_MY_NAME_IS_MA_PL);
        MaPLInvoker mc = new MaPLInvoker();
        mc.getMapleState();

        sessionMaPL(mc);
    }
    private static void sessionMaPL(MaPLInvoker mapleInvokerSession) throws SQLException {
        System.out.println(mapleInvokerSession.getMaplCommands());
        while(true) {
            try(Scanner scan = new Scanner(System.in)) {
                System.out.println("What next? - enter number; 0 to quit()");
                int nextCommand = scan.nextInt();
                if (nextCommand==0)
                    adminConsole();

                mapleInvokerSession.execute(nextCommand);
                System.out.println("Invoked command executed.\n");
                sessionMaPL(mapleInvokerSession);
            }
        }
    }

    static void checkOffer() throws SQLException {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("\n>>>Please type offer ID to view or modify. 0 to exit.");
            int oInt = scan.nextInt();
            scan.nextLine();
            if (oInt == 0) {
                adminConsole();
            }
            Offer offerLook = OfferService.getOffer(oInt);
            System.out.println(">>>Great, looking up offer #" + oInt + "....\n");
            if (offerLook == null) {
                System.out.println(">>>Oops, couldn't find it, " + "maybe double check the #id?\n");
                checkOffer();
            } else {
                System.out.println(offerLook);
                approveOrReject(offerLook);
                adminConsole();
            }
            adminConsole();
        }
    }

    static void approveOrReject(Offer offerLook) {
        try (Scanner scan = new Scanner(System.in)
        ) {
            System.out.println("\n>>>Accept this offer (y)?\n" + "or (r) to reject an offer\n"
                    + "\nOtherwise hit any key+'enter' to return to dashboard");
            String decide = scan.nextLine();
            if (!decide.contentEquals("y") && !decide.contentEquals("r")) {
                adminConsole();
            } else if (decide.contentEquals("y")) {
                Offer offering = new Offer(offerLook.getOfferID(), offerLook.getUserName(), offerLook.getCarId(),
                        offerLook.getOfferAmt(), offerLook.getOfferMos(), "APPROVED");
                // Finalize New-Owner's Offer details
                OfferService.updateOffer(offering);
                // make New-Owner contract
                System.out.println(ElectroLot.makeElectro(offering));
                ElectroLotService.addElectroLot(ElectroLot.makeElectro(offering));
                // Remove car from customer lot
                Car uCar = CarService.getCar(offerLook.getCarId());
                Car removePurchase = new Car(uCar.getCarId(), uCar.getCarMake(), uCar.getCarModel(), uCar.getPriceTotal(),
                        1);
                CarService.updateCar(removePurchase);
                // Reject all other offers for same car
                Offer rejectOffers = new Offer(0, "", uCar.getCarId(), 0.0, 0, "PENDING");  // Reject all other pending offers!!
//				int offerID, String userName, int carID, double offerAmt, int offerMos, String offerStatus
                OfferService.rejectOtherOffers(rejectOffers);
                System.out.println(
                offering.toString() + "\n.....#" + offering.getOfferID() + " successfully approved!!\n");
                adminConsole();

            } else if (decide.contentEquals("r")) {
                Offer offering = new Offer(offerLook.getOfferID(), offerLook.getUserName(), offerLook.getCarId(),
                        offerLook.getOfferAmt(), offerLook.getOfferMos(), "REJECTED");
                OfferService.updateOffer(offering);
                System.out.println(
                        offering.toString() + "\n" + "...\n..#" + offering.getOfferID() + " successfully rejected!!\n");
            }
        } catch (SQLException e) {
            System.out.println("first sql" + e.getMessage());
            try {
                adminConsole();
            } catch (SQLException e1) {
                System.out.println("2nd sql problem " + e.getMessage());
                MainDashboard.mainConsole();
            }
        }
    }

}
