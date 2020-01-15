package com.ecut.math;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends AndroidViewModel {
//        private SavedStateHandle handle;
//
//    public MyViewModel(SavedStateHandle handle) {
//        if (handle.contains("MAX")){
//            handle.set("MAX",getMaxCount());
//        }
//        this.handle = handle;
//    }

    private MutableLiveData<Integer> count ;
    // 设置次数

    private MutableLiveData<Integer> maxCount;
    private MutableLiveData<String> showText;

    public MyViewModel(@NonNull Application application) {
        super(application);
    }


    public  MutableLiveData<String> getShowText() {
        if (showText==null){
            showText = new MutableLiveData<String>("");
        }
          return showText;
    }


    public void clickOnNum(int i){
        showText.setValue(showText.getValue()+i);
    }


    public MutableLiveData<Integer> getMaxCount() {
        maxCount = new MutableLiveData<Integer>(0);
        return maxCount;
    }

    public void setMaxCount(MutableLiveData<Integer> count) {
        if (count.getValue()>getMaxCount().getValue()){
            maxCount.setValue(count.getValue());
        }
    }

    // 两个数 ，数a 数b  以及 符号 符号随机数，通过奇偶数 判断加减号
    private  MutableLiveData<Integer>  symbols;
    private  MutableLiveData<Integer> numberA;
    private  MutableLiveData<Integer> numberB;
    private MutableLiveData<String> expression;


    public MutableLiveData<Integer> getCount() {
        if (count == null ){
            count = new MutableLiveData<Integer>();
            count.setValue(0);
        }
        return count;
    }

    public void setCount() {                // 设置最高分
        this.count = new MutableLiveData<Integer>();
        count.setValue(0);
    }
    public void addCount(){
        this.count.setValue((this.count.getValue()+1));
    }

    public void setSymbols() {
        symbols = new MutableLiveData<Integer>();
        if (getRandom() % 2 == 0){
            symbols.setValue(0);
        }else {
            symbols.setValue(1);
        }
    }

    public MutableLiveData<Integer> getSymbols() {      // 设置符号位
        return symbols;
    }



    public void setNumberA() {
        numberA = new MutableLiveData<Integer>(getRandom());
    }

    public MutableLiveData<Integer> getNumberA() {
        return numberA;
    }

    public void setNumberB() {
        numberB = new MutableLiveData<Integer>(getRandom());
    }
    public MutableLiveData<Integer> getNumberB() {
        return numberB;
    }

    public MutableLiveData<String> getExpression() {
        expression = new MutableLiveData<String>("");
        int numa = numberA.getValue();
        int numb = numberB.getValue();
        int sy = symbols.getValue();
        String symbleInStr = sy==0?"-":"+";
        String string = numa + symbleInStr + numb +"=";
        expression.setValue(string);
        return expression;
    }

    public void innit(){
        setNumberA();
        setNumberB();
        setSymbols();
    }
public int getRandom(){
        int random = (int)(Math.random()*100);
        return random;

}

}
