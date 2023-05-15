/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;
import java.util.List;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        //testFindById();
        //testFindByKeyword();
         //testFindByCategory();
        //testSize();
        testGetAll();
        //testSelfTittleAlbums();
        //testItemsAtSpecifiedPrice();
        //testGenreCount();
        //testAveragePrice();
        //testCheapestItemInCategory();
        //testAveragePriceOfGenre();
        //testIsAllGreaterOrEqualTen();
        //testDoWeSellItem();
        //testAllPopItemsInNaturalOrder();
    }

    private static void testAllPopItemsInNaturalOrder() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        List<String> popTittle = catalog.allPopItemsInNaturalOrder();
        System.out.println(popTittle);
    }

    private static void testDoWeSellItem(){
        InMemoryCatalog catalog = new InMemoryCatalog();
        boolean doWeSell = catalog.doWeSellItem(MusicCategory.POP);
        System.out.println("Do we sell it? " + doWeSell);
    }

    private static void testIsAllGreaterOrEqualTen() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        boolean isGreaterThanTen = catalog.isAllGreaterOrEqualTen();
        System.out.println("Are all items priced at least $10? " + isGreaterThanTen);
    }

    private static void testAveragePriceOfGenre() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        double average = catalog.averagePriceOfGenre(MusicCategory.POP);
        System.out.println("the average price of the collection is: " + average);
    }

    private static void testCheapestItemInCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> cheaper = catalog.cheapestItemInCategory(MusicCategory.CLASSICAL);
        dump(cheaper);
    }

    private static void testAveragePrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        double average = catalog.averagePrice();
        System.out.println("the average price of the collection is: " + average);
    }

    private static void testGenreCount(){
        InMemoryCatalog catalog = new InMemoryCatalog();
        int count = catalog.genreCount(MusicCategory.BLUES);
        System.out.println(count);
    }

    private static void testItemsAtSpecifiedPrice() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> cheapItem = catalog.getItemsAtSpecifiedPrice(16);
        dump(cheapItem);
    }

    private static void testSelfTittleAlbums() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> selfTittle = catalog.selfTittleAlbums();
        dump(selfTittle);
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem itemFound = catalog.findById(6L);
        System.out.println(itemFound);

        MusicItem itemNotFound = catalog.findById(19L);
        System.out.println(itemNotFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.findByKeyword("Seal");
        dump(items);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> items = catalog.findByCategory(MusicCategory.POP);
        dump(items);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Integer size = catalog.size();
        System.out.println(size);
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> allItems = catalog.getAll();
        //allItems.clear();  //No, throws Unsupported operationException
        dump(allItems);
    }
    //helper method to dump a collection<MusicItem> "Vertically"
    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item : items) {
            System.out.println();
            System.out.println(item);
        }
    }
}