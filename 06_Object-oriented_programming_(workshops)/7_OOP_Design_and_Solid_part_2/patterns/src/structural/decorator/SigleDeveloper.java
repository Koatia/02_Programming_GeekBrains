package structural.decorator;

public class SigleDeveloper implements Developer {
    @Override
    public String makeJob() {
        return "Пишу код.";
    }
}