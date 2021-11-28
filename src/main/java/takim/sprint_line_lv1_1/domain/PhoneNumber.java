package takim.sprint_line_lv1_1.domain;

public class PhoneNumber {
    private long id;
    private String name;
    private int phoneNumber;

    public PhoneNumber(long id, String name, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderContentIndex() {
        return phoneNumber;
    }

    public void setOrderContentIndex(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
