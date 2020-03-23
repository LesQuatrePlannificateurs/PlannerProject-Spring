package com.spring.planner.service;

import com.spring.planner.entities.Equipment;
import com.spring.planner.entities.Unavailability;
import com.spring.planner.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public Equipment addEquipment(Equipment equipment){
        return equipmentRepository.save(equipment);
    }

    public void deleteEquipmentById(Long id){
        equipmentRepository.deleteById(id);
    }

    public Equipment findEquipmentById(Long id){
        return equipmentRepository.findById(id).orElse(null);
    }
}
