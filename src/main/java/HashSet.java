import java.util.LinkedList;

public class HashSet<K> {

    private int size;
    private LinkedList<K>[] buckets;

    public HashSet(){
        initbuckets(4);
        size = 0;
    }

    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for(int bi=0;bi<N;bi++){
            buckets[bi] = new LinkedList<>();
        }
    }

    public boolean add(K key){
        int bi = hashfun(key);
        int di = getIndexWithinBuckets(key,bi);
        if(di == -1){
            buckets[bi].add(key);
            size++;
            return true;
        }
        else{
            return false;
        }
    }


    private int hashfun(K key){
        int hc = key.hashCode();
        int comHC = Math.abs(hc) % buckets.length;
        return comHC;
    }

    private int getIndexWithinBuckets(K key,int bi){
        int di = 0;
        for(K k : buckets[bi]){
            if(k.equals(key))
                return di;
            di++;
        }
        return -1;
    }

    public boolean remove(K key){
        int bi = hashfun(key);
        int di = getIndexWithinBuckets(key,bi);
        if(di != -1){
            buckets[bi].remove(key);
            size--;
            return true;
        }else{
            return false;
        }

    }

    public boolean contains(K key){
        int bi = hashfun(key);
        int di = getIndexWithinBuckets(key,bi);
        if(di != -1){
            return true;
        }else{
            return false;
        }
    }

    public void display(){
        for(int bi=0;bi<buckets.length;bi++){
            for(K k : buckets[bi])
                System.out.println(k);
        }
    }


}
