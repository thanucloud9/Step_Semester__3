```java
package week_5.assignment_problems;

import java.util.Arrays;

class LoanReceipt {
    protected final String memberId;
    protected final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds != null
                ? Arrays.copyOf(bookIds, bookIds.length)
                : new String[0];
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newIds = getBookIds();
        newIds[index] = newId;
        return new LoanReceipt(this.memberId, newIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds) {
        super(memberId, bookIds);
    }

    @Override
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        throw new UnsupportedOperationException(
                "Reference-only receipts cannot be modified."
        );
    }
}

public class LoanReceiptApp {
    public static void main(String[] args) {
        String[] ids = {"B101", "B102"};

        LoanReceipt receipt = new LoanReceipt("M001", ids);
        System.out.println("Original book IDs: "
                + Arrays.toString(receipt.getBookIds()));

        LoanReceipt corrected = receipt.withCorrectedBookId(0, "B999");
        System.out.println("Corrected book IDs: "
                + Arrays.toString(corrected.getBookIds()));

        ReferenceOnlyLoanReceipt reference =
                new ReferenceOnlyLoanReceipt("M002", ids);

        System.out.println("Reference-only book IDs: "
                + Arrays.toString(reference.getBookIds()));
    }
}
```
