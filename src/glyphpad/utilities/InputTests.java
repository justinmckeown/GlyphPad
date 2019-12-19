/*
 * Copyright (C) 2019 Justin McKeown
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package glyphpad.utilities;

import java.util.ArrayList;

/**
 *
 * @author Justin McKeown
 */
public class InputTests {
    
       //TODO: These strings will do for now. However these actual test strign shoudl be renered from the Map keys in the GlyphStroe class...
       private static final String subscripts = "0123456789+-=()aeghklmnopstx"; 
       private static final String superscripts = "0123456789+-=()n";
    
    
    
    public static boolean subscriptText(String s){
        boolean inputIsLegal = true;
        for(int i = 0; i <s.length(); i++){
            for(int n = 0; n<subscripts.length(); n++){
                System.out.println("VALUE of S Char: "+s.charAt(i)+" VALUE of subscripts Char: "+ subscripts.charAt(n));
                if(!subscripts.contains(s.substring(i, (i+1)))){
                  inputIsLegal = false;
                }
            }
        }
        
        return inputIsLegal; 
    }
    
    
     public static boolean superscriptText(String s){
        boolean inputIsLegal = true;
        for(int i = 0; i <s.length(); i++){
            for(int n = 0; n<superscripts.length(); n++){
                System.out.println("VALUE of S Char: "+s.charAt(i)+" VALUE of subscripts Char: "+ superscripts.charAt(n));
                if(!superscripts.contains(s.substring(i, (i+1)))){
                  inputIsLegal = false;
                }
            }
        }
        
        return inputIsLegal; 
    }
    
}
