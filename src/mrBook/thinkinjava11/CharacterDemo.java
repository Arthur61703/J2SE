package mrBook.thinkinjava11;

public class CharacterDemo {

	public static void main(String[] args) {
		//���ַ���װ���ַ����󣬶���������Լ�����Щ���������ü��ɣ��������˼��
		String str = "adhugna dj235//.,.;adf52532755finda";
		char[] cha = str.toCharArray();
		int spaceCount=0;
		int alphabelCount=0;
		int otherCharacter=0;
		int digitCount=0;
		for(int i = 0; i<cha.length;i++){
			if(Character.isSpace(cha[i])){
				spaceCount++;
			}else if(Character.isAlphabetic(cha[i])){
				alphabelCount++;
			}else if(Character.isDigit(cha[i])){
				digitCount++;
			}else{
				otherCharacter++;
			}
		}
		System.out.println(spaceCount+"---"+alphabelCount+"---"+digitCount+"---"+otherCharacter);

	}

}
