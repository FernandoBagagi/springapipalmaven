package com.example.springapipalmaven.mapper;

import org.springframework.stereotype.Component;

import com.example.springapipalmaven.domain.OlaMundo;
import com.example.springapipalmaven.dto.OlaMundoDto;

@Component
public class OlaMundoMapper implements ModelDtoMapper<OlaMundo, OlaMundoDto> {

    @Override
    public OlaMundo fromDtoToModel(OlaMundoDto dto) {

        if (dto == null) {
            return null;
        }

        final OlaMundo model = new OlaMundo();
        model.setId(dto.getId());
        model.setName(dto.getName());

        return model;

    }

    @Override
    public OlaMundoDto fromModelToDto(OlaMundo model) {

        if (model == null) {
            return null;
        }

        final OlaMundoDto dto = new OlaMundoDto();
        dto.setId(model.getId());
        dto.setName(model.getName());

        return dto;

    }

}
