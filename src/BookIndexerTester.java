/** @author Aiden Hyunseok Jung & Mingi Lee
 *  Department of Computer Science
 *  Grinnell College
 *  junghyun@grinnell.edu & leemingi@grinnell.edu
 *
 *  The BookeIndexerTest class reads the given paginated contents and creates
 *  the index for the book, using the HeadSubhead and BookIndexer classes.
 */


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class BookIndexerTester {
	
    /**
     * the main method for building
     * and displaying an index.
     * Here are the main steps:
     * 1. Create an instance of a class that stores 
     * the pairs of heading/sub-heading and page number.
     * 2. Create and initialize an instance of the 
     * BookIndexer class.
     * 3. Call the compileIndex method.
     * 4. Call the displayCompiledIndex method.
     */
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please, type the file path!");
			String filePath = sc.nextLine();
			TreeMap<HeadSubhead<String, String>, TreeSet<Integer>> index = new TreeMap<HeadSubhead<String, String>, TreeSet<Integer>>();
			BookIndexer bi = new BookIndexer(index);
			bi.compileIndex(new Scanner(new FileReader(filePath)));
			bi.displayCompiledIndex();
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("Error: The file does not exist!");
		}
	}

}
