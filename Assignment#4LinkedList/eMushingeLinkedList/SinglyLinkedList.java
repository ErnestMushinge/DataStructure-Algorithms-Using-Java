
/*Name: Ernest Mushinge
 * Date: 2/28/2016
 * Course#: IT 2660
 * Assignment#: 4
 *
 *.  
 */
public class SinglyLinkedList
{  
	
	private Node h;  // list header

//Class Constructor
    public SinglyLinkedList()
    {  h = new Node();  // dummy node
        h.l = null;
        h.next = null;
    }
    
    //Insert method
    public boolean insert(Listing newListing) // only accepts Listing objects
    {  Node n = new Node();
        if(n == null) // out of memory
           return false;
        else
        { n.next = h.next; //The value of next of "n node" = next of h node(linked to net of dummy)
           h.next = n;//next of h node is now equal to n node
           n.l = newListing.deepCopy();//l of n node is equal to newListing.deepCopy() that returns a clone//This is the inserted object
           return true;
        }
   }
    
    //Listing Fetch method//
public Listing fetch(String targetKey)
 {  Node p = h.next;
     while (p != null  &&  !(p.l.compareTo(targetKey) == 0))
     {  p = p.next;
     }
     if(p != null)
        return p.l.deepCopy();
     else
        return null;
  }

//delete
  public boolean delete(String targetKey)
  {  Node q = h;
      Node p = h.next;
      while (p != null && !(p.l.compareTo(targetKey) == 0))
      {  q = p;
          p = p.next;
      }
      if(p != null)
      {   q.next = p.next;
           return true;
      }
      else
           return false;
  }
  
  
  //update String targetKey with Listing newListing
  public boolean update(String targetKey, Listing newListing)
  {  if(delete(targetKey) == false)
         return false;
      else if(insert(newListing) == false)
        return false;
      return true;
  }
  
  //showAll
  public void showAll()
  { Node p = h.next;
     while (p != null) //continue to traverse the list
     {   System.out.println(p.l.toString( ));
          p = p.next;
     }
   }
  
  //Class Node
  public class Node
  {  private Listing l;
      private Node next;
      public Node()
     {
     }
   }// end of inner class Node
}//end SinglyLinkedList outer class

