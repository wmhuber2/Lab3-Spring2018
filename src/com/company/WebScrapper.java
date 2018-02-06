package com.company;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScrapper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] args) {
        String toSearch="prince";
        String url="http://erdani.com/tdpl/hamlet.txt";
        String text = urlToString(url).toLowerCase().replace("\n"," ");
        System.out.println("Found "+(text.split(" ").length)+" Words");
        System.out.println("Found "+(text.split( " "+toSearch.toLowerCase()+" " ).length-1)+" Instances of '"+toSearch+"'");

        int numberUniqueWords=0;
        String text_copy = " "+text.replace("\t"," ");
        while (text_copy.indexOf("  ")!= -1){
            text_copy = text_copy.replace("  "," ");
        }

        while (text_copy.split(" ").length != 2){

            String[] words=text_copy.split(" ");

            System.out.println(text_copy.split(" ").length+" '"+words[1]+"'");

            text_copy=text_copy.replace(" "+words[1]+" "," ");
            numberUniqueWords++;

        }
        System.out.println("Found "+(numberUniqueWords)+" Unique Words");

    }
}
