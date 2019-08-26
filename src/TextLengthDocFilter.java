import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;


public class TextLengthDocFilter extends DocumentFilter {
    private int maxTextLength;

    public TextLengthDocFilter(int maxTextLength) {
       this.maxTextLength = maxTextLength;
    }

    private boolean verifyText(String text) {
       return text.length() <= maxTextLength;
    }

  
    public void insertString(FilterBypass fb, int offset, String string,
             AttributeSet attr) throws BadLocationException {

       Document doc = fb.getDocument();
       String oldText = doc.getText(0, doc.getLength());
       StringBuilder sb = new StringBuilder(oldText);
       sb.insert(offset, string);

       if (verifyText(sb.toString())) {
          super.insertString(fb, offset, string, attr);
       }

    }

    
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
             throws BadLocationException {
       Document doc = fb.getDocument();
       String oldText = doc.getText(0, doc.getLength());
       StringBuilder sb = new StringBuilder(oldText);

       sb.replace(offset, offset + length, text);
       if (verifyText(sb.toString())) {
          super.replace(fb, offset, length, text, attrs);
       }
    }

    
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
       Document doc = fb.getDocument();
       String oldText = doc.getText(0, doc.getLength());
       StringBuilder sb = new StringBuilder(oldText);

       sb.replace(offset, offset + length, "");

       if (verifyText(sb.toString())) {
          super.remove(fb, offset, length);            
       }
    }
 }