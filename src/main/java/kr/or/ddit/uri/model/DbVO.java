package kr.or.ddit.uri.model;

public class DbVO {
	private String uri;
	private String classname;
	
	public DbVO(String uri, String classname) {
		super();
		this.uri = uri;
		this.classname = classname;
	}
	
	public DbVO() {
		super();
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	@Override
	public String toString() {
		return "UriMappingVO [uri=" + uri + ", classname=" + classname + "]";
	}
}
