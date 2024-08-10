package com.startup.course.services;

import com.startup.course.data.vo.v1.PersonVO;
import com.startup.course.mapper.DozerMapper;
import com.startup.course.model.Person;
import com.startup.course.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepository personRepository;
    public List<PersonVO> findAll(){
        logger.info("Finding all people!");
        return DozerMapper.parseObject(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id){
        logger.info("Finding one PersonVO!");
        PersonVO person = new PersonVO();
        person.setFirstName("Daniel");
        person.setLastName("Vicenzo");
        person.setAddress("Sao Paulo - Sao Paulo - Brasil");
        person.setGender("Male");
        return DozerMapper.parseObject(personRepository.findById(id).orElseThrow(), PersonVO.class) ;
    }

    private PersonVO mockPerson(int i) {
        PersonVO person = new PersonVO();
        person.setFirstName("PersonVO name " + i);
        person.setLastName("Last name " +i);
        person.setAddress("Some address in Brasil " +i);
        person.setGender("Male");
        return person;
    }

    public PersonVO create(PersonVO person){
        var person1 = DozerMapper.parseObject(person, Person.class);
        var vo = DozerMapper.parseObject(personRepository.save(person1), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person){
        var entity = personRepository.findById(person.getKey()).orElseThrow();
        var updatedEntity = personRepository.save(entity);
        updatedEntity.setFirstName(person.getFirstName());
        updatedEntity.setLastName(person.getLastName());
        updatedEntity.setGender(person.getGender());
        updatedEntity.setAddress(person.getAddress());
        var vo = DozerMapper.parseObject(updatedEntity, PersonVO.class);
        return vo;
    }

    public void delete(Long id){
         var person = personRepository.findById(id).orElseThrow();
        personRepository.delete(person);
    }

}
