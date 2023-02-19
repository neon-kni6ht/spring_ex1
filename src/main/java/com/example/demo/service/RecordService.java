package com.example.demo.service;
import com.example.demo.data.ModifiableRecord;

import java.util.Set;


public interface RecordService {
    public ModifiableRecord save(ModifiableRecord record);

    public void delete(ModifiableRecord record);

    public ModifiableRecord getById(int id);

    public Set<ModifiableRecord> getAll();

}
