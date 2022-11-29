package composite;

import java.util.List;

public class Substract implements Term{

    private Term minuent;
    private List<Term> subtrahenden;

    public Substract(Term minuent, Term... subtrahenden) {
        this.minuent = minuent;
        this.subtrahenden = List.of(subtrahenden);
    }

    @Override
    public int evaluate() {
        int result = minuent.evaluate();
        for (Term term : subtrahenden) {
            result -= term.evaluate();
        }
        return result;
    }
}
