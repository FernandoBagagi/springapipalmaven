package com.example.springapipalmaven.mapper;

import org.springframework.stereotype.Component;

import com.example.springapipalmaven.dto.OlaMundoDto;
import com.example.springapipalmaven.model.OlaMundo;

@Component
public class OlaMundoMapper implements ModelDtoMapper<OlaMundo, OlaMundoDto> {

    @Override
    public OlaMundo fromDtoToModel(OlaMundoDto dto) {

        if (dto == null) {
            return null;
        }

        final OlaMundo model = new OlaMundo();
        model.setId(dto.id());
        model.setName(dto.name());

        return model;

    }

    @Override
    public OlaMundoDto fromModelToDto(OlaMundo model) {

        if (model == null) {
            return null;
        }

        return new OlaMundoDto(model.getId(), model.getName());

    }

}
