package template_method.letter;

public class PayUsBackLetter extends LetterCreator<String>{
    Customer customer;

    public PayUsBackLetter(Customer customer) {
        this.customer = customer;
    }

    @Override
    protected boolean checkLetterNecessity() {
        return customer.getMoney() < 0;
    }

    @Override
    protected String setAdress() {
        return customer.getName() + " " + customer.getAddress();
    }

    @Override
    protected String setHeader() {
        return "We wan't our money, NOW!";
    }

    @Override
    protected String setText() {
        return "This is your first an final warning " + customer.getName()
                +". You owe us " +(-customer.getMoney())+". We know where your house lives." ;
    }

    @Override
    protected String saveToMedium(Letter letter) {
        return letter.beautify();
    }
}
