
public class KalkulasiPecahan {
	Pecahan jawaban=new Pecahan(0,0);
	
	KalkulasiPecahan(Pecahan p1, Pecahan p2,String operasi) {
		switch (operasi) {
        case "*":
            jawaban=perkalianPecahan(p1,p2);
            break;
        case "/":
            jawaban=pembagianPecahan(p1,p2);
            break;
        case "+":
            jawaban=pertambahanPecahan(p1,p2);
            break;
        case "-":
        	jawaban=penguranganPecahan(p1,p2);
        	break;
        default:
            System.out.println("no match");
        }
		
		reduce();
	}
	//get jawaban
	Pecahan getJawaban() {
		return this.jawaban;
	}
	
	//fungsi operasi
	Pecahan perkalianPecahan(Pecahan p1,Pecahan p2) {
		return new Pecahan(
				   p1.getAtas()*p2.getAtas(),p1.getBawah()*p2.getBawah()
	    );
	}
	
	Pecahan pembagianPecahan(Pecahan p1,Pecahan p2) {
		return new Pecahan(
				p1.getAtas()*p2.getBawah(),p1.getBawah()*p2.getAtas()
        );
	}
	
	Pecahan pertambahanPecahan(Pecahan p1,Pecahan p2) {
		if(p1.bawah!=p2.bawah) {
			int container=p1.bawah*p2.bawah;
			
			return new Pecahan(
					(p1.atas*(container/p1.bawah))+(p2.atas*(container/p2.bawah)),container);
		}else {
			return new Pecahan(p1.atas+p2.atas,p1.bawah);
		}
		
	}
	
	Pecahan penguranganPecahan(Pecahan p1,Pecahan p2) {
		if(p1.bawah!=p2.bawah) {
			int container=p1.bawah*p2.bawah;
			
			return new Pecahan(
					(p1.atas*(container/p1.bawah))-(p2.atas*(container/p2.bawah)),container);
		}else {
			return new Pecahan(p1.atas-p2.atas,p1.bawah);
		}
	}
	
	//fungsi memperkecil
	
	void reduce() {
        int gcd = gcd(Math.abs(jawaban.getAtas()), jawaban.getBawah());
        
        jawaban.setAtas(jawaban.getAtas()/gcd);
        jawaban.setBawah(jawaban.getBawah()/gcd);
    }
	
	 int gcd(int x, int y) {
	        while (y != 0) {
	            int temp = x % y;
	            x = y;
	            y = temp;
	        }
	        return x;
	    }
	
}
