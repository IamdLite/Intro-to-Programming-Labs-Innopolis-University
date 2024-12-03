import java.util.*;

/**
 * Chargeable interface describes charging in smart devices
 * no attributes only methods
 */

 public interface Chargeable{

    public boolean isCharging();
    public boolean startCharging();
    public boolean stopCharging();

 }