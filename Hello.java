import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hello {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String[] nk = a.split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		System.out.println(출력(n, k));
	}
	static int 출력(int x, int y) {
		int count = 0;
		int time = 0;
		int num = 2;
		int[] index = new int[1002]; index[0]=0; index[1]=0;
		for(int i=2; i<1001; i++) {
			index[i] = i;
		}
		
		while(time<y) {
			int mul = 1;
			while(num*mul<=x) {
				if(index[num*mul]>0) {
					count = index[num*mul];
					index[num*mul]=0;
					mul++;
					time++;
					if(time==y)
						return count;
				}
				else {
					mul++;
				}
			}
			num=0;
			for(int j=0; j<=x; j++) {
				num = index[j];
				if(num>0)
					break;
			}
		}
		if(y==1)
			return 2;
		else
			return count;
	}
}