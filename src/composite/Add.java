package composite;

import java.util.Arrays;
import java.util.List;

public class Add implements Term{
    private final List<Term> summanten;

    public Add(Term... terms) {
        this.summanten = Arrays.stream(terms).toList();
    }

    @Override
    public int evaluate() {
        int result = 0;
        for (Term term : summanten) {
            result += term.evaluate();
        }
        return result;
    }
}
