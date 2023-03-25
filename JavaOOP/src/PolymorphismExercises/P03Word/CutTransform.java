package PolymorphismExercises.P03Word;

public class CutTransform implements TextTransform {
    private Clipboard clipboard;
    public CutTransform(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        String cutResult = text.substring(startIndex, endIndex);
        this.clipboard.setCurrentText(cutResult);
        text.replace(startIndex, endIndex, "");
    }
}
