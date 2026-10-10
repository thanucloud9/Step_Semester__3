```java
package week_5.assignment_problems;

class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void checkIn() {
        if (copiesAvailable < copiesTotal) {
            copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }
}

public class BookInventoryApp {
    public static void main(String[] args) {
        BookInventory book = new BookInventory(5);

        book.checkOut();
        book.checkOut();
        System.out.println("Available after checkout: "
                + book.getCopiesAvailable());

        book.checkIn();
        System.out.println("Available after check-in: "
                + book.getCopiesAvailable());
    }
}
```
