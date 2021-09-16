import java.util.Scanner;

public class GradeStudent {
    public static int weightHomeWork = 100;

    public static void main(String[] args) {
        begin();
        double diemGiuaKy =midTerm();
        double diemCuoiKy = finalTerm();
        double diemThucHanh = homework();
        report(diemGiuaKy, diemCuoiKy, diemThucHanh);
    }
    public  static void begin(){
        System.out.println("Chào mừng bạn đến với chương trình tính điểm siêu hạng.\n Nhập vào điểm của bạn và tôi" +
                " sẽ trả lại kiết quả");
    }

    public static double midTerm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Diểm thi giữa kỳ của bạn: ");
        System.out.print("Hệ số (0 - 100):");
        int weightMid = sc.nextInt();
        while (weightMid > 100) {
            System.out.print("Nhập lại hệ số (0 - 100): ");
            weightMid = sc.nextInt();
        }
        weightHomeWork -= weightMid;

        System.out.print("Score earned: ");
        int scoreEarned = sc.nextInt();
        System.out.print("Điểm bạn có được tăng không? (1=yes) : ");
        int yesTermSum = sc.nextInt();
        if(yesTermSum == 1){
            System.out.print("Số điểm mà bạn được tăng là: ");
            int termSum = sc.nextInt();
            scoreEarned += termSum;
            if(scoreEarned > 100){
                scoreEarned = 100;
            }
        }
        System.out.println("Total points: " + scoreEarned);
        double weightScore = 1.0 * weightMid * scoreEarned / 100 ;
        System.out.println("Weighted score: " + weightScore +" / " + weightMid);
        System.out.println();
        return weightScore;
    }

    public static double finalTerm(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Diểm thi cuối kỳ của bạn: ");
        System.out.print("Hệ số (0 -" + weightHomeWork +"):");
        int weightFinal = sc.nextInt();
        while (weightFinal > weightHomeWork) {
            System.out.print("Nhập lại hệ số (0 -" + weightHomeWork + "): ");
            weightFinal = sc.nextInt();
        }
        weightHomeWork -= weightFinal;

        System.out.print("Score earned: ");
        int scoreEarned = sc.nextInt();
        System.out.print("Điểm bạn có được tăng không? (1=yes) ");
        int yesTermSum = sc.nextInt();
        if(yesTermSum == 1){
            System.out.print("Số điểm mà bạn được tăng là: ");
            int termSum = sc.nextInt();
            scoreEarned += termSum;
            if (scoreEarned > 100){
                scoreEarned = 100;
            }
        }
        System.out.println("Total points: " + scoreEarned);
        double weightScore = 1.0 * weightFinal * scoreEarned / 100 ;
        System.out.println("Weighted score: " + weightScore +" / " + weightFinal);
        System.out.println();
        return weightScore;
    }

    public static double homework(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Điểm bài tập về nhà ");
        System.out.println("Trọng số là : " + weightHomeWork);
        System.out.print("Số bài tập về nhà cần làm là: ");
        int numAsm = sc.nextInt();
        int[][] arrayTerm = new int[numAsm][2];
        for (int i = 0; i < numAsm; i++){
            System.out.print("Điểm và điểm tối đa bài thực hành " + (i +1) + " : ");
            arrayTerm[i][0] = sc.nextInt();
            arrayTerm[i][1] = sc.nextInt();
        }
        System.out.print("Số ngày điểm danh (nhỏ hơn 6): ");
        int diemDanh = sc.nextInt();
        System.out.println("Điểm chuyên cần : " + (diemDanh * 5) + "/ 30");
        int tongDiem = 0;
        int diemToiDa = 0;
        for(int i = 0; i < numAsm; i ++ ){
            tongDiem += arrayTerm[i][0];
            diemToiDa += arrayTerm[i][1];
        }
        tongDiem += (diemDanh * 5);
        diemToiDa += 30;

        double diemThucHanh = 1.0 * tongDiem * weightHomeWork / diemToiDa;

        System.out.println("Tổng điểm bài thực hành là : " + tongDiem + " / " +diemToiDa + " = " + diemThucHanh + "/" + weightHomeWork );
        System.out.println();
        return diemDanh;
    }

    public static void report(double diemGiuaKy, double diemCuoiKy, double diemThucHanh){
        double tongDiem = diemGiuaKy + diemCuoiKy + diemThucHanh;
        System.out.println("Tổng điểm bạn nhận được là : "  + tongDiem);
        double gpa = 0;
        if(tongDiem >= 85){
            gpa = 3.0;
        }else if (tongDiem >= 75){
            gpa =2.0;
        }else if (tongDiem >= 60){
            gpa = 1.0;
        }else {
            gpa = 0;
        }
        System.out.print("Điểm GPA của bạn là : " + gpa);
    }
}

/*diem thi giua va cuoi ky
    public static double midFinal() {
        Scanner sc = new Scanner(System.in);
        //trong diem
        System.out.print("Weight (0 - 100)? ");
        int weightMid = sc.nextInt();
        //diem thi
        System.out.print("Score earned: ");
        int scoreEarned = sc.nextInt();
        //diem cong them
        System.out.print("Were scores shifted(1 = yes, 2 = no): ");
        int scoreShifted = sc.nextInt();
        //in ra tong diem
        int total = 0;
        if(scoreShifted == 2) {
            total = scoreEarned;
        }
        if (scoreShifted == 1) {
            System.out.print("Shift amount: ");
            int shiftAmount = sc.nextInt();
            if (scoreEarned + shiftAmount <= 100) {
                total = scoreEarned + shiftAmount;
            }else {
                total = 100;
            }
        }
        System.out.println("Total points: " + total + "/100");
        double weightedScore = Math.ceil(((total/100.0)*weightMid)*10)/10;
        System.out.println("Weighted score: " + weightedScore +"/" + weightMid);
        System.out.println();
        return weightedScore;
    } */