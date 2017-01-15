package ch.x01.fuzzy.parser;

import ch.x01.fuzzy.engine.LinguisticVariable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    private Map<String, LinguisticVariable> symbols = new HashMap<>();

    /**
     * Registers a linguistic variable by its name.
     *
     * @param v the linguistic variable
     * @return true if the linguistic variable was registered
     */
    public boolean register(LinguisticVariable v) {
        boolean result = false;
        if (!this.symbols.containsKey(v.getName().toLowerCase())) {
            this.symbols.put(v.getName().toLowerCase(), v);
            result = true;
        }
        return result;
    }

    public boolean validateLV(String name) {
        return this.symbols.containsKey(name.toLowerCase());
    }

    public boolean validateLT(String nameLV, String nameLT) {
        boolean result = false;
        if (this.symbols.containsKey(nameLV.toLowerCase())) {
            LinguisticVariable lv = this.symbols.get(nameLV.toLowerCase());
            result = lv.containsTerm(nameLT);
        }
        return result;
    }

    /**
     * Returns the linguistic variable to which the specified name is mapped, or null if this symbol table contains no
     * mapping for the name.
     *
     * @param name the name of the linguistic variable
     * @return the linguistic variable
     */
    public LinguisticVariable get(String name) {
        return this.symbols.get(name.toLowerCase());
    }

    public Collection<LinguisticVariable> getLinguisticVariables() {
        return Collections.unmodifiableCollection(this.symbols.values());
    }
}
