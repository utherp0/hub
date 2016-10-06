package org.uth.hub.currency;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Entry class for Hub components. 
 * @author Ian 'Uther' Lawson
 */
public class Entry 
{
  private long _created = 0; // UTC time of creation
  private long _modified = 0; // UTC time of modification
  private URL _url = null; // URL
  private String _uuid = null; // Unique ID
  private String _name = null; // Name of entry
  private String _text = null; // Additional text of entry (for searching)
  private List<String> _tags = null; // Tags of entry (for searching)
  private List<String> _categories = null; // Categories of entry (for searching)
  private String _location = null; // Location of entry in hub - uuid of parent leaf
  
  public Entry( URL url, String name, String text, String location, long creation )
  {
    _created = creation;
    _modified = creation;
    
    _url = url;
    _name = name;
    _text = text;
    _location = location;
    
    _tags = new ArrayList<>();
    _categories = new ArrayList<>();
    
    _uuid = Entry.getUUID();
  }
  
  public String getName() { return _name; }
  public String getText() { return _text; }
  public String getLocation() { return _location; }
  public long getCreated() { return _created; }
  public long getModified() { return _modified; }
  public URL getURL() { return _url; }
  public List<String> getTags() { return _tags; }
  public List<String> getCategories() { return _categories; }
  public String getID() { return _uuid; }
  
  private static String getUUID()
  {
    return UUID.randomUUID().toString();
  }  
  
  public void setModified( long modified )
  {
    _modified = modified;
  }
  
  public void setModified()
  {
    _modified = System.currentTimeMillis();
  }
  
  public boolean hasTag( String tag )
  {
    return _tags.contains(tag);
  }
  
  public boolean hasCategory( String category )
  {
    return _categories.contains(category);
  }
  
  public void setLocation( String location )
  {
    _location = location;
  }
  
  public boolean addTag( String tag )
  {
    if( _tags.contains(tag)) return false;
    
    _tags.add(tag);
    return true;
  }
  
  public boolean addCategory( String category )
  {
    if( _categories.contains(category)) { return false; }
    
    _categories.add(category);
    return true;
  }

  public boolean removeTag( String tag )
  {
    if( !( _tags.contains(tag))) return false;
    
    _tags.remove(tag);
    
    return true;
  }
  
  public boolean removeCategory( String category )
  {
    if( !( _categories.contains(category))) return false;
    
    _categories.remove(category);
    
    return true;
  }  
}
