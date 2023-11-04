public class Main {
    public static void main(String[] args) throws InterruptedException {
        Text text = new Text();
        gitHubRepo gitHub = new gitHubRepo();

        text.setTextAndDate("Добро пожаловать!!!");

        System.out.println(text);

        gitHub.setSave(text.save());

        Thread.sleep(5000);

        text.setTextAndDate("asdzcase");

        System.out.println(text);

        text.load(gitHub.getSave());

        System.out.println(text);


    }
}