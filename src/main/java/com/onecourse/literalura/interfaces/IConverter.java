package com.onecourse.literalura.interfaces;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public interface IConverter {

    <T> List<T> getData(String json, TypeReference<List<T>> typeReference);


}