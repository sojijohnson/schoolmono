package com.schoolDb.schoolDesign.Functionals;

import org.springframework.aop.scope.ScopedProxyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _Functions_Streams {
    public static void main(String[] args) {

      // List<Person> people = (List<Person>) new Person("dd",Gender.Female);
        ArrayList<Person>pe = new ArrayList<>(List.of(new Person("game",Gender.Female),
                new Person("seyi",Gender.Female),
                new Person("tope",Gender.Male)
                ));

         pe.stream().filter((person)->person.gender.equals(Gender.Female)).forEach(System.out::println);
        Object objet = Optional.ofNullable("jjj ").orElseThrow(()->new IllegalStateException("errr") );

        System.out.println(objet);

       // pe.stream().map(person -> person.name).mapToInt(name->name.length()).forEach(name-> System.out.println(name));

//        Function<Person, Gender> personGenderFunction = person -> person.gender;
//        pe.stream().map( personGenderFunction).collect(Collectors.toSet()).forEach(name -> System.out.println(name));
//        System.out.println(pe);
//
//      //System.out.println(pe.stream().map( ).toList());
//
//     for(Person person : pe){
//
//         System.out.println(person.name.contains("s"));
//     };
    }


    static class Person{

        private final   String name;
        private final Gender gender;

         Person(String name, Gender gender){

         this.gender=gender;
         this.name=name;

        }

        @Override
        public String toString() {
          //  return super.toString();
   return
            "Person {name =' "+ name + '\''+ "Gender =" + gender + "}" ;
        }
    }

     enum Gender{

        Male, Female
    }
}
