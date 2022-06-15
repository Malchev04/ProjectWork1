package pr.pkg21_malchev_projectwork1;


import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class TextPresets {
    
    public static SimpleAttributeSet getSimpleText(){
        SimpleAttributeSet simpleTextSet = new SimpleAttributeSet();
        return simpleTextSet;
    }
    
    public static SimpleAttributeSet getRedText(){
        SimpleAttributeSet redTextSet = new SimpleAttributeSet();
        StyleConstants.setForeground(redTextSet, new Color(204,0,0));
        return redTextSet;
    }
    
    public static SimpleAttributeSet getGreenText(){
        SimpleAttributeSet greenTextSet = new SimpleAttributeSet();
        StyleConstants.setForeground(greenTextSet, new Color(15, 66, 22));
        return greenTextSet;
    }
    
    public static SimpleAttributeSet getOrangeText(){
        SimpleAttributeSet greenTextSet = new SimpleAttributeSet();
        StyleConstants.setForeground(greenTextSet, new Color(204,138,39));
        return greenTextSet;
    }
    
    public static SimpleAttributeSet getOrangeItalic(){
        SimpleAttributeSet orangeItalicSet = new SimpleAttributeSet();
        StyleConstants.setItalic(orangeItalicSet, true);
        StyleConstants.setForeground(orangeItalicSet, new Color(204,138,39));
        return orangeItalicSet;
    }
    
    public static SimpleAttributeSet getItalic(){
        SimpleAttributeSet italicTextSet = new SimpleAttributeSet();
        StyleConstants.setItalic(italicTextSet, true);
        return italicTextSet;
    }
    
    public static SimpleAttributeSet getBold(){
        SimpleAttributeSet boldTextSet = new SimpleAttributeSet();
        StyleConstants.setBold(boldTextSet, true);
        return boldTextSet;
    } 
    
    public static SimpleAttributeSet getBoldRed(){
        SimpleAttributeSet boldRedTextSet = new SimpleAttributeSet();
        StyleConstants.setBold(boldRedTextSet, true);
        StyleConstants.setForeground(boldRedTextSet, new Color(204,0,0));
        return boldRedTextSet;
    } 
}
