package PolyCalculator;

import java.util.*;

public class Polynomial {
    public ArrayList<Monomial> monomials;

    public Polynomial() {
        monomials = new ArrayList<Monomial>();
    }
    public Polynomial add(Polynomial p) {

        Polynomial c = new Polynomial();
        boolean validation=false;
        if(p.monomials.size()==0||this.monomials.size()==0)
            validation=true;


            if(p.monomials.size()>this.monomials.size()) {
                for (int i = 0; i < p.monomials.size(); i++) {

                if(validation) {
                    c.monomials.add(p.monomials.get(i));
                }
                if(!validation)
                c.monomials.add(p.monomials.get(i).add(this.monomials.get(i)));
                    if (!validation) {
                        if (i == this.monomials.size()-1)
                            validation = true;
                    }
            }

        }
        if(p.monomials.size()<this.monomials.size()) {

            for (int i = 0; i < this.monomials.size(); i++) {

                if(validation) {
                    c.monomials.add(this.monomials.get(i));
                }
                if(!validation)
                    c.monomials.add(p.monomials.get(i).add(this.monomials.get(i)));
                if (!validation) {
                    if (i == p.monomials.size()-1)
                        validation = true;
                }
            }

        }
        if(p.monomials.size()==this.monomials.size()) {
            for (int i = 0; i < this.monomials.size(); i++) {
                c.monomials.add(i, p.monomials.get(i).add(this.monomials.get(i)));
            }
        }

            return c;
    }

    public Polynomial mul(Polynomial p) {
        int size=this.monomials.size()+p.monomials.size();
        Polynomial c = new Polynomial();
        for (int i = 0; i <size ; i=i+1) {
            c.monomials.add(i,new Monomial(i,new Integer(0)));
        }


        if(p.monomials.size()==0)
           return c;
        if(this.monomials.size()==0)
            return c;
       for (int i = 0; i < this.monomials.size(); i++) {
           for (int j = 0; j < p.monomials.size(); j++) {
               Monomial temp = this.monomials.get(i).mult(p.monomials.get(j));
               c.monomials.set(i + j, c.monomials.get(i + j).add(temp));
           }
       }
      return c;
    }
    public Scalar evaluate(Scalar s){
        Scalar a=new Integer(0);
        for (int i=0;i<monomials.size();i++){
        Scalar b=monomials.get(i).evaluate(s);
        a=a.add(b);
        }
        return a;
   }
   public Polynomial derivative(){
        Polynomial p=new Polynomial();
       for (int i = 0; i <this.monomials.size()-1 ; i++) {
           Monomial a=this.monomials.get(i+1).derivative();
           p.monomials.add(a);
       }
        return p;
   }

    public static Polynomial build(String s) {
        Polynomial p = new Polynomial();
        s.trim();
        int index = 0;
          for (int i = 0; i < s.length(); i++) {
             {
                if(s.charAt(i)=='0'){
                    p.monomials.add(index,new Monomial(0,new Integer(0)));
                    index=index+1;
                }
                if(s.charAt(i)!=' '&&s.charAt(i)!='0'){
                    int j=i;
                    String k="";
                    while(j<s.length()&&s.charAt(j)!=' '){
                        k=k+s.charAt(j);
                        j=j+1;

                    }
                    i=i+k.length()-1;
                    p.monomials.add(index,new Monomial(k,index));
                    index=index+1;
                    }

                }
            }
          return p;
        }
    public String toString(){
        String s="";
        for (int i = 0; i <this.monomials.size() ; i++) {
            Monomial temp=monomials.get(i);
            if(temp.sign()!=0){
                if(temp.sign()==-1) {
                    if (i == 0)
                        s=s+temp.toString()+"+";
                    else if(i!=monomials.size()-1)
                        s=s.substring(0,s.length()-1)+temp.toString()+"+";
                    else
                        s=s+temp.toString();
                }
                else if(temp.sign()==1){
                    if(i==monomials.size()-1)
                        s=s+temp.toString();
                    else
                        s=s+this.monomials.get(i).toString()+"+";
                }
            }
            if (temp.sign()==0&&i==monomials.size()-1&s.length()>0){
                s=s.substring(0,s.length()-1);
            }
        }
        if (s.isBlank())
            return "0";
        return s;
    }

    public static void main(String[] args) {
        String s="0";
        String k= " 1 2 ";
        Polynomial p=build(s);
        Polynomial q=build(k);
        Polynomial c=p.add(q);
        Polynomial toprint=p.derivative();

        Polynomial toprint2=toprint.derivative();

            System.out.println(p.toString());
        System.out.println(q);
        System.out.println(c.toString());
        System.out.println(p.mul(q).toString());



    }






            



}
