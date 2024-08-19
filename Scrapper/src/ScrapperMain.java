//github.com/torukoseki
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ScrapperMain {

    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
    	
    	//Defining and connecting to the url
        String url = "https://www.arabam.com/ikinci-el?searchText=duster";
        Document document = Jsoup.connect(url).timeout(6000).get();
        //Selection of all elements
        Elements listing = document.select(".listing-list-item.should-hover.bg-white");
        //Header and some messages for end user
        System.out.println("Please wait...");
        System.out.println("SEARCHING AND SCRAPING FOR YOU\n");
        System.out.println("@ Brand  @ @ Price @");
        //Loops each element in the listing
        for(org.jsoup.nodes.Element ls : listing) {
        	//Extracts title and price and then transforms into text
            String titleSrc = ls.select(".listing-text-new.word-break.val-middle.color-black2018").text();
            String priceSrc = ls.select(".db.no-wrap.listing-price").text();
            //Prints the findings
            System.out.println(titleSrc + " - " + priceSrc);
        }
        //Program ends message
        System.out.println("\nMy Car Com - Web Scraper");
    }
}
