/** @author Aiden Hyunseok Jung & Mingi Lee
 *  Department of Computer Science
 *  Grinnell College
 *  junghyun@grinnell.edu & leemingi@grinnell.edu
 *
 *  An object of the BookIndexer class builds and displays the index of notes.
 */


import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * BookIndexer class builds and display 
 * the index of notes.
 */
public class BookIndexer {
	/**
	 * declare a field for storing 
	 * the pairs of heading/sub-heading 
	 * and page number.
	 * heading/sub-heading are Strings. 
	 * page number is Integer. 
	 */

	/* We use a TreeMap for the index to sort HeadSubheads and to map HeadSubheads to page numbers
	 * We use a TreeSet for page numbers to sort them and to prevent duplicate ones.
	 */
	
	 private TreeMap<HeadSubhead<String, String>, TreeSet<Integer>> index;
	
	/**
	 * a constructor that initializes
	 * the field that stores pairs as mentioned above. 
	 * @param an instance of the class that stores
	 * the pairs of heading/sub-heading and page
	 * numbers. 
	 */
	public BookIndexer(TreeMap<HeadSubhead<String, String>, TreeSet<Integer>> index) {	
		this.index = index;
	}
	
	/**
	 * a method that reads through notes and builds an index
	 * 
	 * @param sc a Scanner object for reading from a file containing notes.
	 */
	
	public void compileIndex(Scanner sc) {
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			//Four cases when the line may not have the right structure
			if (!line.contains(":")) {
				System.err.println(line + " (Error: A line does not have a colon!)");
			}else if(!line.matches("(.*)\\:\\s\\S(.*)")) {
				System.err.println(line + " (Error: There is no space after colon or there are more than one space after colon!)");
			}else if (!line.matches("(.*)\\s[A-Z](.*)")) {
				System.err.println(line + " (Error: A heading does not start with an uppercase letter!)");
			}else if (line.contains("/") && !line.matches("(.*)\\/[a-z](.*)")) {
				System.err.println(line + " (Error: A sub-heading does not start with a lowercase letter!)");
			}
			else {
				HeadSubhead<String, String> hs = new HeadSubhead<String, String>();
				HeadSubhead<String, String> head = new HeadSubhead<String, String>();
				String[] lineSplited;
				
				//Split the line depending on whether it has a sub-heading or not.
				if (!line.contains("/")) {
					lineSplited = line.split("\\:\\s");
					hs.set(lineSplited[1], "");
				} else {
					lineSplited = line.split("\\:\\s|\\/");
					head.set(lineSplited[1], "");
					hs.set(lineSplited[1], lineSplited[2]);
				}
				
				/* If the headSubhead(key) already exists in the map,
				 *         the page number is added to the set(value).
				 * If not, a new set is created, the page number is added to the set,
				 *         and the headSubhead(key) and the new set(value) are put into the map.
				 */
				if (index.containsKey(hs)) {
					index.get(hs).add(Integer.parseInt(lineSplited[0]));
				} else {
					TreeSet<Integer> page = new TreeSet<Integer>();
					page.add(Integer.parseInt(lineSplited[0]));
					index.put(hs,page);
					
					/*If the headSubhead has a sub-heading and the key with only heading does not exist in the map,
					 *     a empty set is created, and headSubhead without sub-heading and the empty set are put into the map.    
					 */
					if(lineSplited.length == 3 && !index.containsKey(head)) {
						TreeSet<Integer> empty = new TreeSet<Integer>();
						index.put(head, empty);
					}
				}
			}
		}
	}
	
	/**
	 * a method that displays an index.
	 * @param an instance of the class that stores the
	 * pairs of heading/sub-heading and page number 
	 */	
	public void displayCompiledIndex() {
				
		for (HeadSubhead<String, String> hs : index.keySet()) {
			
			//Print out the headings and the sub-headings
			if(hs.getSubHead() == "")
				System.out.print(hs.getHead());
			else
				System.out.print("    " + hs.getSubHead());	
				
			//Print out the page numbers
			for (int page : index.get(hs))
				System.out.print(", " + page);
			
			//Print out the new line
			System.out.println();
		}
	}
	
	/**
	 * define a method that returns an instance of
	 * the class that stores the pairs of heading/sub-heading 
	 * and page number
	 * @return an instance of the class that stores the
	 * pairs of heading/sub-heading and page number  
	 */		
	
	public TreeMap<HeadSubhead<String, String>, TreeSet<Integer>> getIndex(){
		return index;
	}
}