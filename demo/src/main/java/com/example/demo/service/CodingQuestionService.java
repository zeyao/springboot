package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CodingQuestionService {

    public List<List<Integer>> combinationSum(int k, int n) {
        int end = Math.min(9,n);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        find(k,n,end,innerList,list);
        return list;
    }
    
    private void find(int k, int n, int end, List<Integer> innerList, List<List<Integer>> list) {
        if (innerList.size() == k && n == 0) {
            list.add(new ArrayList<>(innerList));
        }
        for (int i = end; i > 0; i--) {
            innerList.add(i);
            find(k, n-i, i - 1, innerList, list);
            innerList.remove(innerList.size()-1);
        }        
    }

}



