```java
package week_5.assignment_problems;

public class ReferenceDeskSubclass {

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
            if (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }

            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                return "ALLOWED";
            }

            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
                return "DENIED";
            }

            return "DENIED";
        }

        return "DENIED";
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            if (classifyAccess(attempts[i][0], attempts[i][1])
                    .equals("DENIED")) {
                return attempts[i][0] + " via "
                        + attempts[i][1]
                        + " (attempt #" + (i + 1) + ")";
            }
        }

        return "No denied attempts";
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"public", "OTHER_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"private", "SAME_PACKAGE"}
        };

        System.out.println("First denied attempt:");
        System.out.println(firstDeniedAttempt(attempts));
    }
}
```
