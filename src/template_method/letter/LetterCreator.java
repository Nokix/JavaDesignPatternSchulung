package template_method.letter;

public abstract class LetterCreator<M> {
    public M create() {
        if (checkLetterNecessity()) {
            // Erstelle Inhalt des Briefes
            Letter letter = new Letter(setAdress(), setHeader(), setText());
            //Speichere Brief
            return saveToMedium(letter);
        }
        return noLetterCreated();
    }

    protected boolean checkLetterNecessity() {
        return true;
    }

    protected abstract String setAdress();

    protected abstract String setHeader();

    protected abstract String setText();

    protected abstract M saveToMedium(Letter letter);

    protected M noLetterCreated() {
        return null;
    }

}
