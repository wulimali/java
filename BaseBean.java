package testIterator;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseBean {
	private int id;
	private String name;
    private String url;
    
    public void setProperties(ResultSet rs) throws SQLException {
        setId(rs.getInt("id"));
        setName(rs.getString("name").trim());
        setURL(rs.getString("url").trim());
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}
}
