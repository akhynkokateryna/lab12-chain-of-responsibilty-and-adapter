package decorator;


public interface Document {
    String readText = "";
    String docName = "";
    String gcsPath = "";
    String parse();
    String getDocName();
    String getReadText();
    String getGcsPath();
}
