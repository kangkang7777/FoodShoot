package com.project.foodshoot.service.impl;

import com.project.foodshoot.entity.History;
import com.project.foodshoot.mapper.HistoryMapper;
import com.project.foodshoot.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;

    @Override
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
