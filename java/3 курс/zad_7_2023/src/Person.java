public class Person extends UserBuilder{
    @Override
    public void buildName(String name) {
        user.setName(name);
    }

    @Override
    public void buildMail(String mail) {
        user.setMail(mail);
    }

    @Override
    public void buildAge(int age) {
        user.setAge(age);
    }
}
