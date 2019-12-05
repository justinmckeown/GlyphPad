/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Justin McKeown
 */
public class HelpTextStore {
    
    private LinkedHashMap<String, String> helpText; 
    
    public HelpTextStore(){
        helpText = new LinkedHashMap<String, String>();
        helpText.put("¬ Negation ", "For the negation symbol type the short code '\\neg'");
        helpText.put("∧ Conjunction", "soem stuff ");
        helpText.put("∨ Disjunction", "soem stuff ");
        helpText.put("⇒ Inference", "soem stuff ");
        helpText.put("⇔ Logical Equivilenece (if and only if)", "soem stuff ");
    }

    public LinkedHashMap<String, String> getHelpText() {
        return helpText;
    }

    
    
    
    
    
}
