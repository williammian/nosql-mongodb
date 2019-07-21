package br.com.wm.nosqlmongodb.converter;

import br.com.wm.nosqlmongodb.entity.Person;
import com.mongodb.DBObject;

import java.util.HashMap;
import java.util.Map;

public class PersonConverter {

    public Map<String, Object> converterToMap(Person person) {
        Map<String, Object> mapPerson = new HashMap<String, Object>();
        mapPerson.put("firstName", person.getFirstName());
        mapPerson.put("lastName", person.getLastName());
        mapPerson.put("age", person.getAge());
        mapPerson.put("phone",
                new PhoneConverter().converterToMap(person.getPhone())
        );

        return mapPerson;
    }

    public Person converterToPerson(DBObject dbo) {
        Person person = new Person();
        person.setId(dbo.get("_id").toString());
        person.setFirstName((String) dbo.get("firstName"));
        person.setLastName((String) dbo.get("lastName"));
        person.setAge((Integer) dbo.get("age"));
        person.setPhone(new PhoneConverter().converterToPhone(
                (HashMap<String, Object>) dbo.get("phone"))
        );

        return person;
    }
}
