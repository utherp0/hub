package org.uth.hub.tests;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.uth.hub.currency.Entry;
import org.uth.hub.currency.Descriptor;
import org.uth.hub.currency.Leaf;

/**
 * CLI Test for command line interactions.
 * @author Ian 'Uther' Lawson
 */
public class CLITest 
{
  private List<Leaf> _tree = new LinkedList<>();
  private List<Entry> _entries = new LinkedList<>();
  
  public static void main( String[] args )
  {
    new CLITest();
  }
  
  public CLITest()
  {
    Scanner input = new Scanner( System.in );
    
    String command = input.nextLine();
    
    while( !( command.equalsIgnoreCase("quit") && !( command.equalsIgnoreCase("q"))))
    {
      switch( command.toLowerCase() )
      {
        case "reset" :
        case "re" :
        {
          _tree = new LinkedList<>();
          _entries = new LinkedList<>();
          
          Leaf root = new Leaf( new Descriptor( "root" ));
          Leaf unassigned = new Leaf( new Descriptor( "unassigned" ));
          
          _tree.add(root);
          _tree.add(unassigned);
        }
      }
    }
  }
}
