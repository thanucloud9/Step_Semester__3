```java
package week_5.assignment_problems;

class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}

public class MembershipFieldReach {

    public static String classifyAccess(
            String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        if (fieldModifier.equals("private")) {
            return accessorContext.equals("SAME_CLASS")
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("default")) {
            return (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE"))
                    ? "ALLOWED" : "DENIED";
        }

        if (fieldModifier.equals("protected")) {
            return (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE"))
                    ? "ALLOWED" : "DENIED";
        }

        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        StringBuilder result = new StringBuilder();

        for (String[] attempt : attempts) {
            if (attempt == null || attempt.length < 2) {
                continue;
            }

            String modifier = attempt[0];
            String context = attempt[1];
            String access = classifyAccess(modifier, context);

            if (result.length() > 0) {
                result.append("\n");
            }

            result.append(modifier)
                  .append(" | ")
                  .append(context)
                  .append(" | ")
                  .append(access);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"protected", "SUBCLASS"},
            {"public", "OTHER_PACKAGE"}
        };

        System.out.println(summarizeByModifier(attempts));
    }
}
```
