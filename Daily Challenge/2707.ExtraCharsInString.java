// 2707. Extra Characters in a String

// ======== Date: 23/09/2024 ===============


// You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

// Return the minimum number of extra characters left over if you break up s optimally.

 

// Example 1:

// Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
// Output: 1
// Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

// Example 2:

// Input: s = "sayhelloworld", dictionary = ["hello","world"]
// Output: 3
// Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 

// Constraints:

// 1 <= s.length <= 50
// 1 <= dictionary.length <= 50
// 1 <= dictionary[i].length <= 50
// dictionary[i] and s consists of only lowercase English letters
// dictionary contains distinct words


class Node
{
    Node[] links;
    boolean flag;
    Node()
    {
        links=new Node[26];
        flag=false;
    }
} 
class Trei
{
    Node root;
    Trei()
    {
     root=new Node();
    }
    public void insert(String str)
    {
        Node curr=root;
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(curr.links[c-'a']==null)
            {
                Node temp=new Node();
                curr.links[c-'a']=temp;
            }
            curr=curr.links[c-'a'];
        }
        curr.flag=true;
    }

    public int match(String str,int index)
    {
        Node curr=root;
        int i=index;
        int currmatch = -1;

    for( i=index;i<str.length();i++)
       {
        char c=str.charAt(i);
        if(curr.links[c-'a']==null)
        {
        break;
        } 
            
        curr=curr.links[c-'a'];
        if( curr.flag==true) currmatch=i+1;
       }      
       return currmatch;
    }

}
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trei tr=new Trei();

        for(int i=0;i<dictionary.length;i++)
        {
            tr.insert(dictionary[i]);
        }

        int i=0;
        int count=0;

        while(i<s.length())
        {
            int index=tr.match(s,i);
            if(index ==-1 )
            {
             count++;
               System.out.println(count+" "+i); 
             i++;
            }
            else
            {
                i=index;
            }
        }
        return count;
    }
}