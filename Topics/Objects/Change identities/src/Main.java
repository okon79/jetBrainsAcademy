class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        int ageP1tmp = p1.age;
        String nameP1tmp = p1.name;

        p1.age = p2.age;
        p1.name = p2.name;

        p2.age = ageP1tmp;
        p2.name = nameP1tmp;
    }
}