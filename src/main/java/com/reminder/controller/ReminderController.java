package com.reminder.controller;

import com.reminder.model.Reminder;
import com.reminder.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
@CrossOrigin(origins = "*")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody Reminder reminder) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reminderService.createReminder(reminder));
    }

    @GetMapping
    public ResponseEntity<List<Reminder>> getAllReminders() {
        return ResponseEntity.ok(reminderService.getAllReminders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Long id) {
        return reminderService.getReminderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id, @RequestBody Reminder reminderDetails) {
        return ResponseEntity.ok(reminderService.updateReminder(id, reminderDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/pending")
    public ResponseEntity<List<Reminder>> getPendingReminders() {
        return ResponseEntity.ok(reminderService.getPendingReminders());
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Reminder> markAsCompleted(@PathVariable Long id) {
        return ResponseEntity.ok(reminderService.markAsCompleted(id));
    }
}