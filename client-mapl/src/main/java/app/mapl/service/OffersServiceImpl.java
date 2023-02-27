package app.mapl.service;

import app.mapl.models.Offer;
import app.mapl.repositories.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OffersServiceImpl implements OffersService {

    @Autowired
    private OffersRepository offersRepository;
    /**
     * @param o
     * @return
     */
    @Override
    public Offer createOffer(Offer o) {
        return offersRepository.save(o);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Offer getOffer(int id) {
        try {
            return offersRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return
     */
    @Override
    public List<Offer> getAllOffers() {
        return (List<Offer>) offersRepository.findAll();
    }

    /**
     * @param username
     * @return
     */
    @Override
    public List<Offer> getAllOffersCust(String username) {
        List<Offer> allOffers = (List<Offer>) offersRepository.findAll();
        List<Offer> myOffers = new ArrayList<>();
        for (Offer o : allOffers) {
            if (o.getUserName().equals(username)) {
                myOffers.add(o);
            }
        }
        return myOffers;
    }

    /**
     * @param change
     * @return
     */
    @Override
    public boolean updateOffer(Offer change) {
        try {
            offersRepository.save(change);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteOffer(int id) {
        try {
            Offer o = offersRepository.findById(id).get();
            offersRepository.delete(o);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param rejectionChanges
     * @return
     */
    @Override
    public boolean rejectOtherOffers(Offer rejectionChanges) {
        try {
            List<Offer> allOffers = (List<Offer>) offersRepository.findAll();
            for (Offer o : allOffers) {
                if (o.getCoinId() == rejectionChanges.getCoinId() && o.getOfferID() != rejectionChanges.getOfferID()) {
                    o.setOfferStatus("rejected");
                    offersRepository.save(o);
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
