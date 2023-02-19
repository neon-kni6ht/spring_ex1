package com.example.demo.service;

import com.example.demo.data.ModifiableRecord;
import com.example.demo.repo.RecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class RecordServiceImpl implements RecordService{

    private RecordRepo recordRepo;

    @Autowired
    public void setRecordRepo(RecordRepo recordRepo) {
        this.recordRepo = recordRepo;
    }

    @Override
    public ModifiableRecord save(ModifiableRecord record) {
        return recordRepo.save(record);
    }

    @Override
    public void delete(ModifiableRecord record) {
        recordRepo.delete(record);
    }

    @Override
    public ModifiableRecord getById(int id) throws NoSuchElementException {
        return recordRepo.findById(id).orElseThrow();
    }

    @Override
    public Set<ModifiableRecord> getAll() {
        return recordRepo.findAll();
    }
}
