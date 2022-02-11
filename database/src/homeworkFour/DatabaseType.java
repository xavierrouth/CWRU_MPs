package homeworkFour;
import java.util.Comparator;
/** Interface that all types that we store in our database implement
 * @author Xavier Routh
 */
public interface DatabaseType {
    /**
     * @param trait Trait of the type
     * @return A comparator used to compare and sort indexes
     */
    public Comparator<? extends DatabaseType> getComparatorByTrait(String trait);
}
