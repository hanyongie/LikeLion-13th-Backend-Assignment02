package com.likelion.assignment_2.item.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMusicalRepository implements MusicalRepository {

    private static Map<Long, Musical> database = new HashMap<>();
    @Override
    public void save(Musical musical) {
        database.put(musical.getId(), musical); //database에 저장
    }

    @Override
    public Musical findById(Long id) {
        return database.get(id); //id에 해당하는 musical을 찾아서 반환
    }

    @Override
    public List<Musical> findAll() {
        return database.values().stream().toList(); // database에 있는 모든 value를 ArrayLIst에 담아 반환
    }

    @Override
    public void updateById(Long id, Musical musical) {
        database.put(id, musical);
    }

    @Override
    public void deleteById(Long id) {
        database.remove(id);
    }
}
