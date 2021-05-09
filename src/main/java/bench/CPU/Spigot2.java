package bench.CPU;

public class Spigot2 {
    private int digits;
    private int bucketSize;

    private int piStore[];
    private int bucket[];

    public Spigot2(int digits){
        this.digits=digits;
        bucketSize=(10*digits/3) + 1;
        piStore=new int [digits];
        bucket=new int [bucketSize];
    }

        public void calculatePi(){
            for(int i = 0; i < bucketSize ; i++)
                bucket[i] = 2;

            int q = 0;
            for (int i = 0; i < digits ; i++){
                q = 0;
                for (int j = bucketSize-1; j >= 0 ; j--){
                    bucket[j] *= 10;
                    bucket[j] = bucket[j] + (q * (j + 1));
                    q = bucket[j] / (2 * j + 1);
                    bucket[j] = bucket[j] % (2 * j + 1);
                }
                piStore[i] = q/10;
                bucket[0] = q%10;

            }

            revalidate();

            for ( int i = 0 ; i < digits ; i++)
                System.out.print(piStore[i]);
        }

        public void revalidate(){
            int q;
            int index;
            for (int i = 0 ; i < digits ; i++){
                q = 0;
                index = 0;
                while (piStore[i-index]>9){
                    q = piStore[i-index]/10;
                    piStore[i-index] %= 10;
                    index++;
                    piStore[i-index] += q;
                }
            }
        }
}
