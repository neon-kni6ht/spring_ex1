package com.example.demo.repo;

import com.example.demo.data.ModifiableRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RecordRepo extends CrudRepository<ModifiableRecord, Integer> {
    Set<ModifiableRecord> findAll();
}
