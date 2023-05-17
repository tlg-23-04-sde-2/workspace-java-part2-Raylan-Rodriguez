/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import com.entertainment.Television;

import javax.swing.*;

public class CatalogTest {

    @Test
    public void findByBrands_shouldReturnPopulatedMap_whenBrandsPassed() {
        Map<String,Collection<Television>> tvMap = Catalog.findByBrands("Sony", "No-Matches");

        assertEquals(2,tvMap.size());
        //check the "sony" row.
        Collection<Television> sonyTvs = tvMap.get("Sony");
        assertEquals(7, sonyTvs.size());
        for(Television tv : sonyTvs) {
            assertEquals("Sony", tv.getBrand());
        }
        //check the no-Matches row
        Collection<Television> noMatchesTvs = tvMap.get("No-Matches");
        assertTrue(noMatchesTvs.isEmpty());
    }

    @Test
    public void findByBrands_shouldReturnEmptyMap_whenNoBrandsPassed() {
        Map<String,Collection<Television>> tvMap = Catalog.findByBrands();
        //dont need both, jay prefers isEmpty()
        assertEquals(0, tvMap.size());
        assertTrue(tvMap.isEmpty());
    }

    @Test
    public void findByBrand_shouldReturnPopulatedCollection_whenMatchFound() {
        Collection<Television> tvs = Catalog.findByBrand("Sony");
        assertEquals(7, tvs.size());
        for (Television tv : tvs) {
            assertEquals("Sony", tv.getBrand());
        }
    }

    /**
     * Contract: a no-matches result should be an empty collection (not null).
     */
    @Test
    public void findByBrand_shouldReturnEmptyCollection_whenNoMatchFound() {
        Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
        assertNotNull(tvs);
        assertTrue(tvs.isEmpty());
    }
}