package com.example.springapipalmaven.mapper;

public interface ModelDtoMapper<T, S> {

    public T fromDtoToModel(S dto);

    public S fromModelToDto(T model);

}
