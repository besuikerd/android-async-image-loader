package nl.besuikerd.imageloader.example;

public class TestReference {
	private String title;
	private String url;
	
	public TestReference(int id){
		this.title = "title " + id;
		this.url = "http://services.runescape.com/m=itemdb_rs/obj_big.gif?id=" + id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getUrl() {
		return url;
	}
}
