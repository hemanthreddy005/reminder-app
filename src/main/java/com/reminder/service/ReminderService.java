package com.reminder.service;

import com.reminder.model.Reminder;
import com.reminder.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    public Optional<Reminder> getReminderById(Long id) {
        return reminderRepository.findById(id);
    }

    public Reminder updateReminder(Long id, Reminder reminderDetails) {
        return reminderRepository.findById(id).map(reminder -> {
            reminder.setTitle(reminderDetails.getTitle());
            reminder.setDescription(reminderDetails.getDescription());
            reminder.setReminderDate(reminderDetails.getReminderDate());
            reminder.setStatus(reminderDetails.getStatus());
            return reminderRepository.save(reminder);
        }).orElseThrow(() -> new RuntimeException("Reminder not found"));
    }

    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }

    public List<Reminder> getPendingReminders() {
        return reminderRepository.findByStatus("PENDING");
    }

    public Reminder markAsCompleted(Long id) {
        return reminderRepository.findById(id).map(reminder -> {
            reminder.setStatus("COMPLETED");
            return reminderRepository.save(reminder);
        }).orElseThrow(() -> new RuntimeException("Reminder not found"));
    }
}