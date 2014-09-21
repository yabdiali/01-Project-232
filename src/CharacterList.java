

public class CharacterList  { //implements Cloneable {
	private int numItems;
	private Character[] characterListArray;
	
	/** CharacterList()
	 *  creates an empty Character List and sets the Array at 10 item slots
	 */
	
	public CharacterList() {
		numItems = 0;
		final int INITIAL_CAPACITY = 10;
		characterListArray = new Character[INITIAL_CAPACITY];
	}
	
	/** CharacterList(int InitialCapacity) 
	 *  
	 * @param InitialCapacity
	 */
	
	public CharacterList(int initialCapacity) {
		if (initialCapacity < 0 ) {
			throw new IllegalArgumentException
			("initialCapacity is negatice: " + initialCapacity);
		}
		numItems = 0;
		characterListArray = new Character[initialCapacity];
	}
	
	/** addCharacter(Character item)
	 * Adds Character to array
	 * @param item
	 */
	
	public void add(Character item) {
		if (numItems == characterListArray.length) {
			ensureCapacity(numItems*2 + 1);
		}
		characterListArray[numItems ++] = new Character(item.getName(), item.getTitle(), item.getPrice(), item.getRole(), item.getReleaseDate());
	}
	
	public CharacterList clone() {
		CharacterList mimic;
		try {
			mimic = (CharacterList) super.clone();
		}
		catch (CloneNotSupportedException e) {
			throw new RuntimeException
			("This class CharacterList does not implement Cloneable");
		}
		mimic.characterListArray = characterListArray.clone();
		return mimic;
	}
	
	public void ensureCapacity(int minimumCapacity) {
		Character[] biggerArray;
		if (characterListArray.length < minimumCapacity) {
			biggerArray = new Character[minimumCapacity];
			System.arraycopy(characterListArray,  0,  biggerArray,  0 , numItems);
			characterListArray = biggerArray;
		}
	}
	
	public int getCapacity() {
		return characterListArray.length;
	}
	
	/** toString()
	 * 
	 * @return One String representing all of list
	 */
		
	public String toString() {
		String result = "";
		for (int i=0; i < numItems; i++) {
			result += characterListArray[i].toString() +"\n";
		}
		return result;
	}
	
	/** getList
	 * returns the list of all characters in Character List
	 * @return characterArray
	 */
	
	public Character[] getList() {
		return characterListArray;
	}
	
	/** ListSize
	 * Return number of items in character items
	 * @return int number of items in list
	 * 
	 */
	
	public int listSize() {
		return numItems;
	}
	
	/** searchForCharacter
	 * 
	 * @param name of item to match
	 * @return matching Character
	 * 
	 */
	
	
	public Character searchForCharacter(String name) {
		try {
			int i = 0;	
			boolean found = false;
			while((i < numItems) && !found) {			
				if(characterListArray[i].equals(new Character(name, " ", 0, " ", " "))) {
					found = true;			
				}
				else
						i++;
				}
			if (found) 
				return characterListArray[i];
			else
				return null;
			}catch (NullPointerException e) {
				throw new RuntimeException
				("Search for Character Broke");
			}
			catch (RuntimeException e) {
				throw new RuntimeException
				("Search Method Broke");
			}
		
	}
	
	/** removeCharacterFromList(String n)
	 * 
	 * @param name of item to match
	 * @return false if item was not found
	 * 		   true is item was found and remove item from Array.
	 * 
	 */
	
	public void removeCharacterFromList(String name) { 
		try{ 
			int i = 0;
			boolean found = false;
			while ((i < numItems) && !found) {
				if (characterListArray[i].equals(new Character(name, " ", 0, " ", " "))) {
					found = true;
				}
				else {
					i++;
				}
				if (found) 
					characterListArray[i] = characterListArray[--numItems];
			 }	
		}catch (NullPointerException e) {
			throw new RuntimeException
			("Search for Character Broke");
		}
		catch (RuntimeException e) {
			throw new RuntimeException
			("Search Method Broke");
		}
	}
	
	
	/** change
	 * Swaps old Character with new(updated) Character
	 * @param name			sets new name
	 * @param title			sets new title
	 * @param price			sets new price
	 * @param role			sets new role
	 * @param releaseDate	sets new release Date
	 */
	
	public void change(String name, String title, int price, String role, String releaseDate)  {
		Character ci = this.searchForCharacter(name);
		this.removeCharacterFromList(name);
		Character ciTemp = (Character) ci.clone();
		ciTemp.setName(name);
		ciTemp.setTitle(title);
		ciTemp.setPrice(price);
		ciTemp.setRole(role);
		ciTemp.setReleaseDate(releaseDate);
		this.add(ciTemp);
		}
	
	  public static void selectionSort(Character[] cl, int first, int n) { // fix into Objects
		 int i, j; // loop control variables
		 int big;  // Index of largest value in characterListArray[first] ... characterListArray[first+1]
		 Character temp; // Used during the swapping of two array values
		
		 for(i = n-1; i > 0; i--) {
			 big = first;
			 for(j = first + 1; j <= first + i; j++)
				 if (cl[big].compareTo(cl[j]) < 0)
					 big = j;
			 temp = cl[first + i];
			 cl[first + i] = cl[big];
			 cl[big] = temp;
		 }		 
	 } 
	 
}

	



	




