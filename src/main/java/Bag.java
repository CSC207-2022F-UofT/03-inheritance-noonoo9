/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */

    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;

    /*
     * TODO: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[numberOfContents];
    }


    /*
     * TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */

    public String getColor() {
        return this.color;
    }

    public int getNumberOfContents() {
        return this.numberOfContents;
    }

    public int getCapacity() {
        return this.capacity;
    }


    /*
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     */

    public void setColor(String color) {
        this.color = color;
    }

    /*
     * TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     */

    public boolean addItem(String add_item) {
        if (this.numberOfContents < this.capacity) {
            // add item to bag
            // - create a new array with a length one greater than the contents
            String[] new_contents = new String[numberOfContents + 1];
            // - add all the old contents of the bag into the new array
            for (int i=0; i < numberOfContents; i++) {
                new_contents[i] = this.contents[i];
            }
            // - add the new item at the end of the array (last spot)
            new_contents[numberOfContents + 1] = add_item;
            // set old contents to equal new contents
            this.contents = new_contents;
            // increase number of contents by one
            this.numberOfContents += 1;
            return true;
        } else {
            return false;
        }
    }


    /**
     * TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     * If there are no items in this Bag, return null.
     *
     * @return
     */
    public String popItem() {
        // store last item
        String last_item = this.contents[numberOfContents];
        // create new array with one less of original content's length
        String[] new_contents = new String[numberOfContents - 1];
        // store old contents items in until before the last item
        for (int i=0; i < numberOfContents - 2; i++) {
            new_contents[i] = this.contents[i];
        }
        // set new contents to equal old contents
        this.contents = new_contents;
        // reduce number of contents by one
        this.numberOfContents -= 1;
        // return last item
        return last_item;
    }


    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        this.capacity += n;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}