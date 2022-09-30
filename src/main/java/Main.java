import com.fasterxml.jackson.databind.ObjectMapper;
import model.Animal;
import model.Person;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path pathAnimal = Paths.get("src/main/resources/animals/animal.json");
        Path pathPersons = Paths.get("persons.json");

        // Initiera en lista
        List<Person> persons = new ArrayList<>();

        // Skapa upp en person
        Person person = new Person("Lena", 33);

        // Skapa upp ett Animal
        Animal animal = new Animal("Tod", "Katt", 1);

        // Skapa upp fler personer
        Person jyri = new Person("Jyri", 38);
        Person ella = new Person("Ella", 16);
        Person alva = new Person("Alva", 14);
        Person nova = new Person("Nova", 9);

        // Populera listan som vi initierade tidigare
        persons.add(jyri);
        persons.add(ella);
        persons.add(alva);
        persons.add(nova);

        // Skapa en instans av ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Spara ner "animal" till en jsonfil
            mapper.writeValue(pathAnimal.toFile(), animal);

            // Spara ner en lista av Person till JSON
            mapper.writeValue(pathPersons.toFile(), persons);

            // Läsa information från animal.json
            Animal elephant;
            elephant = mapper.readValue(pathAnimal.toFile(), Animal.class);

            // Läsa information från persons.json (inte i resources)
            Person[] people = mapper.readValue(pathPersons.toFile(), Person[].class);
            List<Person> peopleList = List.of(mapper.readValue(pathPersons.toFile(), Person[].class));

            System.out.println(people.length);
            System.out.println(peopleList.size());

            for (Person p : peopleList) {
                System.out.println(p.getName());
            }

            /*System.out.println(elephant.getName());
            System.out.println(elephant.getType());
            System.out.println(elephant.getAge());*/

        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
