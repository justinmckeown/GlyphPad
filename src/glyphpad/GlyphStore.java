/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author Justin McKeown
 */
public class GlyphStore {
    
    private Map<String, String> predicateLogic;
    private Dictionary setTheory;
    private Map<String, String> otherChars;
    private Map<String, String> superscripts;
    private Map<String, String> subscripts;

    public GlyphStore() {
        
        predicateLogic = new HashMap<>();
        predicateLogic.put("\\neg", "\u00AC"); //negation
        predicateLogic.put("\\con", "\u2227"); //conjoined
        predicateLogic.put("\\and", "\u2227"); //conjoined
        predicateLogic.put("\\dis", "\u2228"); //disjoined
        predicateLogic.put("\\orr", "\u2228"); //disjoined
        predicateLogic.put("\\imp", "\u21D2"); //infers
        predicateLogic.put("\\iff", "\u21D4"); //iff and only iff
        predicateLogic.put("\\line", "\u23af"); //iff and only iff
        
        
        setTheory = new Hashtable();
        
        //Set theory general operators
        setTheory.put("\\uni", "\u222A"); //union
        setTheory.put("\\int", "\u2229"); //intersection SMALL BUT DENSE 
        //setTheory.put("\\sect", "\u22C2"); //intersection - BIG BUT THING
        setTheory.put("\\sub", "\u2286"); //subset
        setTheory.put("\\comp", "\u23BA"); //compliement
        setTheory.put("\\nsub", "\u2288"); //nsubset
        setTheory.put("\\psub", "\u2282"); //proper seubset / properly included
        setTheory.put("\\prop", "\u2282"); //proper subset or properly included
        setTheory.put("\\npsub", "\u2284"); //not a proper subset / not properly included
        setTheory.put("\\sup", "\u2287"); //superset
        setTheory.put("\\nsup", "\u2289"); //not superset
        setTheory.put("\\psup", "\u2283");// proper superset
        setTheory.put("\\npsup", "\u2285"); //not a proper superset
        setTheory.put("\\ele", "\u2208"); //element of
        setTheory.put("\\nele", "\u2209"); //not an element of 
        setTheory.put("\\pow", "\u2119"); //power set
        
        //Set theory special characters
        otherChars = new HashMap<>();
        otherChars.put("\\nat", "\u2115"); //Natural numbers 'N'
        otherChars.put("\\zzz", "\u2124"); //Integers 'Z'
        otherChars.put("\\rea", "\u211D"); //Real Number 'R'
        otherChars.put("\\the", "\u2203"); //There exists
        otherChars.put("\\for", "\u2200"); //for all
        otherChars.put("\\bfd", "\u2981"); //big fat dot
        otherChars.put("\\giv", "\u2981"); //big fat dot
        otherChars.put("\\car", "\u2A09"); //Cartesian product
        otherChars.put("\\emp", "\u2205"); //the empty set
        
        superscripts = new HashMap<>();
        superscripts.put("0", "\u2070");
        superscripts.put("1", "\u00B9");
        superscripts.put("2", "\u00B2");
        superscripts.put("3", "\u00B3");
        superscripts.put("4", "\u2074");
        superscripts.put("5", "\u2075");
        superscripts.put("6", "\u2076");
        superscripts.put("7", "\u2077");
        superscripts.put("8", "\u2078");
        superscripts.put("9", "\u2079");
        superscripts.put("+", "\u207A");
        superscripts.put("-", "\u207B");
        superscripts.put("=", "\u207C");
        superscripts.put("(", "\u207D");
        superscripts.put(")", "\u207E");
        superscripts.put("n", "\u207F");
        
        subscripts = new HashMap<>();
        subscripts.put("0", "\u2080");
        subscripts.put("1", "\u2081");
        subscripts.put("2", "\u2082");
        subscripts.put("3", "\u2083");
        subscripts.put("4", "\u2084");
        subscripts.put("5", "\u2085");
        subscripts.put("6", "\u2086");
        subscripts.put("7", "\u2087");
        subscripts.put("8", "\u2088");
        subscripts.put("9", "\u2089");
        subscripts.put("+", "\u208A");
        subscripts.put("-", "\u208B");
        subscripts.put("=", "\u208C");
        subscripts.put("(", "\u208D");
        subscripts.put(")", "\u208E");
        subscripts.put("a", "\u2090");
        subscripts.put("e", "\u2091");
        subscripts.put("g", "\u2094");
        subscripts.put("h", "\u2095");
        subscripts.put("k", "\u2096");
        subscripts.put("l", "\u2097");
        subscripts.put("m", "\u2098");
        subscripts.put("n", "\u2099");
        subscripts.put("o", "\u2092");
        subscripts.put("p", "\u209A");
        subscripts.put("s", "\u209B");
        subscripts.put("t", "\u209C");
        subscripts.put("x", "\u2093");
    }

    public Map getPredicateLogic() {
        return predicateLogic;
    }

    public void setPredicateLogic(Map predicateLogic) {
        this.predicateLogic = predicateLogic;
    }


    

    public Dictionary getSetTheory() {
        return setTheory;
    }

    public void setSetTheory(Dictionary setTheory) {
        this.setTheory = setTheory;
    }

    public Map<String, String> getSuperscripts() {
        return superscripts;
    }

    public Map<String, String> getSubscripts() {
        return subscripts;
    }

    public Map<String, String> getOtherChars() {
        return otherChars;
    }

    public void setOtherChars(Map<String, String> otherChars) {
        this.otherChars = otherChars;
    }

    
   
    
    
    
    
    
    
}
