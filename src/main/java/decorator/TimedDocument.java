package decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TimedDocument implements Document{
    private Document document;

    @Override
    public String parse() {
        long startTime = System.nanoTime();

        String parsed = document.parse();

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
        return parsed;
    }

    @Override
    public String getDocName() {
        return document.getDocName();
    }

    @Override
    public String getReadText() {
        return document.getReadText();
    }

    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }
}
