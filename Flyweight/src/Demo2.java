import java.util.ArrayList;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        FormattedText ft = new FormattedText("What a wonderfull life");
        ft.capitalize(1, 10);
        System.out.println(ft.toString());
        BetterFormattedText bft = new BetterFormattedText("Make everything awesome");
        bft.getRange(10,20).capitalize = true;
        System.out.println(bft);
    }
}

class FormattedText {
    private String plainText;
    private boolean[] capitalize;

    public FormattedText(String plainText) {
        this.plainText = plainText;
        capitalize = new boolean[plainText.length()];
    }

    public void capitalize(int start, int end) {
        for (int i = start; i <= end; ++i) {
            capitalize[i] = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            sb.append(capitalize[i] ? Character.toUpperCase(c) : c);
        }
        return sb.toString();
    }
}

class BetterFormattedText {
    private String plainText;
    private List<TextRange> formattion = new ArrayList<>();

    public BetterFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange textRange = new TextRange(start, end);
        formattion.add(textRange);
        return textRange;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            for (TextRange range : formattion) {
                if (range.covers(i) && range.capitalize) {
                    c = Character.toUpperCase(c);
                }
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public class TextRange {
        public int start, end;
        public boolean capitalize, bold, italic;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }
    }
}
