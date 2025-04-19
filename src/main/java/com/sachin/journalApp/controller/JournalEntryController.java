package com.sachin.journalApp.controller;


import com.sachin.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();


    @GetMapping
    public List<JournalEntry> getJournalEntries(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createJournal(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable Long id){
        return journalEntries.get(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEntryById(@PathVariable Long id){
        journalEntries.remove(id);
        return "Entry Removed";
    }

    @PatchMapping("/{id}")
    public String updateEntryById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        journalEntries.put(id,myEntry);
        return "Entry Updated";
    }
} 
