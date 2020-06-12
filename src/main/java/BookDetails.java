public class BookDetails {
    private String name;
    private String author;
    private String place;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPlace() {
        return place;
    }



    BookDetails(String name, String author, String place){
        this.name = name;
        this.author = author;
        this.place = place;
    }

    @Override
    public String toString() {
        return "Book: " + name  + ";" +"\n"+
                "Author: " + author  + ";"+"\n"+
                "Place: " + place;
    }
}
