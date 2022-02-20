package com.blogwebpage.blogprojectandreact.core.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forDto();

    ModelMapper forRequest();
}
