//github.com/torukoseki
import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ScrapperMain {

    public static void main(String[] args) throws IOException {
    	// TODO Auto-generated method stub
    	Scanner scanner = new Scanner(System.in);
        String repeating;
		//Getting input from user 
        do{System.out.println("Enter a car brand: ");
        String brand = scanner.next();
        System.out.println("Do you want to see detailed info? : (Yes/No) ");
        String detail = scanner.next();
        
    	//Defining and connecting to the url
        String url = "https://www.arabam.com/ikinci-el?searchText="+brand;
        Document document = Jsoup.connect(url).timeout(6000).get();
        //Selection of all elements
        Elements listing = document.select(".listing-list-item.should-hover.bg-white");
        //Header and some messages for end user
        System.out.println("Please wait...");
        System.out.println("SEARCHING AND SCRAPING FOR YOU\n");
        System.out.println("@ Brand  @ @ Year/Price @");
        //Loops each element in the listing
        for(org.jsoup.nodes.Element ls : listing) {
        	//Extracts title and price and then transforms into text
            String titleSrc = ls.select(".listing-text-new.word-break.val-middle.color-black2018").text();
            //Changes results according to the user's choice
            if(detail.equalsIgnoreCase("yes")) {
            String modelYr = ls.select(".fade-out-content-wrapper").text();
            System.out.println(titleSrc + " - " + modelYr);
            }
            else {
            String priceSrc = ls.select(".db.no-wrap.listing-price").text();
            System.out.println(titleSrc + " - " + priceSrc);
            
            }
        }
        System.out.println("\n --- Do you want another search? (yes/no) --- ");
        repeating = scanner.next();
        }while(repeating.equalsIgnoreCase("yes"));
        //Program ends message
        System.out.println("\ngithub.com/torukoseki - Web Scraper");
    }
}
