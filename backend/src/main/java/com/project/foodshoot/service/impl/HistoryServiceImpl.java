package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.History;
import com.project.foodshoot.mapper.HistoryMapper;
import com.project.foodshoot.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;

    public void addHistory(int historyId, int recipeId, int userId){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String visitTime = simpleDateFormat.format(new Date());
        historyMapper.addHistory(historyId, recipeId, userId, visitTime);
    }

    public List<Integer> getHistory(String userId) {
        List<History> temp = historyMapper.getAllFHistoryByUserId(userId);
        List<Integer> res = new LinkedList<>();
        if (temp == null){
            return null;
        }else {
            for (History history : temp) {
                res.add(history.getHistoryId());
            }
        }
        return res;
    }
}
