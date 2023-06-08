package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {

    @Test
    public void compareWithMin() {
        Ticket ticket1 = new Ticket("DME", "LED", 8700, 5, 11);
        Ticket ticket2 = new Ticket("DME", "LED", 4300, 6, 8);

        int expected = -1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareWithMax() {
        Ticket ticket1 = new Ticket("DME", "LED", 8700, 5, 11);
        Ticket ticket2 = new Ticket("DME", "LED", 4300, 6, 8);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareWithAverage() {
        Ticket ticket1 = new Ticket("DME", "LED", 5000, 5, 11);
        Ticket ticket2 = new Ticket("DME", "LED", 5000, 6, 8);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToOrderingAll() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("DME", "LED", 8700, 5, 11);
        Ticket ticket2 = new Ticket("DME", "LED", 4300, 6, 8);
        Ticket ticket3 = new Ticket("DME", "LED", 4390, 8, 9);
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        Ticket[] order = avia.search("DME", "LED");

        Ticket[] expected = {ticket2, ticket3, ticket1};
        Ticket[] actual = order;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareToOrdering() {
        AviaSouls avia = new AviaSouls();
        Ticket ticket1 = new Ticket("DME", "LED", 8700, 5, 11);
        Ticket ticket2 = new Ticket("DME", "LED", 4300, 6, 8);
        Ticket ticket3 = new Ticket("DME", "OVB", 9390, 4, 9);
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        Ticket[] order = avia.search("DME", "LED");

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = order;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparatorToMinOneTime() {
        TicketTimeComparator timeComp = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("DME", "LED", 6700, 4, 6);
        Ticket ticket2 = new Ticket("DME", "LED", 4300, 5, 9);

        int expected = -1;
        int actual = timeComp.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparatorToMinTwoTime() {
        TicketTimeComparator timeComp = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("DME", "LED", 6700, 5, 8);
        Ticket ticket2 = new Ticket("DME", "LED", 4300, 7, 9);

        int expected = 1;
        int actual = timeComp.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparatorToAverageTime() {
        TicketTimeComparator timeComp = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("DME", "LED", 6700, 5, 8);
        Ticket ticket2 = new Ticket("DME", "LED", 4300, 7, 10);

        int expected = 0;
        int actual = timeComp.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void comparatorSearchAndSort() {
        AviaSouls avia = new AviaSouls();
        TicketTimeComparator timeComp = new TicketTimeComparator();
        Ticket ticket1 = new Ticket("DME", "LED", 6700, 5, 8);
        Ticket ticket2 = new Ticket("DME", "LED", 9900, 7, 9);
        avia.add(ticket1);
        avia.add(ticket2);
        Ticket[] order = avia.searchAndSortBy("DME", "LED", timeComp);

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = order;

        Assertions.assertArrayEquals(expected, actual);
    }

}

