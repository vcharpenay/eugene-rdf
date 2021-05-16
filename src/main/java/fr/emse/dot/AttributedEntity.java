package fr.emse.dot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AttributedEntity {

    protected Map<String, String> attributes = new HashMap<>();

    public String getAttribute(String name) {
        return attributes.get(name);
    }

    public List<Double> getNumbersAttribute(String name) {
        String value = getAttribute(name);

        List<Double> doubles = new ArrayList<>();

        for (String nb : value.split(",")) {
            doubles.add(Double.parseDouble(nb));
        }

        return doubles;
    }

    public void setAttribute(String name, String value) {
        attributes.put(name, value);
    }

    protected String listAttributes() {
        StringBuilder ab = new StringBuilder();
        attributes.forEach((name, val) -> {
            String a = String.format("%s=\"%s\",", name, val);
            ab.append(a);
        });

        if (attributes.size() > 0) {
            ab.deleteCharAt(ab.length() - 1); // remove trailing comma
        }

        return String.format("[%s]", ab);
    }

}
