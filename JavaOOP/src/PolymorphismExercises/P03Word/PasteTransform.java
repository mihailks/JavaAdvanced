package PolymorphismExercises.P03Word;

public class PasteTransform implements TextTransform {
    private Clipboard clipboard;

    public PasteTransform(Clipboard clipboard) {
        this.clipboard = clipboard;
    }
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            String clipboard = this.clipboard.getCurrentText();
            text.replace(startIndex, endIndex, clipboard);
    }
}
