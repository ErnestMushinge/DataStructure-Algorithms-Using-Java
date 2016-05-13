/*Name: Ernest Mushinge
 * Date: 04/21/2016
 * Course#: IT 2660
 * Assignment#: 7
 *
 *This program performs insertion, fetch, delete and update of nodes in a binary tree data structure keeps 
 * 
 */
public class BinaryTreeWithLNRTraversal
{  
	//The root node
	TreeNode root;
	//Constructor
   public BinaryTreeWithLNRTraversal()
   { //initialize root to null
	   root = null;
   }
   
   //Insert Algorithm
   public boolean insert(StudentClass newStudent)
   { TreeNodeWrapper p = new TreeNodeWrapper();
      TreeNodeWrapper c = new TreeNodeWrapper();
      TreeNode n = new TreeNode();
      if(n == null) // out of memory
          return false;
      else  // insert the node
      { n.node = newStudent.deepCopy(); // copy the node as a leaf node
         n.lc = null;
         n.rc = null;
        if(root == null) // tree is empty
        {   root = n;  }
        else
        {  findNode(newStudent.getKey(), p, c ); // find the new node's parent
            if(newStudent.getKey().compareTo(p.get().node.getKey( )) < 0) // insert at right
                 p.get().lc = n;
            else
                 p.get().rc = n;
         }
         return true;
      }
   } //end insert method
   
   public StudentClass fetch(String targetKey)
   { boolean found;
      TreeNodeWrapper p = new TreeNodeWrapper();
      TreeNodeWrapper c = new TreeNodeWrapper();
      found =  findNode(targetKey, p, c); // insert the new leaf node
      if(found == true)
        return c.get().node.deepCopy();
      else
        return null;
   }// end of fetch method
   
   public boolean delete(String targetKey)
   { boolean found;
      TreeNodeWrapper p = new TreeNodeWrapper();
      TreeNodeWrapper c = new TreeNodeWrapper();
      //to store the largest node child of the root or parent to be deleted
      TreeNode largest; 
      //to store the next largest child of the parent to be deleted
      TreeNode nextLargest;
      found =  findNode(targetKey, p, c);
      if(found == false) // node not found
         return false;
      else
      { if(c.get().lc == null && c.get().rc == null) // case 1: deleted node has no children
        { if(p.get().lc == c.get()) // deleted node is a left child
              p.get().lc = null;
          else                      // deleted node is a right child
              p.get().rc = null;
        }// end case 1
       else if(c.get().lc == null || c.get().rc == null) // case 2: delete node has one child
       { if(p.get().lc == c.get()) //deleted node is a left child
          { if(c.get().lc != null) // deleted node has a left child
                p.get().lc = c.get().lc;
            else
                p.get().lc = c.get().rc;
          }
          else                     // deleted node is a right child
          { if(c.get().lc != null) // deleted node has a left child
                p.get().rc = c.get().lc;
             else
                p.get().rc = c.get().rc;
          }
       }// end case 2
       else // case 3: deleted node has two children
       {  nextLargest = c.get().lc;
           largest = nextLargest.rc;
           if(largest != null) // left child of deleted node has a right subtree
          {  while(largest.rc != null)  // move down the right edge of right subtree
             {  nextLargest = largest;
                 largest = largest.rc;
             }
             c.get().node = largest.node; // "copy" largest node's info into deleted node
             nextLargest.rc = largest.lc; // save left subtree of largest node
          }
          else         // left child of deleted node does not have a right subtree
          { nextLargest.rc = c.get().rc; // save the right subtree of the deleted node
             if(p.get().lc == c.get())   //deleted node is a left child
                p.get().lc = nextLargest;   // deleted node's parent jumps around deleted node
            else                        // deleted node is a right child
               p.get().rc = nextLargest;   // deleted node's parent jumps around deleted node
         }
       }// end of case 3
       return true;
     }
   }// end of delete method
   
   //Update Method
   public boolean update(String targetKey, StudentClass newStudent)
   {  if(delete(targetKey) == false)
           return false;
       else if(insert(newStudent) == false)
           return false;
        return true;
   }//end of update
   
   //Inside class class. This is implemented
   //so the BinaryTreeWithLNR can access this
   //class's members
   public class TreeNode
   {  private StudentClass node;
       private TreeNode lc;
       private TreeNode rc;
       public TreeNode()
      {
      }
   }// end of class TreeNode
   
   
   //This method is implemented in a recursive way so it keeps on 
   //Traversing the tree if a node is not found
   private boolean findNode(String targetKey, TreeNodeWrapper parent,
                                               TreeNodeWrapper child)
   {  parent.set(root);
       child.set(root);
       if(root == null) // tree is empty
           return true;
      while(child.get( ) != null)
      { if(child.get( ).node.compareTo(targetKey) == 0) // node found
            return true;
         else
         {  parent.set(child.get( ));
             if(targetKey.compareTo(child.get( ).node.getKey( )) < 0)
                 child.set(child.get( ).lc);
             else
                 child.set(child.get( ).rc);
         }
       }// end while
       return false;
   } // end of findNode
   
   //TreeNodWrapper is implemented to allow a method to return a changed
   //value via a parameter
   public class TreeNodeWrapper
   { TreeNode treeRef = null;
   
   //constructor
      public TreeNodeWrapper()
      {
      }
      
      //TreeNode get()
      public TreeNode get()
      { return treeRef;
      }
      //TreeNode set()
      public void set(TreeNode t)
      { treeRef = t;
      }
   }
   
   // end of class TreeNodeWrapper
 /*  
   //THIS IS WHERE I HAVE TO CHANGE TO IMPLEMENT RNL
   public void LNRoutputTraversal(TreeNode root)
   {  if(root.lc != null)
        LNRoutputTraversal(root.lc);  // traverse the entire left subtree
      System.out.println(root.node.toString());  // output the root node
      if(root.rc != null)
        LNRoutputTraversal(root.rc);  // traverse the entire right subtree
   } //end of LNRoutputTraversal method
   */
   
   //I HAVE TO IMPLEMENT RNL
   public void RNLoutputTraversal(TreeNode root)
   {  if(root.rc != null)
        RNLoutputTraversal(root.rc);// traverse the entire left subtree
      System.out.println(root.node.toString());  // output the root node
      if(root.lc != null)
        RNLoutputTraversal(root.lc);  // traverse the entire right subtree
   } //end of LNRoutputTraversal method

   public void showAll( )
   {  if(root == null)  // check for an empty tree
        System.out.println("the structure is empty");
      else
       // LNRoutputTraversal(root);
    	  RNLoutputTraversal(root);
  } // end of showAll method
}//end class BinaryTreeWithLNRTraversal


