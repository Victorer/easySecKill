package com.miaosha.example.test;




public class TwoWaitNotify {
    private int start = 1;
    private boolean flag = true;
//    public  static  void  main(String [] args){
//          TwoWaitNotify waitNotify = new TwoWaitNotify();
//          Thread  thread1 = new Thread(new ou(waitNotify));
//          thread1.setName("A");
//          Thread thread2 = new Thread(new ji(waitNotify));
//          thread2.setName("B");
//          thread1.start();
//          thread2.start();
//    }

    public static  class ou implements Runnable{
        private TwoWaitNotify number;

        public ou(TwoWaitNotify waitNotify){
            this.number = waitNotify;
        }
        @Override
        public void run() {
            while (number.start <= 100) {
                synchronized (TwoWaitNotify.class) {
                    System.out.println("偶数线程抢到锁了");
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "+-+偶数" + number.start);
                        number.start++;
                        number.flag = false;
                        TwoWaitNotify.class.notify();

                    }else {
                        try {
                            TwoWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        }

    public static class ji implements Runnable{
        private TwoWaitNotify number;
        public ji(TwoWaitNotify twoWaitNotify){
            this.number = twoWaitNotify;
        }
        @Override
        public void run() {
            while (number.start <= 100) {
                synchronized (TwoWaitNotify.class) {
                    System.out.println("奇数线程抢到锁了");
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "+-+奇数" + number.start);
                        number.start++;
                        number.flag = true;
                        TwoWaitNotify.class.notify();

                    }else {
                        try {
                            TwoWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }


    public static void main(String [] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();

    }

    }


