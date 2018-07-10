package com.codecool.present.microservice_present.service;

import com.codecool.present.microservice_present.model.OrderBy;
import com.codecool.present.microservice_present.model.Present;
import com.codecool.present.microservice_present.repository.PresentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentService {

    private PresentRepository presentRepository;

    @Autowired
    public PresentService(PresentRepository presentRepository) {
        this.presentRepository = presentRepository;
    }

    /**
     *
     * @return All of the presents
     */
    public List<Present> getAllPresents() {
        return presentRepository.findAll();
    }

    /**
     *
     * @param orderBy an OrderBy Enum, represents table columns to sort by and how to sort it
     * @return All presents in the requested order
     */
    public List<Present> getAllPresents(OrderBy orderBy) {
        if (orderBy == OrderBy.NAME_ASC) {
            return presentRepository.findAllByOrderByNameAsc();
        } else if (orderBy == OrderBy.NAME_DESC) {
            return presentRepository.findAllByOrderByNameDesc();
        } else if (orderBy == OrderBy.PRICE_ASC) {
            return presentRepository.findAllByOrderByPriceAsc();
        } else if (orderBy == OrderBy.PRICE_DESC) {
            return presentRepository.findAllByOrderByPriceDesc();
        } else if (orderBy == OrderBy.CREATION_ASC) {
            return presentRepository.findAllByOrderByCreationAsc();
        } else if (orderBy == OrderBy.CREATION_DESC) {
            return presentRepository.findAllByOrderByCreationDesc();
        } else {
            throw new IllegalArgumentException("Illegal argument!!4!");
        }
    }

    /**
     *
     * @param category a category (String)
     * @return a list of presents by category without sorting
     */
    public List<Present> getPresentsBy(String category) {
        return presentRepository.findAllByCategory(category);
    }

    /**
     *
     * @param userId a userId
     * @return a list of presents by userId without sorting
     */
    public List<Present> getPresentsBy(Long userId) {
        return presentRepository.findAllByUserId(userId);
    }

        /**
         *
         * @param orderBy an OrderBy Enum, represents table columns to sort by and how to sort it
         * @param category a category
         * @return a list of present objects
         */
    public List<Present> getPresentsBy(OrderBy orderBy, String category) {
        if (orderBy == OrderBy.NAME_ASC) {
            return presentRepository.findAllByCategoryOrderByNameAsc(category);
        } else if (orderBy == OrderBy.NAME_DESC) {
            return presentRepository.findAllByCategoryOrderByNameDesc(category);
        } else if (orderBy == OrderBy.PRICE_ASC) {
            return presentRepository.findAllByCategoryOrderByPriceAsc(category);
        } else if (orderBy == OrderBy.PRICE_DESC) {
            return presentRepository.findAllByCategoryOrderByPriceDesc(category);
        } else if (orderBy == OrderBy.CREATION_ASC) {
            return presentRepository.findAllByCategoryOrderByCreationAsc(category);
        } else if (orderBy == OrderBy.CREATION_DESC) {
            return presentRepository.findAllByCategoryOrderByCreationDesc(category);
        } else {
            throw new IllegalArgumentException("Illegal argument!!4!");
        }
    }

    /**
     *
     * @param orderBy an OrderBy Enum, represents table columns to sort by and how to sort it
     * @param userId a userID
     * @return a list of present objects so
     */
    public List<Present> getPresentsBy(OrderBy orderBy, Long userId) {
        if (orderBy == OrderBy.NAME_ASC) {
            return presentRepository.findAllByUserIdOrderByNameAsc(userId);
        } else if (orderBy == OrderBy.NAME_DESC) {
            return presentRepository.findAllByUserIdOrderByNameDesc(userId);
        } else if (orderBy == OrderBy.PRICE_ASC) {
            return presentRepository.findAllByUserIdOrderByPriceAsc(userId);
        } else if (orderBy == OrderBy.PRICE_DESC) {
            return presentRepository.findAllByUserIdOrderByPriceDesc(userId);
        } else if (orderBy == OrderBy.CREATION_ASC) {
            return presentRepository.findAllByUserIdOrderByCreationAsc(userId);
        } else if (orderBy == OrderBy.CREATION_DESC) {
            return presentRepository.findAllByUserIdOrderByCreationDesc(userId);
        } else {
            throw new IllegalArgumentException("You gave illegal argument!!!");
        }
    }

}
