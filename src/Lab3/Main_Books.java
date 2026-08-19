package Lab3;

public class Main_Books {
    public static void main(String args[]){
        new Books("Java Programming",
                "James Gosling",
                "Oak Publishers",
                560.0,
                20);

        new Books("Python Programming",
                "Guido van Rossum",
                "Tech Books",
                600.0,
                30);

        new Books("C Programming",
                "Dennis Ritchie",
                "Pearson",
                450.0,
                40);

        new Books("Data Structures",
                "Mark Allen",
                "McGraw Hill",
                700.0,
                15);

        new Books("Operating Systems",
                "Abraham Silberschatz",
                "Wiley",
                800.0,
                10);

        Books b = new Books(
                "dummy",
                "dummy",
                "dummy",
                0,
                0
        );
        b.search();
    }
}
