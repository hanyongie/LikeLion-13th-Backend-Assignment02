package com.likelion.assignment_2.item.domain;
import java.util.List;

public interface MusicalRepository {
    void save(Musical musical);
    Musical findById(Long id);
    List<Musical> findAll();
    void updateById(Long id, Musical musical);

    void deleteById(Long id);

}
