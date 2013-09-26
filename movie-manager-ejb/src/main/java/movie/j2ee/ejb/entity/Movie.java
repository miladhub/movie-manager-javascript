package movie.j2ee.ejb.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="movies")
@NamedQueries({
    @NamedQuery(
            name="movie-findByTitle",
            query="select mv from Movie mv where mv.title = :title"        
    )
})
public class Movie implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    
	private Long id;
	private String title;
	private Integer year;
	private String language;
	private Author author;
	private Category category;
		
	@Id
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getLanguage() {
        return language;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "COD_AUTHOR")
    public Author getAuthor() {
        return author;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="COD_CATEGORY")
    public Category getCategory() {
        return category;
    }
    
    public void setId(Long id) {
		this.id = id;
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

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String toString() {
    	return "Title: " + title +
    			", year: " + year +
    			", category: " + category;
    }
}
