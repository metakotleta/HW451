import java.time.Instant;

public class Call implements Comparable<Call> {

    private String phoneNumber;
    private Instant callTime;

    public Call(String phoneNumber) {
        callTime = Instant.now();
        this.phoneNumber = phoneNumber;
    }

    public Instant getCallTime() {
        return callTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(Call o) {
        return this.callTime.compareTo(o.callTime);
    }
}
