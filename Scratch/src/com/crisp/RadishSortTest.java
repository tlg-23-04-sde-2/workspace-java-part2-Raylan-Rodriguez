package com.crisp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class RadishSortTest {

    public static void main(String[] args) {
        List<Radish> radishes = new ArrayList<>();
        radishes.add(new Radish("red",1.0, 2.2, 3)); //color,size, tailLength, guysOnTop
        radishes.add(new Radish("black",3.5, 0.0, 0));
        radishes.add(new Radish("red",0.75, 3.1, 7));
        radishes.add(new Radish("white", 1.0, 1.0, 2));

        radishes.sort(null);  //passing null means natural order.
        System.out.println("Natural order(size)");
        dump(radishes);
        System.out.println();

        radishes.sort(new RadishColorComparator());
        System.out.println("Color");
        dump(radishes);

        System.out.println("Sort by taiLength, via anonymous Comparator");
        radishes.sort(new Comparator<Radish>() {

            @Override
            public int compare(Radish r1, Radish r2) {
                return Double.compare(r1.getTailLength(), r2.getTailLength());

            }
        } );
        dump(radishes);
        System.out.println();

        System.out.println("sort by guysOnTop, via lambda");
        radishes.sort( (r1,r2) -> Integer.compare(r1.getGuysOnTop(),r2.getGuysOnTop()));
        dump(radishes);
        System.out.println();
    }

    private static void dump(List<Radish> radishList) {
        for(Radish radish : radishList) {
            System.out.println(radish);
        }
    }
}