public abstract class UserBuilder {
    User user;

    public void creatUser() {
        user =  new User();
    }

    abstract public void buildName(String name);
    abstract public void buildMail(String mail);
    abstract public void buildAge(int age);

    User getUser(){
        return user;
    }

}
