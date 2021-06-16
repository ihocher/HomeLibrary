import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestBookLibrary {
    @Test
    public void checkDBconnection(){

    }

    @Test
    public void CheckBooksInTheBase(){

        ArrayList<BookDetails> booksToCheck = new ArrayList<BookDetails>(){
            {
                add(new BookDetails("War and Peace","Lev Tolstoy","Vasyl"));
                add(new BookDetails("Red and black","Stendal","Home"));
                add(new BookDetails("The origin of spicies","Charles Darwin","Stepan"));
            }
        };

        for(int i =0;i<booksToCheck.size();i++) {
            GetBase dBase = new GetBase(booksToCheck.get(i).getName());
            dBase.start();
            try {
                dBase.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ArrayList<BookDetails> bookData = dBase.getBd();

            assertEquals(bookData.get(0).getName(), booksToCheck.get(i).getName());
            assertEquals(bookData.get(0).getAuthor(), booksToCheck.get(i).getAuthor());
            assertEquals(bookData.get(0).getPlace(), booksToCheck.get(i).getPlace());
        }
    }
}
