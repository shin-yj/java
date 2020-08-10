import java.sql.PreparedStatement;

public interface Connectionion {

	PreparedStatement prepareStatement(String sql);

	void close();

}
