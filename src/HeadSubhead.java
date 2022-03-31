/** @author Aiden Hyunseok Jung & Mingi Lee
 *  Department of Computer Science
 *  Grinnell College
 *  junghyun@grinnell.edu & leemingi@grinnell.edu
 *
 *  An object of the HeadSubhead class represents the heading and sub-heading
 *  of a book index.
 */

/**
 * the declaration of a generic class that 
 * represents the heading and sub-heading of a book index.
 * Any two objects of this class need to be Comparable.
 * Note that headType and subheadType themselves need to
 * be Comparable too. 
 */
public class HeadSubhead<headType extends Comparable<headType>,
		subheadType extends Comparable<subheadType>> implements
		Comparable<HeadSubhead<headType, subheadType>>  {

	/**
	 * declare generic fields
	 */
	
	headType head;
	subheadType subhead;
	
	/**
	 * a method that sets fields.
	 * @param head heading of an entry
	 * @param subhead sub-heading of an entry
	 */
     public void set(headType head, subheadType subhead) {
    	 this.head = head;
    	 this.subhead = subhead;
     }
	
	/**
	 * a method that returns
	 * the heading.
	 * @return heading
	 */
     
     public headType getHead( ) {    	 
    	 return head;
     }
	
	/**
	 * a method that returns
	 * the sub-heading.
	 * @return sub-heading
	 */
     public subheadType getSubHead( ) {    	 
    	 return subhead;
     }  
     
	
	/**
	 * a method that compares two 
	 * objects of the HeadSubhead class.
	 * This method overrides the compareTo method.
	 * @param an instance of the HeadSubhead class
	 * @return an integer that indicates if 
	 * this object is alphabetically smaller, 
	 * larger, or equal to the object passed into
	 * the method.  
	 */
     
 	@Override
 	public int compareTo(HeadSubhead<headType, subheadType> hs) {
 		if(this.getHead().compareTo(hs.getHead()) > 0) {
 			return 1;
 		}else if(this.getHead().compareTo(hs.getHead()) < 0) {
			return -1;
 		}else {
 			if(this.getSubHead().compareTo(hs.getSubHead()) > 0) {
 	 			return 1;
 	 		}else if(this.getSubHead().compareTo(hs.getSubHead()) < 0) {
 				return -1;
 	 		}else {
 	 			return 0;
 	 		}
 		}
 	}   
     
}
