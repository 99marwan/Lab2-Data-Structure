package eg.edu.alexu.csd.datastructure.hangman.cs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class IMP implements IHangman {
	
    public String[] words = new String[10000];
    private String[] dictionary;
    public  int i;
    private String member;
    private String member1;
    private char[] word;
    public int count=1;
    public int wrong;
    
    
    
    public void read(){
    	i=0;
    	BufferedReader objReader = null;
		  try {
		   String strCurrentLine;

		   objReader = new BufferedReader(new FileReader("C:\\Users\\smart\\eclipse-workspace\\IHangman\\bin\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\cs\\file.txt"));

		   while ((strCurrentLine = objReader.readLine()) != null) {

			   words[i]=strCurrentLine;
			    i++;
		   }
		  } catch (IOException e) {

		   e.printStackTrace();
		  } 
		  finally {
		   try {
		    if (objReader != null)
		     objReader.close();
		   } catch (IOException ex) {
		    ex.printStackTrace();
		   }
		  }
    }
	@Override
	public void setDictionary(String[] words) {
		dictionary = new String[i];
		for(int j=0;j<i;j++) {
			dictionary[j]=words[j];	
		}
		}
	 

	@Override
	public String selectRandomSecretWord() {
		Random r=new Random();
	    int rNumber=r.nextInt(i);	
     /*   System.out.println(dictionary[rNumber]);*/
        member = dictionary[rNumber];
        member1=member.toLowerCase();
		return dictionary[rNumber];
	}
	
	
	public void setWord() {
		word = new char[member1.length()];
		for(int m=0;m<member1.length();m++){
			word[m]='-';}
	}
	@Override
	public String guess(Character c) throws Exception{
		
		if(member1.matches("[a-zA-Z]*$")){
			String word1 = null;
			int q=1;
			c=Character.toLowerCase(c);
			if(wrong!=0 && count!=0) { 
				for(int b=0;b<member1.length();b++)
				{
					if(member1.charAt(b)==c) {
						word[b]=c;
						q=0;
					}
					
				}
				if(q==1) {
					wrong--;
				}
				word1=new String(word);
				System.out.println(word1);
				System.out.println("your life:"+wrong);
			}
			if(word1.equals(member1)) {
				System.out.println("You win");
				System.out.println("The word was"+member);
				count=0;
			}
			else if(wrong==0) {
				System.out.println("You lose");
				return null;
			}
			return word1;
		}
		
		else {
			throw new Exception("buggy secret word");
		}
		
	}
	
	@Override
	public void setMaxWrongGuesses(Integer max) {
		if(max==null)
			wrong=1;
		else
			wrong=max;
	}
	
}
