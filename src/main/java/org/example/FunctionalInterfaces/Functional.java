package org.example.FunctionalInterfaces;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Functional {

    /**
     * Consumer accepts some object and processes it. Returns nothing.
     */
    public static class ConsumerExample {
        public static void main(String[] args) {
           printNames();
        }

        /**
         * This function has to consumers. One changes the name and the other prints the name
         * uses the accept method to chain both together.
         */
        public static void printNames() {
            List<Student> allStudents = StudentDataBase.getAllStudents();

            Consumer<Student> addLetterAToName
                    = student -> student.setName(student.getName() + " ADDED TO NAME");
            Consumer<Student> studentConsumer = student -> System.out.println(student.getName());

            allStudents.forEach(addLetterAToName.andThen(studentConsumer));
        }
    }

    /**
     * Same as consumer but accepts 2 parameters instead of just one
     */
    public static class BiConsumerExample {
        public static void main(String[] args) {
            printNameAndActivities();
        }

        public static void printNameAndActivities() {
            List<Student> allStudents = StudentDataBase.getAllStudents();

            BiConsumer<String, List<String>> printStudentInfo
                    = (name, activities) -> System.out.printf("Name: %s, Activities: %s%n", name, activities);

            allStudents.forEach(student -> printStudentInfo.accept(student.getName(), student.getActivities()));
        }
    }

    public static class PredicateExample {
        static Predicate<Student> gPA3OrGreater = student -> student.getGpa() >= 3.7;
        public static void main(String[] args) {
            printNameAndActivities();
        }

        public static void printNameAndActivities() {
            List<Student> allStudents = StudentDataBase.getAllStudents();

            allStudents.forEach(student -> {
                if (gPA3OrGreater.test(student)) {
                    System.out.printf("%s, Activities: %s, GPA: %s%n", student.getName(), student.getActivities(), student.getGpa());
                }
            });
            System.out.println("**************************");

            allStudents.forEach(student -> {
                if (gPA3OrGreater.negate().test(student)) {
                    System.out.printf("%s, Activities: %s, GPA: %s%n", student.getName(), student.getActivities(), student.getGpa());
                }
            });
        }
    }

    public static class FunctionExample {
        static Function<String, String> function = name -> name.toUpperCase();


        public static void main(String[] args) {

        }
    }
}
