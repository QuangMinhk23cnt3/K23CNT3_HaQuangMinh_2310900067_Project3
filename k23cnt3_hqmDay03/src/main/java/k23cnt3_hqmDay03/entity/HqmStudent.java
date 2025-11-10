package k23cnt3_hqmDay03.entity;

public class HqmStudent {
    long hqmId;
    String hqmName;
    int hqmAge;
    boolean hqmGender;
    String hqmAddress;
    String hqmPhone;
    String hqmEmail;

    public HqmStudent() {
    }

    public HqmStudent(long hqmId, String hqmName, int hqmAge, boolean hqmGender, String hqmAddress, String hqmPhone, String hqmEmail) {
        this.hqmId = hqmId;
        this.hqmName = hqmName;
        this.hqmAge = hqmAge;
        this.hqmGender = hqmGender;
        this.hqmAddress = hqmAddress;
        this.hqmPhone = hqmPhone;
        this.hqmEmail = hqmEmail;
    }

    public long getHqmId() {
        return hqmId;
    }

    public void setHqmId(long hqmId) {
        this.hqmId = hqmId;
    }

    public String getHqmName() {
        return hqmName;
    }

    public void setHqmName(String hqmName) {
        this.hqmName = hqmName;
    }

    public int getHqmAge() {
        return hqmAge;
    }

    public void setHqmAge(int hqmAge) {
        this.hqmAge = hqmAge;
    }

    public boolean isHqmGender() {
        return hqmGender;
    }

    public void setHqmGender(boolean hqmGender) {
        this.hqmGender = hqmGender;
    }

    public String getHqmAddress() {
        return hqmAddress;
    }

    public void setHqmAddress(String hqmAddress) {
        this.hqmAddress = hqmAddress;
    }

    public String getHqmPhone() {
        return hqmPhone;
    }

    public void setHqmPhone(String hqmPhone) {
        this.hqmPhone = hqmPhone;
    }

    public String getHqmEmail() {
        return hqmEmail;
    }

    public void setHqmEmail(String hqmEmail) {
        this.hqmEmail = hqmEmail;
    }
}
