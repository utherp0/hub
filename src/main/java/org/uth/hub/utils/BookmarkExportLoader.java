package org.uth.hub.utils;

import java.util.HashMap;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.uth.hub.exceptions.LoaderException;

/**
 * Loader for extracting and providing link information from an HTML export file.
 * @author Ian Lawson
 */
public class BookmarkExportLoader 
{
  private Map<String,String> _links = null;
  
  public BookmarkExportLoader()
  {
  }
  
  /**
   * Load meythod. Uses the JSoup library to handle broken HTML and get the links.
   * @param htmlFileName file to extract links from
   * @throws LoaderException if the file cannot be loaded
   */
  public void load( String htmlFileName ) throws LoaderException
  {
    _links = new HashMap<>();
    String contents = FileUtils.loadString(htmlFileName);
    
    if( contents == null )
    {
      throw new LoaderException( "Unable to load file contents, check " + htmlFileName );
    }
    
    Document document = Jsoup.parse(contents);
      
    Elements links = document.select("a[href]");
    for( Element link : links ) 
    {
      String href = link.attr("abs:href");
      String text = link.text();        
      _links.put(href, text);
    }  
  }
  
  /**
   * Links accessor.
   * @return the links currently in the Loader
   */
  public Map<String,String> getLinks()
  {
    return _links;
  }
}
