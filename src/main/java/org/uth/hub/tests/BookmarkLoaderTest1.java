package org.uth.hub.tests;

import java.util.Map;
import org.uth.hub.utils.BookmarkExportLoader;

/**
 * Test of the Bookmark Loader.
 * @author Ian Lawson
 */
public class BookmarkLoaderTest1 
{
  public static void main( String[] args )
  {
    if( args.length != 1 )
    {
      System.out.println( "Usage: java BookmarkLoaderTest1 targetFile" );
      System.exit(0);
    }
    
    new BookmarkLoaderTest1( args[0] );
  }
  
  public BookmarkLoaderTest1( String targetFile )
  {
    BookmarkExportLoader loader = new BookmarkExportLoader();
    
    long start = System.currentTimeMillis();
    
    try
    {
      loader.load(targetFile);    
      Map<String,String> links = loader.getLinks();
      long end = System.currentTimeMillis();
      
      System.out.println( "Found " + links.size() + " links in " + ( end - start ) + "ms.");
    }
    catch( Exception exc )
    {
      System.out.println( "Failed to perform load due to " + exc.toString());
    }
  }
}
