

public class Character  implements Cloneable {
	private String name;
	private String title;
	private int price;
	private String role;
	private String releaseDate;
	
	/** Character(String name, String title, int price, String role, String releaseDate)
	 * 
	 * lists 5 attributes (at least 1 string and 1 numerical attribute)
	 * @param name
	 * @param title
	 * @param price
	 * @param role
	 * @param releaseDate
	 * 
	 */
	
	public Character(String name, String title, int price, String role, String releaseDate) {
		this.name = name;
		this.title = title;
		this.price = price;
		this.role = role;
		this.releaseDate = releaseDate;
	}
	
	/** getName()
	 * 
	 * @return name			Returns name of Character
	 * 
	 */
	
	public String getName() {
		return name;
	}
	
	/** setName()
	 * 
	 * @param newName 	Sets a new Name for Character
	 * 
	 */
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	/** getTitle()
	 * 
	 * @return title		Returns name of the Character Title.
	 * 
	 */
	
	public String getTitle() {
		return title;
	}
	
	/** setTitle()
	 * 
	 * @param newTitle 		Sets a new Title for Character
	 * 
	 */
	
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	
	/** getPrice
	 * 
	 * @return price		Returns the Price of the Champion
	 * 
	 */
	
	public int getPrice() {
		return price;
	}
	
	/** setPrice()
	 * 
	 * @param newPrice		Sets a new Price for Character
	 * 
	 */
	
	public void setPrice(int newPrice) {
		this.price = newPrice;
	}
	
	/** getRole
	 * 
	 * @return role			Returns the Main role of the Champion
	 * 
	 */
		
	public String getRole() {
		return role;
	}
	
	/** setRole()
	 * 
	 * @param newRole 		sets new Role for Character
	 * 
	 */
	
	public void setRole(String newRole) {
		this.role = newRole;
	}
	
	/** getReleaseDate()
	 * 
	 * @return releaseDate 	Returns the Release Date of the Character
	 * 
	 */
		
	public String getReleaseDate() {
		return releaseDate;
	}
	
	/** setReleaseDate()
	 * 
	 * @param newReleaseDate 	Sets a new Release Date for Character
	 * 
	 */
	
	public void setReleaseDate(String newReleaseDate) {
		this.releaseDate = newReleaseDate;
	}
	
	/** toString()
	 * 
	 * Converts object to String
	 * @return attributes as concatenated string
	 * 
	 */
	
	public String toString() {
		return "Name: " + name + "\nTitle: " + title + "\nPrice: " + price +  " IP" + "\nMain Role: "  + role + "\nDate Released: " + releaseDate + "\n";
	}
	
	/** equals(Object obj)
	 * 
	 * @param obj		Compares Character object.
	 * @return 			true if names are equal.
	 * 					false if names are not equal.
	 */
	
	 public boolean equals(Object obj) {
		if(obj instanceof Character) {
			Character item = (Character) obj;
			return(this.name.equalsIgnoreCase(item.name));
		}else
			return false;
	}
	 
	 /**  clone()
	  * 
	  * Creates and returns a clone of a character object
	  * 
	  */
	 
	 public Character clone() { //Clone a character Object
		 Character mimic;
		 try {
			 mimic = (Character) super.clone();
		 }
		 catch (CloneNotSupportedException e) {
			 throw new RuntimeException
			 ("This Character Item clone attempt does not implement Clonable");
		 }
		 return mimic;
	 }
	 
	 public int compareTo(Character c) {
		 return this.name.compareToIgnoreCase(c.name);
	 }

}


