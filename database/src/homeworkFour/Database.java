package homeworkFour;

import java.util.*;
/** Xavier Routh
 * Databse class that stores data and has methods to search and sort it
 * @param <T> The type of element we are going to store in our database
 * @author Xavier Routh
 */
public class Database<T extends DatabaseType> {
    // Stores the different indexes
    private Hashtable<String, ArrayList<T>> indexHashtable;
    // Main linked list that will store our data
    private LinkedList<T> linkedList;
    // Field that stores the size of our database
    private int numElements;
    /** Constructor
     * Sets up the fields to their correct values
     */
    public Database() {
        this.linkedList = new LinkedList<>();
        this.indexHashtable = new Hashtable<String, ArrayList<T>>();
    }
    /** Adds an element to the database
     * @param element the element to add to the database
     */
    public void add(T element) {
        this.indexHashtable.clear();
        linkedList.addLast(element);
        this.incrementElements(1);
    }
    /** Deletes all of a certain element from the database
     * @param element The element to delete from the database
     */
    public void delete(T element) {
        Iterator<T> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == element) {
                iterator.remove();
                this.indexHashtable.clear();
                this.incrementElements(-1);
            }
        }
    }
    /** Returns the number of elements stored in the database
     * @return the size of the database
     */
    public int size() {
        return numElements;
    }
    /**
     * @param comparator Comparator used to determine if two <T> objects are equal
     * @param value The value that we are looking for
     * @return A list of all the elements that match the value
     */
    public LinkedList<T> lookupInList(Comparator<T> comparator, T value) {
        ListIterator<T> listIterator = linkedList.listIterator();
        LinkedList<T> output = new LinkedList<>();
        // Uses an iterator to loop through the list, adds all elements that it
        // finds to the output list
        while (listIterator.hasNext()) {
            if (comparator.compare(listIterator.next(), value) == 0) {
                output.addLast(listIterator.previous());
            }
        }
        return output;
    }
    /** Looks up in an already sorted index for faster searching
     * @param index The index we are looking through
     * @param comparator Comparator used to see if the value is equal to the trait
    of the element
     * @param value value that we are looking for
     * @return A linked list of the elements that match our input value
     */
    public LinkedList<T> lookupInIndex(ArrayList<T> index, Comparator<T>
            comparator, T value) {
        LinkedList<T> output = new LinkedList<>();
        ListIterator<T> listIterator =
                index.listIterator(Collections.binarySearch(index, value, comparator));
        // Loop through the elements starting with the first one we found using our
        // search
        while (listIterator.hasNext()) {
            if (comparator.compare(listIterator.next(), value) == 0) {
                output.addLast(listIterator.previous());
            }
        }
        return output;
    }
    /** Makes an index using a comparator specific to the type of data we are
     storing
     * @param trait The trait to sort the index by
     */
    public void makeIndex(String trait) {
        if (!linkedList.isEmpty()) {
            // Comparator used to sort our data
            Comparator<T> comparator = (Comparator<T>)
                    linkedList.getFirst().getComparatorByTrait(trait);
            ArrayList<T> newIndex = new ArrayList<T>(this.numElements);
            // Copy the elements addresses into a new Index
            ListIterator<T> listIterator = linkedList.listIterator();
            for (int i = 0; i < this.size(); i++) {
                newIndex.set(i, listIterator.next());
            }
            // Sort the new index using our comparator
            newIndex.sort(comparator);
            indexHashtable.put(trait, newIndex);
        }
    }
    /** Looks up in the database specific elements by trait
     * @param trait The trait we are looking at
     * @param value The value of the trait
     * @return Returns a linked list with all the elements containing the correct
    value of the trait.
     */
    public LinkedList<T> lookup(String trait, T value) throws Exception {
        if (indexHashtable.containsKey(trait)) {
            return this.lookupInIndex(indexHashtable.get(trait), (Comparator<T>)
                    value.getComparatorByTrait(trait), value);
        } else if (!indexHashtable.containsKey(trait)) {
            return lookupInList((Comparator<T>) value.getComparatorByTrait(trait),
                    value);
        } else if (linkedList.isEmpty()) {
            return new LinkedList<>();
        } else throw new Exception(); // We should never get here hopefully
    }
    /** Creates or gets an index for the trait specified
     * @param trait the trait we are searching for an index for
     * @return Returns a list if there is an index for the trait already
     */
    public ArrayList<T> getList(String trait) {
        if (linkedList.isEmpty()) {
            return new ArrayList<>();
        }
        else if (indexHashtable.containsKey(trait)) {
            return indexHashtable.get(trait); }
        else if (!indexHashtable.containsKey(trait)) {
            makeIndex(trait);
            return indexHashtable.get(trait);
        }
        else return null;
    }
    /** Helper method to change the size of numElements when adding or deleting
     from the database
     * @param change the amount to increment by
     */
    public void incrementElements(int change) {
        this.numElements += change;
    }
}