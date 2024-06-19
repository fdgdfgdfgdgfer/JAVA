package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author jfz
 * @Date 2024/6/17 14:26
 * @PackageName:org.example
 * @ClassName: Map
 */

public class Map {
    public static void main(String[] args) {

        dag dag = new dag();
        Integer integer = new Integer(0);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        dag.a = integer;
        dag.atomicInteger = atomicInteger;
        System.out.println(dag);

        integer = 5;
        atomicInteger.set(10);
        System.out.println(dag);
    }

    static class dag {
        public AtomicInteger atomicInteger ;
        public Integer a;

        @Override
        public String toString() {
            return "dag{" +
                    "atomicInteger=" + atomicInteger +
                    ", a=" + a +
                    '}';
        }
    }
}
