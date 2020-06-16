package com.project.foodshoot.controller;

import com.project.foodshoot.entity.History;
import com.project.foodshoot.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/getHistory")
    public List<Integer> getHistories(@RequestParam String userId){
        return historyService.getHistory(userId);
    }
}
