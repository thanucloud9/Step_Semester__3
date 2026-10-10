```java
package week_5.assignment_problems;

class LibraryMemberBean {
    private String membershipId = null;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMemberBean() {}

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (this.membershipId == null) {
            this.membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String answer) {
        this.securityAnswer = answer == null
                ? null
                : String.valueOf(answer.hashCode());
    }

    public boolean verifySecurityAnswer(String answer) {
        if (answer == null || securityAnswer == null) {
            return false;
        }
        return securityAnswer.equals(String.valueOf(answer.hashCode()));
    }
}

public class LibraryMemberBeanApp {
    public static void main(String[] args) {
        LibraryMemberBean member = new LibraryMemberBean();

        member.setMembershipId("LIB101");
        member.setMembershipId("LIB202");
        member.setName("Anu");
        member.setPremiumMember(true);
        member.setSecurityAnswer("blue");

        System.out.println("Membership ID: " + member.getMembershipId());
        System.out.println("Name: " + member.getName());
        System.out.println("Premium member: " + member.isPremiumMember());
        System.out.println("Correct security answer: "
                + member.verifySecurityAnswer("blue"));
        System.out.println("Incorrect security answer: "
                + member.verifySecurityAnswer("red"));
    }
}
```
