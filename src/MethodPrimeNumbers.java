public class MethodPrimeNumbers {

    public int SearchPrimeNumbers (int begin, int end) {

        int count = 0;

        for (int num = begin; num <= end; num += 2) {

            boolean isPrime = true;

            for (int i = 3; i <= Math.ceil(Math.sqrt(num)); i+= 2) {

                if (num % i == 0) {

                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                count++;
            }
        }
        return count;
    }
}
