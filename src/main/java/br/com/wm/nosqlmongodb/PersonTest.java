package br.com.wm.nosqlmongodb;

import br.com.wm.nosqlmongodb.dao.PersonDao;
import br.com.wm.nosqlmongodb.entity.Person;
import br.com.wm.nosqlmongodb.entity.Phone;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonTest {

    public static void main(String[] args) {
        save();
        //update();
        //delete();
        //saveIndex();
    }
    private static void saveIndex() {
        Phone ph1 = new Phone("045-4599-8800", "045-99111-9911");
        Person p1 = new Person("Cristiano Ronaldo", "dos Santos Aveiro", 26, ph1);
        new PersonDao().saveWithIndex(p1);

        Phone ph2 = new Phone("011-3502-0555", "011-99155-9056");
        Person p2 = new Person("Lionel Messi", "Cuccittini", 33, ph2);
        new PersonDao().saveWithIndex(p2);

        Phone ph3 = new Phone("055-3525-2552", "055-99525-4454");
        Person p3 = new Person("Zinedine", "Zidane", 38, ph3);
        new PersonDao().saveWithIndex(p3);

        List<Person> persons = new PersonDao().findPersons();
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }

    private static void save() {
        Phone ph1 = new Phone("021-3424-6494", "021-99144-9446");
        Person p1 = new Person("Romário", "de Souza", 22, ph1);
        new PersonDao().save(p1);

        Phone ph2 = new Phone("011-3332-4490", "011-99440-9044");
        Person p2 = new Person("Osmar", "Pereira", 29, ph2);
        new PersonDao().save(p2);

        Phone ph3 = new Phone("055-3222-2599", "055-99995-9494");
        Person p3 = new Person("Tereza", "Fagundes de Almeida", 33, ph3);
        new PersonDao().save(p3);

        List<Person> persons = new PersonDao().findPersons();
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }

    private static void update() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("firstName", "Tereza");
        Person query = new PersonDao().findPerson(map);

        Phone phone = new Phone("048-3222.2522", "048-99225.4464");
        Person person = new Person("Anita", "Pires de Almeida", 30, phone);
        new PersonDao().update(query, person);

        Map<String, Object> map2 = new HashMap();
        map2.put("firstName", "Anita");
        Person newPerson = new PersonDao().findPerson(map2);
        System.out.println("Old:> " + query + "\nNew:> " + newPerson.toString());
    }

    private static void delete() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("firstName", "Osmar");
        List<Person> query = new PersonDao().findPersons(map);

        for (Person person : query) {
            new PersonDao().delete(person);
        }

        List<Person> persons = new PersonDao().findPersons();
        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }  // new org.bson.types.ObjectId("4ffb431f6b70d45d7679e87f")
}
