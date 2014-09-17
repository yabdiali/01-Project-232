/** Characters
 * 
 * Program that stores Characters represented from League of Legends.
 * 
 * @author Cassidy Halvorson
 *		   Due: Sept. 10 2014
 *
 *Source: GroceryList.java 		by Sue Fitzgerald 
 *
 */

public class CharacterList {
	private int numItems;
	private Character[] characterListArray;
	private Character ci;
	
	/** CharacterList()
	 *  creates an empty Character List
	 */
	
	CharacterList() {
		numItems = 0; 
		characterListArray = new Character[30];
	}
	
	/** addCharacter(Character item)
	 * Adds Character to array
	 * @param item
	 */
	
	public void add(Character item) {
		characterListArray[numItems ++] = new Character(item.getName(), item.getTitle(), item.getPrice(), item.getRole(), item.getReleaseDate());
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
	
	public Character searchForCharacter(String n) {
		int i = 0;	
			while(i < numItems) {			
				if(characterListArray[i].equals(new Character(n, " ", 0, " ", " "))) {
					return characterListArray[i];
				}
			}
		return null; 
	}
	
	/** removeCharacterFromList(String n)
	 * 
	 * @param name of item to match
	 * @return false if item was not found
	 * 		   true is item was found and remove item from Array.
	 * 
	 */
	
	public boolean removeCharacterFromList(String n) { //(String n) { //Swap method
		int i = 0;
		Character ci = searchForCharacter(n);
		while ((i < numItems) && (ci != characterListArray[i])) 
			i++;
			if (i == numItems) 
				return false;
			 else {
				numItems--;
				characterListArray[i] = characterListArray[numItems];
				return true;
			 }	
	}
	
	/** remove(Character item)
	 * 
	 * @param item 	removes a Character from Array
	 * 
	 */
	
	public void remove(Character item) {
		//Character ci = new Character;
		   // characterListArray[numItems] = characterListArray[numItems-1];
		   // numItems--;
		//for (int i = 0; i < item.length; i++) {
			//item[i] = null;
		ci = item;
		characterListArray[numItems --] = this.ci;
	//	}
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
		Character ciTemp = (Character) ci.clone();
		this.remove(ci);
		ciTemp.setName(name);
		ciTemp.setTitle(title);
		ciTemp.setPrice(price);
		ciTemp.setRole(role);
		ciTemp.setReleaseDate(releaseDate);
		this.add(ciTemp);
		}
}


	




