package com.codecool.present.microservice_present.service;

import com.codecool.present.microservice_present.model.Order;
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

    public List<Present> getAllPresents() {
        return presentRepository.findAll();
    }

    public List<Present> getAllPresents(Order order, OrderBy orderBy) {
        return presentRepository.findAll();
    }

    /**
     *
     * @param order ASC or DESC
     * @param orderBy A table column to order the result by
     * @param category a category
     * @return a list of present objects
     */
    public List<Present> getPresentsBy(Order order, OrderBy orderBy, String category) {
        if (orderBy == OrderBy.NAME && (order == Order.ASC)) {
            return presentRepository.findAllByCategoryOrderByNameAsc(category);
        } else if (orderBy == OrderBy.NAME && (order == Order.DESC)) {
            return presentRepository.findAllByCategoryOrderByNameDesc(category);
        } else if (orderBy == OrderBy.PRICE && (order == Order.ASC)) {
            return presentRepository.findAllByCategoryOrderByPriceAsc(category);
        } else if (orderBy == OrderBy.PRICE && (order == Order.DESC)) {
            return presentRepository.findAllByCategoryOrderByPriceDesc(category);
        } else if (orderBy == OrderBy.CREATION && (order == Order.ASC)) {
            return presentRepository.findAllByCategoryOrderByCreationAsc(category);
        } else if (orderBy == OrderBy.CREATION && (order == Order.DESC)) {
            return presentRepository.findAllByCategoryOrderByCreationDesc(category);
        } else {
            throw new IllegalArgumentException("Illegal argument!!4!");
        }
    }

    /**
     *
     * @param order ASC or DESC
     * @param orderBy A table column to order the result by
     * @param userId a userID
     * @return a list of present objects
     */
    public List<Present> getPresentsBy(Order order, OrderBy orderBy, Long userId) {
        if (orderBy == OrderBy.NAME && (order == Order.ASC)) {
            return presentRepository.findAllByUserIdOrderByNameAsc(userId);
        } else if (orderBy == OrderBy.NAME && (order == Order.DESC)) {
            return presentRepository.findAllByUserIdOrderByNameDesc(userId);
        } else if (orderBy == OrderBy.PRICE && (order == Order.ASC)) {
            return presentRepository.findAllByUserIdOrderByPriceAsc(userId);
        } else if (orderBy == OrderBy.PRICE && (order == Order.DESC)) {
            return presentRepository.findAllByUserIdOrderByPriceDesc(userId);
        } else if (orderBy == OrderBy.CREATION && (order == Order.ASC)) {
            return presentRepository.findAllByUserIdOrderByCreationAsc(userId);
        } else if (orderBy == OrderBy.CREATION && (order == Order.DESC)) {
            return presentRepository.findAllByUserIdOrderByCreationDesc(userId);
        } else {
            throw new IllegalArgumentException("You gave illegal argument!!!");
        }
    }

}
