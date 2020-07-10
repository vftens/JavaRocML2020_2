
public class Main {

    public static void main(String[] args) throws Exception {
        UsersCRUD usersCRUD = new UsersCRUD();
        Users users1 = new Users();
        users1.setName("John");
        users1.setEmail("connor_john@gmail.com");
        users1.setPassword("somepswd123");
        usersCRUD.save(users1);

        Users users2 = new Users();
        users2.setName("Sara");
        users2.setEmail("sarra_mother@gmail.com");
        users2.setPassword("qwerty123");
        usersCRUD.save(users2);

        usersCRUD.getAll().forEach(it -> System.out.println(it));

        Users userWithId1 = usersCRUD.getById(5);
        System.out.println(userWithId1);

        usersCRUD.delete(userWithId1);

        usersCRUD.getAll().forEach(it -> System.out.println(it));

    }

}
