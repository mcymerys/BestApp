package pl.mcymerys.best.model;


public class ResultDTO {
	private String authorFirstName;
	private String authorLastName;
	private String categoryName;
	private Long bookCount;

	public ResultDTO() {
	}

	public ResultDTO(String authorFirstName, String authorLastName, String categoryName, Long bookCount) {
		this.authorFirstName = authorFirstName;
		this.authorLastName = authorLastName;
		this.categoryName = categoryName;
		this.bookCount = bookCount;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getBookCount() {
		return bookCount;
	}

	public void setBookCount(Long bookCount) {
		this.bookCount = bookCount;
	}
}
