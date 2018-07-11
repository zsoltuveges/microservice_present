package com.codecool.present.microservice_present.repository;

import com.codecool.present.microservice_present.model.Present;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresentRepository extends JpaRepository<Present, Long> {

    public List<Present> findAllByOrderByNameAsc();

    public List<Present> findAllByOrderByNameDesc();

    public List<Present> findAllByOrderByPriceAsc();

    public List<Present> findAllByOrderByPriceDesc();

    public List<Present> findAllByOrderByCreationAsc();

    public List<Present> findAllByOrderByCreationDesc();

    public List<Present> findAllByCategory(String category);

    public List<Present> findAllByCategoryOrderByNameAsc(String category);

    public List<Present> findAllByCategoryOrderByNameDesc(String category);

    public List<Present> findAllByCategoryOrderByPriceAsc(String category);

    public List<Present> findAllByCategoryOrderByPriceDesc(String category);

    public List<Present> findAllByCategoryOrderByCreationAsc(String category);

    public List<Present> findAllByCategoryOrderByCreationDesc(String category);

    public List<Present> findAllByUserId(long id);

    public List<Present> findAllByUserIdOrderByNameAsc(long id);

    public List<Present> findAllByUserIdOrderByNameDesc(long id);

    public List<Present> findAllByUserIdOrderByPriceAsc(long id);

    public List<Present> findAllByUserIdOrderByPriceDesc(long id);

    public List<Present> findAllByUserIdOrderByCreationAsc(long id);

    public List<Present> findAllByUserIdOrderByCreationDesc(long id);

}
