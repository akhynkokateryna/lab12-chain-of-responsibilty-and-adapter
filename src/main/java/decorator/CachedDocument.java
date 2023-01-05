package decorator;


public class CachedDocument implements Document{
    private final Document document;
    private final DBConnection dbConnection = DBConnection.getInstance();

    public CachedDocument(Document document) {
        this.document = document;
    }

    @Override
    public String parse() {
        String res = dbConnection.searchQuery("select * from document where name = '"  + document.getDocName() + "'");
        if (res!=null) {
            return res;
        } else {
            String parsed = document.parse();
            String query = "insert into document (name, readText) values ('" + document.getDocName() + "', '" + document.getReadText() + "')";
            dbConnection.executeQuery(query);
            return parsed;
        }
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
