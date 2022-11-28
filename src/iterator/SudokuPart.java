package iterator;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuPart {
    int length;
    Collection<Integer> values;
    Collection<Integer> expected;

    public SudokuPart(Collection<Integer> values) {
        this.length = values.size();
        this.values = values;
        this.expected = IntStream.range(1, length + 1).boxed().collect(Collectors.toList());
    }

    public boolean isValid() {
        return values.containsAll(expected) && expected.containsAll(values);
    }
}

