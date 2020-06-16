package com.project.foodshoot.service;

import com.project.foodshoot.entity.History;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoryService {
    List<Integer> getHistory(String userId);

    void addHistory(int historyId, int recipeId, int userId);
}
