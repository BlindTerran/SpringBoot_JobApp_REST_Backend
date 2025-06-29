package com.blindterran.springbootrest.service;

import com.blindterran.springbootrest.model.JobPost;
import com.blindterran.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost job) {
        repo.save(job);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public Optional<JobPost> getJobById(int id) {
        return repo.findById(id);
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int jobId) {
        repo.deleteById(jobId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "Software Engineer", "Good Experience", 2, new ArrayList<>((Arrays.asList("Java", "Python")))),
            new JobPost(2, "Software Engineer 2", "Good Experience", 2, new ArrayList<>((Arrays.asList("Java", "Python"))))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }
}
