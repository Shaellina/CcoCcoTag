package basic.exam;

public class ConversionTest {
	public static void main(String[] args) {
		// 자동 형변환이 가능
		// 잃을 값이 없기 때문이다.
		double d = 10; // 자동 형변환 ( 묵시적 형변환 )
		System.out.println(d);

		// 잃을 값이 있기 때문에 에러가 난다.
		int i = (int) 3.14; // 강제 형변환 ( 명시적 형변환 )
		
		System.out.println((int)(Math.random()*12+4));
		System.out.println((int)(Math.random()*17+6)*100);
	}
	
//	조건문
//	if / else
//	switch / case
	
//	반복문
//	for
//	while
//	do / while
	
//	분기문
//	break
//	continue
//	return
}
