package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.lang.instrument.UnmodifiableClassException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {

    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }

    @Test
    public void selfTittleAlbums_shouldReturnAcollectionofSelfTittleAlbums_ifFound() {
        Collection<MusicItem> selfTitles = catalog.selfTittleAlbums();
        assertEquals(2,selfTitles.size());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void getAll_shouldReturnAnUnmodifiableCatalogCollection_shouldNotBeAbleTo_add_Clear_remove() {
        Collection<MusicItem> allItems = catalog.getAll();
        allItems.add(new MusicItem(1L, "Diva", "Annie Lennox", "1992-01-04", 13.99, MusicCategory.POP));
        allItems.remove(new MusicItem(1L, "Diva", "Annie Lennox", "1992-01-04", 13.99, MusicCategory.POP));
        allItems.clear();
    }

    @Test
    public void findByCategory_ShouldReturnPopulatedCollection_categoryFound() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        assertEquals(4,popItems.size());
    }

    @Test
    public void findByKeyword_keyWordShouldMatchTitleorArtistNameAndReturn_shouldNotBeCaseSensitive() {
        Collection<MusicItem> matches = catalog.findByKeyword("seal");
        for(MusicItem match: matches ) {
            if(match.getTitle().toLowerCase().equals("seal") ||
                    match.getArtist().toLowerCase().equals("seal")) {
                assertEquals(1,matches.size());
            }
        }
    }

    @Test
    public void findById_shouldReturnNull_idNotFound() {
        MusicItem item = catalog.findById(19L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItem_WthThatId_idFound() {
        MusicItem item = catalog.findById(6L);
        assertEquals(6,item.getId().longValue());
    }
}