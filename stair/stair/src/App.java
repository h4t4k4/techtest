public class App {
    public static void main(String[] args) throws Exception {
        cetakTangga(6);
    }

    public static void cetakTangga(Integer n){
		if(n>0 && n<=100){
			for(Integer i=1;i<=n;i++){
				for(Integer x=1;x<=(n-i);x++){
					System.out.print("  ");
				}
				for(Integer y=1;y<=i;y++){
					System.out.print(" #");
					if(y==i){
						System.out.println("");
					}
				}
			}
		}else{
            System.out.println("Angka berkisar 1-100");
        }
	}
}
