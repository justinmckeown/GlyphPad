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

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Justin McKeown
 */
public class TextFormatUtility {
    
    public static Text headerText(String s){
        Text intro = new Text("\n"+s+"\n");
        intro.setFont(Font.font("Calibri", FontWeight.BOLD, 26));
        return intro;
    }
    
    public static Text bodyText(String s){
        Text body = new Text(s+"\n");
        body.setFont(Font.font("Calibri", FontWeight.MEDIUM, 24));
        return body;
        
    }
    
}
