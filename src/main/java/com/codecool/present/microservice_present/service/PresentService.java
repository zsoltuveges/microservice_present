package com.codecool.present.microservice_present.service;

import com.codecool.present.microservice_present.model.OrderBy;
import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresentService {

    private PresentRepository presentRepository;

    @Autowired
    public PresentService(PresentRepository presentRepository) {
        this.presentRepository = presentRepository;
    }

    /**
     * @return All of the presents
     */
    public List<Present> getAllPresents() {
        return presentRepository.findAllByAvailable(true);
    }

    /**
     * @param orderBy an OrderBy Enum, represents table columns to sort by and how to sort it
     * @return All presents in the requested order
     */
    public List<Present> getAllPresents(OrderBy orderBy) {
        switch (orderBy) {
            case NAME_ASC:
                return presentRepository.findAllByOrderByNameAsc();
            case NAME_DESC:
                return presentRepository.findAllByOrderByNameDesc();
            case PRICE_ASC:
                return presentRepository.findAllByOrderByPriceAsc();
            case PRICE_DESC:
                return presentRepository.findAllByOrderByPriceDesc();
            case CREATION_ASC:
                return presentRepository.findAllByOrderByCreationAsc();
            case CREATION_DESC:
                return presentRepository.findAllByOrderByCreationDesc();
            default:
                throw new IllegalArgumentException("Illegal argument!!4!");
        }
    }

    /**
     * @param category a category (String)
     * @return a list of presents by category without sorting
     */
    public List<Present> getPresentsBy(String category) {
        return presentRepository.findAllByCategory(category);
    }

    /**
     * @param presentId
     * @return a present by id
     */
    public Present getPresentBy(Long presentId) {
        Present emptyPresent = new Present("", "", 0, "", "", -1);
        emptyPresent.setId(-1);
        return presentRepository.findById(presentId).orElse(emptyPresent);
    }

    /**
     *
     * @param userId
     * @return a list of presents by userId without sorting
     */
    public List<Present> getAllPresentsByUserId(long userId) {
        return presentRepository.findAllByUserId(userId);
    }

    /**
     * @param orderBy  an OrderBy Enum, represents table columns to sort by and how to sort it
     * @param category a category
     * @return a list of present objects
     */
    public List<Present> getPresentsBy(OrderBy orderBy, String category) {
        switch (orderBy) {
            case NAME_ASC:
                return presentRepository.findAllByCategoryOrderByNameAsc(category);
            case NAME_DESC:
                return presentRepository.findAllByCategoryOrderByNameDesc(category);
            case PRICE_ASC:
                return presentRepository.findAllByCategoryOrderByPriceAsc(category);
            case PRICE_DESC:
                return presentRepository.findAllByCategoryOrderByPriceDesc(category);
            case CREATION_ASC:
                return presentRepository.findAllByCategoryOrderByCreationAsc(category);
            case CREATION_DESC:
                return presentRepository.findAllByCategoryOrderByCreationDesc(category);
            default:
                throw new IllegalArgumentException("Illegal argument!!4!");
        }
    }

    /**
     * @param orderBy an OrderBy Enum, represents table columns to sort by and how to sort it
     * @param userId  a userID
     * @return a list of present objects so
     */
    public List<Present> getPresentsBy(OrderBy orderBy, Long userId) {
        switch (orderBy) {
            case NAME_ASC:
                return presentRepository.findAllByUserIdOrderByNameAsc(userId);
            case NAME_DESC:
                return presentRepository.findAllByUserIdOrderByNameDesc(userId);
            case PRICE_ASC:
                return presentRepository.findAllByUserIdOrderByPriceAsc(userId);
            case PRICE_DESC:
                return presentRepository.findAllByUserIdOrderByPriceDesc(userId);
            case CREATION_ASC:
                return presentRepository.findAllByUserIdOrderByCreationAsc(userId);
            case CREATION_DESC:
                return presentRepository.findAllByUserIdOrderByCreationDesc(userId);
            default:
                throw new IllegalArgumentException("You gave illegal argument!!!");
        }
    }

    public Optional<Present> addPresent(Present present) {
        presentRepository.save(present);
        return presentRepository.findById(present.getId());
    }

    public void removePresentById(long id) {
        presentRepository.deleteById(id);
    }
}
