package business;

public class JUnitTesting {

	public int square(int nbr) {
		int ans = nbr*nbr;
		return ans;
	}
	
	public int countA(String str) {
		int count = 0;

	    for(int i=0; i < str.length(); i++)
	    {    if(str.charAt(i) == 'a' | str.charAt(i)=='A')
	            count++;
	    }

	    return count;
	}
}
