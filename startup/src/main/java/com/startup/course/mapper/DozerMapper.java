package com.startup.course.mapper;


import com.startup.course.data.vo.v1.PersonVO;
import com.startup.course.model.Person;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

//    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    private static ModelMapper mapper = new ModelMapper();

    static {
        mapper.createTypeMap(Person.class, PersonVO.class)
                .addMapping(Person::getId, PersonVO::setKey);
        mapper.createTypeMap(PersonVO.class, Person.class)
                .addMapping(PersonVO::getKey, Person::setId);
    }

    public static  <O, D> D parseObject(O origem, Class<D> destination){
        return mapper.map(origem, destination);
    }

    public static  <O, D> List<D> parseObject(List<O> origem, Class<D> destination){
        List<D> destinationObjects = new ArrayList<D>();
        for (O o : origem) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
