package movie;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

	private String title;
	private Integer year;
	private String language;
	private String author;
	private String category;

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String toString() {
    	return "Title: " + title +
    			", year: " + year +
    			", category: " + category;
    }
}
