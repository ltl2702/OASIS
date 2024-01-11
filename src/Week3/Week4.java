package Week3;

public class Week4 {
    public static int max2Int(int a, int b) {
        return Math.max(a, b);
    }

    public static int minArray (int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static String calculateBMI(double weight, double height) {
        double bmi = weight/(height*height);
        double roundbmi = Math.round(bmi * 10.0) / 10.0;
        String s1 = "";
        if (roundbmi < 18.5) {
            s1 = "Thiếu cân";
        } else if (roundbmi >= 18.5 && roundbmi <= 22.9) {
            s1 = "Bình thường";
        } else if (roundbmi >= 23 && roundbmi <= 24.9) {
            s1 = "Thừa cân";
        } else if (roundbmi >= 25) {
            s1 = "Béo phì";
        }
        return s1;
    }
}
