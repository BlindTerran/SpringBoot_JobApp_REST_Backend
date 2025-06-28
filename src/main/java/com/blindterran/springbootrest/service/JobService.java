package com.blindterran.springbootrest.service;

import com.blindterran.springbootrest.model.JobPost;
import com.blindterran.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost job) {
        repo.addJob(job);
    }

    public List<JobPost> getAllJobs() {
        return repo.getAllJobs();
    }

    public JobPost getJobById(int id) {
        return repo.getJob(id);
    }

    public void updateJob(JobPost jobPost) {
        repo.updateJob(jobPost);
    }

    public void deleteJob(int jobId) {
        repo.deleteJob(jobId);
    }
}
