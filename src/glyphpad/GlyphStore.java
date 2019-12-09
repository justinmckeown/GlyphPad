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
        setTheory.put("\\uni", "\u222A"); //union
        setTheory.put("\\int", "\u2229"); //intersection 
        setTheory.put("\\diff", "\u22C2"); //difference
        setTheory.put("\\sub", "\u2286"); //subset
        setTheory.put("\\comp", "\u23BA"); //compliement
        setTheory.put("\\nsub", "\u2288"); //nsubset
        setTheory.put("\\psub", "\u2282"); //proper seubset / properly included
        setTheory.put("\\npsub", "\u2284"); //not a proper subset / not properly included
        setTheory.put("\\sup", "\u2283");//superset
        setTheory.put("\\nsup", "\u2289"); //not superset
        setTheory.put("\\psup", "\u2287"); //proper superset
        setTheory.put("\\npsup", "\u2285"); //not a proper superset
        setTheory.put("\\ele", "\u2208"); //element of
        setTheory.put("\\nele", "\u2209"); //not an element of 
        setTheory.put("\\Pow", "\u2119"); //power set
        setTheory.put("\\Nat", "\u2115"); //Natural numbers 'N'
        setTheory.put("\\Int", "\u2124"); //Integers 'Z'
        setTheory.put("\\Rea", "\u211D"); //Real Number 'R'
        setTheory.put("\\the", "\u2203"); //There exists
        setTheory.put("\\for", "\u2200"); //for all
        setTheory.put("\\bfd", "\u2981"); //big fat dot
        setTheory.put("\\car", "\u2A09"); //Cartesian product
        setTheory.put("\\emp", "\u2205"); //the empty set
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

   
    
    
    
    
    
    
}
