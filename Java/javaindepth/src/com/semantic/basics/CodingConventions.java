public class Namingconventions {
	public void namingConventions() {}
}

/* naming conventions are two types
11.Typographical ~ appearance  --> lower and uppercase
22.Grammatical   ~ parts of speech  --> verb,noun,adj etc..

			11.Typographical ~ packages
			  1.Always use Lowecase alphabetic characters,rarely digits.
			  2.generally Short(<8 chars) & Single word
			  3.Meaningful abbreviations, e.g., util for utilities.
			  4.Acronyms are fine, e.g., awt for abstarct window toolkit
			  5.Never start with java or javax
				 
				 6.IMPORTANT: Use organization's reverse internet domain name. e.g., tcs.com
				 
				 
			2.Typographical ~ Case
			   1.Class
				  --> Capitalize first letter of each word, e.g., BufferedWriter
			   2.Methods & variables
				  --> Camel-Case, e.g., getArea,studentCount
			   3.static final variables
				  --> All caps with underscore  separating values
					  --> static final int COPY_THRESHOLD = 10;
					  
			3.Typographical ~ Abbreviations
			   1.Class,methods, and Fields
				  --> Avoid abbreviations except commonly used like min/max
				  --> Acronyms are fine, e.g., HttpUrl
			   2. Loacl Variables
				  --> Abbreviations & acronyms are fine
				  --> Meaningful individual characters are fine
					 --> x,y,z for co-ordinates
					 --> i for index
				  
				  
				  
22.Grammatical ~ Classes
   1. Singualr noun or noun phrase
      --> e.g., User,BufferedWriter
	  --> Simple & descriptive
	  
   2.Grammatical ~ Methods
      1.performing action
	    --> verb or verb phrase
		--> e.g., append or calculateDistance
		--> Use descriptive names
		--> Don't hesitate to use longer names
	  2.boolean return type
	    --> is followed by noun or noun phrase or adjective
		     e.g., noun -> isDigit
			 e.g., adjective -> isEmpty
			 e.g., isActive & setActive
		--> Sometimes, has is used, e.g., hasLicense
		
	  3.Non -boolean attribute of object
	    --> Noun or noun  phrase, e.g., gender,hashCode
		--> getAttribute if there is setter, e.g., getGender
		         action - verb
		--> returning boolean - is followed by noun/adj/boolean attribute name
		
	   4. Grammatical ~ Fields
	    --> Boolean
		   -> Usually, adjectives
		   -> active instead of isActive
		--> Non-Boolean
		   -> nouns or noun phrases
		--> Singular & plural nouns, e.g., item vs list
		--> Name objects of same class by purpose
		   -> void sendMessage(User sender,User receiver)
		
*) Special Methods

	1.Object type conversions
	   --> toType, e.g., toString,toArray
	2.Static factory methods
	   -->valueOf, of, getInstance, newInstance, getType, newType 
	   
	   
*/
		  