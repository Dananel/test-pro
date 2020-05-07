package com.txd.exception;

public class TestExc {

    public void test() throws TestExveption {
     throw new TestExveption();
    }

    public String testTry(){
        String result = null;
           try {
               result = "12";
            }catch (Exception e){
               result = "Exception";
            }finally {
               result = "finally";
               System.out.println("finally");
            }

        result = "ddd";
             return result;

               }
}
