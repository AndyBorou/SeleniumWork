package io.cod.test;

import java.util.function.Function;
import java.util.function.Predicate;



public class JenericsExamples <K, V> {

    private final K key;
    private final V value;

    public JenericsExamples(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void streamsTest(){
        Predicate<K> predicate;
        Function<K, V> function;
    }


    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public <U, R> R getPair(final  U val1, final R val2){

        System.out.println(getKey() +" : "+ getValue() + " ; " +val1);
        return val2;
    }



    public static void main(String [] args){
        final JenericsExamples<Integer, String> pair = new JenericsExamples<>(5, "abc");
        System.out.println(pair.getKey()+" : "+ pair.value);

        final JenericsExamples<String, Double> pair2 = new JenericsExamples<>("STR", 0.1);
        System.out.println(pair2.getKey()+" : "+ pair2.value);

        System.out.println(pair2.getPair("25", "53.5"));
    }


}
