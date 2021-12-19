package com.academy.footballproject.converter;

import com.academy.footballproject.dto.ManagerDto;
import com.academy.footballproject.model.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerConverter {
    public ManagerDto toManagerDto(Manager manager){
        return ManagerDto.builder()
                .id(manager.getId())
                .name(manager.getName())
                .build();

    }
    public Manager toManager(ManagerDto managerDto){
        return Manager.builder()
                .id(managerDto.getId())
                .name(managerDto.getName())
                .build();
    }
}
