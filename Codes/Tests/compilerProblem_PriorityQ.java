package Tests;

import secretaryProblem.compilerProblem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class compilerProblem_PriorityQ  {


    public static class Program implements Comparable<Program>{
        String name;
        double len, freq;

        public Program(String name, double len, double freq) {
            this.name = name;
            this.len = len;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "[" + name + " ," + len + " ," + freq + "]";
        }


        @Override
        public int compareTo(Program o) {
            if ((this.len/this.freq)<(o.len/o.freq)) return -1;
            if ((this.len/this.freq)>(o.len/o.freq)) return 1;
            return 0;
        }
    }
    public static Program[] CompilerQ(Program[] p){
        PriorityQueue<Program> queue=new PriorityQueue<Program>();
        for (int i = 0; i <p.length ; i++) {
            queue.add(p[i]);
        }
        Program[] newP=new Program[p.length];
        int index=0;
        while (!queue.isEmpty()){
            newP[index]=queue.poll();
            System.out.println(newP[index]);
            index++;
        }
        return newP;
    }

    public static void main(String[] args) {
       Program[] a=new Program[5];
        for (int i=0;i<5;i++){
            Program p=new Program("i",(int) (Math.random()*100),(int) (Math.random()*100));
            a[i]=p;
        }
        System.out.println(Arrays.toString(a));
        Program[] b=CompilerQ(a);
        System.out.println(Arrays.toString(a));

    }
}

