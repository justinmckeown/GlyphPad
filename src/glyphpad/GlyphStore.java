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
    
    private Map<String, String> coreMaths;
    private Map<String, String> predicateLogic;
    private Dictionary setTheory;
    private Map<String, String> otherChars;
    private Map<String, String> superscripts;
    private Map<String, String> subscripts;

    public GlyphStore() {
        
        
        //core maths
        coreMaths = new HashMap<>();
        coreMaths.put("\\appro", "\u2248"); //aproximation
        coreMaths.put("\\summ", "\u2211"); //summation
        coreMaths.put("\\less", "\u2264"); //Less than or equal to 
        coreMaths.put("\\grea", "\u2265"); //greater than or equal to 
        coreMaths.put("\\nequ", "\u2260"); //not equal
        coreMaths.put("\\eop", "\u220E"); //End Of Proof
        coreMaths.put("\\ang", "\u221F"); //angle
        
        //Predicate logic
        predicateLogic = new HashMap<>();
        predicateLogic.put("\\neg", "\u00AC"); //negation
        predicateLogic.put("\\con", "\u2227"); //conjoined
        predicateLogic.put("\\and", "\u2227"); //conjoined
        predicateLogic.put("\\dis", "\u2228"); //disjoined
        predicateLogic.put("\\orr", "\u2228"); //disjoined
        predicateLogic.put("\\imp", "\u21D2"); //infers
        predicateLogic.put("\\iff", "\u21D4"); //iff and only iff
        predicateLogic.put("\\line", "\u23af"); //iff and only iff
        predicateLogic.put("\\the", "\u2203"); //There exists
        predicateLogic.put("\\for", "\u2200"); //for all
        
        
        //Set theory general operators
        setTheory = new Hashtable();
        setTheory.put("\\uni", "\u222A"); //union
        setTheory.put("\\int", "\u2229"); //intersection SMALL BUT DENSE 
        //setTheory.put("\\sect", "\u22C2"); //intersection - BIG BUT THIN
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
        setTheory.put("\\car", "\u2A09"); //Cartesian product
        setTheory.put("\\emp", "\u2205"); //the empty set
        
        //Set relations
        setTheory.put("\\allr", "\u2194"); //Double headed Arrow: the set of all relations between a and b
        setTheory.put("\\mapl", "\u21A6"); //Maplet: a maps to b
        setTheory.put("\\dres", "\u25C1"); //domain restriction
        setTheory.put("\\dcres", "\u2A64"); //domain co-restriction
        setTheory.put("\\rres", "\u25B7"); //range restriction
        setTheory.put("\\rcres", "\u2A65"); //range co-restriction
        
        setTheory.put("\\lrib", "\u2987"); //z - left image bracket
        setTheory.put("\\rrib", "\u2988"); //z - right image bracket
        setTheory.put("\\rcom", "\u25E6"); //z - relational composition 
        setTheory.put("\\refr", "\u25FB"); //reflexive relationship \u25A1
        setTheory.put("\\over", "\u2295"); //orverriding
        
        
        //Arrows: Injective, Serjective, Bijective
        setTheory.put("\\arr", "\u2192"); //generic arrow
        setTheory.put("\\inj", "\u21F8"); //intective relations
        setTheory.put("\\tinj", "\u21A3"); //total set of intective relations
        setTheory.put("\\ser", "\u2900"); //serjective relations
        setTheory.put("\\tser", "\u21A0"); //total set of serjective relations
        setTheory.put("\\tbi", "\u2917"); //total set of bijective relations
        
        //Bags
        setTheory.put("\\lbag", "\u27E6"); //bag left bracket
        setTheory.put("\\rbag", "\u27E7"); //bag right bracket
        
        //Sequences
        setTheory.put("\\lseq", "\u27E8"); //sequence left bracket
        setTheory.put("\\rseq", "\u27E9"); //sequence right bracket
        setTheory.put("\\cat", "\u2312"); //concat
        
        
        //Other Special characters
        otherChars = new HashMap<>();
        otherChars.put("\\nat", "\u2115"); //Natural numbers 'N'
        otherChars.put("\\zzz", "\u2124"); //Integers 'Z'
        otherChars.put("\\rea", "\u211D"); //Real Numbers 'R'
        otherChars.put("\\rat", "\u211A"); //Rational Numbers 'R'
        otherChars.put("\\zee", "\u22FF"); //Z - notation E
        otherChars.put("\\bfd", "\u2981"); //big fat dot
        otherChars.put("\\giv", "\u2981"); //big fat dot
        
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

    public Map<String, String> getCoreMaths() {
        return coreMaths;
    }

    
   
    
    
    
    
    
    
}
