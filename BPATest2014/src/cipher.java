public class cipher {
//
// This method takes the ciphertext character and the key character and converts it to plain text.
// @param key a character of the key
// @param code a character of ciphertext
// @return <br />the plain text character

public char convert(char key, char code){
return sub(key,code);
}
private static char sub(char a, char b){ //calc a-b
 int ia=a, ib=b;
 if(ia<=ib) ia+=26;
 return (char) ('A'-1 +(ia-ib));
 }
}
