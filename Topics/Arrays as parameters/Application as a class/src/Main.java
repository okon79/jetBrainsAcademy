class Application {

    String name;

    void run(String[] args) {
        System.out.println(name);
        for (String item: args) {
            System.out.println(item);
        }
    }
}