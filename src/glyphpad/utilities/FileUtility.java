/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glyphpad.utilities;

/**
 *
 * @author Justin McKeown
 */
public class FileUtility {
    
    
    public static String getDirectoryFromPath(String path){
        int last = path.lastIndexOf("\\");
        return path.substring(0,last);
        
    }
    
}
