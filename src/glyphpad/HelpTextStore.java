/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author Justin McKeown
 */
public class HelpTextStore {
    
    
    
    
    private LinkedHashMap<String, String> helpText;
    private LinkedHashMap<String, String> setTheoryTextHelp;
    private LinkedHashMap<String, String> otherCharsTextHelp;
    
    
    
    public HelpTextStore(){
        helpText = new LinkedHashMap<String, String>();
        setTheoryTextHelp = new LinkedHashMap<String, String>();
        otherCharsTextHelp = new LinkedHashMap<String, String>();
        
        helpText.put("¬ Negation: '\\neg'", "Law 1.1.1: Not True is logically equivilent to false and vice versa:\n(¬𝑡𝑟𝑢𝑒) ⟺ 𝑓𝑎𝑙𝑠𝑒 \n(¬𝑓𝑎𝑙𝑠𝑒) ⟺ 𝑡𝑟𝑢𝑒\n\n"
                + "Law 1.1.2: Two negatives make a positive:\n(¬¬𝑝) ⟺ 𝑝");
        
        helpText.put("∧ Conjunction: '\\con' or '\\and'", "Law 1.2.1: A proposition conjoined with itself is equivalent to itself:\n(𝑝 ∧ 𝑝) ⟺ 𝑝\n\n "
                + "Law 1.2.2: P conjoined with itself if equivilent to p:\n(𝑝 ∧ 𝑡𝑟𝑢𝑒) ⟺ 𝑝\n\n"
                + "Law 1.2.3: a proposition conjoined with false will always resolve to false \n(𝑝 ∧ 𝑓𝑎𝑙𝑠𝑒) ⟺ 𝑓𝑎𝑙𝑠𝑒 \n\n" 
                + "Law 1.2.4: a proposition conjoined with its own negation will always resolve to false \n(𝑝 ∧ (¬𝑝)) ⟺ 𝑓𝑎𝑙𝑠𝑒 \n\n" 
                + "Law 1.2.5: conjunction is commutative \n(𝑝 ∧ 𝑞) ⟺ (𝑞 ∧ 𝑝) \n\n" 
                + "Law 1.2.6: conjunction is associative \n(𝑝 ∧ 𝑞) ∧ 𝑟 ⟺ 𝑝 ∧ (𝑞 ∧ 𝑟)");
        
        helpText.put("∨ Disjunction: '\\dis' or '\\orr'", "Law 1.3.1 de Morgan’s Laws \n¬(𝑝 ∧ 𝑞) ⟺ ((¬𝑝) ∨ (¬𝑞)) \n¬(𝑝 ∨ 𝑞) ⟺ ((¬𝑝) ∧ (¬𝑞)) \n\n" 
                +"Law 1.3.2: disjunction is idempotent\n(𝑝 ∨ 𝑝) ⟺ 𝑝 \n\n" 
                +"Law 1.3.3: A proposition disjioned with false is logically equivalent to the value of the proposition \n(𝑝 ∨ 𝑓𝑎𝑙𝑠𝑒) ⟺ 𝑝 \n\n"
                +"Law 1.3.4: a proposition combined via disjunction with true will always resolve to true \n(𝑝 ∨ 𝑡𝑟𝑢𝑒) ⟺ 𝑡𝑟𝑢𝑒 \n\n" 
                +"Law 1.3.5: disjunction is associative\n𝑝 ∨ (𝑞 ∨ 𝑟) ⟺ (𝑝 ∨ 𝑞) ∨ 𝑟 \n\n" 
                +"Law 1.3.6: disjunction is commutative \n𝑝 ∨ 𝑞 ⟺ 𝑞 ∨ 𝑝 \n\n" 
                +"Law 1.3.7: a proposition combined via disjunction with its own negation will always resolve to true \n((¬𝑝) ∨ 𝑝) ⟺ 𝑡𝑟𝑢𝑒 \n\n"
                +"Law 1.3.8: disjunction distributes through conjunction \n𝑝 ∨ (𝑞 ∧ 𝑟) ⟺ (𝑝 ∨ 𝑞) ∧ (𝑝 ∨ 𝑟) \n\n" 
                +"Law 1.3.9: conjunction distributes through disjunction \n𝑝 ∧ (𝑞 ∨ 𝑟) ⟺ (𝑝 ∧ 𝑞) ∨ (𝑝 ∧ 𝑟)");
        
        helpText.put("⇒ Implication: '\\imp'", "Law 1.4.1: 𝑝 implies 𝑞 is the same as not 𝑝, or 𝑞\n(𝑝 ⇒ 𝑞) ⟺ ((¬𝑝) ∨ 𝑞)");
        
        helpText.put("⇔ Logical Equivilenece (if, and only if): '\\iff'","Law 1.5.1: equivalence is associative\n((𝑝 ⟺ 𝑞) ⟺ 𝑟) ⟺ (𝑝 ⟺ (𝑞 ⟺ 𝑟)) \n\n" 
                +"Law 1.5.2: equivalence is commutative \n(𝑝 ⟺ 𝑞) ⟺ (𝑞 ⟺ 𝑝) \n\n" 
                +"Law 1.5.3: every proposition is equivalent to itself \n(𝑝 ⟺ 𝑝) ⟺ 𝑡𝑟𝑢𝑒 \n\n" 
                +"Law 1.5.4: no proposition is equivalent to its negation \n(𝑝 ⟺ (¬𝑝)) ⟺ 𝑓𝑎𝑙𝑠𝑒 \n\n" 
                +"Law 1.5.5: claiming proposition p is equivalent proposition q is the same as claiming that p implies q and q implies p \n(𝑝 ⟺ 𝑞) ⟺ ((𝑝 ⇒ 𝑞) ∧ (𝑞 ⇒ 𝑝))");
        
        setTheoryTextHelp.put("∈ Set Membership '\\ele'", "Law 2.1.1: for any set 𝑆 and any element 𝑠\n "
                + "¬(𝑠 ∈ 𝑆) ⟺ 𝑠 ∉ 𝑆 \n\n"
                + "Law 2.1.2: for any element 𝑥  \n𝑥 ∈ ∅ ⟺ 𝑓𝑎𝑙𝑠𝑒");
        
        setTheoryTextHelp.put("⊆ Subsets '\\sub'", "Law 2.2.1: for any sets S and T, where S is a subset of T and T is a subset of S, S and T must be equal\n"
                +"(𝑆 ⊆ 𝑇 ∧ 𝑇 ⊆ 𝑆) ⟺ 𝑆 = 𝑇\n\n"
                +"Law 2.2.2: for any sets S, the empty set is a subset of S\n"
                +"(∅ ⊆ 𝑆) \n\n"
                +"Law 2.2.3: all sets are a subset of themselves \n"
                +"(𝑆 ⊆ 𝑆) \n\n" 
                +"Law 2.2.4: for any sets S and T, the negation of 'S is a subset of T' is logically equivalent to stating 'S is not a subset of T'\n "
                +"¬(𝑆 ⊆ 𝑇) ⟺ 𝑆 ⊈ 𝑇 \n\n" 
                +"Law 2.2.5: for any sets S and T, stating 'S is a subset of T' is logically equivalent to  stating 'either S is  properly included in T or S is equal to T\n"
                +"𝑆 ⊆ 𝑇 ⟺ (𝑆 ⊂ 𝑇 ∨ 𝑆 = 𝑇)"); 
        
        setTheoryTextHelp.put("⊂ Proper subset '\\prop' or '\\psub'", "Law 2.2.6: for any sets S and T, stating 'S is not properly included in S' is logically equivalent to the negation of the statement 'S is properly included in T'\n"
                + "𝑆 ⊄ 𝑇 ⟺ ¬(𝑆 ⊂ 𝑇) \n\n" 
                +"Law 2.2.7: for any set S, S can never be properly included in itself.\n"
                +"𝑆 ⊄ 𝑆 \n\n" 
                +"Law 2.2.8: for any sets S and T, it follows that if S is properly included in T then this implies T is not properly included in S\n"
                +"𝑆 ⊂ 𝑇 ⇒ 𝑇 ⊄ 𝑆");
        
        setTheoryTextHelp.put("⊈ Not a Subset '\\nsub'", "\n");
        setTheoryTextHelp.put("⊄ Not a Proper Subset '\\npsub'", "\n");
        
        setTheoryTextHelp.put("⊇ Supersets '\\sup'", "Law 2.3.1: for any sets S and T. Stating S is a superset of T is logically equivalent to stating that T is a subset of S\n"
                + "𝑆 ⊇ 𝑇 ⟺ 𝑇 ⊆ 𝑆");
        
        setTheoryTextHelp.put(" ⊃ Proper Superset '\\psup'", "\n");
        setTheoryTextHelp.put(" ⊉ not a Superset '\\nsup'", "\n");
        setTheoryTextHelp.put(" ⊅ not a Proper Superset '\\npsup'", "\n");
        
        setTheoryTextHelp.put("∪ Set Union '\\uni'", "Law 2.4.1: for any element a, and any sets S and T  \n𝑎 ∈ 𝑆 ∪ 𝑇 ⟺ (𝑎 ∈ 𝑆 ∨ 𝑎 ∈ 𝑇) \n\n" 
                +"Law 2.4.2: combining Set 𝑆 with the empty set Ø,  is equivalent to Set 𝑆:  \n𝑆 ∪ ∅ = 𝑆 \n\n" 
                +"Law 2.4.3: The set union of any set 𝑆 combined with itself is equivalent to itself  \n𝑆 ∪ 𝑆 = 𝑆 \n\n" 
                +"Law 2.4.4: Union is commutative  \n𝑆 ∪ 𝑇 = 𝑇 ∪ 𝑆 \n\n" 
                +"Law 2.4.5: Union is associative   \n𝑅 ∪ (𝑆 ∪ 𝑇) = (𝑅 ∪ 𝑇) ∪ 𝑆 \n\n" 
                +"Law 2.4.6: The union of two sets is always at least as big as each set considered individually \n𝑆 ⊆ 𝑆 ∪ 𝑇");
        
        setTheoryTextHelp.put("∩ Set Intersection '\\int'", "Law 2.5.1: where a given element 𝑎 is in the intersection of sets 𝑆 and 𝑇 is must be an element of both sets \n𝑎 ∈ 𝑆 ∩ 𝑇 ⟺ (𝑎 ∈ 𝑆 ∧ 𝑎 ∈ 𝑇) \n\n"
                +"Law 2.5.2: the intersection of a given set 𝑆 with the empty set Ø is always the empty set \n𝑆 ∩ ∅ = ∅ \n\n"
                + "Law 2.5.3: the intersection of set 𝑆 with itself is always 𝑆 \n𝑆 ∩ 𝑆 = 𝑆 \n\n"
                + "Law 2.5.4: Intersection is commutative \n𝑆 ∩ 𝑇 = 𝑇 ∩ 𝑆 \n\n" 
                +"Law 2.5.5: Intersection is associative \n𝑅 ∩ (𝑆 ∩ 𝑇) = (𝑅 ∩ 𝑆) ∩ 𝑇 \n\n" 
                +"Law 2.5.6: The intersection of any given sets is always at least as small as one of the given sets \n𝑆 ∩ 𝑇 ⊆ 𝑆 \n\n" 
                +"Law 2.5.7: union distributes through Intersection and Intersection distributes through distribution \n𝑹 ∪ (𝑺 ∩ 𝑻) = (𝑹 ∪ 𝑺) ∩ (𝑹 ∪ 𝑻) \n𝑹 ∩ (𝑺 ∪ 𝑻) = (𝑹 ∩ 𝑺) ∪ (𝑹 ∩ 𝑻)");
 
        setTheoryTextHelp.put("\\ Set Difference '\\dif'", "Law 2.6.1: if a is an element of the Set difference of Sets S\\T then S is a member of the former and not the latter \n" 
                +"𝒂 ∈ 𝑆\\𝑇 ⟺ (𝑎 ∈ 𝑆 ∧ 𝑎 ∉ 𝑇) \n" 
                +"Law 2.6.2: Set S intersected with the empty set is equivocal to set S \n" 
                +"𝑆\\∅ = 𝑆 \n\n" 
                +"Law 2.6.3: The empty set intersected with set S is equivocal to the empty set \n" 
                +"∅\\𝑆 = ∅ \n\n" 
                +"Law 2.6.4: The intersection of any set with itself is equal to the empty set \n" 
                +"𝑆\\𝑆 = ∅ \n\n" 
                +"Law 2.6.5: The difference in Set 𝑅 and the union or sets 𝑆 and 𝑇 is equivocal to the union of the difference in set 𝑅 and 𝑆 and 𝑅 and 𝑇. A similar propery holds for Intersection. \n" 
                +"𝑅\\(𝑆 ∪ 𝑇) = (𝑅\\𝑆) ∩ (𝑅\\𝑇) \n" 
                +"𝑅\\(𝑆 ∩ 𝑇) = (𝑅\\𝑆) ∪ (𝑅\\𝑇)");
        
        setTheoryTextHelp.put("⟺ Set Equality '\\iff'", "Law 2.7.1: When two different sets have exactly the same elements, they are equal \n" 
                +"𝑥 ∈ 𝑆 ⟺ 𝑥 ∈ 𝑇");

        setTheoryTextHelp.put("# Cardinality 'no short cut key required", "Law 2.8.1: the cardinality of the empty set is 0 \n" 
                +"#∅ = 0 \n\n"
                +"Law 2.8.2: the cardinality of the union of 𝑆 and 𝑇 is equal to the cardinality of 𝑆 minus the cardinality of the intersection of 𝑆 and 𝑇\n" 
                +"#(𝑆 ∩ 𝑇) = #𝑆 − #(𝑆\\𝑇) \n\n"
                +"Law 2.8.3: the cardinality of the union of S and T is equal to the cardinality of S plus the cardinality of T minus the cardinality of the intersection of S and T \n" 
                +"#(𝑆 ∪ 𝑇) = #𝑆 + #𝑇 − #(𝑆 ∩ 𝑇) \n\n" 
                +"Law 2.8.4: the Cardinality of the intersection of S and T is equal to the cardinality of S minus the cardinality of the intersection of S and T \n" 
                +"#(𝑆\\𝑇) = #𝑆 − #(𝑆 ∩ 𝑇)");
        
        setTheoryTextHelp.put("ℙ Power Sets '\\Pow'", "Law 2.9.1: Set S is an element of the power set of T if and only if S is a subset of T \n" 
                +"𝑆 ∈ ℙ 𝑇 ⟺ 𝑆 ⊆ 𝑇 \n\n" 
                +"Law 2.9.2: the empty set is an element of the power set of a any given set S \n" 
                +"∅ ∈ ℙ 𝑆 \n\n" 
                +"Law 2.9.3: for any given set S, S is an element of the power set of itself  \n" 
                +"𝑆 ∈ ℙ 𝑆 \n\n" 
                +"Law 2.9.4: the power set of set S is equal to two to the power of the cardinality of S \n" 
                +"#(ℙ 𝑆) = 2#(𝑆) \n\n" 
                +"Law 2.9.5: for a given set 𝑅 which is an element of the power set of 𝑆, it is always the case that the intersection of R and S is equal to 𝑅. Thus where 𝑅 ∈ ℙ𝑆  \n" 
                +"𝑅 ∩ 𝑆 = 𝑅");
        
        setTheoryTextHelp.put("− Compliment '\\comp'", "Law 2.10.1: for a given set 𝑇, which is an element of the power set of 𝑆, The compliment of 𝑇 is equal to the set difference in 𝑆 and 𝑇. Thus where 𝑇 ∈ ℙ𝑆 \n" 
                +"𝑇− = 𝑆\\𝑇 \n\n"
                +"Law 2.10.2: for a given set 𝑇, which is an element of the power set of 𝑆, The union of 𝑇 and its compliment is equal to the 𝑆. Thus where 𝑇 ∈ ℙ𝑆 \n" 
                +"𝑇 ∪ 𝑇− = 𝑆 \n\n" 
                +"Law 2.10.3 for a given set 𝑇, which is an element of the power set of 𝑆, The intersection of 𝑇 and its compliment is equal to the Ø. Thus where 𝑇 ∈ ℙ𝑆:  \n" 
                +"𝑇 ∩ 𝑇− = Ø");
        
        setTheoryTextHelp.put("Generalised Operations", "Law 2.11.1: (Generalised Union) - for any set of sets A and any element 𝑎,𝑎 ∈ ⋃𝐴 if, and only if, there is some set 𝑆 ∈ 𝐴 𝑠𝑢𝑐ℎ 𝑡ℎ𝑎𝑡 𝑎 ∈ 𝑆 \n" 
                +"a ∈ ⋃𝐴 ⟺ 𝑆 ∈ 𝐴|𝑎 ∈ 𝑆 \n\n" 
                +"Law 2.11.2: (Generalised Intersection) - for any set of sets A and any element 𝑎,𝑎 ∈ ⋂𝐴 if, and only if, for every set 𝑆 ∈ 𝐴 𝑖𝑡 𝑖𝑠 𝑡ℎ𝑒 𝑐𝑎𝑠𝑒 𝑡ℎ𝑎𝑡 𝑎 ∈ 𝑆 \n" 
                +"a ∈ ⋃𝐴 ⟺ {∀𝑆 ∈ 𝐴 |𝑎 ∈ 𝑆} ");
        
        setTheoryTextHelp.put("× Cartesian Products '\\car'", "2.12. Laws of Cartesian Products \n" 
                +"Law 2.12.1: the size of a Cartesian product s determined by the cardinality of the elements of the considered sets.  \n" 
                +"#(𝑆 × 𝑅) = #𝑋 × #𝑌");
        
        
        otherCharsTextHelp.put("ℕ The set of all Natural numbers '\\nat'", "\n");
        otherCharsTextHelp.put("ℤ The set of all Integers '\\zzz'", "\n");
        otherCharsTextHelp.put("ℝ The set of all Real numbers '\\rea'", "\n");
        otherCharsTextHelp.put("∀ Universal quantification (For all...) '\\for'", "\n");
        otherCharsTextHelp.put("∃ Existential quantification: (There exists...) '\\the'", "\n");
        otherCharsTextHelp.put("⦁ Z dot operator. Big Fat dot or 'give me' '\\bfd' or '\\giv'", "\n");
    }
    
    

    
    public LinkedHashMap<String, String> getHelpText() {
        return helpText;
    }

    public LinkedHashMap<String, String> getSetTheoryTextHelp() {
        return setTheoryTextHelp;
    }  

    public LinkedHashMap<String, String> getOtherCharsTextHelp() {
        return otherCharsTextHelp;
    }
    
    
    
}
