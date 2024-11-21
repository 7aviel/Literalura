package com.onecourse.literalura.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onecourse.literalura.interfaces.IConverter;
import com.onecourse.literalura.persistence.model.BookWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataConversor implements IConverter {
    private final ObjectMapper objectMapper;

    @Override
    public <T> List<T> getData(String json, TypeReference<List<T>> typeReference) {
        try {
            BookWrapper wrapper = objectMapper.readValue(json, BookWrapper.class);
            return objectMapper.convertValue(wrapper.getResults(), typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    public DataConversor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
